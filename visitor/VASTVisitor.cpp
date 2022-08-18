#include "VASTVisitor.h"
#include <stdexcept>
#include <iostream>

using namespace std;
using namespace vast;

namespace vastvisitor {
  VAST* VASTVisitor::visitSpec(VParser::SpecContext *ctx) {

    if (ctx->behavioralSpec()) {
      return visitBehavioralSpec(ctx->behavioralSpec());
    } else if (ctx->testSpec()) {
      return visitTestSpec(ctx->testSpec());
    } else if (ctx->tempSpec()) {
      return visitTempSpec(ctx->tempSpec());
    } else if (ctx->invariantSpec()) {
      return visitInvariantSpec(ctx->invariantSpec());
    } else if (ctx->synthSpec()) {
      return visitSynthSpec(ctx->synthSpec());
    }

    return nullptr;
  }

  VImportList *VASTVisitor::visitImports(VParser::ImportsContext *ctx) {
    VImportList *imports = nullptr;
    if(ctx->imports()) {
      imports = visitImports(ctx->imports());
    }
    else {
      imports = new VImportList(vector<VImport *>());
    }

    if (ctx->PATH()) {
      string path = ctx->PATH()->getText();
      path = path.substr(1, path.length() - 2);
      imports->imports.push_back(new VImport(path));
    }

    return imports;
  }

  VBehavioralSpec* VASTVisitor::visitBehavioralSpec(VParser::BehavioralSpecContext *ctx) {
    VVarDeclList* var_decs = nullptr;
    VStatementExpr* pre = nullptr;
    VImportList *imports = nullptr;
    if (ctx->imports()) {
      imports = visitImports(ctx->imports());
    }
    if (ctx->varsSection()) {
      var_decs = visitVarsSection(ctx->varsSection());
    }
    if (ctx->precondSection()) {
      pre = visitPrecondSection(ctx->precondSection());
    }
    VStatementExpr* post = visitPostcondSection(ctx->postcondSection());
    return new VBehavioralSpec(imports, var_decs, pre, post);
  }

  VTestSpec* VASTVisitor::visitTestSpec(VParser::TestSpecContext *ctx) {
    VVarDeclList* var_decs = nullptr;
    VStatementExpr *init = nullptr;
    VImportList *imports = nullptr;
    if (ctx->imports()) {
      imports = visitImports(ctx->imports());
    }
    if (ctx->varsSection()) {
      var_decs = visitVarsSection(ctx->varsSection());
    }
    if (ctx->initSection()) {
      init = visitInitSection(ctx->initSection());
    }
    VStatementExpr *spec = visitSpecSection(ctx->specSection());
    return new VTestSpec(imports, var_decs, init, spec);
  }

  VTempSpec* VASTVisitor::visitTempSpec(VParser::TempSpecContext *ctx) {
    VVarDeclList* var_decs = nullptr;
    VStatementExpr* fairness = nullptr;
    VImportList *imports = nullptr;
    if (ctx->imports()) {
      imports = visitImports(ctx->imports());
    }
    if (ctx->varsSection()) {
      var_decs = visitVarsSection(ctx->varsSection());
    }
    if (ctx->ltlFairnessSection()) {
      fairness = visitLtlFairnessSection(ctx->ltlFairnessSection());
    }
    VStatementExpr* prop = visitLtlPropertySection(ctx->ltlPropertySection());
    return new VTempSpec(imports, var_decs, fairness, prop);
  }

  VInvSpec* VASTVisitor::visitInvariantSpec(VParser::InvariantSpecContext *ctx) {
    VVarDeclList* var_decs = nullptr;
    VImportList *imports = nullptr;
    if (ctx->imports()) {
      imports = visitImports(ctx->imports());
    }
    if (ctx->varsSection()) {
      var_decs = visitVarsSection(ctx->varsSection());
    }
    VStatementExpr* inv = visitInvariantSection(ctx->invariantSection());
    return new VInvSpec(imports, var_decs, inv);
  }

  VSynthSpec* VASTVisitor::visitSynthSpec(VParser::SynthSpecContext *ctx) {
    VVarDeclList *var_decls = nullptr;
    VImportList *imports = nullptr;
    VStatementExpr *init = nullptr;
    VStatementExpr *synth = nullptr;

    if(ctx->imports()) {
      imports = visitImports(ctx->imports());
    }
    if(ctx->varsSection()) {
      var_decls = visitVarsSection(ctx->varsSection());
    }
    if(ctx->initSection()) {
      init = visitInitSection(ctx->initSection());
    }

    synth = visitSynthSection(ctx->synthSection());
    return new VSynthSpec(imports, var_decls, init, synth);
  }

  VVarDeclList* VASTVisitor::visitVarsSection(VParser::VarsSectionContext *ctx) {
    return visitDeclList(ctx->declList());
  }

  VStatementExpr* VASTVisitor::visitInitSection(VParser::InitSectionContext *ctx) {
    return visitSeqAtom(ctx->seqAtom());
  }

  VStatementExpr* VASTVisitor::visitSpecSection(VParser::SpecSectionContext *ctx) {
    return visitSeqAtom(ctx->seqAtom());
  }

  VStatementExpr* VASTVisitor::visitSynthSection(VParser::SynthSectionContext *ctx) {
    return visitAtom(ctx->atom());
  }

  VStatementExpr* VASTVisitor::visitLtlFairnessSection(VParser::LtlFairnessSectionContext *ctx) {
    return visitSmartltlAtom(ctx->smartltlAtom());
  }

  VStatementExpr* VASTVisitor::visitLtlPropertySection(VParser::LtlPropertySectionContext *ctx) {
    return visitSmartltlAtom(ctx->smartltlAtom());
  }

  VStatementExpr* VASTVisitor::visitInvariantSection(VParser::InvariantSectionContext *ctx) {
    return visitInvAtom(ctx->invAtom());
  }

  VStatementExpr* VASTVisitor::visitInvAtom(VParser::InvAtomContext *ctx) {
    if (ctx->CONTRACT_INV()) {
      // Contract invariant is syntactic sugar for finished w/ wildcard
      VConstraintExpr *var = visitVarAccess(ctx->varAccess());
      VID *fname = new VID("*");
      VFunctionID* fun = new VFunctionID(var, fname, nullptr);
      VConstraintExpr *pre = nullptr;
      VConstraintExpr *con = visitConstraint(ctx->constraint()[0]);
      if(ctx->constraint()[1]) {
        pre = visitConstraint(ctx->constraint()[1]);
      }
      return new VFinishedStatement(fun, pre, con);
    }

    return visitAtom(ctx->atom());
  }

  VStatementExpr* VASTVisitor::visitSmartltlAtom(VParser::SmartltlAtomContext *ctx) {
    if (ctx->atom()) {
      return visitAtom(ctx->atom());
    }

    if (ctx->smartltlAtom().size() > 0) {
      VStatementExpr* s1 = visitSmartltlAtom(ctx->smartltlAtom()[0]);
      if (ctx->T_UN()) {
        VUnOp *op = new VUnOp(ctx->T_UN()->getText());
        return new VUnStatementExpr(s1, op);
      } else if (ctx->L_UN()) {
        VUnOp *op = new VUnOp(ctx->L_UN()->getText());
        return new VUnStatementExpr(s1, op);
      } else if (ctx->LBRACK()) {
        VUnOp *op = new VUnOp("[]");
        return new VUnStatementExpr(s1, op);
      } else if (ctx->IMP()) {
        VUnOp *op = new VUnOp("==>");
        return new VUnStatementExpr(s1, op);
      } else if (ctx->smartltlAtom().size() == 2) {
        VStatementExpr* s2 = visitSmartltlAtom(ctx->smartltlAtom()[1]);
        string op_str;
        if (ctx->T_BIN()) {
          op_str = ctx->T_BIN()->getText();
        } else if (ctx->L_BIN()) {
          op_str = ctx->L_BIN()->getText();
        } else if (ctx->SEQ()) {
          op_str = ctx->SEQ()->getText();
        }
        VBinOp *op = new VBinOp(op_str);
        return new VBinStatementExpr(s1, s2, op);
      }
      return s1;
    }

    return nullptr;
  }

  VStatementExpr* VASTVisitor::visitSeqAtom(VParser::SeqAtomContext *ctx) {
    VStatementExpr *s1 = visitAtom(ctx->atom());

    if (ctx->seqAtom()) {
      VStatementExpr *s2 = visitSeqAtom(ctx->seqAtom());
      VBinOp *op = new VBinOp(ctx->SEQ()->getText());
      return new VBinStatementExpr(s1, s2, op);
    }

    return s1;
  }

  VVarDeclList* VASTVisitor::visitDeclList(VParser::DeclListContext *ctx) {
    vector<VVarDecl*> var_decs;
    VType *typ = visitTyp(ctx->typ());
    VID *var = visitIdent(ctx->ident());

    VVarDecl *var_dec = new VVarDecl(typ, var);
    var_decs.push_back(var_dec);

    if (ctx->declList()) {
      VVarDeclList *restDecs = visitDeclList(ctx->declList());
      var_decs.insert(var_decs.end(), restDecs->var_decs.begin(), restDecs->var_decs.end());
    }

    return new VVarDeclList(var_decs);
  }

  VType* VASTVisitor::visitTyp(VParser::TypContext *ctx) {
    string name = ctx->IDENTIFIER()->getText();
    bool is_arr = false;
    if (ctx->LBRACK()) {
      is_arr = true;
    }
    return new VType(name, is_arr);
  }

  VID* VASTVisitor::visitIdent(VParser::IdentContext *ctx) {
    string name;
    if (ctx->IDENTIFIER()) {
      name = ctx->IDENTIFIER()->getText();
    }
    if (ctx->ATOM_PRE_LOC()) {
      name = ctx->ATOM_PRE_LOC()->getText();
    }
    if (ctx->ATOM_POST_LOC()) {
      name = ctx->ATOM_POST_LOC()->getText();
    }
    return new VID(name);
  }

  VStatementExpr* VASTVisitor::visitPostcondSection(VParser::PostcondSectionContext *ctx) {
    return visitAtom(ctx->atom());
  }

  VStatementExpr* VASTVisitor::visitPrecondSection(VParser::PrecondSectionContext *ctx) {
    return visitAtom(ctx->atom());
  }

  VStatementExpr* VASTVisitor::visitAtom(VParser::AtomContext *ctx) {
    if (ctx->ATOM_PRE_LOC() || ctx->ATOM_POST_LOC()) {
      VFunctionID *fun = visitAtomFn(ctx->atomFn());
      string stmt_typ;
      VConstraintExpr *pre = nullptr;
      VConstraintExpr *con = nullptr;

      if(ctx->ATOM_PRE_LOC()) {
        stmt_typ = ctx->ATOM_PRE_LOC()->getText();
        if (ctx->constraint()[0]) {
          con = visitConstraint(ctx->constraint()[0]);
        }
      }
      else {
        stmt_typ = ctx->ATOM_POST_LOC()->getText();
        if (ctx->PRE_SEP()) {
          pre = visitConstraint(ctx->constraint()[0]);
          con = visitConstraint(ctx->constraint()[1]);
        }
        else if(ctx->constraint().size() > 0) {
          con = visitConstraint(ctx->constraint()[0]);
        }

      }


      if (stmt_typ == "executed") {
        return new VExecutedStatement(fun,pre, con);
      } else if (stmt_typ == "finished") {
        return new VFinishedStatement(fun, pre, con);
      } else if (stmt_typ == "started") {
        return new VStartedStatement(fun, con);
      } else if (stmt_typ == "reverted") {
        return new VRevertedStatement(fun, con);
      } else if (stmt_typ == "willSucceed") {
        return new VWillSucceedStatement(fun, con);
      }
    }

    if (ctx->LET()) {
      // TODO
    }

    if (ctx->FOREACH()) {
      // TODO
    }

    if (ctx->SENT()) {
      // TODO
    }

    if (ctx->atom().size() > 0) {
      VStatementExpr* a1 = visitAtom(ctx->atom()[0]);
      if (ctx->L_UN()) {
        VUnOp *op = new VUnOp(ctx->L_UN()->getText());
        return new VUnStatementExpr(a1, op);
      } else if (ctx->atom().size() == 2) {
        VStatementExpr* a2 = visitAtom(ctx->atom()[1]);
        VBinOp *op = new VBinOp(ctx->L_BIN()->getText());
        return new VBinStatementExpr(a1, a2, op);
      }

      return a1;
    }

    return nullptr;
  }

  VFunctionID* VASTVisitor::visitAtomFn(VParser::AtomFnContext *ctx) {
    VArgList *args = nullptr;
    VConstraintExpr *func = visitAtomFnName(ctx->atomFnName());
    VConstraintExpr *base = nullptr;
    VID *fnName = nullptr;
    

    if(func->exprType() == ExprType::FIELD_ACCESS) {
      VFieldAccessExpr *access = (VFieldAccessExpr *) func;
      base = access->expr;
      fnName = access->field;
    }
    else {
      throw runtime_error("Unknown atomFn type");
    }

    if (ctx->params()) {
      args = visitParams(ctx->params());
    }

    return new VFunctionID(base, fnName, args);
  }

  VConstraintExpr* VASTVisitor::visitAtomFnName(VParser::AtomFnNameContext *ctx) {
    VID *field;
    if(ctx->WILDCARD()) {
        field = new VID(ctx->WILDCARD()->getText());
    }
    else if(ctx->ident()) {
        field = visitIdent(ctx->ident());
    }

    VConstraintExpr *expr = visitVarAccess(ctx->varAccess());
    return new VFieldAccessExpr(expr, field);
  }

  VArgList* VASTVisitor::visitParams(VParser::ParamsContext *ctx) {
    vector<VConstraintExpr*> args;

    if (ctx->ident()) {
      VID *id = visitIdent(ctx->ident());
      VVarExpr *expr = new VVarExpr(id);
      args.push_back(expr);
    }

    if (ctx->NUM()) {
      VConstExpr *expr = new VConstExpr("int", ctx->NUM()->getText());
      args.push_back(expr);
    }

    if (ctx->params()) {
      VArgList* rest = visitParams(ctx->params());
      args.insert(args.end(), rest->args.begin(), rest->args.end());
    }

    return new VArgList(args);
  }

  VConstraintExpr* VASTVisitor::visitConstraint(VParser::ConstraintContext *ctx) {
    if (ctx->constraint().size() > 0) {
      VConstraintExpr* c1 = visitConstraint(ctx->constraint()[0]);
      if (ctx->constraint().size() == 2) {
        VConstraintExpr* c2 = visitConstraint(ctx->constraint()[1]);
        string op_str = "==>";
        if (ctx->L_BIN()) {
          op_str = ctx->L_BIN()->getText();
        }
        VBinOp *op = new VBinOp(op_str);
        return new VBinExpr(c1, c2, op);
      }

      return c1;
    }

    if (ctx->boolExpr()) {
      return visitBoolExpr(ctx->boolExpr());
    }

    return nullptr;
  }

  VConstraintExpr* VASTVisitor::visitBoolExpr(VParser::BoolExprContext *ctx) {
    if (ctx->boolExpr()) {
      VConstraintExpr* expr = visitBoolExpr(ctx->boolExpr());
      if (ctx->L_UN()) {
        VUnOp *op = new VUnOp(ctx->L_UN()->getText());
        return new VUnExpr(expr, op);
      }

      return expr;
    }

    if (ctx->varOrNum()) {
      return visitVarOrNum(ctx->varOrNum());
    }

    if (ctx->arithExpr().size() > 0) {
      VConstraintExpr *lhs = visitArithExpr(ctx->arithExpr()[0]);
      VConstraintExpr *rhs = visitArithExpr(ctx->arithExpr()[1]);
      VBinOp *op = new VBinOp(ctx->C_BIN()->getText());
      return new VBinExpr(lhs, rhs, op);
    }

    return nullptr;
  }

  VConstraintExpr* VASTVisitor::visitVarOrNum(VParser::VarOrNumContext *ctx) {
    if (ctx->num()) {
      return new VConstExpr("int", ctx->num()->NUM()->getText());
    }

    if (ctx->varAccess()) {
      return visitVarAccess(ctx->varAccess());
    }

    return nullptr;
  }

  VConstraintExpr* VASTVisitor::visitVarAccess(VParser::VarAccessContext *ctx) {
    if (ctx->varAccess()) {
      VConstraintExpr *var = visitVarAccess(ctx->varAccess());
      if (ctx->LBRACK()) {
        VConstraintExpr *idx = visitArithExpr(ctx->arithExpr());
        return new VArrAccessExpr(var, idx);
      }

      VID *field = visitIdent(ctx->ident());
      return new VFieldAccessExpr(var, field);
    }

    if (ctx->ident()) {
      VID *id = visitIdent(ctx->ident());
      return new VVarExpr(id);
    }

    if (ctx->fnCall()) {
      return visitFnCall(ctx->fnCall());
    }

    return nullptr;
  }

  VConstraintExpr* VASTVisitor::visitFnCall(VParser::FnCallContext *ctx) {
    if (ctx->FSUM()) {
      VFunctionID *func = visitAtomFn(ctx->atomFn());
      VConstraintExpr* arg = visitVarOrNum(ctx->varOrNum());
      VConstraintExpr* con = visitConstraint(ctx->constraint());

      return new VFSumExpr(func, arg, con);
    }

    if (ctx->fnName()) {
      VConstraintExpr *func = visitFnName(ctx->fnName());
      VConstraintExpr *base = nullptr;
      VID *fnName = nullptr;

      if(func->exprType() == ExprType::FIELD_ACCESS) {
        VFieldAccessExpr *access = (VFieldAccessExpr *) func;
        base = access->expr;
        fnName = access->field;
      }
      else if(func->exprType() == ExprType::VAR) {
        VVarExpr *var = (VVarExpr *) func;
        fnName = var->var;
      }
      else {
        throw runtime_error("Unknown fnCall type");
      }
      VArgList *args = visitArgList(ctx->argList());

      return new VFuncCallExpr(base, fnName, args);
    }

    return nullptr;
  }

  VConstraintExpr* VASTVisitor::visitFnName(VParser::FnNameContext *ctx) {
    VID *id = visitIdent(ctx->ident());

    if (ctx->fnName()) {
      VConstraintExpr *expr = visitFnName(ctx->fnName());
      if (ctx->LBRACK()) {
        VConstraintExpr *idx = visitArithExpr(ctx->arithExpr());
        expr = new VArrAccessExpr(expr, idx);
      } else if (ctx->LPAREN()) {
        VConstraintExpr *base = nullptr;
        VID *fnName = nullptr;
        if(expr->exprType() == ExprType::FIELD_ACCESS) {
          VFieldAccessExpr *access = (VFieldAccessExpr *) expr;
          base = access->expr;
          fnName = access->field;
        }
        else if(expr->exprType() == ExprType::VAR) {
          VVarExpr *var = (VVarExpr *) expr;
          fnName = var->var;
        }
        else {
          throw runtime_error("Unknown fnCall type");
        }

        VArgList *args = visitArgList(ctx->argList());

        expr = new VFuncCallExpr(base, fnName, args);
      }

      return new VFieldAccessExpr(expr, id);
    }

    return new VVarExpr(id);
  }

  VArgList* VASTVisitor::visitArgList(VParser::ArgListContext *ctx) {
    vector<VConstraintExpr*> args;
    if (ctx->arithExpr()) {
      args.push_back(visitArithExpr(ctx->arithExpr()));
    }
    if (ctx->constraint()) {
      args.push_back(visitConstraint(ctx->constraint()));
    }

    if (ctx->argList()) {
      VArgList *rest = visitArgList(ctx->argList());
      args.insert(args.end(), rest->args.begin(), rest->args.end());
    }

    return new VArgList(args);
  }

  VConstraintExpr* VASTVisitor::visitArithExpr(VParser::ArithExprContext *ctx) {
    if (ctx->varOrNum()) {
      return visitVarOrNum(ctx->varOrNum());
    }

    if (ctx->arithExpr().size() > 0) {
      VConstraintExpr* a1 = visitArithExpr(ctx->arithExpr()[0]);
      if (ctx->arithExpr().size() == 2) {
        VConstraintExpr* a2 = visitArithExpr(ctx->arithExpr()[1]);
        string op_str;
        if (ctx->A1_BIN()) {
          op_str = ctx->A1_BIN()->getText();
        } else if (ctx->A2_BIN()) {
          op_str = ctx->A2_BIN()->getText();
        }
        VBinOp *op = new VBinOp(op_str);
        return new VBinExpr(a1, a2, op);
      }

      return a1;
    }

    return nullptr;
  }
}
