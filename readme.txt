Implemented forms:
car, cdr, cons,
+, -, *, / (two arguments only)
<, >, =
if, cond, or, and not,
define, set!, let
cons, car, cdr, list
empty? zero? list?
eval, apply, '

Partially implemented:

Things that I would like to work that don't:
* eval - eval is implemented but simply takes it input and runs the input string 
back through the parser.  Thus, this: (eval (list foo 4)) doesn't work because
the parser sees (eval #<procedure:foo> 4) and it can't tokenize #<proc...
This, however, does work: (eval '(foo 4)), since ' does not evaluate foo.

* ' - quote sort of works, but is a hack.  This is primarily due to the
main language features being implemented as syntactic forms and not symbols
that are mapped to code in some symbol table.  (see below)

Significant differences from other Scheme variants:
* Syntactic forms.  The language features such as arithmetic operators,
logical operators, conditional operators, and other built-in primitives
are implemented as part of the syntax of the RUSE language.  In other variants
(Racket, R5RS), these are merely symbols that have a default mapping to their
associated functions.  As such, they can be passed to other functions.  (In
R5RS they cannot be remapped by default, but in Racket they can.  So, for
example, (define + -) is allowed in Racket.)  The intent of this interpreter
is as a first interpreter in an intro programming languages class, so this
approach was taken in order to allow the students to see the syntax directly
in the grammar.

Note, that this difference affects constructs such as '.  '(+ 3 4) is
perfectly legal in Racket, since + is a symbol.  This is not legal in the
supplied RUSE interpreter since + is part of the syntax of the language.  This
also makes doing something like (map + '(1 2) '(3 4)) very challenging in RUSE.
I have had students successfully implement map, even using the builtin 
syntactic operators.

