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
        // total += "LTLProperty: " + visit(node->spec);
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
        string a = std::any_cast<std::string>(visit(node->typ));
        string b = std::any_cast<std::string>(visit(node->var));
        return a + " " + b;
    }

    std::any ToStringVisitor::visit(VVarDeclList* node){
        vector<string> varDecsString;
        for (VVarDecl* v : node->var_decs) {
            string a = std::any_cast<std::string>(visit(v));
            varDecsString.push_back(a);
        }
        string decls = boost::algorithm::join(varDecsString, ", ");
        return decls;
    }
}