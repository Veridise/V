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

### Using the VAST Visitors

This code is a part of the code present in ```main.cpp```. The comments explain the usage.

```cpp
    // Generate the ast from VASTGenVisitor as earlier
    VASTGenVisitor visitor;
    VAST* ast = visitor.visitSpec(tree);

    // Using the ToString visitor.
    vastvisitor::ToStringVisitor tsvisitor;
    string vastString = std::any_cast<std::string>(tsvisitor.visit(ast));
    std::cout<<vastString;

    // Using the ToPropLTL visitor. Throws a const char* exception.
    vastvisitor::ToPropLTLVisitor tpvisitor;
    try{
      string vastPropString = std::any_cast<std::string>(tpvisitor.visit(ast));
      std::cout<<vastPropString;
      // Extract the map
      std::map<string, VAST*> atomMap = tpvisitor.getMap();
      // Print the map
      tpvisitor.printMap();
    }
    catch(const char* txtException){
      std::cout<<"Exception: "<<txtException;
    }

    // Using the ToJson visitor.
    vastvisitor::ToJsonVisitor tjvisitor;
    json vastJsonString = std::any_cast<json>(tjvisitor.visit(ast));
    std::cout<<vastJsonString;
```

### Code organization
    .
    ├── ast                     # VAST Classes and an ANTLR4 visitor VASTGenVisitor to generate a VAST from V.g4
    ├── build                   # Compiled files
    ├── cmake                   # ANTLR cmake files
    ├── docs    
    ├── example_specs 
    ├── libs               
    ├── test                    # Automated tests
    ├── tools                   # Tools and utilities
    ├── visitors                # Visitors over the VAST.
    ├── CMakeLists.txt          
    ├── Dockerfile 
    ├── LICENSE
    ├── main.cpp                # Code showing the usage of the V language parser that generates VAST, and VAST visitors
    ├── README.md
    └── V.g4                    # V Specification grammar
    
### Use V as a submodule

Add `V` as a submodule of a project using:
```
git submodule add https://github.com/Veridise/V
```
Set up the project by including the following statements in the `CMakeLists.txt` file:
```
link_directories(V)
add_subdirectory(V)
target_link_libraries(project_executable PRIVATE parse_lib)
```
Commit and push the changes using:
```
git commit -am "Add V as a submodule"
git push
```
Clone a project that contains submodules using:
```
git clone --recurse-submodules https://github.com/project
```
OR
```
git clone https://github.com/project
git submodule init
git submodule update
```
