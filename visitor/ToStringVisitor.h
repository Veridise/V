/**
 * Author: Stanly Samuel
 * 
 */
#pragma once

#include "antlr4-runtime.h"
#include "VVisitor.h"


/**
 * This class provides an implementation of the ToString visitor that converts
 * a V specification into a readable format.
 */
class  ToStringVisitor : public VVisitor {
public:

  virtual std::any visitSpec(VParser::SpecContext *ctx) override {
    
    if (ctx->behavioralSpec()) {
      return visitBehavioralSpec(ctx->behavioralSpec());
    } else if (ctx->testSpec()) {
      return visitTestSpec(ctx->testSpec());
    } else if (ctx->tempSpec()) {
      return visitTempSpec(ctx->tempSpec());
    } else if (ctx->invariantSpec()) {
      return visitInvariantSpec(ctx->invariantSpec());
    }

    return nullptr;
  }

  virtual std::any visitBehavioralSpec(VParser::BehavioralSpecContext *ctx) override {
    std::string importsString = std::any_cast<std::string>(visitImports(ctx->imports()));
    std::string varsSpecString;
    if(ctx->varsSection())
        varsSpecString = std::any_cast<std::string>(visitVarsSection(ctx->varsSection()));
    else
        varsSpecString = "";
    
    std::string preSectionString;
    if(ctx->precondSection())
      preSectionString = std::any_cast<std::string>(visitPrecondSection(ctx->precondSection()));
    else
      preSectionString = "";

    std::string postSectionString = std::any_cast<std::string>(visitPostcondSection(ctx->postcondSection()));
    std::string behSpecString = importsString + varsSpecString + "\n" + preSectionString + postSectionString;
    return behSpecString;
  }

  virtual std::any visitTestSpec(VParser::TestSpecContext *ctx) override {
    // std::cout << "Visited Test Spec \n";
    return visitChildren(ctx);
  }

  virtual std::any visitTempSpec(VParser::TempSpecContext *ctx) override {
    // std::cout << "Visited Temp Spec \n";
    return visitChildren(ctx);
  }

  virtual std::any visitInvariantSpec(VParser::InvariantSpecContext *ctx) override {
    std::string importsString = std::any_cast<std::string>(visitImports(ctx->imports()));
    std::string varsSpecString;
    if(ctx->varsSection())
        varsSpecString = std::any_cast<std::string>(visitVarsSection(ctx->varsSection()));
    else
        varsSpecString = "";
    std::string invSecString = std::any_cast<std::string>(visitInvariantSection(ctx->invariantSection()));
    std::string invSpecString = importsString + varsSpecString + "\n" +invSecString;
    return invSpecString;
  }

  virtual std::any visitSynthSpec(VParser::SynthSpecContext *ctx) override {
    // std::cout << "Visited Synth Spec \n";
    return visitChildren(ctx);
  }

  virtual std::any visitImports(VParser::ImportsContext *ctx) override {
    std::string importsString;
    // Naive way: 
    // Later figure out how to explicitly check for epsilon using the API.
    if(ctx->IMPORT())
    {
        //Assume production 1
        std::string importString = ctx->IMPORT()->toString();
        std::string pathString = ctx->PATH()->toString();
        std::string recImportsString = std::any_cast<std::string>(visitImports(ctx->imports()));

        importsString = importString+" " + pathString + "\n" + recImportsString;
    }
    else
      importsString = "";


    return importsString;
  }

  virtual std::any visitVarsSection(VParser::VarsSectionContext *ctx) override {
    std::string varsSectionString = ctx->VARS_LABEL()->getText()+ " " + std::any_cast<std::string>(visitDeclList(ctx->declList()));
    return varsSectionString;
  }

  virtual std::any visitPrecondSection(VParser::PrecondSectionContext *ctx) override {
    std::string preSectionString = ctx->PRECOND_LABEL()->getText()+ " " + ctx->atom()->getText()+ "\n";
    return preSectionString;
  }

  virtual std::any visitPostcondSection(VParser::PostcondSectionContext *ctx) override {
    std::string postSectionString = ctx->POSTCOND_LABEL()->getText()+ " " + ctx->atom()->getText();
    return postSectionString;
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
    std::string invSecString = ctx->INV_LABEL()->getText()+ " " + ctx->invAtom()->getText();
    return invSecString;
  }

  virtual std::any visitSeqAtom(VParser::SeqAtomContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitDeclList(VParser::DeclListContext *ctx) override {
    // std::cout << "Visited DeclList \n";
    std::string type =  std::any_cast<std::string>(visitTyp(ctx->typ()));
    std::string ident = std::any_cast<std::string>(visitIdent(ctx->ident()));
    std::string comma;
    if(ctx->COMMA())
        comma = ctx->COMMA()->toString();
    else
        comma = "";
    std::string dList;
    if(ctx->declList())
        dList = std::any_cast<std::string>(visitDeclList(ctx->declList()));
    else
        dList = "";
    return type+" "+ident+comma+" "+dList;
  }

  virtual std::any visitTyp(VParser::TypContext *ctx) override {
    std::string id = ctx->IDENTIFIER()->toString();
    std::string lbrack, rbrack;
    if(ctx->LBRACK())
        lbrack = ctx->LBRACK()->toString();
    else
        lbrack = "";
    
    if(ctx->RBRACK())
        rbrack = ctx->RBRACK()->toString();
    else
        rbrack = "";
    std::string typ = id+lbrack+rbrack;
    return typ;
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
    std::string id;
    if(ctx->IDENTIFIER())
        id = ctx->IDENTIFIER()->toString();
    if(ctx->ATOM_PRE_LOC())
        id = ctx->ATOM_PRE_LOC()->toString();
    if(ctx->ATOM_POST_LOC())
        id = ctx->ATOM_POST_LOC()->toString();
    return id;
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

