#ifndef V_TEST_H
#define V_TEST_H

#include <iostream>

#include "antlr4-runtime.h"

namespace Test {
  class Tester {
  public:
    virtual ~Tester() = default;
    virtual bool runTests() = 0;
  };
}

#endif
