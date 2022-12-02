from antlr4 import *

from dist.VParser import VParser
from dist.VVisitor import VVisitor

from vast import *

class VastGenVisitor(VVisitor):
    """Visitor for generating VAST from antlr parse tree."""

    def visitSpec(self, ctx):
        if ctx.behavioralSpec():
            return self.visitBehavioralSpec(ctx.behavioralSpec())
        elif ctx.testSpec():
            return self.visitTestSpec(ctx.testSpec())
        elif ctx.tempSpec():
            return self.visitTempSpec(ctx.tempSpec())
        elif ctx.invariantSpec():
            return self.visitInvariantSpec(ctx.invariantSpec())
        elif ctx.synthSpec():
            return self.visitSynthSpec(ctx.synthSpec())

        raise Exception("[ERROR]: Unknown context type: {}".format(ctx))

    def visitBehavioralSpec(self, ctx):
        raise NotImplementedError

    def visitTestSpec(self, ctx):
        raise NotImplementedError

    def visitTempSpec(self, ctx):
        imports = None
        if ctx.imports():
            imports = self.visitImports(ctx.imports())

        var_decs = None
        if ctx.varsSection():
            var_decs = self.visitVarsSection(ctx.varsSection())

        fairness = None
        if ctx.ltlFairnessSection():
            fairness = self.visitLtlFairnessSection(ctx.ltlFairnessSection())

        prop = self.visitLtlPropertySection(ctx.ltlPropertySection())

        return VTempSpec(imports, var_decs, fairness, prop)

    def visitInvariantSpec(self, ctx):
        raise NotImplementedError

    def visitSynthSpec(self, ctx):
        raise NotImplementedError

    def visitImports(self, ctx):
        imports = None
        if ctx.imports():
            imports = self.visitImports(ctx.imports())
        else:
            imports = VImportList([])

        if ctx.PATH():
            path = ctx.PATH().getText()
            path = path[1:-2]
            imports.imports.append(VImport(path))

        return imports

    def visitVarsSection(self, ctx):
        return self.visitDeclList(ctx.declList())

    def visitPrecondSection(self, ctx):
        raise NotImplementedError

    def visitPostcondSection(self, ctx):
        raise NotImplementedError

    def visitInitSection(self, ctx):
        raise NotImplementedError

    def visitSpecSection(self, ctx):
        raise NotImplementedError

    def visitSynthSection(self, ctx):
        raise NotImplementedError

    def visitLtlFairnessSection(self, ctx):
        return self.visitSmartltlAtom(ctx.smartltlAtom())

    def visitLtlPropertySection(self, ctx):
        return self.visitSmartltlAtom(ctx.smartltlAtom())

    def visitInvariantSection(self, ctx):
        raise NotImplementedError

    def visitSeqAtom(self, ctx):
        raise NotImplementedError

    def visitDeclList(self, ctx):
        var_decs = []
        typ = self.visitTyp(ctx.typ())
        var = self.visitIdent(ctx.ident())

        var_dec = VVarDecl(typ, var)
        var_decs.append(var_dec)

        if ctx.declList():
            rest_decs = self.visitDeclList(ctx.declList())
            var_decs += rest_decs.var_decs

        return VVarDeclList(var_decs)

    def visitTyp(self, ctx):
        name = ctx.IDENTIFIER().getText()
        is_arr = False
        if ctx.LBRACK():
            is_arr = True

        return VType(name, is_arr)

    def visitSmartltlAtom(self, ctx):
        if ctx.atom():
            return self.visitAtom(ctx.atom())

        if len(ctx.smartltlAtom()) > 0:
            s1 = self.visitSmartltlAtom(ctx.smartltlAtom()[0])
            if ctx.T_UN():
                op = VUnOp(ctx.T_UN().getText())
                return VUnStatementExpr(s1, op)
            elif ctx.L_UN():
                op = VUnOp(ctx.L_UN().getText())
                return VUnStatementExpr(s1, op)
            elif ctx.LBRACK():
                op = VUnOp("[]")
                return VUnStatementExpr(s1, op)
            elif len(ctx.smartltlAtom()) == 2:
                s2 = self.visitSmartltlAtom(ctx.smartltlAtom()[1])
                op_str = None
                if ctx.T_BIN():
                    op_str = ctx.T_BIN().getText()
                elif ctx.op != None:
                    op_str = ctx.op.text
                elif ctx.SEQ():
                    op_str = ctx.SEQ().getText()
                elif ctx.IMP():
                    op_str = ctx.IMP().getText()
                else:
                    raise Exception("[ERROR]: Unrecognized context {}".format(ctx))

                op = VBinOp(op_str)
                return VBinStatementExpr(s1, s2, op)
            return s1

        raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))

    def visitInvAtom(self, ctx):
        raise NotImplementedError

    def visitAtom(self, ctx:VParser.AtomContext):
        if ctx.ATOM_PRE_LOC() or ctx.ATOM_POST_LOC():
            fun = self.visitAtomFn(ctx.atomFn())

            pre = None
            con = None
            if ctx.ATOM_PRE_LOC():
                stmt_typ = ctx.ATOM_PRE_LOC().getText()
                if len(ctx.constraint()) > 0:
                    con = self.visitConstraint(ctx.constraint()[0])
            elif ctx.ATOM_POST_LOC():
                stmt_typ = ctx.ATOM_POST_LOC().getText()
                if ctx.PRE_SEP():
                    pre = self.visitConstraint(ctx.constraint()[0])
                    con = self.visitConstraint(ctx.constraint()[1])
                elif len(ctx.constraint()) > 0:
                    con = self.visitConstraint(ctx.constraint()[0])
            else:
                raise Exception("[ERROR]: Unsupported V Atom")


            if stmt_typ == "executed":
                return VExecutedStatement(fun, pre, con)
            elif stmt_typ == "finished":
                return VFinishedStatement(fun, pre, con)
            elif stmt_typ == "started":
                return VStartedStatement(fun, con)
            elif stmt_typ == "reverted":
                return VRevertedStatement(fun, con)
            elif stmt_typ == "willSucceed":
                return VWillSucceedStatement(fun, con)

        if ctx.LET():
            raise Exception("[ERROR]: Unsupported atom LET")
        if ctx.FOREACH():
            raise Exception("[ERROR]: Unsupported atom FOREACH")
        if ctx.SENT():
            raise Exception("[ERROR]: Unsupported atom SENT")

        if len(ctx.atom()) > 0:
            a1 = self.visitAtom(ctx.atom()[0])
            if ctx.L_UN():
                op = VUnOp(ctx.L_UN().getText())
                return VUnStatementExpr(a1, op)
            elif len(ctx.atom()) == 2:
                a2 = self.visitAtom(ctx.atom()[1])
                op = VBinOp(ctx.L_BIN().getText())
                return VBinStatementExpr(a1, a2, op)

            return a1

        raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))

    def visitAtomFn(self, ctx):
        func = self.visitAtomFnName(ctx.atomFnName())

        # TODO: This is very messy and makes no sense...
        base = None
        if isinstance(func, VFieldAccessExpr):
            if func.field == None:
                if isinstance(func.expr, VFieldAccessExpr):
                    base = func.expr.expr
                    func = func.expr.field
                else:
                    func = func.expr
            else:
                base = func.expr
                func = func.field
        else:
            raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))

        args = None
        if ctx.params():
            args = self.visitParams(ctx.params())

        return VFunctionID(base, func, args)

    def visitAtomFnName(self, ctx):
        field = None
        if ctx.WILDCARD():
            field = VID(ctx.WILDCARD().getText())

        expr = self.visitVarAccess(ctx.varAccess())
        return VFieldAccessExpr(expr, field)

    def visitParams(self, ctx):
        args = []

        if ctx.ident():
            id = self.visitIdent(ctx.ident())
            expr = VVarExpr(id)
            args.append(expr)

        if ctx.NUM():
            expr = VConstExpr("int", int(ctx.NUM().getText()))
            args.append(expr)

        if ctx.params():
            rest = self.visitParams(ctx.params())
            args += rest

        return VArgList(args)

    def visitConstraint(self, ctx):
        if len(ctx.constraint()) > 0:
            c1 = self.visitConstraint(ctx.constraint()[0])
            if len(ctx.constraint()) == 2:
                c2 = self.visitConstraint(ctx.constraint()[1])
                op_str = "==>"
                if ctx.op != None:
                    op_str = ctx.op.text
                op = VBinOp(op_str)
                return VBinExpr(c1, c2, op)

            return c1

        if ctx.boolExpr():
            return self.visitBoolExpr(ctx.boolExpr())

        raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))

    def visitBoolExpr(self, ctx):
        if ctx.boolExpr():
            expr = self.visitBoolExpr(ctx.boolExpr())
            if ctx.L_UN():
                op = VUnOp(ctx.L_UN().getText())
                return VUnExpr(expr, op)
            return expr

        # if ctx.fnCall():
        #     return self.visitFnCall(ctx.fnCall())

        if ctx.varOrNum():
            return self.visitVarOrNum(ctx.varOrNum())

        if len(ctx.arithExpr()) > 0:
            lhs = self.visitArithExpr(ctx.arithExpr()[0])
            rhs = self.visitArithExpr(ctx.arithExpr()[1])
            op = VBinOp(ctx.C_BIN().getText())
            return VBinExpr(lhs, rhs, op)

        raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))

    def visitArithExpr(self, ctx):
        if ctx.varOrNum():
            return self.visitVarOrNum(ctx.varOrNum())

        # if ctx.fnCall():
        #     return self.visitFnCall(ctx.fnCall())

        if len(ctx.arithExpr()) > 0:
            a1 = self.visitArithExpr(ctx.arithExpr()[0])
            if len(ctx.arithExpr()) == 2:
                a2 = self.visitArithExpr(ctx.arithExpr()[1])
                if ctx.A1_BIN():
                    op = VBinOp(ctx.A1_BIN())
                if ctx.A2_BIN():
                    op = VBinOp(ctx.A2_BIN())
                else:
                    raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))
                
                return VBinExpr(a1, a2, op)
            return a1
        print(ctx.A2_BIN())

        raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))

    def visitFnCall(self, ctx):
        if ctx.FSUM():
            func = self.visitAtomFn(ctx.atomFn())
            arg = self.visitArithExpr(ctx.arithExpr())
            con = self.visitConstraint(ctx.constraint())

            return VFSumExpr(func, arg, con)

        if ctx.fnName():
            func = self.visitFnName(ctx.fnName())
            args = self.visitArgList(ctx.argList())

            # TODO: Handle case of field access and var?
            base = None
            if isinstance(func, VFieldAccessExpr):
                base = func.expr
                func = func.field
            elif isinstance(func, VVarExpr):
                func = func.var
            else:
                raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))

            # TODO: What about base?
            return VFunctionCallExpr(base, func, args)

        raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))

    def visitFnName(self, ctx):
        _id = self.visitIdent(ctx.ident())

        if (ctx.fnName()):
            expr = self.visitFnName(ctx.fnName())
            if ctx.LBRACK():
                idx = self.visitArithExpr(ctx.arithExpr())
                return VArrAccessExpr(expr, idx)
            elif ctx.LPAREN():
                base = None
                fnName = None
                if isinstance(expr, VFieldAccessExpr):
                    base = expr.expr
                    fnName = expr.field
                elif isinstance(expr, VVarExpr):
                    fnName = expr.var
                else:
                    raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))

                args = sefl.visitArgList(ctx.argList())

                return VFieldAccessExpr(base, fnName, args)

            return VFieldAccessExpr(expr, _id)


        return VVarExpr(_id)

    def visitArgList(self, ctx):
        args = []

        if ctx.arithExpr():
            args.append(self.visitArithExpr(ctx.arithExpr()))

        if ctx.constraint():
            args.append(self.visitConstraint(ctx.constraint()))

        if ctx.argList():
            rest = self.visitArgList(ctx.argList())
            args += rest

        return VArgList(args)

    def visitIdent(self, ctx):
        name = None
        if ctx.IDENTIFIER():
            name = ctx.IDENTIFIER().getText()
        elif ctx.ATOM_LOC():
            name = ctx.ATOM_LOC().getText()
        else:
            raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))

        return VID(name)

    def visitVarOrNum(self, ctx):
        if ctx.num():
            return self.visitNum(ctx.num())

        if ctx.varAccess():
            return self.visitVarAccess(ctx.varAccess())

        raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))

    def visitNum(self, ctx):
        if ctx.NUM():
            return VConstExpr("int", int(ctx.NUM().getText()))

        if ctx.NEG_NUM():
            return VConstExpr("int", int(ctx.NEG_NUM().getText()))

        raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))

    def visitVarAccess(self, ctx):
        if ctx.varAccess():
            var = self.visitVarAccess(ctx.varAccess())
            if ctx.LBRACK():
                idx = self.visitArithExpr(ctx.arithExpr())
                return VArrAccessExpr(var, idx)
            field = self.visitIdent(ctx.ident())
            return VFieldAccessExpr(var, field)

        if ctx.ident():
            _id = self.visitIdent(ctx.ident())
            return VVarExpr(_id)

        if ctx.fnCall():
            return self.visitFnCall(ctx.fnCall())

        raise Exception("[ERROR]: Unrecognized context: {}".format(ctx))
