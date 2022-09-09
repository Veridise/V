/**
 * Author: Stanly Samuel
 * 
 */

#ifndef ABSTRACTVAST_VISITOR_H
#define ABSTRACTVAST_VISITOR_H


#include "../ast/VAST.h"
using namespace vast;

/**
 * This class defines the interface for VAST Visitors.
 */
namespace vastvisitor {
    class AbstractVASTVisitor
        {
            public:
                virtual std::any visit(VAST* node) = 0;
                
                // VAST Types (17)
                virtual std::any visit(VID* node) = 0;
                virtual std::any visit(VType* node) = 0;
                virtual std::any visit(VVarDecl* node) = 0;
                virtual std::any visit(VImport* node) = 0;
                virtual std::any visit(VImportList* node) = 0;
                virtual std::any visit(VVarDeclList* node) = 0;
                virtual std::any visit(VBinOp* node) = 0;
                virtual std::any visit(VUnOp* node) = 0;
                virtual std::any visit(VArgList* node) = 0;
                virtual std::any visit(VFunctionID* node) = 0;
                
                virtual std::any visit(VBehavioralSpec* node)= 0;
                virtual std::any visit(VTestSpec* node)= 0;
                virtual std::any visit(VTempSpec* node)= 0;
                virtual std::any visit(VInvSpec* node)= 0;
                virtual std::any visit(VSynthSpec* node)= 0;
                
                virtual std::any visit(VStatementExpr* node) = 0;
                virtual std::any visit(VConstraintExpr* node) = 0;

                //VStatement Expression Types (7)
                virtual std::any visit(VUnStatementExpr* node)= 0;
                virtual std::any visit(VBinStatementExpr* node)= 0;
                virtual std::any visit(VExecutedStatement* node)= 0;
                virtual std::any visit(VFinishedStatement* node)= 0;
                virtual std::any visit(VStartedStatement* node)= 0;
                virtual std::any visit(VRevertedStatement* node)= 0;
                virtual std::any visit(VWillSucceedStatement* node)= 0;
                
                //VConstraint Expression Types (8)
                virtual std::any visit(VUnExpr* node)= 0;
                virtual std::any visit(VBinExpr* node)= 0;
                virtual std::any visit(VVarExpr* node)= 0;
                virtual std::any visit(VConstExpr* node)= 0;
                virtual std::any visit(VFieldAccessExpr* node)= 0;
                virtual std::any visit(VArrAccessExpr* node)= 0;
                virtual std::any visit(VFuncCallExpr* node)= 0;
                virtual std::any visit(VFSumExpr* node)= 0;
        };
}
#endif //ABSTRACTVAST_VISITOR_H