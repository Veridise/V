from typing import List

class VAST():
    pass

class VStatementExpr(VAST):
    pass

class VID(VAST):
    def __init__(self, name: str):
        self.name = name

class VType(VAST):
    def __init__(self, name: str, is_arr: bool):
        self.name = name
        self.is_arr = is_arr

class VVarDecl(VAST):
    def __init__(self, typ: VType, var: VID):
        self.typ = typ
        self.var = var

class VVarDeclList(VAST):
    def __init__(self, var_decs: List[VVarDecl]):
        self.var_decs = var_decs

class VImport(VAST):
    def __init__(self, path: str):
        self.path = path

class VImportList(VAST):
    def __init__(self, imports: List[VImport]):
        self.imports = imports

class VBehavioralSpec(VAST):
    def __init__(self, imports: VImportList, var_decs: VVarDeclList, pre: VStatementExpr, post: VStatementExpr):
        self.imports = imports
        self.var_decs = var_decs
        self.pre = pre
        self.post = post

class VTestSpec(VAST):
    def __init__(self, imports: VImportList, var_decs: VVarDeclList, init: VStatementExpr, spec: VStatementExpr):
        self.imports = imports
        self.var_decs = var_decs
        self.init = init
        self.spec = spec

class VTempSpec(VAST):
    def __init__(self, imports: VImportList, var_decs: VVarDeclList, fairness: VStatementExpr, spec: VStatementExpr):
        self.imports = imports
        self.var_decs = var_decs
        self.fairness = fairness
        self.spec = spec

class VInvSpec(VAST):
    def __init__(self, imports: VImportList, var_decs: VVarDeclList, inv: VStatementExpr):
        self.imports = imports
        self.var_decs = var_decs
        self.inv = inv

class VSynthSpec(VAST):
    def __init__(self, imports: VImportList, var_decs: VVarDeclList, init: VStatementExpr, synth: VStatementExpr):
        self.imports = imports
        self.var_decs = var_decs
        self.init = init
        self.synth = synth

class VBinOp(VAST):
    def __init__(self, op: str):
        self.op = op

class VBinStatementExpr(VStatementExpr):
    def __init__(self, lhs: VStatementExpr, rhs: VStatementExpr, op: VBinOp):
        self.lhs = lhs
        self.rhs = rhs
        self.op = op

class VUnOp(VAST):
    def __init__(self, op: str):
        self.op = op

class VUnStatementExpr(VStatementExpr):
    def __init__(self, con: VStatementExpr, op: VUnOp):
        self.con = con
        self.op = op

class VConstraintExpr(VAST):
    pass

class VArgList(VAST):
    def __init__(self, args: List[VConstraintExpr]):
        self.args = args

    def __len__(self):
        return len(self.args)

    def __iter__(self):
        return self.args.__iter__()

class VFunctionID(VAST):
    def __init__(self, base: VConstraintExpr, fnName: VID, args: VArgList):
        self.base = base
        self.fnName = fnName
        self.args = args

class VExecutedStatement(VStatementExpr):
    def __init__(self, fun: VFunctionID, pre: VConstraintExpr, con: VConstraintExpr):
        self.fun = fun
        self.pre = pre
        self.con = con

class VFinishedStatement(VStatementExpr):
    def __init__(self, fun: VFunctionID, pre: VConstraintExpr, con: VConstraintExpr):
        self.fun = fun
        self.pre = pre
        self.con = con

class VStartedStatement(VStatementExpr):
    def __init__(self, fun: VFunctionID, con: VConstraintExpr):
        self.fun = fun
        self.con = con

class VRevertedStatement(VStatementExpr):
    def __init__(self, fun: VFunctionID, con: VConstraintExpr):
        self.fun = fun
        self.con = con

class VWillSucceedStatement(VStatementExpr):
    def __init__(self, fun: VFunctionID, con: VConstraintExpr):
        self.fun = fun
        self.con = con

class VBinExpr(VConstraintExpr):
    def __init__(self, lhs: VConstraintExpr, rhs: VConstraintExpr, op: VBinOp):
        self.lhs = lhs
        self.rhs = rhs
        self.op = op

class VUnExpr(VConstraintExpr):
    def __init__(self, expr: VConstraintExpr, op: VBinOp):
        self.expr = expr
        self.op = op

class VVarExpr(VConstraintExpr):
    def __init__(self, var: VID):
        self.var = var

class VConstExpr(VConstraintExpr):
    def __init__(self, type: str, val: str):
        self.type = type
        self.val = val

class VFieldAccessExpr(VConstraintExpr):
    def __init__(self, expr: VConstraintExpr, field: VID):
        self.expr = expr
        self.field = field

class VArrAccessExpr(VConstraintExpr):
    def __init__(self, arr: VConstraintExpr, idx: VConstraintExpr):
        self.arr = arr
        self.idx = idx

class VFunctionCallExpr(VConstraintExpr):
    def __init__(self, base: VConstraintExpr, fnName: VID, args: VArgList):
        self.base = base
        self.fnName = fnName
        self.args = args

class VFSumExpr(VConstraintExpr):
    def __init__(self, func: VFunctionID, arg: VConstraintExpr, con: VConstraintExpr):
        self.func = func
        self.arg = arg
        self.con = con
