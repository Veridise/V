grammar V;

/*
 * Parser Rules
 */

/*
 * Spec Rules
 */

behavioralSpec : invariant behavioralSpec
               | varsSection initSection? testSection behavioralSpec
               ;

invariantSpec  : invariant invariantSpec
               ;

temporalSpec : varsSection? ltlFairnessSection? ltlPropertySection temporalSpec
             ;


/*
 * Section Rules
 */
varsSection : ('Vars:' | 'vars:') declList
            ;

initSection : ('Init:' | 'init:') stmtList
            ;

testSection : ('Test:' | 'test:') stmtList
            ;

invariantSection : ('Invariant:' | 'invariant:') atom
                 ;

ltlFairnessSection : 'LTLFairness:' smartltl
                   ;

ltlPropertySection : 'LTLProperty:' smartltl
                   ;




/*
 * Variable Section Rules
 */
declList    : type ident 
            | type ident ',' declList
            ;

type        : IDENTIFIER
            ;


/*
 * Statement List
 */

stmtList    : atom
            | atom CON_BIN stmtList
            ;


/*
 * SmartLTL Rules
 */
smartltl    : atom 
            | '(' smartltl ')'
            | L_UN smartltl
            | T_UN smartltl 
            | smartltl  T_BIN  smartltl  
            | smartltl L_BIN smartltl 
            ;
               
atom        : ATOM_LOC '(' atomFn ',' constraint ')'
            | ATOM_LOC '(' atomFn ')' 
            | 'sent' '(' constraint ')'
            ;
               
atomFn      : atomFnName
            | '*'
            | atomFnName '(' params ')' 
            ;
            
atomFnName  : ident '.' ident
            | ident
            ;
               
params      : ident
            | ident ',' params
            | /*epsilon*/
            ; 

constraint  : varOrNum
            | '(' constraint ')'
            | A_UN constraint
            | L_UN constraint
            | constraint A1_BIN constraint
            | constraint A2_BIN constraint
            | constraint C_BIN constraint
            | constraint L_BIN constraint
            | fnCall
            ;

fnCall      : 'fsum' '(' atomFn ',' varAccess ',' constraint ')'
            | fnName '(' argList ')'
            ;
            
fnName      : ident '.' ident
            | ident
            ;
            
argList     : constraint
            | constraint ',' argList
            | /*epsilon*/
            ;

ident       : IDENTIFIER
            | ATOM_LOC
            ;
            
varOrNum    : varAccess
            | num
            ;
            
num         : NUM
            ;
            
varAccess   : ident
            | varAccess '[' constraint ']'
            | varAccess '.' ident
            ;
            


/*
 * Lexer Rules
 */

ATOM_LOC   : ('executed' | 'finished' | 'started' | 'reverted' | 'willSucceed') ;

CON_BIN    : (';' | '&&' | '||') ;

T_BIN      : (';' | 'U' | 'R' | '==>') ;

T_UN       : ('[]' | '<>' | 'X') ;

IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]* ;

A1_BIN     : ('*' | '/') ;

A2_BIN     : ('+' | '-') ;

A_UN       : '-';

C_BIN      : ('==' | '!=' | '<' | '>' | '<=' | '>=') ;

L_BIN      : ('&&' | '||') ;

L_UN       : '!' ;

NUM        : [0-9]+ ;

NEWLINE    : ('\r'? '\n' | '\r')+ ;

WHITESPACE : ' ' -> skip ;

