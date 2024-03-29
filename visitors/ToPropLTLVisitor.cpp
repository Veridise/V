/**
 * Authors: Stanly, Andreea
 * 
 */

#include<iostream>
#include<any>
#include<boost/algorithm/string/join.hpp>

#include "../ast/VAST.h"
#include "ToPropLTLVisitor.h"
#include "ToStringVisitor.h"

using namespace vast;

namespace vastvisitor{

    string ToPropLTLVisitor::generateFreshVariable() {
        string variableNameBase = "x";
        string freshVariable = variableNameBase + to_string(currentVarIdx);
        currentVarIdx = currentVarIdx + 1;

        return freshVariable;
    };

    std::map<string, VAST*> ToPropLTLVisitor::getMap(){
        return freshVarsToAtoms;
     }
    
    void ToPropLTLVisitor::printMap(){
        vastvisitor::ToStringVisitor tsvisitor;
        std::cout<<"Printing Atoms Map: \n \n";
        std::cout<< "Variable -> Atom: \n";
        for(auto i : freshVarsToAtoms){
            string second = std::any_cast<std::string>(tsvisitor.visit(i.second));
            std::cout<< i.first + " -> " + second + " \n";
        }
        std::cout<<"\n";
    }
    
    std::any ToPropLTLVisitor::visit(VAST* node){
        //Specification Types
        if(VTempSpec* specNode = dynamic_cast<VTempSpec*>(node))
            return std::any_cast<std::string>(visit(specNode));
        else{
            throw "Not a Temporal Specification. ToPropLTLVisitor visits temporal specifications only. \n";
        }
    }

    std::any ToPropLTLVisitor::visit(VBehavioralSpec* node){
        string total;

        // if (node->imports != nullptr) {
        // total += "import: " + std::any_cast<std::string>(visit(node->imports)) + "\n";
        // }
        // if (node->var_decs != nullptr) {
        // total += "vars: " + std::any_cast<std::string>(visit(node->var_decs)) + "\n";
        // }
        // if (node->pre != nullptr) {
        // total += "pre: " + std::any_cast<std::string>(visit(node->pre)) + "\n";
        // }
        // if (node->post != nullptr) {
        // total += "post: " + std::any_cast<std::string>(visit(node->post)) + "\n";
        // }

        return total;
    }

    std::any ToPropLTLVisitor::visit(VTestSpec* node){
        string total;

        // if (node->imports != nullptr) {
        // total += "import: " + std::any_cast<std::string>(visit(node->imports)) + "\n";
        // }
        // if (node->var_decs != nullptr) {
        // total += "vars: " + std::any_cast<std::string>(visit(node->var_decs)) + "\n";
        // }
        // if (node->init != nullptr) {
        // total += "init: " + std::any_cast<std::string>(visit(node->init))+ "\n";
        // }
        // if (node->spec != nullptr) {
        // total += "spec: " + std::any_cast<std::string>(visit(node->spec)) + "\n";
        // }

        return total;
    }

    std::any ToPropLTLVisitor::visit(VTempSpec* node) {
        string total;

        if (node->fairness != nullptr && node->spec != nullptr) {
            return "(" + std::any_cast<std::string>(visit(node->fairness)) + "->" + std::any_cast<std::string>(visit(node->spec)) + ")";
        } else if (node->fairness != nullptr) {
            return std::any_cast<std::string>(visit(node->fairness));
        } else if (node->spec != nullptr) {
            return std::any_cast<std::string>(visit(node->spec));
        }

        return total;
    }

    std::any ToPropLTLVisitor::visit(VInvSpec* node){
        string total;
        
        // if (node->imports != nullptr) {
        // total += "import: " + std::any_cast<std::string>(visit(node->imports)) + "\n";
        // }
        // if (node->var_decs != nullptr) {
        // total += "vars: " + std::any_cast<std::string>(visit(node->var_decs)) + "\n";
        // }
        // if (node->inv != nullptr) {
        // total += "inv: " + std::any_cast<std::string>(visit(node->inv)) + "\n";
        // }

        return total;
    }

    std::any ToPropLTLVisitor::visit(VSynthSpec* node){
        string total;

        // if (node->imports != nullptr) {
        // total += "import: " + std::any_cast<std::string>(visit(node->imports)) + "\n";
        // }
        // if (node->var_decls != nullptr) {
        // total += "vars: " + std::any_cast<std::string>(visit(node->var_decls)) + "\n";
        // }
        // if (node->init != nullptr) {
        // total += "init: " + std::any_cast<std::string>(visit(node->init))+ "\n";
        // }
        // if (node->synth != nullptr) {
        // total += "synth: " + std::any_cast<std::string>(visit(node->synth)) + "\n";
        // }

        return total;
    }

    std::any ToPropLTLVisitor::visit(VID* node){
        return node->name;
    }
    std::any ToPropLTLVisitor::visit(VType* node){
        return node->name;
    }

    std::any ToPropLTLVisitor::visit(VVarDecl* node){
        string type = std::any_cast<std::string>(visit(node->typ));
        string var = std::any_cast<std::string>(visit(node->var));
        return type + " " + var;
    }

    std::any ToPropLTLVisitor::visit(VVarDeclList* node){
        vector<string> varDecsString;
        for (VVarDecl* varDec : node->var_decs) {
            string varDecStr = std::any_cast<std::string>(visit(varDec));
            varDecsString.push_back(varDecStr);
        }
        string decls = boost::algorithm::join(varDecsString, ", ");
        return decls;
    }

    std::any ToPropLTLVisitor::visit(vast::VStatementExpr* node){
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
    std::any ToPropLTLVisitor::visit(VUnStatementExpr* node){
        string op = std::any_cast<std::string>(visit(node->op));
        string con = std::any_cast<std::string>(visit(node->con));
        return op + "(" + con + ")";
    }

    std::any ToPropLTLVisitor::visit(VBinStatementExpr* node){
        string lhs = std::any_cast<std::string>(visit(node->lhs));
        string op = std::any_cast<std::string>(visit(node->op));
        string rhs = std::any_cast<std::string>(visit(node->rhs));
        return "(" + lhs + " " + op + " " + rhs + ")";
    }

    std::any ToPropLTLVisitor::visit(VExecutedStatement* node){
      string freshVar = generateFreshVariable();
      freshVarsToAtoms[freshVar] = node;

      return freshVar;
    }
    std::any ToPropLTLVisitor::visit(VFinishedStatement* node){
      string freshVar = generateFreshVariable();
      freshVarsToAtoms[freshVar] = node;

      return freshVar;
    }
    std::any ToPropLTLVisitor::visit(VStartedStatement* node){
      string freshVar = generateFreshVariable();
      freshVarsToAtoms[freshVar] = node;

      return freshVar;
    }
    std::any ToPropLTLVisitor::visit(VRevertedStatement* node){
      string freshVar = generateFreshVariable();
      freshVarsToAtoms[freshVar] = node;

      return freshVar;
    }
    std::any ToPropLTLVisitor::visit(VWillSucceedStatement* node){
      string freshVar = generateFreshVariable();
      freshVarsToAtoms[freshVar] = node;

      return freshVar;
    }

    std::any ToPropLTLVisitor::visit(VImport* node){
        return node->path;
    }
    std::any ToPropLTLVisitor::visit(VImportList* node){
        vector<string> importsString;
        for (VImport *import : node->imports) {
        importsString.push_back(std::any_cast<std::string>(visit(import)));
        }

        string importListString = boost::algorithm::join(importsString, ", ");

        return importListString;
    }

    std::any ToPropLTLVisitor::visit(VUnOp* node){
        return node->op;
    }

    std::any ToPropLTLVisitor::visit(VBinOp* node){
        if(node->op == "==>"){
            string ltlImpl = "->";
            return ltlImpl;
        }
        return node->op;
    }

    std::any ToPropLTLVisitor::visit(VFunctionID* node){
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

    std::any ToPropLTLVisitor::visit(VArgList* node){
        vector<string> argsString;
        for (VConstraintExpr* arg : node->args) {
        argsString.push_back(std::any_cast<std::string>(visit(arg)));
        }
        
        string argsListString = boost::algorithm::join(argsString, ", ");

        return argsListString;
    }

    std::any ToPropLTLVisitor::visit(VConstraintExpr* node){
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
    std::any ToPropLTLVisitor::visit(VUnExpr* node){
        string op = std::any_cast<std::string>(visit(node->op));
        string expr = std::any_cast<std::string>(visit(node->expr));
        return op + expr;
    }
    std::any ToPropLTLVisitor::visit(VBinExpr* node){
        string lhs = std::any_cast<std::string>(visit(node->lhs));
        string op = std::any_cast<std::string>(visit(node->op));
        string rhs = std::any_cast<std::string>(visit(node->rhs));
        return "(" + lhs + " " + op + " " + rhs + ")";
    }
    std::any ToPropLTLVisitor::visit(VVarExpr* node){
        return std::any_cast<std::string>(visit(node->var));
    }
    std::any ToPropLTLVisitor::visit(VConstExpr* node){
        return node->val;
    }
    std::any ToPropLTLVisitor::visit(VFieldAccessExpr* node){
        string expr= std::any_cast<std::string>(visit(node->expr));
        string field = std::any_cast<std::string>(visit(node->field));
        return expr + "." + field;
    }
    std::any ToPropLTLVisitor::visit(VArrAccessExpr* node){
        string arr = std::any_cast<std::string>(visit(node->arr));
        string idx = std::any_cast<std::string>(visit(node->idx));

        return arr + "[" + idx + "]";
    }
    std::any ToPropLTLVisitor::visit(VFuncCallExpr* node){
        string baseString;
        if (node->base != nullptr) {
        baseString = std::any_cast<std::string>(visit(node->base)) + ".";
        }
        string funcString = std::any_cast<std::string>(visit(node->fnName));
        string argsString = std::any_cast<std::string>(visit(node->args));
        string vFuncCallExprString = baseString + funcString + "(" + argsString + ")";

        return vFuncCallExprString;
    }
    std::any ToPropLTLVisitor::visit(VFSumExpr* node){
        string funcString = std::any_cast<std::string>(visit(node->func));
        string argString = std::any_cast<std::string>(visit(node->arg));
        string conString = std::any_cast<std::string>(visit(node->con));
        string vFSumExprString = "fsum(" + funcString + ", " + argString + ", " + conString + ")";

        return vFSumExprString;
    }

}