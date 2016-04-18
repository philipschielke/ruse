#RUSE
##Introduction
RUSE (RedUced SchemE) is a Scheme-like language loosely based on Scheme and Racket.  This
code implements a simple RUSE interpreter built on [ANTLR](http://antlr.org) and Java.  The project is intended
to be used as a programming project in an introductory Programming Languages Course.  It gives students
an opportunity to implement language features for a language with a simple syntax within
a parser generator system.  See the pdf file included in the repository for some sample student exercises.


###Use
This repository is a NetBeans
project.  After you clone the repository, simply "open" the project in NetBeans by
selecting "Open Project" and point NetBeans at the cloned directory.  Then
do a Clean and Build, and finally run the project.

To build from the command line you must have ant installed (as well as the jdk.)  To build from the command
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
* if, cond, or, and, not,
* define, set!, let, lambda
* cons, car, cdr, list
* empty? zero? list?
* eval, apply, '
* display, displayln
* load
  * (load "filename")

###Unit tests
The file testcases.ruse includes a simple test harness and
a set of (incomplete) unit tests.  To run, simply do a
(load "testcases.ruse") from the interpreter.  All testcases
should pass with the unmodified interpreter.

###Things that I would like to work that don't (or kind of work):
*eval* - eval is implemented but simply takes its input and runs the input string 
back through the parser.  Thus, this:

        (eval (list foo 4))

doesn't work because
the parser sees (eval #<procedure:foo> 4) and it can't tokenize #<proc...
This, however, does work:

    (eval '(foo 4))

since ' does not evaluate foo.

*'* - quote sort of works, but is a hack.  This is primarily due to the
main language features being implemented as syntactic forms and not symbols
that are mapped to code in some symbol table.  (see below)

### Significant differences from other Scheme variants:

* define is only allowed at the top level.  No local defines are allowed.

* Syntactic forms.  RUSE operators such as arithmetic operators,
logical operators, conditional operators, and other built-in primitives
are implemented as part of the *syntax* of the RUSE language.  In other variants
(Racket, R5RS), these are merely symbols that have a default mapping to their
associated functions.  As such, they can be passed to other functions.  (In
R5RS they cannot be remapped by default, but in Racket they can.  So, for
example, (define + -) is allowed in Racket.)  The intent of this interpreter
is as a first interpreter in an intro programming languages class, so this
approach was taken in order to allow the students to see the syntax directly
in the grammar.  This also makes accepting something like (map + '(1 2) '(3 4))
very challenging in RUSE.
I have had students successfully implement map, even using the builtin 
syntactic operators.

* quote ' does not allow syntatic forms to be quote.  For example, '(+ 3 4) is
perfectly legal in Racke, since + is a symbol not syntax.  This is not legal in the
supplied RUSE interpreter since + is part of the syntax of the language. No,
syntatic forms can be quoted, e.g. 'lambda, 'define, etc.

*Copyright Information*

The ANTLR jar file and the code in Ruse.java is licensed under the ANTLR 4 license below:  (See also [antlr.org](http://antlr.org)).

ANTLR 4 License

[The BSD License]

Copyright (c) 2012 Terence Parr and Sam Harwell
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
Neither the name of the author nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
