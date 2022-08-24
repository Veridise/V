
// Generated from V.g4 by ANTLR 4.10.1

#pragma once

#include "antlr4-runtime.h"
#include "VVisitor.h"


/**
 * This class provides an empty implementation of VVisitor, which can be
 * extended to create a visitor which only needs to handle a subset of the available methods.
 */
class  ToStringVisitor : public VVisitor {
public:

  virtual std::any visitSpec(VParser::SpecContext *ctx) override {
    std::cout << "Visited Spec \n"; 
    // visitBehavioralSpec(ctx->behavioralSpec());
    visitChildren(ctx);
    return "Dummy";
  }

  virtual std::any visitBehavioralSpec(VParser::BehavioralSpecContext *ctx) override {
    std::cout << "Visited Behavioral Spec \n";
    return visitChildren(ctx);
  }

  virtual std::any visitTestSpec(VParser::TestSpecContext *ctx) override {
    std::cout << "Visited Test Spec \n";
    return visitChildren(ctx);
  }

  virtual std::any visitTempSpec(VParser::TempSpecContext *ctx) override {
    std::cout << "Visited Temp Spec \n";
    return visitChildren(ctx);
  }

  virtual std::any visitInvariantSpec(VParser::InvariantSpecContext *ctx) override {
    std::cout << "Visited Invariant Spec \n";
    return visitChildren(ctx);
  }

  virtual std::any visitSynthSpec(VParser::SynthSpecContext *ctx) override {
    std::cout << "Visited Synth Spec \n";
    return visitChildren(ctx);
  }

  virtual std::any visitImports(VParser::ImportsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitVarsSection(VParser::VarsSectionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitPrecondSection(VParser::PrecondSectionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitPostcondSection(VParser::PostcondSectionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitInitSection(VParser::InitSectionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitSpecSection(VParser::SpecSectionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitSynthSection(VParser::SynthSectionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitLtlFairnessSection(VParser::LtlFairnessSectionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitLtlPropertySection(VParser::LtlPropertySectionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitInvariantSection(VParser::InvariantSectionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitSeqAtom(VParser::SeqAtomContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitDeclList(VParser::DeclListContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTyp(VParser::TypContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitSmartltlAtom(VParser::SmartltlAtomContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitInvAtom(VParser::InvAtomContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitAtom(VParser::AtomContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitAtomFn(VParser::AtomFnContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitAtomFnName(VParser::AtomFnNameContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParams(VParser::ParamsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitConstraint(VParser::ConstraintContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitBoolExpr(VParser::BoolExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitArithExpr(VParser::ArithExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFnCall(VParser::FnCallContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFnName(VParser::FnNameContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitArgList(VParser::ArgListContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitIdent(VParser::IdentContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitVarOrNum(VParser::VarOrNumContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitNum(VParser::NumContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitVarAccess(VParser::VarAccessContext *ctx) override {
    return visitChildren(ctx);
  }


};

