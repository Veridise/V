#include <string.h>
#include "test/ParseTester/ParseTester.h"
#include "visitors/ToStringVisitor.h"
#include "visitors/ToPropLTLVisitor.h"
#include "visitors/ToJsonVisitor.h"

using namespace ParseTest;

using json = nlohmann::json;
using namespace boost::filesystem;
using namespace antlr4;
using namespace vastgenvisitor;
using namespace vast;

int main(int argc, const char **argv) {

  if (argc <= 1) {
    cout << "WARNING: Passed no arguments! Pass a path or --parseTests!\n";
    return 0;
  }

  if (strcmp(argv[1], "--parseTests") == 0) { // make strncmp?
    ParseTester *pt = new ParseTester();
    pt->runTests();
  } else {
    std::ifstream specfile (argv[1]);
    std::string spec((std::istreambuf_iterator<char>(specfile)),
                     (std::istreambuf_iterator<char>()));
    
    std::cout<<"V-Cpp: Parsing the specfile with ANTLR \n";
    ANTLRInputStream input(spec.c_str());
    VLexer lexer(&input);
    CommonTokenStream tokens(&lexer);

    VParser parser(&tokens);
    VParser::SpecContext* tree = parser.spec();

    std::cout<<"V-Cpp: Creating the VAST using (parse tree) VASTGenVisitor \n";
    VASTGenVisitor visitor;
    VAST* ast = visitor.visitSpec(tree);

    //Using the ToString visitor.
    std::cout<<"V-Cpp: Converting VAST to String using the VAST ToStringVisitor \n";
    vastvisitor::ToStringVisitor tsvisitor;
    string vastString = std::any_cast<std::string>(tsvisitor.visit(ast));
    std::cout<<vastString <<"\n";

    //Using the ToPropLTL visitor.
    std::cout<<"V-Cpp: Converting VAST to propostional LTL using the VAST ToPropLTLVisitor \n";
    vastvisitor::ToPropLTLVisitor tpvisitor;
    try{
      string vastPropString = std::any_cast<std::string>(tpvisitor.visit(ast));
      std::cout<<vastPropString<< "\n";
      std::map<string, VAST*> atomMap = tpvisitor.getMap();
      tpvisitor.printMap();
    }
    catch(const char* txtException){
      std::cout<<"Exception: "<<txtException<<"\n";
    }

    // Using the ToJson visitor.
    std::cout<<"V-Cpp: Converting VAST to JSON using the VAST ToJsonVisitor \n";
    vastvisitor::ToJsonVisitor tjvisitor;
    json vastJsonString = std::any_cast<json>(tjvisitor.visit(ast));
    std::cout<<vastJsonString<<"\n \n";

    // Using the inbuilt Json function.
    std::cout<<"V-Cpp: Converting VAST to JSON without using any visitor \n";
    json ast_json = ast->toJson();
    std::cout << ast_json << "\n \n";
  }

  return 0;
}

