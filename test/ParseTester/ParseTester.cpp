#include "ParseTester.h"

using json = nlohmann::json;
using namespace boost::filesystem;
using namespace antlr4;
using namespace vastvisitor;
using namespace vast;

namespace ParseTest {
  ParseTester::ParseTester() : Tester() {

  }

  bool ParseTester::runTests() {
    directory_iterator end_itr;
    for (directory_iterator itr ("/workspaces/VInstrumenter/example_specs"); itr != end_itr; ++itr) {
      if (!is_directory(itr->status())) {
        std::cout << "Testing " << itr->path() << "\n--------\n";
        std::ifstream specfile (itr->path().string());
        std::string spec((std::istreambuf_iterator<char>(specfile)),
                         (std::istreambuf_iterator<char>()));
        if (!testParse(spec.c_str())) {
          return false; // Unreachable at the moment
        }
        std::cout << "----------------\n";
      }
    }
    return true;
  }

  bool ParseTester::testParse(const char *spec) {
    ANTLRInputStream input(spec);
    VLexer lexer(&input);
    CommonTokenStream tokens(&lexer);

    // tokens.fill();
    // for (auto token : tokens.getTokens()) {
    //   std::cout << token->toString() << std::endl;
    // }

    VParser parser(&tokens);
    VParser::SpecContext* tree = parser.spec();

    VASTVisitor visitor;
    VAST* ast = visitor.visitSpec(tree);

    json ast_json = ast->toJson();

    std::cout << ast_json << "\n";

    return true;
  }
}
