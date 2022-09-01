// /**
//  * Author: Stanly Samuel
//  * 
//  */

// #ifndef TOSTRING_VISITOR_H
// #define TOSTRING_VISITOR_H

// #include "../ast/VAST.h"
// // using namespace vast;

// /**
//  * This class defines an interface, AbstractVASTVisitor for the VAST structure
//  */
// namespace vastvisitor {
//     class ToStringVisitor : public AbstractVASTVisitor
//         {
//             public:
//                 std::any visit(vast::VAST* node);
//                 std::any visit(vast::VStatementExpr* node);
//                 std::any visit(vst::VID* node);
//                 // std::any visit(VType* node);
//                 // std::any visit(VVarDecl* node);
//                 // std::any visit(VImport* node);
//                 // std::any visit(VImportList* node);
//                 // std::any visit(VVarDeclList* node);
//                 // std::any visit(VBehavioralSpec* node);
//                 // std::any visit(VTestSpec* node);
//                 // std::any visit(VTempSpec* node);
//                 // std::any visit(VInvSpec* node);
//                 // std::any visit(VSynthSpec* node);
//                 // std::any visit(VBinOp* node);
//                 // std::any visit(VBinStatementExpr* node);
//                 // std::any visit(VUnOp* node);
//                 // std::any visit(VUnStatementExpr* node);
//                 // std::any visit(VConstraintExpr* node);
//                 // std::any visit(VArgList* node);
//                 // std::any visit(VFunctionID* node);
//                 // std::any visit(VExecutedStatement* node);
//                 // std::any visit(VFinishedStatement* node);
//                 // std::any visit(VStartedStatement* node);
//                 // std::any visit(VRevertedStatement* node);
//                 // std::any visit(VWillSucceedStatement* node);
//                 // std::any visit(VBinExpr* node);
//                 // std::any visit(VUnExpr* node);
//                 // std::any visit(VVarExpr* node);
//                 // std::any visit(VConstExpr* node);
//                 // std::any visit(VFieldAccessExpr* node);
//                 // std::any visit(VArrAccessExpr* node);
//                 // std::any visit(VFuncCallExpr* node);
//                 // std::any visit(VFSumExpr* node);
//         };
// }
// #endif //TOSTRING_VISITOR_H