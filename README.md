# V

This repository contains the grammar for the V specification language (in V.g4) and a parser that converts a given V specification into an intermediate representation called VAST.

### Building

```bash
./build.sh
```
This step generates a library `libparse_lib.a` and an executable `parse` that links this library.
- A user can [run the exectuable](#usage) (compiled from `main.cpp`) to get an idea of how to use the V library.
- A user can also [include V as a submodule](#use-v-as-a-submodule) and include the libraries directly in their repostory.

### Usage

The `build/parse` executable compiled from `main.cpp ` invoke the V parser and visitors.

```bash
./parse <path-to-spec>
```

This executable takes as input a specification file, parses it using ANTLR4, converts the resulting parse tree into a VAST using VASTGenVisitor and performs various operations over it. For example, you can traverse the VAST using the ToString VAST visitor, to convert it into a string. 

To illustrate, running 

```bash
./parse ../example_specs/invariant1.spec
```
which contains the invariant specification
```
vars: ERC20 erc20
inv: finished(erc20.*, address(this).balance = sum(balances))
```

returns the following:

```bash
Parsing the specfile with ANTLR 
Creating the VAST using (parse tree) VASTGenVisitor 
Converting VAST to String using the VAST ToStringVisitor 
import: 
vars: ERC20 erc20
inv: finished(erc20.*, (address(this).balance = sum(balances)))

Converting VAST to propostional LTL using the VAST ToPropLTLVisitor 
Exception: Not a Temporal Specification. ToPropLTLVisitor visits temporal specifications only. 

Converting VAST to JSON using the VAST ToJsonVisitor 
{"imports":{"imports":[],"ntype":"VImportList"},"inv":{"con":{"lhs":{"expr":{"args":{"args":[{"ntype":"VVarExpr","var":{"name":"this","ntype":"VID"}}],"ntype":"VArgList"},"base":null,"func":{"name":"address","ntype":"VID"},"ntype":"VFuncCallExpr"},"field":{"name":"balance","ntype":"VID"},"ntype":"VFieldAccessExpr"},"ntype":"VBinExpr","op":{"ntype":"VBinOp","op":"="},"rhs":{"args":{"args":[{"ntype":"VVarExpr","var":{"name":"balances","ntype":"VID"}}],"ntype":"VArgList"},"base":null,"func":{"name":"sum","ntype":"VID"},"ntype":"VFuncCallExpr"}},"fun":{"args":{"ntype":"VVarExpr","var":{"name":"erc20","ntype":"VID"}},"base":null,"func":{"name":"*","ntype":"VID"},"ntype":"VFunctionID"},"ntype":"VFinishedStatementExpr","pre":null},"ntype":"VInvSpec","var_decls":{"ntype":"VVarDeclList","var_decls":[{"ntype":"VVarDecl","type":{"name":"ERC20","ntype":"VType"},"var":{"name":"erc20","ntype":"VID"}}]}}
 
Converting VAST to JSON without using any visitor 
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
git clone --recurse-submodules https://github.com/Veridise/V
```
OR
```
git clone https://github.com/Veridise/V
git submodule init
git submodule update
```
