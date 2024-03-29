/**
 * Authors: Stanly, Andreea
 * 
 */

#include<iostream>
#include<any>
#include<boost/algorithm/string/join.hpp>

#include "../ast/VAST.h"
#include "ToStringVisitor.h"

using namespace vast;

namespace vastvisitor{
    
    std::any ToStringVisitor::visit(VAST* node){
        //Specification Types
        if(VBehavioralSpec* specNode = dynamic_cast<VBehavioralSpec*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VTestSpec* specNode = dynamic_cast<VTestSpec*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VTempSpec* specNode = dynamic_cast<VTempSpec*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VInvSpec* specNode = dynamic_cast<VInvSpec*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VSynthSpec* specNode = dynamic_cast<VSynthSpec*>(node))
            return std::any_cast<std::string>(visit(specNode));

        // VStatement and VConstraint Types
        else if(VStatementExpr* specNode = dynamic_cast<VStatementExpr*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VConstraintExpr* specNode = dynamic_cast<VConstraintExpr*>(node))
            return std::any_cast<std::string>(visit(specNode));

        // Rest
        else if(VID* specNode = dynamic_cast<VID*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VType* specNode = dynamic_cast<VType*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VVarDecl* specNode = dynamic_cast<VVarDecl*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VImport* specNode = dynamic_cast<VImport*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VImportList* specNode = dynamic_cast<VImportList*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VVarDeclList* specNode = dynamic_cast<VVarDeclList*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VBinOp* specNode = dynamic_cast<VBinOp*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VUnOp* specNode = dynamic_cast<VUnOp*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VArgList* specNode = dynamic_cast<VArgList*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else if(VFunctionID* specNode = dynamic_cast<VFunctionID*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else{
            // Add exception here.
            std::cout<<"Error";
            string empty = "";
            return empty;
        }
    }

    std::any ToStringVisitor::visit(VBehavioralSpec* node){
        string total;

        if (node->imports != nullptr) {
        total += "import: " + std::any_cast<std::string>(visit(node->imports)) + "\n";
        }
        if (node->var_decs != nullptr) {
        total += "vars: " + std::any_cast<std::string>(visit(node->var_decs)) + "\n";
        }
        if (node->pre != nullptr) {
        total += "pre: " + std::any_cast<std::string>(visit(node->pre)) + "\n";
        }
        if (node->post != nullptr) {
        total += "post: " + std::any_cast<std::string>(visit(node->post)) + "\n";
        }

        return total;
    }

    std::any ToStringVisitor::visit(VTestSpec* node){
        string total;

        if (node->imports != nullptr) {
        total += "import: " + std::any_cast<std::string>(visit(node->imports)) + "\n";
        }
        if (node->var_decs != nullptr) {
        total += "vars: " + std::any_cast<std::string>(visit(node->var_decs)) + "\n";
        }
        if (node->init != nullptr) {
        total += "init: " + std::any_cast<std::string>(visit(node->init))+ "\n";
        }
        if (node->spec != nullptr) {
        total += "spec: " + std::any_cast<std::string>(visit(node->spec)) + "\n";
        }

        return total;
    }

    std::any ToStringVisitor::visit(VTempSpec* node){

        string total;
    
        if (node->imports != nullptr) {
        total += "import: " + std::any_cast<std::string>(visit(node->imports)) + "\n";
        }
        if (node->var_decs != nullptr) {
        total += "vars: " + std::any_cast<std::string>(visit(node->var_decs)) + "\n";
        }
        if (node->fairness != nullptr) {
        total += "LTLFairness: " + std::any_cast<std::string>(visit(node->fairness)) + "\n";
        }
        if (node->spec != nullptr) {
        total += "LTLProperty: " + std::any_cast<std::string>(visit(node->spec)) + "\n";
        }

    return total;
    }

    std::any ToStringVisitor::visit(VInvSpec* node){
        string total;
        
        if (node->imports != nullptr) {
        total += "import: " + std::any_cast<std::string>(visit(node->imports)) + "\n";
        }
        if (node->var_decs != nullptr) {
        total += "vars: " + std::any_cast<std::string>(visit(node->var_decs)) + "\n";
        }
        if (node->inv != nullptr) {
        total += "inv: " + std::any_cast<std::string>(visit(node->inv)) + "\n";
        }

        return total;
    }

    std::any ToStringVisitor::visit(VSynthSpec* node){
        string total;

        if (node->imports != nullptr) {
        total += "import: " + std::any_cast<std::string>(visit(node->imports)) + "\n";
        }
        if (node->var_decls != nullptr) {
        total += "vars: " + std::any_cast<std::string>(visit(node->var_decls)) + "\n";
        }
        if (node->init != nullptr) {
        total += "init: " + std::any_cast<std::string>(visit(node->init))+ "\n";
        }
        if (node->synth != nullptr) {
        total += "synth: " + std::any_cast<std::string>(visit(node->synth)) + "\n";
        }

        return total;
    }

    std::any ToStringVisitor::visit(VID* node){
        return node->name;
    }
    std::any ToStringVisitor::visit(VType* node){
        return node->name;
    }

    std::any ToStringVisitor::visit(VVarDecl* node){
        string type = std::any_cast<std::string>(visit(node->typ));
        string var = std::any_cast<std::string>(visit(node->var));
        return type + " " + var;
    }

    std::any ToStringVisitor::visit(VVarDeclList* node){
        vector<string> varDecsString;
        for (VVarDecl* varDec : node->var_decs) {
            string varDecStr = std::any_cast<std::string>(visit(varDec));
            varDecsString.push_back(varDecStr);
        }
        string decls = boost::algorithm::join(varDecsString, ", ");
        return decls;
    }

    std::any ToStringVisitor::visit(vast::VStatementExpr* node){
        if(VUnStatementExpr* exprNode = dynamic_cast<VUnStatementExpr*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else if (VBinStatementExpr* exprNode = dynamic_cast<VBinStatementExpr*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else if (VExecutedStatement* exprNode = dynamic_cast<VExecutedStatement*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else if (VFinishedStatement* exprNode = dynamic_cast<VFinishedStatement*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else if (VStartedStatement* exprNode = dynamic_cast<VStartedStatement*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else if (VRevertedStatement* exprNode = dynamic_cast<VRevertedStatement*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else if (VWillSucceedStatement* exprNode = dynamic_cast<VWillSucceedStatement*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else{
            // Add exception here.
            std::cout<<"Error";
            string empty = "";
            return empty;
        }
    }

    // VStatementExpr derived classes.
    std::any ToStringVisitor::visit(VUnStatementExpr* node){
        string op = std::any_cast<std::string>(visit(node->op));
        string con = std::any_cast<std::string>(visit(node->con));
        return op + con;
    }

    std::any ToStringVisitor::visit(VBinStatementExpr* node){
        string lhs = std::any_cast<std::string>(visit(node->lhs));
        string op = std::any_cast<std::string>(visit(node->op));
        string rhs = std::any_cast<std::string>(visit(node->rhs));
        return "(" + lhs + " " + op + " " + rhs + ")";
    }

    std::any ToStringVisitor::visit(VExecutedStatement* node){
        string vExecutedStmtString = "executed(" + std::any_cast<std::string>(visit(node->fun));

        if (node->pre != nullptr) {
        vExecutedStmtString += ", " + std::any_cast<std::string>(visit(node->pre));
        }

        if (node->con != nullptr) {
        vExecutedStmtString += ", " + std::any_cast<std::string>(visit(node->con));
        }

        vExecutedStmtString += ")";
    
        return vExecutedStmtString;
    }
    std::any ToStringVisitor::visit(VFinishedStatement* node){
        string VFinishedStmtString = "finished(" + std::any_cast<std::string>(visit(node->fun));

        if (node->pre != nullptr) {
        VFinishedStmtString += ", " + std::any_cast<std::string>(visit(node->pre));
        }

        if (node->con != nullptr) {
        VFinishedStmtString += ", " + std::any_cast<std::string>(visit(node->con));
        }

        VFinishedStmtString += ")";
        return VFinishedStmtString;
    }
    std::any ToStringVisitor::visit(VStartedStatement* node){
        string VStartedStmtString = "started(" + std::any_cast<std::string>(visit(node->fun));

        if (node->con != nullptr) {
        VStartedStmtString += ", " + std::any_cast<std::string>(visit(node->con));
        }

        VStartedStmtString += ")";
        return VStartedStmtString;
    }
    std::any ToStringVisitor::visit(VRevertedStatement* node){
        string VRevertedStmtString = "reverted(" + std::any_cast<std::string>(visit(node->fun));

        if (node->con != nullptr) {
        VRevertedStmtString += ", " + std::any_cast<std::string>(visit(node->con));
        }

        VRevertedStmtString += ")";

        return VRevertedStmtString;
    }
    std::any ToStringVisitor::visit(VWillSucceedStatement* node){
        string VWillSucceedStmtString = "willSucceed(" + std::any_cast<std::string>(visit(node->fun));

        if (node->con != nullptr) {
        VWillSucceedStmtString += ", " + std::any_cast<std::string>(visit(node->con));;
        }
    
        VWillSucceedStmtString += ")";
    
        return VWillSucceedStmtString;
    }

    std::any ToStringVisitor::visit(VImport* node){
        return node->path;
    }
    std::any ToStringVisitor::visit(VImportList* node){
        vector<string> importsString;
        for (VImport *import : node->imports) {
        importsString.push_back(std::any_cast<std::string>(visit(import)));
        }

        string importListString = boost::algorithm::join(importsString, ", ");

        return importListString;
    }

    std::any ToStringVisitor::visit(VUnOp* node){
        return node->op;
    }

    std::any ToStringVisitor::visit(VBinOp* node){
        return node->op;
    }

    std::any ToStringVisitor::visit(VFunctionID* node){
        string baseString;
        string funcString = std::any_cast<std::string>(visit(node->fnName));
        string argsString;

        if (node->base != nullptr) {
        baseString = std::any_cast<std::string>(visit(node->base))+ ".";
        }
        if (node->args != nullptr) {
        argsString = std::any_cast<std::string>(visit(node->args));
        }

        string vFunctionIDString = baseString + funcString;

        if (funcString == "*") {
        return vFunctionIDString;
        } else {
        return vFunctionIDString + "(" + argsString + ")";
        }
    }

    std::any ToStringVisitor::visit(VArgList* node){
        vector<string> argsString;
        for (VConstraintExpr* arg : node->args) {
        argsString.push_back(std::any_cast<std::string>(visit(arg)));
        }
        
        string argsListString = boost::algorithm::join(argsString, ", ");

        return argsListString;
    }

    std::any ToStringVisitor::visit(VConstraintExpr* node){
        if(VUnExpr* exprNode = dynamic_cast<VUnExpr*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else if (VBinExpr* exprNode = dynamic_cast<VBinExpr*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else if (VVarExpr* exprNode = dynamic_cast<VVarExpr*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else if (VConstExpr* exprNode = dynamic_cast<VConstExpr*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else if (VFieldAccessExpr* exprNode = dynamic_cast<VFieldAccessExpr*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else if (VArrAccessExpr* exprNode = dynamic_cast<VArrAccessExpr*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else if (VFuncCallExpr* exprNode = dynamic_cast<VFuncCallExpr*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else if (VFSumExpr* exprNode = dynamic_cast<VFSumExpr*>(node))
            return std::any_cast<std::string>(visit(exprNode));
        else{
            // Add exception here.
            std::cout<<"Error";
            string empty = "";
            return empty;
        }
    }

    // Constraint expression types.
    std::any ToStringVisitor::visit(VUnExpr* node){
        string op = std::any_cast<std::string>(visit(node->op));
        string expr = std::any_cast<std::string>(visit(node->expr));
        return op + expr;
    }
    std::any ToStringVisitor::visit(VBinExpr* node){
        string lhs = std::any_cast<std::string>(visit(node->lhs));
        string op = std::any_cast<std::string>(visit(node->op));
        string rhs = std::any_cast<std::string>(visit(node->rhs));
        return "(" + lhs + " " + op + " " + rhs + ")";
    }
    std::any ToStringVisitor::visit(VVarExpr* node){
        return std::any_cast<std::string>(visit(node->var));
    }
    std::any ToStringVisitor::visit(VConstExpr* node){
        return node->val;
    }
    std::any ToStringVisitor::visit(VFieldAccessExpr* node){
        string expr= std::any_cast<std::string>(visit(node->expr));
        string field = std::any_cast<std::string>(visit(node->field));
        return expr + "." + field;
    }
    std::any ToStringVisitor::visit(VArrAccessExpr* node){
        string arr = std::any_cast<std::string>(visit(node->arr));
        string idx = std::any_cast<std::string>(visit(node->idx));

        return arr + "[" + idx + "]";
    }
    std::any ToStringVisitor::visit(VFuncCallExpr* node){
        string baseString;
        if (node->base != nullptr) {
        baseString = std::any_cast<std::string>(visit(node->base)) + ".";
        }
        string funcString = std::any_cast<std::string>(visit(node->fnName));
        string argsString = std::any_cast<std::string>(visit(node->args));
        string vFuncCallExprString = baseString + funcString + "(" + argsString + ")";

        return vFuncCallExprString;
    }
    std::any ToStringVisitor::visit(VFSumExpr* node){
        string funcString = std::any_cast<std::string>(visit(node->func));
        string argString = std::any_cast<std::string>(visit(node->arg));
        string conString = std::any_cast<std::string>(visit(node->con));
        string vFSumExprString = "fsum(" + funcString + ", " + argString + ", " + conString + ")";

        return vFSumExprString;
    }

}