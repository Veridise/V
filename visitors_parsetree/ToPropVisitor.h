/**
 * Author: Stanly Samuel
 * 
 */
#pragma once

#include "antlr4-runtime.h"
#include "VVisitor.h"
// #include "../build/antlr4_runtime/src/antlr4_runtime/runtime/Cpp/runtime/src/tree/ParseTree.h"


/**
 * This class provides an implementation of the ToProp visitor that converts
 * a V specification into a readable format and replaces every atom with a proposition.
 */
class  ToPropVisitor : public VVisitor {
private:

  int currentVarIdx = 0;
  std::string generateFreshVariable() {
    std::string variableNameBase = "x";
    std::string freshVariable = variableNameBase + std::to_string(currentVarIdx);
    currentVarIdx = currentVarIdx + 1;

    return freshVariable;
  };

  std::map<std::string, std::string> freshVarsToAtoms;

    // virtual std::any visitChildrenString(ParseTree *node) {
    //   std::any result = defaultResult();
    //   size_t n = node->children.size();
    //   for (size_t i = 0; i < n; i++) {
    //     if (!shouldVisitNextChild(node, result)) {
    //       break;
    //     }

    //     std::any childResult = node->children[i]->accept(this);
    //     result = aggregateResult(std::move(result), std::move(childResult));
    //   }

    //   return result;
    // }

public:

  void printMap(){
    for(auto i: freshVarsToAtoms)
      std::cout<<i.first << "-> " << i.second << "\n";
  }

  virtual std::any visitSpec(VParser::SpecContext *ctx) override {
    
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
    std::string importsString = std::any_cast<std::string>(visitImports(ctx->imports()));
    std::string varsSpecString;
    if(ctx->varsSection())
        varsSpecString = std::any_cast<std::string>(visitVarsSection(ctx->varsSection()));
    else
        varsSpecString = "";
    
    std::string initSectionString;
    if(ctx->initSection())
      initSectionString = std::any_cast<std::string>(visitInitSection(ctx->initSection()));
    else
      initSectionString = "";

    std::string specSectionString = std::any_cast<std::string>(visitSpecSection(ctx->specSection()));
    std::string testSpecString = importsString + varsSpecString + "\n" + initSectionString + specSectionString;
    return testSpecString;
  }

  virtual std::any visitTempSpec(VParser::TempSpecContext *ctx) override {
    std::string importsString = std::any_cast<std::string>(visitImports(ctx->imports()));
    std::string varsSpecString;
    if(ctx->varsSection())
        varsSpecString = std::any_cast<std::string>(visitVarsSection(ctx->varsSection()));
    else
        varsSpecString = "";
    
    std::string ltlFairnessSectionString;
    if(ctx->ltlFairnessSection())
      ltlFairnessSectionString = std::any_cast<std::string>(visitLtlFairnessSection(ctx->ltlFairnessSection()));
    else
      ltlFairnessSectionString = "";

    std::string ltlPropertySectionString = std::any_cast<std::string>(visitLtlPropertySection(ctx->ltlPropertySection()));
    std::string tempSpecString = importsString + varsSpecString + "\n" + ltlFairnessSectionString + ltlPropertySectionString;
    return tempSpecString;
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
    std::string importsString = std::any_cast<std::string>(visitImports(ctx->imports()));
    std::string varsSpecString;
    if(ctx->varsSection())
        varsSpecString = std::any_cast<std::string>(visitVarsSection(ctx->varsSection()));
    else
        varsSpecString = "";
    
    std::string initSectionString;
    if(ctx->initSection())
      initSectionString = std::any_cast<std::string>(visitInitSection(ctx->initSection()));
    else
      initSectionString = "";

    std::string synthSectionString = std::any_cast<std::string>(visitSynthSection(ctx->synthSection()));
    std::string synthSpecString = importsString + varsSpecString + "\n" + initSectionString + synthSectionString;
    return synthSpecString;
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
    std::string initSectionString = ctx->INIT_LABEL()->getText() + " " + std::any_cast<std::string>(visitSeqAtom(ctx->seqAtom()));
    return initSectionString;
  }

  virtual std::any visitSpecSection(VParser::SpecSectionContext *ctx) override {
    std::string specSectionString = ctx->SPEC_LABEL()->toString() + " " + std::any_cast<std::string>(visitSeqAtom(ctx->seqAtom()));
    return specSectionString;
  }

  virtual std::any visitSynthSection(VParser::SynthSectionContext *ctx) override {
    std::string synthSectionString = ctx->SYNTH_LABEL()->getText()+" "+ctx->atom()->getText();
    return synthSectionString;
  }

  virtual std::any visitLtlFairnessSection(VParser::LtlFairnessSectionContext *ctx) override {
    std::string ltlFairnessSectionString = ctx->LTLFAIR_LABEL()->getText() +" "+ std::any_cast<std::string>(visitSmartltlAtom(ctx->smartltlAtom())) + "\n";
    return ltlFairnessSectionString;
  }

  virtual std::any visitLtlPropertySection(VParser::LtlPropertySectionContext *ctx) override {
    std::string ltlPropertySectionString = ctx->LTLPROP_LABEL()->getText()+ " " + std::any_cast<std::string>(visitSmartltlAtom(ctx->smartltlAtom()));
    return ltlPropertySectionString;
  }

  virtual std::any visitInvariantSection(VParser::InvariantSectionContext *ctx) override {
    std::string invSecString = ctx->INV_LABEL()->getText()+ " " + ctx->invAtom()->getText();
    return invSecString;
  }

  virtual std::any visitSeqAtom(VParser::SeqAtomContext *ctx) override {
    std::string atomString = ctx->atom()->getText();
    std::string seqAtomString;
    if(ctx->SEQ())
    {
      seqAtomString = atomString + ctx->SEQ()->getText() +"\n" + std::any_cast<std::string>(visitSeqAtom(ctx->seqAtom()));
    }
    else
    seqAtomString = atomString + "\n";
    return seqAtomString;
  }

  virtual std::any visitDeclList(VParser::DeclListContext *ctx) override {
    std::string declString =  ctx->typ()->getText() + " " + ctx->ident()->getText();
    std::string decListString;
    if(ctx->COMMA())
    {
      decListString = declString + ctx->COMMA()->toString() + " " + std::any_cast<std::string>(visitDeclList(ctx->declList()));
    }
    else
      decListString = declString;
    return decListString;
  }

  virtual std::any visitTyp(VParser::TypContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitSmartltlAtom(VParser::SmartltlAtomContext *ctx) override {
    if(ctx->atom())
      return visitAtom(ctx->atom());
    else if(ctx->LBRACK())
      {
        std::string output = "[]" ;
        return output;
      }
      return visitChildren(ctx);
  }

  virtual std::any visitInvAtom(VParser::InvAtomContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitAtom(VParser::AtomContext *ctx) override {
    std::cout<<"Visited Atom";
    std::string visitAtomString;
    if(ctx->ATOM_POST_LOC() || ctx->ATOM_PRE_LOC())
    {
      std::string freshVar = generateFreshVariable();
      freshVarsToAtoms[freshVar] = ctx->getText();
      visitAtomString = freshVar;
    }
    else
      { //Hack to handle one test case
        if(ctx->L_UN())
          {
            visitAtomString = ctx->L_UN()->getText() + "";
          }
      }
      visitAtomString = "None Received";
      return visitAtomString;
      // return visitChildren(ctx);
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

