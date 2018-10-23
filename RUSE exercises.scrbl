#lang scribble/manual

@title{Ruse Exercises for Instructors}
@author{Philip Schielke}
@author+email["Philip Schielke" "philip.schielke@concordia.edu"] 

This document describes a set of exercises that instructors may have their students implement
within the supplied RUSE interpreter.  A brief introduction to the language and codebase is
described and a set of exercises is presented.  

Solutions to exercises may be provided to verified instructors by contacting the author
via email.

@section{Introduction}
You will  be working on an interpreter for RUSE, a subset of Scheme/Racket, which is
built on the ANTLR lexing and parsing system.  The system will automatically produce
a parse tree for each RUSE expression input by the user.
Once the tree is built, additional Java code (called visitors) will examine each node of the tree and produce the correct result.
For example if the grammar matches the following @racket[(cons 4 (cons 8 3))], the interpreter would generate a parse tree that looks like this:
@image{./antlr4_parse_tree.png}@(linebreak)
Later, when that tree is evaluated, the interpreter will create a Pair object with 8 and 3, and later a Pair object of 4 and the pair 8, 3.

@;------------------------------
@section{Current Language}
Currently the interpreter supports the following:
@itemlist[
   @item{@bold{@tt{+ - * /}}: with two operands only: @(linebreak)
	    @racket[(+ 3 4)] → 7@(linebreak)
	    @racket[(-5 4)] → 1}
   @item{@bold{@tt{= < >}}: relational operators, equals, less than, and greater than (2 operands only): @(linebreak)
	    @racket[(= 1 1)] → @racket[#t]@(linebreak)
	    @racket[(> 4 5)] → @racket[#f]}
   @item{@bold{@tt{and or not}}: logical and, or (two operands), and not (negation, 1 operand): @(linebreak)
	    @racket[(and (= 1 1) (= 1 2))] → @racket[#f] @(linebreak)
	    @racket[(or (= 1 1) (= 1 2))] → @racket[#t] @(linebreak)
	    @racket[(not (= 1 1))] → @racket[#f]}
   @item{@bold{@tt{if}}: a simple if conditional  (if <relational expr> <then expr> <else expr>) @(linebreak)
	    @racket[(if (= 1 1) "yes" "no")] → @racket["yes"] @(linebreak)
	    @racket[(if (= 1 0) "yes" "no")] → @racket["no"] @(linebreak)
	    @racket[(if (and (> 1 0) (< 0 1)) (+ 1 2) (+ 3 4))] -> @racket[3]}
   @item{@bold{@tt{cond}}: a more complex conditional, like a series of @tt{if-else} statements,
     or a @tt{switch} statement. @(linebreak)
     @tt{(cond (test1 (action1)) (test2 (action2)) ... (testn (actionn)))} @(linebreak)
     Each test is evaluated in order.  The action associated with the first test that evaluates to @racket[#t]
     is evaluated and its result is the result of the @racket[cond].  All other actions are ignored.
     For example:
	      @racketblock[(cond ((= 1 0) (+ 1 2))
				 ((= 1 1) (+ 1 3))
				 ((= 2 2) (+ 1 4)))]
     would return @racket[4], because @racket[(= 1 1)] is the first test that evaluates to true.
     The corresponding action @racket[(+ 1 3)] evalutes to 4.}
   @item{@bold{@tt{cons car cdr}}: behave as they would in Scheme or Racket.}
   @item{@bold{@tt{list}}: this creates a list of items.  A list is a special form of a cons pair,
     where the rightmost value in the list is the empty list.  For example:@(linebreak)
	   @racket[(list 4 "hello" (+ 3 4))] → @racket[(4 "hello" 7)] @(linebreak)
	   Empty list, @racket['()] is also matched as a literal.}
   @item{@bold{@tt{list?}}: Checks to see if its argument is a list.@(linebreak)
	      @racket[(list? (list 1 4))] → @racket[#t]@(linebreak)
	      @racket[(list? (cons 'a 'b))] → @racket[#f]}
   @item{@bold{@tt{empty?}}: Checks to see if a list is empty.@(linebreak)
	      @racket[(empty? (list 1 2))] → @racket[#f]@(linebreak)
	      @racket[(empty? (cdr (list 'a)))] → @racket[#t]}
   @item{@bold{@tt{zero?}}: Checks to see if its argument is 0.@(linebreak)
	      @racket[(zero? (- 5 5))] → @racket[#t]@(linebreak)
	      @racket[(zero? (- 5 4))] → @racket[#f]}
   @item{@bold{@racket['()]}: This is the empty list.  A list with no items in it.}
   @item{@bold{@tt{lambda}}: Lambda is used to create anonymous functions.  The format is: @(linebreak)
   	  @tt{(lambda (<paramaters>) <function body>)} @(linebreak)
	  Simply entering a lambda expression into the interpreter will create a function that then
          disappears.  In this example we are creating a function to square a value with lambda, and applying that function
	  to an argument, 7: @(linebreak)
	  @racket[((lambda (x) (* x x)) 7)] @(linebreak)
	  The result is 49.}
   @item{@bold{@tt{define}}: is used to set the values of global identifiers or assign names to functions. For example,
	  @racket[(define a 3)] sets the value of symbol 'a' to be 3.  Thus if you enter this into
	  the interpreter @racket[a] you would get the value @racket[3]. @racket[(define b "Hello World")]
	  sets the value of the symbol 'b' to be the string @racket["Hello World"].  
	  @racket[(define myPair (cons 1 2))] would set the symbol @tt{myPair} to be @tt{(1 . 2)}.
	  @(linebreak)
	  The format for using @tt{define} to create a function is this: @(linebreak)
	  @tt{(define (<function name> <list of parameters>) <function body>)} @(linebreak)
	  So, for example, to write a function called @tt{square} that squares the value of input @tt{x} we would write this: @(linebreak)
	  @racket[(define (square x) (* x x))] @(linebreak)
	  To call this function:
	  @racket[(square 5)] -> @racket[25].
	  }
   @item{@bold{@tt{let}}: creates local variables and binds them to values.  For example:@(linebreak)
   			 @racket[(let ((x 4)) (+ x 3))] would return 7, because @tt{x} is bound to 4 and
			 then added to 3. }
    @item{@bold{@tt{set!}}: @racket[(set! id expr)], evaluates expr and installs the result into the location for id,
    			    which must be bound as a local variable or defined as a top-level variable }
    @item{@bold{@tt{eval, apply, displayln, load}}}
]
@;------------------------------
@section{Code Organization}
You have been given a NetBeans project containing code for an interpreter that handles all the constructs above.  That code includes:
@itemlist[#:style 'ordered
     @item{@filepath{ruse.g4} - This is the ANTLR grammar file for RUSE}
     @item{@filepath{Pair.java} - Code to implement the Pair type (also used for lists)}
     @item{@filepath{Symbol.java} – A class to hold RUSE symbols}
     @item{@filepath{SymbolTable.java} - Code to implement the symbol table used for local variables in functions and globals set by @tt{define}}
     @item{@filepath{Function.java} - Creates a class Function to store details about RUSE functions.}
     @item{@filepath{EmptyList.java} – A class for the singleton RUSE empty list object.}
     @item{@filepath{Void.java} – A special class for RUSE void.}
     @item{@filepath{EvalVisitor.java} - This file contains all the code to visit nodes of the parse tree.  You will do most of your work in here.}
]

@;------------------------------
@section{Exercises}
	@itemlist[#:style 'ordered
	   @item{@bold{Short-circuit and/or}: Logical and/or do not ``short circuit'', but they should.  
	      Currently, both halves of an and/or expression are evaluated first and then the logical
	      operation is performed on the two results.  This is non-standard.  For example,@(linebreak)
	      @racket[(and (= 0 1) (= (/5 0) 0))] should simply return @racket[#f],
	      but currently it crashes the parser. If the first expression of an
	      @tt{and} expression is false, the second expression should not be evaluated.
	      Likewise, if the first expression of an @tt{or} expression is true,
      	      the second one should not be evaluated.}

	   @item{@bold{Boolean literals}: Implement the Boolean literals @racket[#t] (true) and @racket[#f] (false).
 	      For example, you could use @racket[#t] like this: @racket[(if #t 1 0)].  These are already
 	      matched in the lexer, but you will have to match them in the parser as well
	      (additional rules in @tt{expr}), as well as adding visitor functions to @filepath{EvalVisitor.java}.
	      These functions should return @tt{Boolean} values @tt{true} or @tt{false}.}

	   @item{@bold{modulo}: Add modulo (@tt{%}) to the language.
	      The @tt{%} symbol is already matched by the lexer, but nothing is done with
	      it.  You will add a rule to @tt{expr} in @filepath{ruse.g4}, and will need to add a visitor function
	      for modulo in @filepath{EvalVisitor.java}.  I suggest you look at the code for divide `/', and
	      use that as your basis for doing modulo.}

	   @item{@bold{String concatenation}: You will extend the language to make the addition of
	     strings perform string concatenation.
	      For example @racket[(+"Hello " "world!")] would return the string @racket["Hello world!"].
	      Currently, trying to add two strings just results in a Java exception being thrown.  You will
	      need to modify the @tt{VisitSimplePlus} visitor and possibly use Java's @tt{instanceOf} operator,
	      to check the types of the children under the '+' operator.  Also, to receive full credit,
	      you will need to get rid of the extra "" (double quote) characters within your new string.}

	   @item{@bold{Varargs arithmetic}: Currently, the @tt{list} operation can take any number of arguments.
	     However, +, -, *, and /  only take two arguments.  Modifiy the grammar in @filepath{ruse.g4} and
	     visitor functions in @filepath{EvalVisitor.java} to allow those arithmetic operations to accept
	     any number of arguments.  Use the code for @tt{list} as an example of how to do this.}

	  @item{@bold{Dynamic scope}: By default, this language is statically scoped.
	    You will implement dynamic scoping for variables within functions. For example, this code:
		@racketblock[(define a 4)
			     (define (foo x) a)
			     (define (bar a) (foo a))
			     (bar 7)]
	    gives, 4, since the binding of @tt{a} in @tt{foo} must be the @tt{a} in global scope
	    since there is no local variable @tt{a}.  If this were dynamically scoped, the above code would return 7,
	    since the @tt{a} in @tt{foo} would then be bound to the local variable @tt{a} in the function
	    that called it, namely @tt{bar}, where @tt{a} is bound to the value 7.}

	  @item{@bold{if-statements}: The following is a RUSE function that implements factorial recursively:
	    @racketblock[(define (fact x) (if (= 0 x) 1 (* x (fact (- x 1)))))]
	    You will discover that this correctly written recursive function
	    doesn't work properly in the RUSE interpreter.  (Executing this function produces the equivalent of an
	    infinite loop causing a Java stack overflow.)
	    The problem lies in the implementation of @tt{if}.  You need to fix this. (You might consider how the
	    @tt{if}-statement should work. Consider how you fixed the
	    @tt{and} and @tt{or} operations earlier.  The solution to the problem with @tt{if} is related.)}

	  @item{@bold{Lazy evaluation.}  Consider this RUSE code, @racket[(define a (* b 3))].
	     If the variable @tt{b} is not defined
	     then this code will result in an error.  Lazy evaluation says don't evaluate the
	     expression @racket[(* b 3)] until
	     the variable @tt{a} is actually needed.  You'll add a new version of define
	     called @racket[define-lazy].  @racket[define-lazy] will not evaluate the expression being
	     assigned until it is actually needed.  For example, consider this code sequence: 
			 @racketblock[(define-lazy a (* b 3))
				      (define b 4)
				      a]
	     This would return 12.  If we then did:
			 @racketblock[(define b 5)
				      a]
	     we would get 15. Here are the steps you need to take:
	     @itemlist[
		@item{add a matching rule for the keyword define-lazy to the lexer portion of @filepath{ruse.g4}}
		@item{add a rule to @tt{define} in @filepath{ruse.g4}.  This will look a lot like the rule labeled
							     @tt{#DefSimple}.  Label it @tt{#DefLazy}.}
		@item{add a vistitor function to @filepath{EvalVisitor.java}, @tt{visitDefLazy}.
		  This function will look a lot
		  like @tt{visitDefSimple}, but will not visit @tt{ctx.expr()}, but instead will put the
		  expression directly into the symbol table.}
		@item{Modify the function @tt{visitJustID}.  If the #tt{Object} stored in the symbol table is
		  an expression,
		  you need to visit it before returning the value from @tt{visitJustID}.}]}

	 @item{@bold{Floating point}: Implement a floating-point type.  This will work in a way very similar to the
	   integer type. Floating point types should work in arithmetic expressions (not @tt{%})
	   and relational expressions as well.  Floating point values are already
	   matched by the lexer.  See the @tt{FLOAT} matching rule in @filepath{ruse.g4}.
	   You will need to add a matching rule to @tt{expr} in @filepath{ruse.g4}, and will
	   need to add a visitor function for floats in @filepath{EvalVisitor.java}, as well as modifying		           the other visitor functions for arithmetic and relational operators in that file.}

	 @item{@bold{Type checking}:  This interpreter does very little type-checking.  For example, if you
	   execute @racket[(car 5)]
	   or @racket[(+ (cons 2 3) 7)], the interpreter simply crashes with a Java exception.
	   Your goal is to make type-checking work at least a little bit better.  You can simply use
	   try and catch to avoid
	   crashing the parser when there is a type error.  Or, you can check for the correct types
	   before performing an operation.  For example, consider the code in @tt{visitCar}.
	   This function evaluates the argument to @tt{car}, assumes it is a @tt{Pair}, then casts it to @tt{Pair}.
	   If the object returned by @tt{visit} is an @tt{Integer}, for example,
	   this will cause the interpreter to crash because it cannot convert @tt{Integer} to @tt{Pair}.
	   If you assign the result of @tt{visit} to a variable of type @tt{Object} and then check to
	   make sure it is @tt{Pair}, using @tt{instanceOf}, you could exit gracefully if it is not a @tt{Pair}.
	   You should check for errors in the following: car, cdr, arithmetic operations,
	   relational operations, if, cond, and, or, not.  I will check several expressions for each of these.}
		
	@item{@bold{map}: Implement the @racket[map] operator. The first argument to @racket[map] is a function and
	  the remaining arguments are lists of parameters to that function.  For example:@(linebreak)
	  @racket[(map + '(1 2 3) '(4 5 6))] takes each
	  element from the first list and adds it to the corresponding element in the second list,
	  returning another list.  In this case
	  you would get @racket['(5 7 9)].  Another example, @racket[(map (lambda (x) (* x x)) '(2 4 5))],
	  will take each item in the list and apply the square function to them, and return a list:
	  @racket['(4 16 25)].  Your task is to fully implement @racket[map].}

       @;{@item{@bold{var-args lambda}}}

]