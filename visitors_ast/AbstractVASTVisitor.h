// /**
//  * Author: Stanly Samuel
//  * 
//  */

// #ifndef VAST_VISITOR_H
// #define VAST_VISITOR_H

// #include "../ast/VAST.h"
// // namespace vast{};
// using namespace vast;

// // class VAST;
// // class VStatementExpr;
// // class VID;
// // class VType;
// // class VVarDecl;
// // class VBehavioralSpec;
// // class VTestSpec;
// // class VTempSpec;
// // class VInvSpec;
// // class VSynthSpec;
// // class VBinOp;
// // class VBinStatementExpr;
// // class VUnOp;
// // class VUnStatementExpr;
// // class VConstraintExpr;
// // class VArgList;
// // class VFunctionID;
// // class VExecutedStatement;
// // class VFinishedStatement;
// // class VStartedStatement;
// // class VRevertedStatement;
// // class VWillSucceedStatement;
// // class VBinExpr;
// // class VUnExpr;
// // class VVarExpr;
// // class VConstExpr;
// // class VFieldAccessExpr;
// // class VArrAccessExpr;
// // class VFuncCallExpr;
// // class VAST;
// // class VAST;
// // class VAST;
// // class VAST;

// /**
//  * This class defines an interface, AbstractVASTVisitor for the VAST structure
//  */
// namespace vastvisitor {
//     class AbstractVASTVisitor
//         {
//             public:
//                 virtual std::any visit(vast::VAST* node) = 0;
//                 virtual std::any visit(vast::VStatementExpr* node) = 0;
//                 virtual std::any visit(vast::VID* node) = 0;
//                 // virtual std::any visit(VType* node) = 0;
//                 // virtual std::any visit(VVarDecl* node) = 0;
//                 // virtual std::any visit(VImport* node) = 0;
//                 // virtual std::any visit(VImportList* node) = 0;
//                 // virtual std::any visit(VVarDeclList* node) = 0;
//                 // virtual std::any visit(VBehavioralSpec* node) = 0;
//                 // virtual std::any visit(VTestSpec* node) = 0;
//                 // virtual std::any visit(VTempSpec* node) = 0;
//                 // virtual std::any visit(VInvSpec* node) = 0;
//                 // virtual std::any visit(VSynthSpec* node) = 0;
//                 // virtual std::any visit(VBinOp* node) = 0;
//                 // virtual std::any visit(VBinStatementExpr* node) = 0;
//                 // virtual std::any visit(VUnOp* node) = 0;
//                 // virtual std::any visit(VUnStatementExpr* node) = 0;
//                 // virtual std::any visit(VConstraintExpr* node) = 0;
//                 // virtual std::any visit(VArgList* node) = 0;
//                 // virtual std::any visit(VFunctionID* node) = 0;
//                 // virtual std::any visit(VExecutedStatement* node) = 0;
//                 // virtual std::any visit(VFinishedStatement* node) = 0;
//                 // virtual std::any visit(VStartedStatement* node) = 0;
//                 // virtual std::any visit(VRevertedStatement* node) = 0;
//                 // virtual std::any visit(VWillSucceedStatement* node) = 0;
//                 // virtual std::any visit(VBinExpr* node) = 0;
//                 // virtual std::any visit(VUnExpr* node) = 0;
//                 // virtual std::any visit(VVarExpr* node) = 0;
//                 // virtual std::any visit(VConstExpr* node) = 0;
//                 // virtual std::any visit(VFieldAccessExpr* node) = 0;
//                 // virtual std::any visit(VArrAccessExpr* node) = 0;
//                 // virtual std::any visit(VFuncCallExpr* node) = 0;
//                 // virtual std::any visit(VFSumExpr* node) = 0;
//         };
// }

// #endif //VAST_VISITOR_H