#include <string.h>
#include "test/ParseTester/ParseTester.h"
#include "visitor/ToStringVisitor.h"

using namespace ParseTest;

using json = nlohmann::json;
using namespace boost::filesystem;
using namespace antlr4;
using namespace vastvisitor;
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

    ToStringVisitor tsvisitor;
    std::any specString = tsvisitor.visitSpec(tree);
    std::cout << std::any_cast<std::string>(specString) << '\n'; 

    // VASTVisitor visitor;
    // VAST* ast = visitor.visitSpec(tree);

    // json ast_json = ast->toJson();

    // std::cout << ast_json << "\n";
  }

  return 0;
}
