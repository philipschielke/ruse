/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
package ruse;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
        
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ruse {
    
    private static final ruseParser parser = new ruseParser(null); // share single parser instance

    public static void main(String[] args) throws Exception {

        InputStream is = System.in;
        String input_line;
        int current_line = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        EvalVisitor eval = new EvalVisitor();
        
        while ( true ) {             // while we have more expressions
            System.out.print("ruse> ");
            input_line = br.readLine();              // get first expression
            if (input_line == null) { break; }
            ANTLRInputStream input = new ANTLRInputStream(input_line+"\n");
            ruseLexer lexer = new ruseLexer(input);
            lexer.setLine(current_line);           // notify lexer of input position
            lexer.setCharPositionInLine(0);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser.setInputStream(tokens); // notify parser of new token stream
            ParseTree tree = parser.eval();                 // start the parser
            
            eval.visit(tree);
            current_line++;
        }
    }
}
