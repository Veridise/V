/**
 * Author: Stanly Samuel
 * 
 */

#ifndef VAST_VISITOR_H
#define VAST_VISITOR_H

#include "ast/VAST.h"
using namespace vast;

/**
 * This class defines an interface, AbstractVASTVisitor for the VAST structure
 */
namespace vastvisitor {
    class AbstractVASTVisitor
        {
            public:
                virtual std::any visit(VAST* node){};
                virtual std::any visit(VStatementExpr* node){};
                virtual std::any visit(VID* node){};
        };
}

#endif //VAST_VISITOR_H