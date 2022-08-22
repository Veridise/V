# V

This repository contains the grammar for the V specification language (in V.g4) and a parser that converts a given V specification into an intermediate representation called VAST.

### Building

```bash
mkdir build
cd build
cmake ../
make
```

### Running 

```bash
./parse <path-to-spec>
```

This returns the intermediate VAST in JSON format.

For example, running 

```bash
./parse ../example_specs/invariant1.spec
```
which contains the invariant specification
```
vars: ERC20 erc20
inv: finished(erc20.*, address(this).balance = sum(balances))
```

returns the following:

```json
{"imports":{"imports":[],"ntype":"VImportList"},"inv":{"con":{"lhs":{"expr":{"args":{"args":[{"ntype":"VVarExpr","var":{"name":"this","ntype":"VID"}}],"ntype":"VArgList"},"base":null,"func":{"name":"address","ntype":"VID"},"ntype":"VFuncCallExpr"},"field":{"name":"balance","ntype":"VID"},"ntype":"VFieldAccessExpr"},"ntype":"VBinExpr","op":"=","rhs":{"args":{"args":[{"ntype":"VVarExpr","var":{"name":"balances","ntype":"VID"}}],"ntype":"VArgList"},"base":null,"func":{"name":"sum","ntype":"VID"},"ntype":"VFuncCallExpr"}},"fun":{"args":null,"base":{"ntype":"VVarExpr","var":{"name":"erc20","ntype":"VID"}},"func":{"name":"*","ntype":"VID"},"ntype":"VFunctionID"},"ntype":"VFinishedStatementExpr","pre":null},"ntype":"VInvSpec","var_decls":{"ntype":"VVarDeclList","var_decls":[{"ntype":"VVarDecl","type":{"name":"ERC20","ntype":"VType"},"var":{"name":"erc20","ntype":"VID"}}]}}
```

### Using Dockerfile

Build using:

```bash
docker build -t veridise/v:1.0 .
```

Run using:

```bash
docker run -d -it --name v_run veridise/v:1.0
```

Access the bash using:

```bash
docker exec -it v_run bash
```

Stop snd remove using:

```bash
docker stop v_run
docker rm v_run
```

Alternatively, the VSCode remote extension for Docker can also be used to develop directly within the container.