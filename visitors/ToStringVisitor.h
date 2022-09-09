/**
 * Author: Stanly Samuel
 * 
 */

#ifndef TOSTRING_VISITOR_H
#define TOSTRING_VISITOR_H


#include "../ast/VAST.h"
using namespace vast;

/**
 * This class defines the ToStringVisitor for the VAST that prints VAST in a string format.
 */
namespace vastvisitor {
    // class ToStringVisitor : public AbstractVASTVisitor
    class ToStringVisitor 
        {
            public:
                std::any visit(VAST* node);
                
                // VAST Types (17)
                std::any visit(VID* node);
                std::any visit(VType* node);
                std::any visit(VVarDecl* node);
                std::any visit(VImport* node);
                std::any visit(VImportList* node);
                std::any visit(VVarDeclList* node);
                std::any visit(VBinOp* node);
                std::any visit(VUnOp* node);
                std::any visit(VArgList* node);
                std::any visit(VFunctionID* node);
                
                std::any visit(VBehavioralSpec* node);
                std::any visit(VTestSpec* node);
                std::any visit(VTempSpec* node);
                std::any visit(VInvSpec* node);
                std::any visit(VSynthSpec* node);
                
                std::any visit(VStatementExpr* node);
                std::any visit(VConstraintExpr* node);

                //VStatement Expression Types (7)
                std::any visit(VUnStatementExpr* node);
                std::any visit(VBinStatementExpr* node);
                std::any visit(VExecutedStatement* node);
                std::any visit(VFinishedStatement* node);
                std::any visit(VStartedStatement* node);
                std::any visit(VRevertedStatement* node);
                std::any visit(VWillSucceedStatement* node);
                
                //VConstraint Expression Types (8)
                std::any visit(VUnExpr* node);
                std::any visit(VBinExpr* node);
                std::any visit(VVarExpr* node);
                std::any visit(VConstExpr* node);
                std::any visit(VFieldAccessExpr* node);
                std::any visit(VArrAccessExpr* node);
                std::any visit(VFuncCallExpr* node);
                std::any visit(VFSumExpr* node);
        };
}
#endif //TOSTRING_VISITOR_H