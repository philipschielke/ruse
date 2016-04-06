#RUSE
##Introduction
RUSE (RedUced SchemE) is a Scheme-like language loosely based on Scheme and Racket.  This
code implements a simple RUSE interpreter built on ANTLR and Java.  The project is intended
to be used as a programming in an introductory Programming Languages Course.  It gives students
an opportunity to implement language features for a language with a simple syntax within
a parser generator system.


###Use
This repository is a NetBeans
project.  After you clone the repository, simply "open" the project in NetBeans by
selecting "Open Project" and point NetBeans at the cloned direcoty.  Then
do a Clean and Build.

To build from the command line you must have ant installed.  To build from the command
line enter the cloned directory and type:

     ant -f /Users/phil/ruse -Dnb.internal.action.name=rebuild clean jar

After the build is complete, to run the RUSE interpreter type:

      java -jar "/Users/phil/ruse/dist/ruse.jar" 

##About the language/interpreter
###Implemented forms
The following forms are implemented in the provided interpreter and
work roughly like they would in Racket.

* car, cdr, cons,
* +, -, \*, / (two arguments only)
* <, >, =
* if, cond, or, and not,
* define, set!, let
* cons, car, cdr, list
* empty? zero? list?
* eval, apply, '

###Things that I would like to work that don't (or kind of work):
* eval - eval is implemented but simply takes it input and runs the input string 
back through the parser.  Thus, this: (eval (list foo 4)) doesn't work because
the parser sees (eval #<procedure:foo> 4) and it can't tokenize #<proc...
This, however, does work: (eval '(foo 4)), since ' does not evaluate foo.

* ' - quote sort of works, but is a hack.  This is primarily due to the
main language features being implemented as syntactic forms and not symbols
that are mapped to code in some symbol table.  (see below)

### Significant differences from other Scheme variants:
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

