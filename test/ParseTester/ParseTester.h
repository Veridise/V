#ifndef VINSTRUMENTER_PARSETESTER_H
#define VINSTRUMENTER_PARSETESTER_H

#include <iostream>
#include <fstream>
#include <string>

#include "antlr4-runtime.h"
#include "../../libs/VLexer.h"
#include "../../libs/VParser.h"
#include "../Tester.h"
#include "../visitor/VASTVisitor.h"
#include "../ast/VAST.h"
#include "boost/filesystem.hpp"
#include "../libs/json.hpp"

using namespace Test;

namespace ParseTest {
  class ParseTester : public Tester {
  public:
    ParseTester();
    bool runTests() override;
    bool testParse(const char *);
  };
}

#endif
