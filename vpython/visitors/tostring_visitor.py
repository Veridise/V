from typing import Any

from vast.vast import *

class ToStringVisitor():
    """Visitor for converting VAST to a string"""

    def visit(self, vast: VAST, **kwargs) -> Any:
        if isinstance(vast, VID):
            return self.visitVID(vast, **kwargs)
        elif isinstance(vast, VType):
            return self.visitVType(vast, **kwargs)
        elif isinstance(vast, VVarDecl):
            return self.visitVVarDecl(vast, **kwargs)
        elif isinstance(vast, VImport):
            return self.visitVImport(vast, **kwargs)
        elif isinstance(vast, VImportList):
            return self.visitVImportList(vast, **kwargs)
        elif isinstance(vast, VBehavioralSpec):
            return self.visitVBehavioralSpec(vast, **kwargs)
        elif isinstance(vast, VTestSpec):
            return self.visitVTestSpec(vast, **kwargs)
        elif isinstance(vast, VTempSpec):
            return self.visitVTempSpec(vast, **kwargs)
        elif isinstance(vast, VInvSpec):
            return self.visitVInvSpec(vast, **kwargs)
        elif isinstance(vast, VSynthSpec):
            return self.visitVSynthSpec(vast, **kwargs)
        elif isinstance(vast, VBinOp):
            return self.visitVBinOp(vast, **kwargs)
        elif isinstance(vast, VBinStatementExpr):
            return self.visitVBinStatementExpr(vast, **kwargs)
        elif isinstance(vast, VUnOp):
            return self.visitVUnOp(vast, **kwargs)
        elif isinstance(vast, VUnStatementExpr):
            return self.visitVUnStatementExpr(vast, **kwargs)
        elif isinstance(vast, VArgList):
            return self.visitVArgList(vast, **kwargs)
        elif isinstance(vast, VFunctionID):
            return self.visitVFunctionID(vast, **kwargs)
        elif isinstance(vast, VExecutedStatement):
            return self.visitVExecutedStatement(vast, **kwargs)
        elif isinstance(vast, VFinishedStatement):
            return self.visitVFinishedStatement(vast, **kwargs)
        elif isinstance(vast, VStartedStatement):
            return self.visitVStartedStatement(vast, **kwargs)
        elif isinstance(vast, VRevertedStatement):
            return self.visitVRevertedStatement(vast, **kwargs)
        elif isinstance(vast, VWillSucceedStatement):
            return self.visitVWillSucceedStatement(vast, **kwargs)
        elif isinstance(vast, VBinExpr):
            return self.visitVBinExpr(vast, **kwargs)
        elif isinstance(vast, VUnExpr):
            return self.visitVUnExpr(vast, **kwargs)
        elif isinstance(vast, VVarExpr):
            return self.visitVVarExpr(vast, **kwargs)
        elif isinstance(vast, VConstExpr):
            return self.visitVConstExpr(vast, **kwargs)
        elif isinstance(vast, VFieldAccessExpr):
            return self.visitVFieldAccessExpr(vast, **kwargs)
        elif isinstance(vast, VArrAccessExpr):
            return self.visitVArrAccessExpr(vast, **kwargs)
        elif isinstance(vast, VFunctionCallExpr):
            return self.visitVFunctionCallExpr(vast, **kwargs)
        elif isinstance(vast, VFSumExpr):
            return self.visitVFSumExpr(vast, **kwargs)

        raise Exception("[ERROR]: unrecognized vast type: {}".format(type(vast)))

    def visitVID(self, vast: VID, **kwargs) -> Any:
        return vast.name

    def visitVType(self, vast: VType, **kwargs) -> Any:
        return vast.name

    def visitVVarDecl(self, vast: VVarDecl, **kwargs) -> Any:
        typ = visitTyp(vast.typ)
        var = visitVID(vast.var)
        return typ + " " + var

    def visitVImport(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVImportList(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVBehavioralSpec(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVTestSpec(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVTempSpec(self, vast: VTempSpec, **kwargs) -> Any:
        if (vast.fairness):
            fairness = self.visitVStatementExpr(vast.fairness) + "\n"
        else:
            fairness = ""
        spec = self.visitVStatementExpr(vast.spec) + "\n"
        return fairness + spec

    def visitVInvSpec(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVSynthSpec(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVStatementExpr(self, vast: VStatementExpr, **kwargs) -> Any:
        if isinstance(vast, VUnStatementExpr):
            return self.visitVUnStatementExpr(vast, **kwargs)
        elif isinstance(vast, VBinStatementExpr):
            return self.visitVBinStatementExpr(vast, **kwargs)
        elif isinstance(vast, VFinishedStatement):
            return self.visitVFinishedStatement(vast, **kwargs)
        elif isinstance(vast, VStartedStatement):
            return self.visitVStartedStatement(vast, **kwargs)
        elif isinstance(vast, VRevertedStatement):
            return self.visitVRevertedStatement(vast, **kwargs)
        elif isinstance(vast, VWillSucceedStatement):
            return self.visitVWillSucceedStatement(vast, **kwargs)

        raise Exception("[ERROR]: unrecognized vast type: {}".format(type(vast)))

    def visitVBinOp(self, vast: VBinOp, **kwargs) -> Any:
        return vast.op

    def visitVBinStatementExpr(self, vast: VBinExpr, **kwargs) -> Any:
        lhs = self.visitVStatementExpr(vast.lhs)
        op = self.visitVBinOp(vast.op)
        rhs = self.visitVStatementExpr(vast.rhs)
        return "(" + lhs + " " + op + " " + rhs + ")"

    def visitVUnOp(self, vast: VUnOp, **kwargs) -> Any:
        return vast.op

    def visitVUnStatementExpr(self, vast: VUnStatementExpr, **kwargs) -> Any:
        op = self.visitVUnOp(vast.op)
        con = self.visitVStatementExpr(vast.con)
        return "(" + op + " " + con + ")"

    def visitVArgList(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVFunctionID(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVExecutedStatement(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVFinishedStatement(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVStartedStatement(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVRevertedStatement(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVWillSucceedStatement(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVBinExpr(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVUnExpr(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVVarExpr(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVConstExpr(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVFieldAccessExpr(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVArrAccessExpr(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVFunctionCallExpr(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError

    def visitVFSumExpr(self, vast: VAST, **kwargs) -> Any:
        raise NotImplementedError
    