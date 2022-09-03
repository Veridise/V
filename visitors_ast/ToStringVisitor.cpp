/**
 * Authors: Stanly, Andreea
 * 
 */

#include "ToStringVisitor.h"
#include<iostream>
#include<any>
#include <typeinfo>
#include <boost/algorithm/string/join.hpp>

#include "../ast/VAST.h"
using namespace vast;

namespace vastvisitor{
    
    std::any ToStringVisitor::visit(VAST* node){
        if(VBehavioralSpec* specNode = dynamic_cast<VBehavioralSpec*>(node))
            return visit(specNode);
        else if(VTestSpec* specNode = dynamic_cast<VTestSpec*>(node))
        {
            //Gives segmentation fault: VASTGenVisitor does not generate TestSpec AST properly.
        }
        else if(VTempSpec* specNode = dynamic_cast<VTempSpec*>(node))
            return visit(specNode);
        else if(VInvSpec* specNode = dynamic_cast<VInvSpec*>(node))
            return visit(specNode);
        else if(VSynthSpec* specNode = dynamic_cast<VSynthSpec*>(node))
            return visit(specNode);
            
        return "";
    }

    std::any ToStringVisitor::visit(VBehavioralSpec* node){

        return "";
    }

    std::any ToStringVisitor::visit(VTestSpec* node){
        visit(node->imports);
        visit(node->init);
        visit(node->spec);
        visit(node->var_decs);
        return "";
    }

    std::any ToStringVisitor::visit(VTempSpec* node){

        string total;
    
        // if (node->imports != nullptr) {
        // total += "import: " + std::any_cast<std::string>(visit(node->imports)) + "\n";
        // }
        // if (var_decs != nullptr) {
        total += "vars: " + std::any_cast<std::string>(visit(node->var_decs)) + "\n";
        // }
        // if (fairness != nullptr) {
        // total += "LTLFairness: " + visit(node->fairness) + "\n";
        // }
        // if (spec != nullptr) {
        total += "LTLProperty: " + std::any_cast<std::string>(visit(node->spec));
        // }

    return total;
    }

    std::any ToStringVisitor::visit(VInvSpec* node){

        return "";
    }

    std::any ToStringVisitor::visit(VSynthSpec* node){

        return "";
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
        else
            {//Throw exception. Confirm once with Ben for exhaution of cases.
            }
        string empty = "";
        return empty;
    }

    // VStatementExpr derived classes.
    std::any ToStringVisitor::visit(VUnStatementExpr* node){
        string op = std::any_cast<std::string>(visit(node->op));
        string con = std::any_cast<std::string>(visit(node->con));
        return op+ con;
    }

    std::any ToStringVisitor::visit(VBinStatementExpr* node){
        std::cout<<"Bin Stmt";
        string empty = "";
        return empty;
    }

    std::any ToStringVisitor::visit(VExecutedStatement* node){
        std::cout<<"Executed Stmt";
        string empty = "";
        return empty;
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
        std::cout<<"Started Stmt";
        string empty = "";
        return empty;
    }
    std::any ToStringVisitor::visit(VRevertedStatement* node){
        std::cout<<"Reverted stmt";
        string empty = "";
        return empty;
    }
    std::any ToStringVisitor::visit(VWillSucceedStatement* node){
        std::cout<<"Will Succeed Stmt";
        string empty = "";
        return empty;
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
        else
            {//Throw exception. Confirm once with Ben for exhaution of cases.
            }
        string empty = "";
        return empty;
    }

    // Constraint expression types.
    std::any ToStringVisitor::visit(VUnExpr* node){
        std::cout<<"VUnExpr";
        string empty = "";
        return empty;
    }
    std::any ToStringVisitor::visit(VBinExpr* node){
        std::cout<<"VBinExpr";
        string lhs = std::any_cast<std::string>(visit(node->lhs));
        string op = std::any_cast<std::string>(visit(node->op));
        string rhs = std::any_cast<std::string>(visit(node->rhs));
        return "(" + lhs + " " + op + " " + rhs + ")";
    }
    std::any ToStringVisitor::visit(VVarExpr* node){
        return std::any_cast<std::string>(visit(node->var));
    }
    std::any ToStringVisitor::visit(VConstExpr* node){
        std::cout<<"VConstExpr";
        string empty = "";
        return empty;
    }
    std::any ToStringVisitor::visit(VFieldAccessExpr* node){
        std::cout<<"VFieldAccessExpr";
        string expr= std::any_cast<std::string>(visit(node->expr));
        string field = std::any_cast<std::string>(visit(node->field));
        return expr + "." + field;
    }
    std::any ToStringVisitor::visit(VArrAccessExpr* node){
        std::cout<<"VArrExpr";
        string arr = std::any_cast<std::string>(visit(node->arr));
        string idx = std::any_cast<std::string>(visit(node->idx));

        return arr + "[" + idx + "]";
    }
    std::any ToStringVisitor::visit(VFuncCallExpr* node){
        std::cout<<"VFuncCallExpr";
        string empty = "";
        return empty;
    }
    std::any ToStringVisitor::visit(VFSumExpr* node){
        std::cout<<"VFSumExpr";
        string empty = "";
        return empty;
    }

}

// Only difference between Andreea's ToString and my Visitor was that I had to ensure downcast.
// UnOp is astring. Shouldn't there be ideally inherited classes such as GOp, LToP ETC?
// Also, took some time because of understanding VAST and V specs in general, which will be helpful in the future.