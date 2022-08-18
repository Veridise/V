grammar V;

/*
 * Spec Rules
 */

spec : behavioralSpec EOF 
     | testSpec EOF 
     | tempSpec EOF 
     | invariantSpec EOF 
     | synthSpec EOF
     ;


behavioralSpec : imports varsSection? precondSection? postcondSection
               ;

testSpec       : imports varsSection? initSection? specSection
               ;

tempSpec       : imports varsSection? ltlFairnessSection? ltlPropertySection
               ;

invariantSpec  : imports varsSection? invariantSection
               ;

synthSpec      : imports varsSection? initSection? synthSection
               ;

imports : IMPORT PATH imports
        | /*epsilon*/
        ;

/*
 * Section Rules
 */
varsSection : VARS_LABEL declList
            ;

precondSection : PRECOND_LABEL atom
               ;  

postcondSection : POSTCOND_LABEL atom
                ;

initSection : INIT_LABEL seqAtom
            ;

specSection : SPEC_LABEL seqAtom
            ;

synthSection : SYNTH_LABEL atom
             ;

ltlFairnessSection : LTLFAIR_LABEL smartltlAtom
                   ;

ltlPropertySection : LTLPROP_LABEL smartltlAtom
                   ;

invariantSection : INV_LABEL invAtom
                 ;

/*
 * Sequence of atoms
 */

seqAtom : atom
        | atom SEQ seqAtom
        ;

/*
 * Variable Section Rules
 */

declList    : typ ident
            | typ ident COMMA declList
            ;

typ        : IDENTIFIER
           | IDENTIFIER LBRACK RBRACK
           ;


/*
 * SmartLTL Rules
 */

smartltlAtom : atom
             | LPAREN smartltlAtom RPAREN
             | T_UN smartltlAtom
             | L_UN smartltlAtom
             | LBRACK RBRACK smartltlAtom
             | smartltlAtom T_BIN smartltlAtom
             | smartltlAtom IMP smartltlAtom
             | smartltlAtom SEQ smartltlAtom
             | smartltlAtom L_BIN smartltlAtom
             ;

invAtom     : atom
            | CONTRACT_INV LPAREN varAccess COMMA constraint RPAREN
            | CONTRACT_INV LPAREN varAccess COMMA constraint PRE_SEP constraint RPAREN
            ;

atom        : ATOM_PRE_LOC LPAREN atomFn COMMA constraint RPAREN
            | ATOM_PRE_LOC LPAREN atomFn RPAREN
            | ATOM_POST_LOC LPAREN atomFn COMMA constraint PRE_SEP constraint RPAREN
            | ATOM_POST_LOC LPAREN atomFn COMMA constraint RPAREN
            | ATOM_POST_LOC LPAREN atomFn RPAREN
            | LET LPAREN ident ASSN LBRACK params RBRACK RPAREN
            | FOREACH LPAREN ident IN ident COMMA atom RPAREN
            | SENT LPAREN constraint RPAREN
            | LPAREN atom RPAREN
            | L_UN atom
            | atom L_BIN atom
            ;
               
atomFn      : atomFnName
            | atomFnName LPAREN params RPAREN 
            ;
            
atomFnName  : varAccess DOT ident
            | varAccess DOT WILDCARD
            ;
               
params      : ident
            | ident COMMA params
            | NUM
            | NUM COMMA params
            | /*epsilon*/
            ; 

constraint  : boolExpr
            | LPAREN constraint RPAREN
            | constraint L_BIN constraint
            | constraint IMP constraint
            ;

boolExpr    : varOrNum
            | L_UN boolExpr
            | LPAREN boolExpr RPAREN
            | arithExpr C_BIN arithExpr
            ;

arithExpr   : varOrNum
            | LPAREN arithExpr RPAREN
            | arithExpr A1_BIN arithExpr
            | arithExpr A2_BIN arithExpr
            ;

fnCall      : FSUM LPAREN atomFn COMMA varOrNum COMMA constraint RPAREN
            | fnName LPAREN argList RPAREN
            ;
            
fnName      : fnName LPAREN argList RPAREN DOT ident
            | fnName LBRACK arithExpr RBRACK DOT ident
            | fnName DOT ident
            | ident
            ;
            
argList     : constraint
            | arithExpr
            | arithExpr COMMA argList
            | constraint COMMA argList
            | /*epsilon*/
            ;

ident       : IDENTIFIER
            | ATOM_PRE_LOC
            | ATOM_POST_LOC
            ;
            
varOrNum    : varAccess
            | num
            ;
            
num         : NUM
            ;
            
varAccess   : ident
            | fnCall
            | varAccess LBRACK arithExpr RBRACK
            | varAccess DOT ident
            ;

/*
 * Lexer Rules
 */

LPAREN : '(' ;
RPAREN : ')' ;
LBRACK : '[' ;
RBRACK : ']' ;
COMMA :   ',' ;
SENT :    'sent' ;
FSUM :    'fsum' ;
WILDCARD : '*' ;
DOT      : '.' ;
SEQ      : ';' ;
ASSN     : ':=' ;
LET      : 'let' ;
FOREACH  : 'foreach' ;
IN       : ':' ;
IMPORT   : 'import:' ;

VARS_LABEL : ('Vars:' | 'vars:' | 'Variables:' | 'variables:') ;       
PRECOND_LABEL : ('Pre:' | 'pre:'| 'Preconditions:' | 'preconditions:') ;       
POSTCOND_LABEL : ('Post:' | 'post:' | 'Postconditions:' | 'postconditions:') ;       
INIT_LABEL : ('Init:' | 'init:' | 'Assume:' | 'assume:') ;       
SPEC_LABEL : ('Spec:' | 'Specification:' | 'spec:' | 'specification:' | 'Assert:' | 'assert:') ;       
SYNTH_LABEL: ('Synth:' | 'Synthesize:' | 'synth:' | 'synthesize:') ;
LTLFAIR_LABEL : 'LTLFairness:' ;
LTLPROP_LABEL : 'LTLProperty:' ;
INV_LABEL : ('Inv:' | 'inv:' | 'Invariant:' | 'invariant:') ;

ATOM_PRE_LOC     : ('started' | 'reverted' | 'willSucceed') ;
ATOM_POST_LOC    : ('executed' | 'finished') ;
CONTRACT_INV : 'Cinv' ;

PRE_SEP    : '|=>' ;
IMP        : '==>' ;
T_BIN      : ('U' | 'R') ; // also includes ';' and '==>' but already specified above
T_UN       : ('<>' | 'X') ; // also includes '[]' but necessary in types also so specified above

PATH       : '"'[@./][a-zA-Z0-9/._\-]+'"' ;
IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]* ;

A1_BIN     : ('*' | '/') ;
A2_BIN     : ('+' | '-') ;
A_UN       : '-';
C_BIN      : ('=' | '!=' | '<' | '>' | '<=' | '>=') ;
L_BIN      : ('&&' | '||') ;
L_UN       : '!' ;

NUM        : ([0-9]+ | [0-9]+ 'e' [0-9]+) ;

NEWLINE    : ('\r'? '\n' | '\r')+ -> skip ;

WHITESPACE : ' ' -> skip ;
LINE_COMMENT : '#' ~[\r\n]* -> skip ;

