#include <string.h>
#include "test/ParseTester/ParseTester.h"
#include "visitors_ast/ToStringVisitor.h"
#include "visitors_ast/ToPropVisitor.h"
#include "visitors_ast/ToJsonVisitor.h"

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
    ANTLRInputStream input(spec.c_str());
    VLexer lexer(&input);
    CommonTokenStream tokens(&lexer);

    VParser parser(&tokens);
    VParser::SpecContext* tree = parser.spec();

    VASTGenVisitor visitor;
    VAST* ast = visitor.visitSpec(tree);

    //Using the string visitor.
    vastvisitor::ToStringVisitor tsvisitor;
    string vastString = std::any_cast<std::string>(tsvisitor.visit(ast));
    std::cout<<vastString;

    //Using the prop visitor.
    vastvisitor::ToPropVisitor tpvisitor;
    string vastPropString = std::any_cast<std::string>(tpvisitor.visit(ast));
    std::cout<<vastPropString;
    std::map<string, VAST*> atomMap = tpvisitor.getMap();
    tpvisitor.printMap();

    // Using the JSON visitor.
    vastvisitor::ToJsonVisitor tjvisitor;
    json vastJsonString = std::any_cast<json>(tjvisitor.visit(ast));
    std::cout<<vastJsonString;

    // Using the inbuilt Json function.
    
    // json ast_json = ast->toJson();

    // std::cout << ast_json << "\n";
  }

  return 0;
}

