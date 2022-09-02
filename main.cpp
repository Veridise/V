#include <string.h>
#include "test/ParseTester/ParseTester.h"
// #include "visitors_ast/ToPropVisitor.h"
#include "visitors_ast/ToStringVisitor.h"

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

    // std::any specString;
    // // Code to output String format
    // ToStringVisitor tsvisitor;
    // specString = tsvisitor.visitSpec(tree);
    // std::cout << std::any_cast<std::string>(specString) << '\n'; 

    // // Code to output Propositional format
    // ToPropVisitor tpvisitor;
    // specString = tpvisitor.visitSpec(tree);
    // std::cout << std::any_cast<std::string>(specString) << '\n'; 
    // std::cout << "Generated map:" <<"\n";
    // tpvisitor.printMap();

    // NO PROBLEM WITH parsetree visitors when used with VASTGenVisitors.
    // However VASTGenVisitor interferes with my AbstractVASTVisitor.
    // Understand namespaces and draw an includes diagram! ONLY way understand maybe
    // Or reimplement the visitor that I made earlier to get an idea and add namespaces to it!
    // Code to output JSON format

    VASTGenVisitor visitor;
    VAST* ast = visitor.visitSpec(tree);

    vastvisitor::ToStringVisitor tsvisitor;
    std::cout<<std::any_cast<std::string>(tsvisitor.visit(ast));

    json ast_json = ast->toJson();

    // std::cout << ast_json << "\n";
  }

  return 0;
}

