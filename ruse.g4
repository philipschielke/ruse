grammar ruse;

@header {
package ruse;
import java.util.*;
}

eval:    expr NEWLINE                                           # SExpr
    |   define                                                  # Def
    ;

expr
    :    LPAREN PLUS e1=expr e2=expr RPAREN                     # SimplePlus
    |    LPAREN MINUS e1=expr e2=expr RPAREN                    # SimpleMinus
    |    LPAREN TIMES e1=expr e2=expr RPAREN                    # SimpleTimes
    |    LPAREN DIVIDE e1=expr e2=expr RPAREN                   # SimpleDivide
    |    LPAREN CAR expr RPAREN                                 # Car
    |    LPAREN CDR expr RPAREN                                 # Cdr
    |    LPAREN CONS e1=expr e2=expr RPAREN                     # Cons
    |    LPAREN LIST ( expr )* RPAREN                           # List
    |    LPAREN LESSTHAN e1=expr e2=expr RPAREN                 # LessThan
    |    LPAREN GREATERTHAN e1=expr e2=expr RPAREN              # GreaterThan
    |    LPAREN EQUALS e1=expr e2=expr RPAREN                   # Equals
    |    LPAREN IF cond=expr thenpart=expr elsepart=expr RPAREN # IfThenElse
    |    LPAREN AND e1=expr e2=expr RPAREN                      # And
    |    LPAREN OR e1=expr e2=expr RPAREN                       # Or
    |    LPAREN NOT expr RPAREN                                 # Not
    |    INT                                                    # Int
    |    MINUS INT                                              # MinusInt
    |    STRING                                                 # String
    |    LPAREN f=expr (expr)* RPAREN                           # FuncCall
    |    ID                                                     # JustID
    |    LPAREN LET LPAREN ( letbinding )* RPAREN expr RPAREN   # Let
    |    lambda                                                 # LambdaMatch
    |    LPAREN COND ( LPAREN t=expr v=expr RPAREN )+ RPAREN    # Cond
//    |    SYMBOL                                                 # Symbol
    |    ELIST                                                  # EList
    |    LPAREN ZEROQ expr RPAREN                               # ZeroQ
    |    LPAREN EMPTYQ expr RPAREN                              # EmptyQ
    |    LPAREN LISTQ expr RPAREN                               # ListQ
    |    LPAREN EVAL expr RPAREN                                # Evaluate
    |    LPAREN APPLY f=expr l=expr RPAREN                      # Apply
    |    LPAREN EQUALQ e1=expr e2=expr RPAREN                   # EqualQ
    |    LPAREN SETBANG ID expr RPAREN                          # SetBang
    |    LPAREN DSPLYLN expr RPAREN                             # Displayln
    |    LPAREN LOAD STRING RPAREN                              # Load
    |    LPAREN (expr)* RPAREN                                  # OtherExpr
    |    QUOTE e=quoteexpr                                      # Quote
    ;

quoteexpr
    : INT                                                       #QuoteInt
    | ID                                                        #QuoteID
    | STRING                                                    #QuoteString
    | MINUS INT                                                 #QuoteMinusInt
    | LPAREN (quoteexpr)* RPAREN                                #QuoteList
    ;

define
    :   LPAREN DEFINE ID expr RPAREN                            #DefSimple
    |   LPAREN DEFINE LPAREN ( ID )+ RPAREN expr RPAREN         #DefFunc
    |   LPAREN DEFINE LPAREN ( ID )+ DOT ID RPAREN expr RPAREN  #DefFuncRest
    ;

lambda
    :   LPAREN LAMBDA LPAREN ( ID )* RPAREN expr RPAREN         
    |   LPAREN LAMBDA LPAREN ( ID )* DOT ID RPAREN expr RPAREN  
    ;

letbinding
    :   LPAREN ID expr RPAREN
    ;
        
// Lexer Code begins here

WS  :   [ \t]+ -> skip ; // toss out whitespace
COMMENT: ';' ~[\r\n]* '\r'? '\n' -> skip;
INT :   [0-9]+ ;         // Integer literals
DOT :   '.';
FLOAT : [0-9]*'.'[0-9]+; // Floating point literals
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
TIMES : '*' ;
DIVIDE : '/' ;
PLUS : '+' ;
MINUS : '-' ;
MODULO: '%';
LPAREN: '(';
RPAREN: ')';
CAR: 'car';
CDR: 'cdr';
CONS: 'cons';
LESSTHAN: '<';
GREATERTHAN: '>';
EQUALS: '=';
IF: 'if';
OR: 'or';
AND: 'and';
NOT: 'not';
DEFINE: 'define';
LAMBDA: 'lambda';
TRUE: '#t';
FALSE: '#f';
LIST: 'list';
COND: 'cond';
LET: 'let';
EMPTYQ: 'empty?';
ZEROQ: 'zero?';
LISTQ: 'list?';
EVAL: 'eval';
APPLY: 'apply';
STRING: '"'~('"')*'"';
ELIST: '\'()';
SETBANG: 'set!';
EQQ: 'eq?';
EQUALQ: 'equal?';
DSPLYLN: 'displayln';
LOAD: 'load';
ID: LEADING(LEADING|[0-9])*; // These are really scheme "symbols".
QUOTE: '\'';
LEADING: [A-Z]|'!'|'@'|'#'|'$'|'%'|'^'|'&'|'*'|'_'|[a-z]|'+'|'*'|'/'|'<'|'>';
