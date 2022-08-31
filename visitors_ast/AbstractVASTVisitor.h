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
    class AbstractVASTVisitor<Result, Arg>
        {
            public:
                virtual Result visit(VAST* node, Arg arg) = 0;
                virtual Result visit(VStatementExpr* node, Arg arg) = 0;
                virtual Result visit(VID* node, Arg arg) = 0;
                virtual Result visit(VType* node, Arg arg) = 0;
                virtual Result visit(VVarDecl* node, Arg arg) = 0;
                virtual Result visit(VImport* node, Arg arg) = 0;
                virtual Result visit(VImportList* node, Arg arg) = 0;
                virtual Result visit(VVarDeclList* node, Arg arg) = 0;
                virtual Result visit(VBehavioralSpec* node, Arg arg) = 0;
                virtual Result visit(VTestSpec* node, Arg arg) = 0;
                virtual Result visit(VTempSpec* node, Arg arg) = 0;
                virtual Result visit(VInvSpec* node, Arg arg) = 0;
                virtual Result visit(VSynthSpec* node, Arg arg) = 0;
                virtual Result visit(VBinOp* node, Arg arg) = 0;
                virtual Result visit(VBinStatementExpr* node, Arg arg) = 0;
                virtual Result visit(VUnOp* node, Arg arg) = 0;
                virtual Result visit(VUnStatementExpr* node, Arg arg) = 0;
                virtual Result visit(VConstraintExpr* node, Arg arg) = 0;
                virtual Result visit(VArgList* node, Arg arg) = 0;
                virtual Result visit(VFunctionID* node, Arg arg) = 0;
                virtual Result visit(VExecutedStatement* node, Arg arg) = 0;
                virtual Result visit(VFinishedStatement* node, Arg arg) = 0;
                virtual Result visit(VStartedStatement* node, Arg arg) = 0;
                virtual Result visit(VRevertedStatement* node, Arg arg) = 0;
                virtual Result visit(VWillSucceedStatement* node, Arg arg) = 0;
                virtual Result visit(VBinExpr* node, Arg arg) = 0;
                virtual Result visit(VUnExpr* node, Arg arg) = 0;
                virtual Result visit(VVarExpr* node, Arg arg) = 0;
                virtual Result visit(VConstExpr* node, Arg arg) = 0;
                virtual Result visit(VFieldAccessExpr* node, Arg arg) = 0;
                virtual Result visit(VArrAccessExpr* node, Arg arg) = 0;
                virtual Result visit(VFuncCallExpr* node, Arg arg) = 0;
                virtual Result visit(VFSumExpr* node, Arg arg) = 0;
        };
}

#endif //VAST_VISITOR_H