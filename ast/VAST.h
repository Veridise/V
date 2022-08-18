#ifndef VINSTRUMENTER_VAST_H
#define VINSTRUMENTER_VAST_H

#include <string>
#include <vector>
#include <iostream>
#include "../libs/json.hpp"

using json = nlohmann::json;
using namespace std;

namespace vast {

  enum ExprType {
    BIN,
    UN,
    CONST,
    VAR,
    FIELD_ACCESS,
    ARR_ACCESS,
    FN_CALL,
    FSUM
  };

  class VAST {
  public:
    virtual ~VAST() = default;
    virtual json toJson() = 0;
  };

  class VStatementExpr : public VAST {
  public:
    VStatementExpr();
    json toJson() override;
  };

  class VID : public VAST {
  public:
    VID(string _name);
    string name;
    json toJson() override;
  };

  class VType : public VAST {
  public:
    VType(string _name, bool _is_arr);
    string name;
    bool is_arr;
    json toJson() override;
  };

  class VVarDecl : public VAST {
  public:
    VVarDecl(VType* _typ, VID* _var);
    json toJson() override;
    VType* typ;
    VID* var;
  };

  class VImport : public VAST {
  public:
    VImport(string _path);
    json toJson() override;
    string path;
  };

  class VImportList : public VAST {
  public:
    VImportList(vector<VImport *> _imports);
    json toJson() override;
    vector<VImport *> imports;
  };

  class VVarDeclList : public VAST {
  public:
    VVarDeclList(vector<VVarDecl*> _var_decs);
    json toJson() override;
    vector<VVarDecl*> var_decs;
  };

  class VBehavioralSpec : public VAST {
  public:
    VBehavioralSpec(VImportList *_imports, VVarDeclList *_var_decs, VStatementExpr *_pre, VStatementExpr *_post);
    VImportList *imports;
    VVarDeclList *var_decs;
    VStatementExpr *pre;
    VStatementExpr *post;
    json toJson() override;
  };

  class VTestSpec : public VAST {
  public:
    VTestSpec(VImportList *_imports, VVarDeclList *_var_decs, VStatementExpr *_init, VStatementExpr *_spec);
    VImportList *imports;
    VVarDeclList *var_decs;
    VStatementExpr *init;
    VStatementExpr *spec;
    json toJson() override;
  };

  class VTempSpec : public VAST {
  public:
    VTempSpec(VImportList *_imports, VVarDeclList *_var_decs, VStatementExpr *_fairness, VStatementExpr *_spec);
    VImportList *imports;
    VVarDeclList *var_decs;
    VStatementExpr *fairness;
    VStatementExpr *spec;
    json toJson() override;
  };

  class VInvSpec : public VAST {
  public:
    VInvSpec(VImportList *_imports, VVarDeclList *_var_decs, VStatementExpr *_inv);
    VImportList *imports;
    VVarDeclList *var_decs;
    VStatementExpr *inv;
    json toJson() override;
  };

  class VSynthSpec: public VAST {
  public:
    VSynthSpec(VImportList *_imports, VVarDeclList *_var_decls, VStatementExpr *_init, VStatementExpr *_synth);
    
    VImportList *imports;
    VVarDeclList *var_decls;
    VStatementExpr *init;
    VStatementExpr *synth;
    json toJson() override;
  };

  class VBinOp : public VAST {
  public:
    VBinOp(string _op);
    string op;
    json toJson() override;
  };

  class VBinStatementExpr : public VStatementExpr {
  public:
    VBinStatementExpr(VStatementExpr *_lhs, VStatementExpr *_rhs, VBinOp *_op);
    VStatementExpr *lhs;
    VStatementExpr *rhs;
    VBinOp *op;
    json toJson() override;
  };

  class VUnOp : public VAST {
  public:
    VUnOp(string _op);
    string op;
    json toJson() override;
  };

  class VUnStatementExpr : public VStatementExpr {
  public:
    VUnStatementExpr(VStatementExpr *_con, VUnOp *_op);
    VStatementExpr *con;
    VUnOp *op;
    json toJson() override;
  };

  class VConstraintExpr : public VAST {
  public:
    VConstraintExpr();
    virtual ExprType exprType() = 0;
    json toJson() override;
  };

  class VArgList : public VAST {
  public:
    VArgList(vector<VConstraintExpr*> _args);
    vector<VConstraintExpr*> args;
    json toJson() override;
  };

  class VFunctionID : public VAST {
  public:
    VFunctionID(VConstraintExpr *_base, VID *_fnName, VArgList *_args);
    VConstraintExpr *base;
    VID *fnName;
    VArgList *args;
    json toJson() override;
  };

  class VExecutedStatement : public VStatementExpr {
  public:
    VExecutedStatement(VFunctionID *_fun, VConstraintExpr *_pre, VConstraintExpr *_con);
    VFunctionID *fun;
    VConstraintExpr *pre;
    VConstraintExpr *con;
    json toJson() override;
  };

  class VFinishedStatement : public VStatementExpr {
  public:
    VFinishedStatement(VFunctionID *_fun, VConstraintExpr *_pre, VConstraintExpr *_con);
    VFunctionID *fun;
    VConstraintExpr *pre;
    VConstraintExpr *con;
    json toJson() override;
  };

  class VStartedStatement : public VStatementExpr {
  public:
    VStartedStatement(VFunctionID *_fun, VConstraintExpr *_con);
    VFunctionID *fun;
    VConstraintExpr *con;
    json toJson() override;
  };

  class VRevertedStatement : public VStatementExpr {
  public:
    VRevertedStatement(VFunctionID *_fun, VConstraintExpr *_con);
    VFunctionID *fun;
    VConstraintExpr *con;
    json toJson() override;
  };

  class VWillSucceedStatement : public VStatementExpr {
  public:
    VWillSucceedStatement(VFunctionID *_fun, VConstraintExpr *_con);
    VFunctionID *fun;
    VConstraintExpr *con;
    json toJson() override;
  };

  class VBinExpr : public VConstraintExpr {
  public:
    VBinExpr(VConstraintExpr *_lhs, VConstraintExpr *_rhs, VBinOp *_op);
    ExprType exprType() override { return ExprType::BIN; }
    VConstraintExpr *lhs;
    VConstraintExpr *rhs;
    VBinOp *op;
    json toJson() override;
  };

  class VUnExpr : public VConstraintExpr {
  public:
    VUnExpr(VConstraintExpr *_expr, VUnOp *_op);
    ExprType exprType() override { return ExprType::UN; }
    VConstraintExpr *expr;
    VUnOp *op;
    json toJson() override;
  };

  class VVarExpr : public VConstraintExpr {
  public:
    VVarExpr(VID *_var);
    ExprType exprType() override { return ExprType::VAR; }
    VID *var;
    json toJson() override;
  };

  class VConstExpr : public VConstraintExpr {
  public:
    VConstExpr(string _type, string _val);
    ExprType exprType() override { return ExprType::CONST; }
    string val;
    string type;
    json toJson() override;
  };

  class VFieldAccessExpr : public VConstraintExpr {
  public:
    VFieldAccessExpr(VConstraintExpr *_expr, VID *_field);
    ExprType exprType() override { return ExprType::FIELD_ACCESS; }
    VConstraintExpr *expr;
    VID *field;
    json toJson() override;
  };

  class VArrAccessExpr : public VConstraintExpr {
  public:
    VArrAccessExpr(VConstraintExpr *_arr, VConstraintExpr *_idx);
    ExprType exprType() override { return ExprType::ARR_ACCESS; }
    VConstraintExpr *arr;
    VConstraintExpr *idx;
    json toJson() override;
  };

  class VFuncCallExpr : public VConstraintExpr {
  public:
    VFuncCallExpr(VConstraintExpr *_base, VID *_fnName, VArgList *_args);
    ExprType exprType() override { return ExprType::FN_CALL; }
    VConstraintExpr *base;
    VID *fnName;
    VArgList *args;
    json toJson() override;
  };

  class VFSumExpr : public VConstraintExpr {
  public:
    VFSumExpr(VFunctionID *_func, VConstraintExpr* _arg, VConstraintExpr *_con);
    ExprType exprType() override { return ExprType::FSUM; }
    VFunctionID *func;
    VConstraintExpr* arg;
    VConstraintExpr *con;
    json toJson() override;
  };

}

#endif
