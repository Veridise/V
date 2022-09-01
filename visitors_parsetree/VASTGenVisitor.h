#ifndef V_VASTGENVISITOR_H
#define V_VASTGENVISITOR_H

#include <string>
#include "antlr4-runtime.h"
#include "../libs/VParser.h"
#include "../ast/VAST.h"

// using namespace std;

namespace vastgenvisitor {
  class VASTGenVisitor {
  public:
    vast::VAST* visitSpec(VParser::SpecContext *ctx);
    vast::VImportList *visitImports(VParser::ImportsContext *ctx);
    vast::VBehavioralSpec* visitBehavioralSpec(VParser::BehavioralSpecContext *ctx);
    vast::VTestSpec* visitTestSpec(VParser::TestSpecContext *ctx);
    vast::VTempSpec* visitTempSpec(VParser::TempSpecContext *ctx);
    vast::VInvSpec* visitInvariantSpec(VParser::InvariantSpecContext *ctx);
    vast::VSynthSpec* visitSynthSpec(VParser::SynthSpecContext *ctx);
    vast::VVarDeclList* visitVarsSection(VParser::VarsSectionContext *ctx);
    vast::VStatementExpr* visitInitSection(VParser::InitSectionContext *ctx);
    vast::VStatementExpr* visitSpecSection(VParser::SpecSectionContext *ctx);
    vast::VStatementExpr* visitSynthSection(VParser::SynthSectionContext *ctx);
    vast::VStatementExpr* visitLtlFairnessSection(VParser::LtlFairnessSectionContext *ctx);
    vast::VStatementExpr* visitLtlPropertySection(VParser::LtlPropertySectionContext *ctx);
    vast::VStatementExpr* visitInvariantSection(VParser::InvariantSectionContext *ctx);
    vast::VStatementExpr* visitInvAtom(VParser::InvAtomContext *ctx);
    vast::VStatementExpr* visitSmartltlAtom(VParser::SmartltlAtomContext *ctx);
    vast::VStatementExpr* visitSeqAtom(VParser::SeqAtomContext *ctx);
    vast::VVarDeclList* visitDeclList(VParser::DeclListContext *ctx);
    vast::VType* visitTyp(VParser::TypContext *ctx);
    vast::VID* visitIdent(VParser::IdentContext *ctx);
    vast::VStatementExpr* visitPostcondSection(VParser::PostcondSectionContext *ctx);
    vast::VStatementExpr* visitPrecondSection(VParser::PrecondSectionContext *ctx);
    vast::VStatementExpr* visitAtom(VParser::AtomContext *ctx);
    vast::VFunctionID* visitAtomFn(VParser::AtomFnContext *ctx);
    vast::VConstraintExpr* visitAtomFnName(VParser::AtomFnNameContext *ctx);
    vast::VArgList* visitParams(VParser::ParamsContext *ctx);
    vast::VConstraintExpr* visitConstraint(VParser::ConstraintContext *ctx);
    vast::VConstraintExpr* visitBoolExpr(VParser::BoolExprContext *ctx);
    vast::VConstraintExpr* visitVarOrNum(VParser::VarOrNumContext *ctx);
    vast::VConstraintExpr* visitVarAccess(VParser::VarAccessContext *ctx);
    vast::VConstraintExpr* visitFnCall(VParser::FnCallContext *ctx);
    vast::VConstraintExpr* visitFnName(VParser::FnNameContext *ctx);
    vast::VArgList* visitArgList(VParser::ArgListContext *ctx);
    vast::VConstraintExpr* visitArithExpr(VParser::ArithExprContext *ctx);
  private:
  };
}

#endif
