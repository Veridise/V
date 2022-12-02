# Generated from ../V.g4 by ANTLR 4.11.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .VParser import VParser
else:
    from VParser import VParser

# This class defines a complete listener for a parse tree produced by VParser.
class VListener(ParseTreeListener):

    # Enter a parse tree produced by VParser#spec.
    def enterSpec(self, ctx:VParser.SpecContext):
        pass

    # Exit a parse tree produced by VParser#spec.
    def exitSpec(self, ctx:VParser.SpecContext):
        pass


    # Enter a parse tree produced by VParser#behavioralSpec.
    def enterBehavioralSpec(self, ctx:VParser.BehavioralSpecContext):
        pass

    # Exit a parse tree produced by VParser#behavioralSpec.
    def exitBehavioralSpec(self, ctx:VParser.BehavioralSpecContext):
        pass


    # Enter a parse tree produced by VParser#testSpec.
    def enterTestSpec(self, ctx:VParser.TestSpecContext):
        pass

    # Exit a parse tree produced by VParser#testSpec.
    def exitTestSpec(self, ctx:VParser.TestSpecContext):
        pass


    # Enter a parse tree produced by VParser#tempSpec.
    def enterTempSpec(self, ctx:VParser.TempSpecContext):
        pass

    # Exit a parse tree produced by VParser#tempSpec.
    def exitTempSpec(self, ctx:VParser.TempSpecContext):
        pass


    # Enter a parse tree produced by VParser#invariantSpec.
    def enterInvariantSpec(self, ctx:VParser.InvariantSpecContext):
        pass

    # Exit a parse tree produced by VParser#invariantSpec.
    def exitInvariantSpec(self, ctx:VParser.InvariantSpecContext):
        pass


    # Enter a parse tree produced by VParser#synthSpec.
    def enterSynthSpec(self, ctx:VParser.SynthSpecContext):
        pass

    # Exit a parse tree produced by VParser#synthSpec.
    def exitSynthSpec(self, ctx:VParser.SynthSpecContext):
        pass


    # Enter a parse tree produced by VParser#imports.
    def enterImports(self, ctx:VParser.ImportsContext):
        pass

    # Exit a parse tree produced by VParser#imports.
    def exitImports(self, ctx:VParser.ImportsContext):
        pass


    # Enter a parse tree produced by VParser#varsSection.
    def enterVarsSection(self, ctx:VParser.VarsSectionContext):
        pass

    # Exit a parse tree produced by VParser#varsSection.
    def exitVarsSection(self, ctx:VParser.VarsSectionContext):
        pass


    # Enter a parse tree produced by VParser#precondSection.
    def enterPrecondSection(self, ctx:VParser.PrecondSectionContext):
        pass

    # Exit a parse tree produced by VParser#precondSection.
    def exitPrecondSection(self, ctx:VParser.PrecondSectionContext):
        pass


    # Enter a parse tree produced by VParser#postcondSection.
    def enterPostcondSection(self, ctx:VParser.PostcondSectionContext):
        pass

    # Exit a parse tree produced by VParser#postcondSection.
    def exitPostcondSection(self, ctx:VParser.PostcondSectionContext):
        pass


    # Enter a parse tree produced by VParser#initSection.
    def enterInitSection(self, ctx:VParser.InitSectionContext):
        pass

    # Exit a parse tree produced by VParser#initSection.
    def exitInitSection(self, ctx:VParser.InitSectionContext):
        pass


    # Enter a parse tree produced by VParser#specSection.
    def enterSpecSection(self, ctx:VParser.SpecSectionContext):
        pass

    # Exit a parse tree produced by VParser#specSection.
    def exitSpecSection(self, ctx:VParser.SpecSectionContext):
        pass


    # Enter a parse tree produced by VParser#synthSection.
    def enterSynthSection(self, ctx:VParser.SynthSectionContext):
        pass

    # Exit a parse tree produced by VParser#synthSection.
    def exitSynthSection(self, ctx:VParser.SynthSectionContext):
        pass


    # Enter a parse tree produced by VParser#ltlFairnessSection.
    def enterLtlFairnessSection(self, ctx:VParser.LtlFairnessSectionContext):
        pass

    # Exit a parse tree produced by VParser#ltlFairnessSection.
    def exitLtlFairnessSection(self, ctx:VParser.LtlFairnessSectionContext):
        pass


    # Enter a parse tree produced by VParser#ltlPropertySection.
    def enterLtlPropertySection(self, ctx:VParser.LtlPropertySectionContext):
        pass

    # Exit a parse tree produced by VParser#ltlPropertySection.
    def exitLtlPropertySection(self, ctx:VParser.LtlPropertySectionContext):
        pass


    # Enter a parse tree produced by VParser#invariantSection.
    def enterInvariantSection(self, ctx:VParser.InvariantSectionContext):
        pass

    # Exit a parse tree produced by VParser#invariantSection.
    def exitInvariantSection(self, ctx:VParser.InvariantSectionContext):
        pass


    # Enter a parse tree produced by VParser#seqAtom.
    def enterSeqAtom(self, ctx:VParser.SeqAtomContext):
        pass

    # Exit a parse tree produced by VParser#seqAtom.
    def exitSeqAtom(self, ctx:VParser.SeqAtomContext):
        pass


    # Enter a parse tree produced by VParser#declList.
    def enterDeclList(self, ctx:VParser.DeclListContext):
        pass

    # Exit a parse tree produced by VParser#declList.
    def exitDeclList(self, ctx:VParser.DeclListContext):
        pass


    # Enter a parse tree produced by VParser#typ.
    def enterTyp(self, ctx:VParser.TypContext):
        pass

    # Exit a parse tree produced by VParser#typ.
    def exitTyp(self, ctx:VParser.TypContext):
        pass


    # Enter a parse tree produced by VParser#smartltlAtom.
    def enterSmartltlAtom(self, ctx:VParser.SmartltlAtomContext):
        pass

    # Exit a parse tree produced by VParser#smartltlAtom.
    def exitSmartltlAtom(self, ctx:VParser.SmartltlAtomContext):
        pass


    # Enter a parse tree produced by VParser#invAtom.
    def enterInvAtom(self, ctx:VParser.InvAtomContext):
        pass

    # Exit a parse tree produced by VParser#invAtom.
    def exitInvAtom(self, ctx:VParser.InvAtomContext):
        pass


    # Enter a parse tree produced by VParser#atom.
    def enterAtom(self, ctx:VParser.AtomContext):
        pass

    # Exit a parse tree produced by VParser#atom.
    def exitAtom(self, ctx:VParser.AtomContext):
        pass


    # Enter a parse tree produced by VParser#atomFn.
    def enterAtomFn(self, ctx:VParser.AtomFnContext):
        pass

    # Exit a parse tree produced by VParser#atomFn.
    def exitAtomFn(self, ctx:VParser.AtomFnContext):
        pass


    # Enter a parse tree produced by VParser#atomFnName.
    def enterAtomFnName(self, ctx:VParser.AtomFnNameContext):
        pass

    # Exit a parse tree produced by VParser#atomFnName.
    def exitAtomFnName(self, ctx:VParser.AtomFnNameContext):
        pass


    # Enter a parse tree produced by VParser#params.
    def enterParams(self, ctx:VParser.ParamsContext):
        pass

    # Exit a parse tree produced by VParser#params.
    def exitParams(self, ctx:VParser.ParamsContext):
        pass


    # Enter a parse tree produced by VParser#constraint.
    def enterConstraint(self, ctx:VParser.ConstraintContext):
        pass

    # Exit a parse tree produced by VParser#constraint.
    def exitConstraint(self, ctx:VParser.ConstraintContext):
        pass


    # Enter a parse tree produced by VParser#boolExpr.
    def enterBoolExpr(self, ctx:VParser.BoolExprContext):
        pass

    # Exit a parse tree produced by VParser#boolExpr.
    def exitBoolExpr(self, ctx:VParser.BoolExprContext):
        pass


    # Enter a parse tree produced by VParser#arithExpr.
    def enterArithExpr(self, ctx:VParser.ArithExprContext):
        pass

    # Exit a parse tree produced by VParser#arithExpr.
    def exitArithExpr(self, ctx:VParser.ArithExprContext):
        pass


    # Enter a parse tree produced by VParser#fnCall.
    def enterFnCall(self, ctx:VParser.FnCallContext):
        pass

    # Exit a parse tree produced by VParser#fnCall.
    def exitFnCall(self, ctx:VParser.FnCallContext):
        pass


    # Enter a parse tree produced by VParser#fnName.
    def enterFnName(self, ctx:VParser.FnNameContext):
        pass

    # Exit a parse tree produced by VParser#fnName.
    def exitFnName(self, ctx:VParser.FnNameContext):
        pass


    # Enter a parse tree produced by VParser#argList.
    def enterArgList(self, ctx:VParser.ArgListContext):
        pass

    # Exit a parse tree produced by VParser#argList.
    def exitArgList(self, ctx:VParser.ArgListContext):
        pass


    # Enter a parse tree produced by VParser#ident.
    def enterIdent(self, ctx:VParser.IdentContext):
        pass

    # Exit a parse tree produced by VParser#ident.
    def exitIdent(self, ctx:VParser.IdentContext):
        pass


    # Enter a parse tree produced by VParser#varOrNum.
    def enterVarOrNum(self, ctx:VParser.VarOrNumContext):
        pass

    # Exit a parse tree produced by VParser#varOrNum.
    def exitVarOrNum(self, ctx:VParser.VarOrNumContext):
        pass


    # Enter a parse tree produced by VParser#num.
    def enterNum(self, ctx:VParser.NumContext):
        pass

    # Exit a parse tree produced by VParser#num.
    def exitNum(self, ctx:VParser.NumContext):
        pass


    # Enter a parse tree produced by VParser#varAccess.
    def enterVarAccess(self, ctx:VParser.VarAccessContext):
        pass

    # Exit a parse tree produced by VParser#varAccess.
    def exitVarAccess(self, ctx:VParser.VarAccessContext):
        pass



del VParser