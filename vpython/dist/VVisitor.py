# Generated from ../V.g4 by ANTLR 4.11.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .VParser import VParser
else:
    from VParser import VParser

# This class defines a complete generic visitor for a parse tree produced by VParser.

class VVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by VParser#spec.
    def visitSpec(self, ctx:VParser.SpecContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#behavioralSpec.
    def visitBehavioralSpec(self, ctx:VParser.BehavioralSpecContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#testSpec.
    def visitTestSpec(self, ctx:VParser.TestSpecContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#tempSpec.
    def visitTempSpec(self, ctx:VParser.TempSpecContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#invariantSpec.
    def visitInvariantSpec(self, ctx:VParser.InvariantSpecContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#synthSpec.
    def visitSynthSpec(self, ctx:VParser.SynthSpecContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#imports.
    def visitImports(self, ctx:VParser.ImportsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#varsSection.
    def visitVarsSection(self, ctx:VParser.VarsSectionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#precondSection.
    def visitPrecondSection(self, ctx:VParser.PrecondSectionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#postcondSection.
    def visitPostcondSection(self, ctx:VParser.PostcondSectionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#initSection.
    def visitInitSection(self, ctx:VParser.InitSectionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#specSection.
    def visitSpecSection(self, ctx:VParser.SpecSectionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#synthSection.
    def visitSynthSection(self, ctx:VParser.SynthSectionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#ltlFairnessSection.
    def visitLtlFairnessSection(self, ctx:VParser.LtlFairnessSectionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#ltlPropertySection.
    def visitLtlPropertySection(self, ctx:VParser.LtlPropertySectionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#invariantSection.
    def visitInvariantSection(self, ctx:VParser.InvariantSectionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#seqAtom.
    def visitSeqAtom(self, ctx:VParser.SeqAtomContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#declList.
    def visitDeclList(self, ctx:VParser.DeclListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#typ.
    def visitTyp(self, ctx:VParser.TypContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#smartltlAtom.
    def visitSmartltlAtom(self, ctx:VParser.SmartltlAtomContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#invAtom.
    def visitInvAtom(self, ctx:VParser.InvAtomContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#atom.
    def visitAtom(self, ctx:VParser.AtomContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#atomFn.
    def visitAtomFn(self, ctx:VParser.AtomFnContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#atomFnName.
    def visitAtomFnName(self, ctx:VParser.AtomFnNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#params.
    def visitParams(self, ctx:VParser.ParamsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#constraint.
    def visitConstraint(self, ctx:VParser.ConstraintContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#boolExpr.
    def visitBoolExpr(self, ctx:VParser.BoolExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#arithExpr.
    def visitArithExpr(self, ctx:VParser.ArithExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#fnCall.
    def visitFnCall(self, ctx:VParser.FnCallContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#fnName.
    def visitFnName(self, ctx:VParser.FnNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#argList.
    def visitArgList(self, ctx:VParser.ArgListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#ident.
    def visitIdent(self, ctx:VParser.IdentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#varOrNum.
    def visitVarOrNum(self, ctx:VParser.VarOrNumContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#num.
    def visitNum(self, ctx:VParser.NumContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by VParser#varAccess.
    def visitVarAccess(self, ctx:VParser.VarAccessContext):
        return self.visitChildren(ctx)



del VParser