/**
 * Authors: Stanly, Ben?
 * 
 */

#include<iostream>
#include<any>

#include "../ast/VAST.h"
#include "ToJsonVisitor.h"

using json = nlohmann::json;
using namespace vast;

namespace vastvisitor{
    
    std::any ToJsonVisitor::visit(VAST* node){
        //Specification Types
        if(VBehavioralSpec* specNode = dynamic_cast<VBehavioralSpec*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VTestSpec* specNode = dynamic_cast<VTestSpec*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VTempSpec* specNode = dynamic_cast<VTempSpec*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VInvSpec* specNode = dynamic_cast<VInvSpec*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VSynthSpec* specNode = dynamic_cast<VSynthSpec*>(node))
            return std::any_cast<json>(visit(specNode));

        // VStatement and VConstraint Types
        else if(VStatementExpr* specNode = dynamic_cast<VStatementExpr*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VConstraintExpr* specNode = dynamic_cast<VConstraintExpr*>(node))
            return std::any_cast<json>(visit(specNode));

        // Rest
        else if(VID* specNode = dynamic_cast<VID*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VType* specNode = dynamic_cast<VType*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VVarDecl* specNode = dynamic_cast<VVarDecl*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VImport* specNode = dynamic_cast<VImport*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VImportList* specNode = dynamic_cast<VImportList*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VVarDeclList* specNode = dynamic_cast<VVarDeclList*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VBinOp* specNode = dynamic_cast<VBinOp*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VUnOp* specNode = dynamic_cast<VUnOp*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VArgList* specNode = dynamic_cast<VArgList*>(node))
            return std::any_cast<json>(visit(specNode));
        else if(VFunctionID* specNode = dynamic_cast<VFunctionID*>(node))
            return std::any_cast<json>(visit(specNode));
        else{
            // Add exception here.
            std::cout<<"Error";
            string empty = "";
            return empty;
        }
    }

    std::any ToJsonVisitor::visit(VBehavioralSpec* node){

        json varsJson = {};
        if (node->var_decs != nullptr) 
            varsJson = std::any_cast<json>(visit(node->var_decs));

        json preJson = {};
        if (node->pre != nullptr) 
            preJson = std::any_cast<json>(visit(node->pre));

        json postJson = {};
        if (node->post != nullptr) 
            postJson = std::any_cast<json>(visit(node->post));

        json importsJson = {};
        if (node->imports != nullptr) 
            importsJson = std::any_cast<json>(visit(node->imports));

        json total = {
        {"ntype", "VBehavioralSpec"}, {"imports", importsJson}, {"var_decls", varsJson}, {"pre", preJson}, {"post", postJson}
        };
        return total;
    }

    std::any ToJsonVisitor::visit(VTestSpec* node){
        json varsJson = {};
        if (node->var_decs != nullptr) 
            varsJson = std::any_cast<json>(visit(node->var_decs));

        json initJson = {};
        if (node->init != nullptr) 
            initJson = std::any_cast<json>(visit(node->init));
        
        json specJson = {};
        if (node->spec != nullptr)
            specJson  = std::any_cast<json>(visit(node->spec));

        json importsJson = {};
        if (node->imports != nullptr)
            importsJson = std::any_cast<json>(visit(node->imports));

        json total = {
        {"ntype", "VTestSpec"}, {"imports", importsJson}, {"var_decls", varsJson}, {"init", initJson}, {"spec", specJson}
        };
        return total;
    }

    std::any ToJsonVisitor::visit(VTempSpec* node){
        json varsJson = {};
        if (node->var_decs != nullptr) 
            varsJson = std::any_cast<json>(visit(node->var_decs));

        json fairnessJson = {};
        if (node->fairness != nullptr) 
            fairnessJson = std::any_cast<json>(visit(node->fairness));

        json specJson = {};
        if (node->spec != nullptr)
            specJson  = std::any_cast<json>(visit(node->spec));

        json importsJson = {};
        if (node->imports != nullptr)
            importsJson = std::any_cast<json>(visit(node->imports));

        json total = {
        {"ntype", "VTempSpec"}, {"imports", importsJson}, {"var_decls", varsJson}, {"fairness", fairnessJson}, {"spec", specJson}
        };
        return total;
    }

    std::any ToJsonVisitor::visit(VInvSpec* node){
        json varsJson = {};
        if (node->var_decs != nullptr) 
            varsJson = std::any_cast<json>(visit(node->var_decs));

        json invJson = {};
        if (node->inv != nullptr)
            invJson =  std::any_cast<json>(visit(node->inv));

        json importsJson = {};
        if (node->imports != nullptr)
            importsJson = std::any_cast<json>(visit(node->imports));

        json total = {
        {"ntype", "VInvSpec"}, {"imports", importsJson}, {"var_decls", varsJson}, {"inv", invJson}
        };
        return total;
    }

    std::any ToJsonVisitor::visit(VSynthSpec* node){
        json varsJson = {};
        if (node->var_decls != nullptr) 
            varsJson = std::any_cast<json>(visit(node->var_decls));

        json initJson = {};
        if (node->init != nullptr) 
            initJson = std::any_cast<json>(visit(node->init));
        
        json synthJson = {};
        if (node->synth != nullptr)
            synthJson  = std::any_cast<json>(visit(node->synth));

        json importsJson = {};
        if (node->imports != nullptr)
            importsJson = std::any_cast<json>(visit(node->imports));

        json total = {
        {"ntype", "VSynthSpec"}, {"imports", importsJson}, {"var_decls", varsJson}, {"init", initJson}, {"synth", synthJson}
        };
        return total;
    }

    std::any ToJsonVisitor::visit(VID* node){
        json vidJson = {
        {"ntype", "VID"}, {"name", node->name}
        };
        return vidJson;
    }
    std::any ToJsonVisitor::visit(VType* node){
        string typ_str = node->name;

        if (node->is_arr) 
            typ_str = node->name + "[]";

        json vtypJson = {
        {"ntype", "VType"}, {"name", typ_str}
        };

        return vtypJson;
    }

    std::any ToJsonVisitor::visit(VVarDecl* node){
        json declJson = {
        {"ntype", "VVarDecl"}, {"type", std::any_cast<json>(visit(node->typ))}, {"var", std::any_cast<json>(visit(node->var))}
        };
        return declJson;
    }

    std::any ToJsonVisitor::visit(VVarDeclList* node){
        vector<json> varDecsJson;

        for (VVarDecl* varDec : node->var_decs) {
            json varDecJson = std::any_cast<json>(visit(varDec));
            varDecsJson.push_back(varDecJson);
        }

        json declJson = {
        {"ntype", "VVarDeclList"}, {"var_decls", varDecsJson}
        };
        return declJson;
    }

    std::any ToJsonVisitor::visit(vast::VStatementExpr* node){
        if(VUnStatementExpr* exprNode = dynamic_cast<VUnStatementExpr*>(node))
            return std::any_cast<json>(visit(exprNode));
        else if (VBinStatementExpr* exprNode = dynamic_cast<VBinStatementExpr*>(node))
            return std::any_cast<json>(visit(exprNode));
        else if (VExecutedStatement* exprNode = dynamic_cast<VExecutedStatement*>(node))
            return std::any_cast<json>(visit(exprNode));
        else if (VFinishedStatement* exprNode = dynamic_cast<VFinishedStatement*>(node))
            return std::any_cast<json>(visit(exprNode));
        else if (VStartedStatement* exprNode = dynamic_cast<VStartedStatement*>(node))
            return std::any_cast<json>(visit(exprNode));
        else if (VRevertedStatement* exprNode = dynamic_cast<VRevertedStatement*>(node))
            return std::any_cast<json>(visit(exprNode));
        else if (VWillSucceedStatement* exprNode = dynamic_cast<VWillSucceedStatement*>(node))
            return std::any_cast<json>(visit(exprNode));
        else{
            // Add exception here.
            std::cout<<"Error";
            string empty = "";
            return empty;
        }
    }

    // VStatementExpr derived classes.
    std::any ToJsonVisitor::visit(VUnStatementExpr* node){
        
        json exprJson = std::any_cast<json>(visit(node->con));
        json opJson = std::any_cast<json>(visit(node->op));

        json vUnStmtExprJson = {
        {"ntype", "VUnStatementExpr"}, {"expr", exprJson}, {"op", opJson}
        };
        return vUnStmtExprJson;
    }

    std::any ToJsonVisitor::visit(VBinStatementExpr* node){

        json lhsJson = std::any_cast<json>(visit(node->lhs));
        json opJson = std::any_cast<json>(visit(node->op));
        json rhsJson = std::any_cast<json>(visit(node->rhs));

        json vBinStmtExprJson = {
        {"ntype", "VBinStatementExpr"}, {"lhs", lhsJson}, {"rhs", rhsJson}, {"op", opJson}
        };

        return vBinStmtExprJson;

    }

    std::any ToJsonVisitor::visit(VExecutedStatement* node){

        json funJson = {};
        if (node->fun != nullptr) 
            funJson = std::any_cast<json>(visit(node->fun));
        
        json preJson = {};
        if (node->pre != nullptr) 
            preJson = std::any_cast<json>(visit(node->pre));

        json conJson = {};
        if (node->con != nullptr) 
            conJson = std::any_cast<json>(visit(node->con));

        json vExecutedStmtJson = {
        {"ntype", "VExecutedStatementExpr"}, {"fun", funJson}, {"pre", preJson}, {"con", conJson}
        };

        return vExecutedStmtJson;
    }

    std::any ToJsonVisitor::visit(VFinishedStatement* node){

        json funJson = {};
        if (node->fun != nullptr) 
            funJson = std::any_cast<json>(visit(node->fun));

        json preJson = {};
        if (node->pre != nullptr) 
            preJson = std::any_cast<json>(visit(node->pre));

        json conJson = {};
        if (node->con != nullptr) 
            conJson = std::any_cast<json>(visit(node->con));

        json vFinishedStmtJson = {
        {"ntype", "VFinishedStatementExpr"}, {"fun", funJson}, {"pre", preJson}, {"con", conJson}
        };

        return vFinishedStmtJson;
    }

    std::any ToJsonVisitor::visit(VStartedStatement* node){

        json funJson = {};
        if (node->fun != nullptr) 
            funJson = std::any_cast<json>(visit(node->fun));
        
        json conJson = {};
        if (node->con != nullptr) 
            conJson = std::any_cast<json>(visit(node->con));

        json vStartedStmtJson = {
        {"ntype", "VStartedStatementExpr"}, {"fun", funJson}, {"con", conJson}
        };

        return vStartedStmtJson;
    }

    std::any ToJsonVisitor::visit(VRevertedStatement* node){

        json funJson = {};
        if (node->fun != nullptr) 
            funJson = std::any_cast<json>(visit(node->fun));

        json conJson = {};
        if (node->con != nullptr) 
            conJson = std::any_cast<json>(visit(node->con));

        json vRevertedStmtJson = {
        {"ntype", "VRevertedStatementExpr"}, {"fun", funJson}, {"con", conJson}
        };

        return vRevertedStmtJson;
    }

    std::any ToJsonVisitor::visit(VWillSucceedStatement* node){

        json funJson = {};
        if (node->fun != nullptr) 
            funJson = std::any_cast<json>(visit(node->fun));

        json conJson = {};
        if (node->con != nullptr) 
            conJson = std::any_cast<json>(visit(node->con));

        json vWillSucceedStmtJson = {
        {"ntype", "VWillSucceedStatementExpr"}, {"fun", funJson}, {"con", conJson}
        };

        return vWillSucceedStmtJson;
    }

    std::any ToJsonVisitor::visit(VImport* node){
        json importJson = {
        {"ntype", "VImport"}, {"path", node->path}
        };
        return importJson;
    }
    std::any ToJsonVisitor::visit(VImportList* node){

        vector<json> importsJson;
        for(VImport *import : node->imports) {
        importsJson.push_back(std::any_cast<json>(visit(import)));
        }
        json importListJson = {
        {"ntype", "VImportList"}, {"imports", importsJson}
        };
        return importListJson;
    }

    std::any ToJsonVisitor::visit(VUnOp* node){
        json vUnOpJson = {
        {"ntype", "VUnOp"}, {"op", node->op}
        };
        return vUnOpJson;
    }

    std::any ToJsonVisitor::visit(VBinOp* node){
        json vBinOpJson = {
        {"ntype", "VBinOp"}, {"op", node->op}
        };
        return vBinOpJson;
    }

    std::any ToJsonVisitor::visit(VFunctionID* node){
        json baseJson={};
        json funcJson = std::any_cast<json>(visit(node->fnName));
        json argsJson = {};

        if (node->base != nullptr) 
            argsJson = std::any_cast<json>(visit(node->base));

        if (node->args != nullptr) 
            argsJson = std::any_cast<json>(visit(node->args));

        json vFunctionIDJson = {
        {"ntype", "VFunctionID"}, {"base", baseJson}, {"func", funcJson}, {"args", argsJson}
        };
        return vFunctionIDJson;
    }

    std::any ToJsonVisitor::visit(VArgList* node){
        vector<json> argsJson;
        for (VConstraintExpr* arg : node->args) 
            argsJson.push_back(std::any_cast<json>(visit(arg)));

        json vArgListJson = {
        {"ntype", "VArgList"}, {"args", argsJson}
        };
        return vArgListJson;
    }

    std::any ToJsonVisitor::visit(VConstraintExpr* node){
        if(VUnExpr* exprNode = dynamic_cast<VUnExpr*>(node))
            return std::any_cast<json>(visit(exprNode));
        else if (VBinExpr* exprNode = dynamic_cast<VBinExpr*>(node))
            return std::any_cast<json>(visit(exprNode));
        else if (VVarExpr* exprNode = dynamic_cast<VVarExpr*>(node))
            return std::any_cast<json>(visit(exprNode));
        else if (VConstExpr* exprNode = dynamic_cast<VConstExpr*>(node))
            return std::any_cast<json>(visit(exprNode));
        else if (VFieldAccessExpr* exprNode = dynamic_cast<VFieldAccessExpr*>(node))
            return std::any_cast<json>(visit(exprNode));
        else if (VArrAccessExpr* exprNode = dynamic_cast<VArrAccessExpr*>(node))
            return std::any_cast<json>(visit(exprNode));
        else if (VFuncCallExpr* exprNode = dynamic_cast<VFuncCallExpr*>(node))
            return std::any_cast<json>(visit(exprNode));
        else if (VFSumExpr* exprNode = dynamic_cast<VFSumExpr*>(node))
            return std::any_cast<json>(visit(exprNode));
        else{
            // Add exception here.
            std::cout<<"Error";
            string empty = "";
            return empty;
        }
    }

    // Constraint expression types.
    std::any ToJsonVisitor::visit(VUnExpr* node){
        json exprJson = std::any_cast<json>(visit(node->expr));
        json opJson = std::any_cast<json>(visit(node->op));

        json vUnExprJson = {
        {"ntype", "VUnExpr"}, {"expr", exprJson}, {"op", opJson}
        };
        return vUnExprJson;
    }

    std::any ToJsonVisitor::visit(VBinExpr* node){
        json lhsJson = std::any_cast<json>(visit(node->lhs));
        json rhsJson = std::any_cast<json>(visit(node->rhs));
        json opJson = std::any_cast<json>(visit(node->op));

        json vBinExprJson = {
        {"ntype", "VBinExpr"}, {"lhs", lhsJson}, {"rhs", rhsJson}, {"op", opJson}
        };

        return vBinExprJson;
    }

    std::any ToJsonVisitor::visit(VVarExpr* node){
        json varJson = std::any_cast<json>(visit(node->var));
        json vVarExprJson = {
        {"ntype", "VVarExpr"}, {"var", varJson}
        };
        return vVarExprJson;
    }

    std::any ToJsonVisitor::visit(VConstExpr* node){
        json constExpr = {{"ntype", "VConstExpr"}, {"val", node->val}};
        return constExpr;
    }

    std::any ToJsonVisitor::visit(VFieldAccessExpr* node){
        json exprJson = std::any_cast<json>(visit(node->expr));
        json fieldJson = std::any_cast<json>(visit(node->field));
        json vFieldAccessExprJson = {
        {"ntype", "VFieldAccessExpr"}, {"expr", exprJson}, {"field", fieldJson}
        };
        return vFieldAccessExprJson;
    }

    std::any ToJsonVisitor::visit(VArrAccessExpr* node){
        json arrJson = std::any_cast<json>(visit(node->arr));
        json idxJson = std::any_cast<json>(visit(node->idx));
        json vArrAccessExprJson = {
        {"ntype", "VArrAccessExpr"}, {"arr", arrJson}, {"idx", idxJson}
        };
        return vArrAccessExprJson;
    }

    std::any ToJsonVisitor::visit(VFuncCallExpr* node){
        json baseJson = {};
        if(node->base != nullptr) {
            baseJson = std::any_cast<json>(visit(node->base));
        }
        json funcJson = std::any_cast<json>(visit(node->fnName));
        json argsJson = std::any_cast<json>(visit(node->args));

        json vFuncCallExprJson = {
        {"ntype", "VFuncCallExpr"}, {"base", baseJson}, {"func", funcJson}, {"args", argsJson}
        };

        return vFuncCallExprJson;
    }

    std::any ToJsonVisitor::visit(VFSumExpr* node){
        json funcJson = std::any_cast<json>(visit(node->func));
        json argJson = std::any_cast<json>(visit(node->arg));
        json conJson = std::any_cast<json>(visit(node->con));

        json vFSumExprJson = {
        {"ntype", "VFSumExpr"}, {"func", funcJson}, {"arg", argJson}, {"con", conJson}
        };
        return vFSumExprJson;
    }

}