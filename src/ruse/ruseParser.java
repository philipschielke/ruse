// Generated from /Users/phil/NetBeansProjects/ruse/ruse.g4 by ANTLR 4.4

package ruse;
import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ruseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, INT=3, DOT=4, FLOAT=5, NEWLINE=6, TIMES=7, DIVIDE=8, 
		PLUS=9, MINUS=10, MODULO=11, LPAREN=12, RPAREN=13, CAR=14, CDR=15, CONS=16, 
		LESSTHAN=17, GREATERTHAN=18, EQUALS=19, IF=20, OR=21, AND=22, NOT=23, 
		DEFINE=24, LAMBDA=25, TRUE=26, FALSE=27, LIST=28, COND=29, LET=30, EMPTYQ=31, 
		ZEROQ=32, LISTQ=33, EVAL=34, APPLY=35, STRING=36, ELIST=37, SETBANG=38, 
		EQQ=39, EQUALQ=40, DSPLYLN=41, LOAD=42, ID=43, QUOTE=44, LEADING=45;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "COMMENT", "INT", "'.'", "FLOAT", "NEWLINE", "'*'", 
		"'/'", "'+'", "'-'", "'%'", "'('", "')'", "'car'", "'cdr'", "'cons'", 
		"'<'", "'>'", "'='", "'if'", "'or'", "'and'", "'not'", "'define'", "'lambda'", 
		"'#t'", "'#f'", "'list'", "'cond'", "'let'", "'empty?'", "'zero?'", "'list?'", 
		"'eval'", "'apply'", "STRING", "''()'", "'set!'", "'eq?'", "'equal?'", 
		"'displayln'", "'load'", "ID", "'''", "LEADING"
	};
	public static final int
		RULE_eval = 0, RULE_expr = 1, RULE_quoteexpr = 2, RULE_define = 3, RULE_lambda = 4, 
		RULE_letbinding = 5;
	public static final String[] ruleNames = {
		"eval", "expr", "quoteexpr", "define", "lambda", "letbinding"
	};

	@Override
	public String getGrammarFileName() { return "ruse.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ruseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EvalContext extends ParserRuleContext {
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
	 
		public EvalContext() { }
		public void copyFrom(EvalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SExprContext extends EvalContext {
		public TerminalNode NEWLINE() { return getToken(ruseParser.NEWLINE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SExprContext(EvalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitSExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefContext extends EvalContext {
		public DefineContext define() {
			return getRuleContext(DefineContext.class,0);
		}
		public DefContext(EvalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eval);
		try {
			setState(16);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new SExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(12); expr();
				setState(13); match(NEWLINE);
				}
				break;
			case 2:
				_localctx = new DefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(15); define();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ZeroQContext extends ExprContext {
		public TerminalNode ZEROQ() { return getToken(ruseParser.ZEROQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public ZeroQContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitZeroQ(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DisplaylnContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode DSPLYLN() { return getToken(ruseParser.DSPLYLN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public DisplaylnContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitDisplayln(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoadContext extends ExprContext {
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LOAD() { return getToken(ruseParser.LOAD, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(ruseParser.STRING, 0); }
		public LoadContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitLoad(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode LESSTHAN() { return getToken(ruseParser.LESSTHAN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public LessThanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConsContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode CONS() { return getToken(ruseParser.CONS, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public ConsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitCons(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusIntContext extends ExprContext {
		public TerminalNode INT() { return getToken(ruseParser.INT, 0); }
		public TerminalNode MINUS() { return getToken(ruseParser.MINUS, 0); }
		public MinusIntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitMinusInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CdrContext extends ExprContext {
		public TerminalNode CDR() { return getToken(ruseParser.CDR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public CdrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitCdr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CarContext extends ExprContext {
		public TerminalNode CAR() { return getToken(ruseParser.CAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public CarContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitCar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleMinusContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(ruseParser.MINUS, 0); }
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public SimpleMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitSimpleMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OtherExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public OtherExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitOtherExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JustIDContext extends ExprContext {
		public TerminalNode ID() { return getToken(ruseParser.ID, 0); }
		public JustIDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitJustID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondContext extends ExprContext {
		public ExprContext t;
		public ExprContext v;
		public TerminalNode LPAREN(int i) {
			return getToken(ruseParser.LPAREN, i);
		}
		public TerminalNode COND() { return getToken(ruseParser.COND, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode RPAREN(int i) {
			return getToken(ruseParser.RPAREN, i);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(ruseParser.RPAREN); }
		public List<TerminalNode> LPAREN() { return getTokens(ruseParser.LPAREN); }
		public CondContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuoteContext extends ExprContext {
		public QuoteexprContext e;
		public TerminalNode QUOTE() { return getToken(ruseParser.QUOTE, 0); }
		public QuoteexprContext quoteexpr() {
			return getRuleContext(QuoteexprContext.class,0);
		}
		public QuoteContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitQuote(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode GREATERTHAN() { return getToken(ruseParser.GREATERTHAN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public GreaterThanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ApplyContext extends ExprContext {
		public ExprContext f;
		public ExprContext l;
		public TerminalNode APPLY() { return getToken(ruseParser.APPLY, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public ApplyContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public TerminalNode LIST() { return getToken(ruseParser.LIST, 0); }
		public ListContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(ruseParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaMatchContext extends ExprContext {
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public LambdaMatchContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitLambdaMatch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualQContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode EQUALQ() { return getToken(ruseParser.EQUALQ, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public EqualQContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitEqualQ(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyQContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EMPTYQ() { return getToken(ruseParser.EMPTYQ, 0); }
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public EmptyQContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitEmptyQ(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetContext extends ExprContext {
		public TerminalNode LPAREN(int i) {
			return getToken(ruseParser.LPAREN, i);
		}
		public TerminalNode LET() { return getToken(ruseParser.LET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN(int i) {
			return getToken(ruseParser.RPAREN, i);
		}
		public LetbindingContext letbinding(int i) {
			return getRuleContext(LetbindingContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(ruseParser.RPAREN); }
		public List<TerminalNode> LPAREN() { return getTokens(ruseParser.LPAREN); }
		public List<LetbindingContext> letbinding() {
			return getRuleContexts(LetbindingContext.class);
		}
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleTimesContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode TIMES() { return getToken(ruseParser.TIMES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public SimpleTimesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitSimpleTimes(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListQContext extends ExprContext {
		public TerminalNode LISTQ() { return getToken(ruseParser.LISTQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public ListQContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitListQ(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallContext extends ExprContext {
		public ExprContext f;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public FuncCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EvaluateContext extends ExprContext {
		public TerminalNode EVAL() { return getToken(ruseParser.EVAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public EvaluateContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitEvaluate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EListContext extends ExprContext {
		public TerminalNode ELIST() { return getToken(ruseParser.ELIST, 0); }
		public EListContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitEList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleDivideContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public TerminalNode DIVIDE() { return getToken(ruseParser.DIVIDE, 0); }
		public SimpleDivideContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitSimpleDivide(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(ruseParser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimplePlusContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode PLUS() { return getToken(ruseParser.PLUS, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public SimplePlusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitSimplePlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfThenElseContext extends ExprContext {
		public ExprContext cond;
		public ExprContext thenpart;
		public ExprContext elsepart;
		public TerminalNode IF() { return getToken(ruseParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public IfThenElseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitIfThenElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(ruseParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(ruseParser.OR, 0); }
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualsContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode EQUALS() { return getToken(ruseParser.EQUALS, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public EqualsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetBangContext extends ExprContext {
		public TerminalNode SETBANG() { return getToken(ruseParser.SETBANG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(ruseParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public SetBangContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitSetBang(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode AND() { return getToken(ruseParser.AND, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		int _la;
		try {
			setState(209);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new SimplePlusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(18); match(LPAREN);
				setState(19); match(PLUS);
				setState(20); ((SimplePlusContext)_localctx).e1 = expr();
				setState(21); ((SimplePlusContext)_localctx).e2 = expr();
				setState(22); match(RPAREN);
				}
				break;
			case 2:
				_localctx = new SimpleMinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(24); match(LPAREN);
				setState(25); match(MINUS);
				setState(26); ((SimpleMinusContext)_localctx).e1 = expr();
				setState(27); ((SimpleMinusContext)_localctx).e2 = expr();
				setState(28); match(RPAREN);
				}
				break;
			case 3:
				_localctx = new SimpleTimesContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(30); match(LPAREN);
				setState(31); match(TIMES);
				setState(32); ((SimpleTimesContext)_localctx).e1 = expr();
				setState(33); ((SimpleTimesContext)_localctx).e2 = expr();
				setState(34); match(RPAREN);
				}
				break;
			case 4:
				_localctx = new SimpleDivideContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(36); match(LPAREN);
				setState(37); match(DIVIDE);
				setState(38); ((SimpleDivideContext)_localctx).e1 = expr();
				setState(39); ((SimpleDivideContext)_localctx).e2 = expr();
				setState(40); match(RPAREN);
				}
				break;
			case 5:
				_localctx = new CarContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(42); match(LPAREN);
				setState(43); match(CAR);
				setState(44); expr();
				setState(45); match(RPAREN);
				}
				break;
			case 6:
				_localctx = new CdrContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(47); match(LPAREN);
				setState(48); match(CDR);
				setState(49); expr();
				setState(50); match(RPAREN);
				}
				break;
			case 7:
				_localctx = new ConsContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(52); match(LPAREN);
				setState(53); match(CONS);
				setState(54); ((ConsContext)_localctx).e1 = expr();
				setState(55); ((ConsContext)_localctx).e2 = expr();
				setState(56); match(RPAREN);
				}
				break;
			case 8:
				_localctx = new ListContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(58); match(LPAREN);
				setState(59); match(LIST);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << MINUS) | (1L << LPAREN) | (1L << STRING) | (1L << ELIST) | (1L << ID) | (1L << QUOTE))) != 0)) {
					{
					{
					setState(60); expr();
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66); match(RPAREN);
				}
				break;
			case 9:
				_localctx = new LessThanContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(67); match(LPAREN);
				setState(68); match(LESSTHAN);
				setState(69); ((LessThanContext)_localctx).e1 = expr();
				setState(70); ((LessThanContext)_localctx).e2 = expr();
				setState(71); match(RPAREN);
				}
				break;
			case 10:
				_localctx = new GreaterThanContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(73); match(LPAREN);
				setState(74); match(GREATERTHAN);
				setState(75); ((GreaterThanContext)_localctx).e1 = expr();
				setState(76); ((GreaterThanContext)_localctx).e2 = expr();
				setState(77); match(RPAREN);
				}
				break;
			case 11:
				_localctx = new EqualsContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(79); match(LPAREN);
				setState(80); match(EQUALS);
				setState(81); ((EqualsContext)_localctx).e1 = expr();
				setState(82); ((EqualsContext)_localctx).e2 = expr();
				setState(83); match(RPAREN);
				}
				break;
			case 12:
				_localctx = new IfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(85); match(LPAREN);
				setState(86); match(IF);
				setState(87); ((IfThenElseContext)_localctx).cond = expr();
				setState(88); ((IfThenElseContext)_localctx).thenpart = expr();
				setState(89); ((IfThenElseContext)_localctx).elsepart = expr();
				setState(90); match(RPAREN);
				}
				break;
			case 13:
				_localctx = new AndContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(92); match(LPAREN);
				setState(93); match(AND);
				setState(94); ((AndContext)_localctx).e1 = expr();
				setState(95); ((AndContext)_localctx).e2 = expr();
				setState(96); match(RPAREN);
				}
				break;
			case 14:
				_localctx = new OrContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(98); match(LPAREN);
				setState(99); match(OR);
				setState(100); ((OrContext)_localctx).e1 = expr();
				setState(101); ((OrContext)_localctx).e2 = expr();
				setState(102); match(RPAREN);
				}
				break;
			case 15:
				_localctx = new NotContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(104); match(LPAREN);
				setState(105); match(NOT);
				setState(106); expr();
				setState(107); match(RPAREN);
				}
				break;
			case 16:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(109); match(INT);
				}
				break;
			case 17:
				_localctx = new MinusIntContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(110); match(MINUS);
				setState(111); match(INT);
				}
				break;
			case 18:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(112); match(STRING);
				}
				break;
			case 19:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(113); match(LPAREN);
				setState(114); ((FuncCallContext)_localctx).f = expr();
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << MINUS) | (1L << LPAREN) | (1L << STRING) | (1L << ELIST) | (1L << ID) | (1L << QUOTE))) != 0)) {
					{
					{
					setState(115); expr();
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(121); match(RPAREN);
				}
				break;
			case 20:
				_localctx = new JustIDContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(123); match(ID);
				}
				break;
			case 21:
				_localctx = new LetContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(124); match(LPAREN);
				setState(125); match(LET);
				setState(126); match(LPAREN);
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LPAREN) {
					{
					{
					setState(127); letbinding();
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(133); match(RPAREN);
				setState(134); expr();
				setState(135); match(RPAREN);
				}
				break;
			case 22:
				_localctx = new LambdaMatchContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(137); lambda();
				}
				break;
			case 23:
				_localctx = new CondContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(138); match(LPAREN);
				setState(139); match(COND);
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(140); match(LPAREN);
					setState(141); ((CondContext)_localctx).t = expr();
					setState(142); ((CondContext)_localctx).v = expr();
					setState(143); match(RPAREN);
					}
					}
					setState(147); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LPAREN );
				setState(149); match(RPAREN);
				}
				break;
			case 24:
				_localctx = new EListContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(151); match(ELIST);
				}
				break;
			case 25:
				_localctx = new ZeroQContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(152); match(LPAREN);
				setState(153); match(ZEROQ);
				setState(154); expr();
				setState(155); match(RPAREN);
				}
				break;
			case 26:
				_localctx = new EmptyQContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(157); match(LPAREN);
				setState(158); match(EMPTYQ);
				setState(159); expr();
				setState(160); match(RPAREN);
				}
				break;
			case 27:
				_localctx = new ListQContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(162); match(LPAREN);
				setState(163); match(LISTQ);
				setState(164); expr();
				setState(165); match(RPAREN);
				}
				break;
			case 28:
				_localctx = new EvaluateContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(167); match(LPAREN);
				setState(168); match(EVAL);
				setState(169); expr();
				setState(170); match(RPAREN);
				}
				break;
			case 29:
				_localctx = new ApplyContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(172); match(LPAREN);
				setState(173); match(APPLY);
				setState(174); ((ApplyContext)_localctx).f = expr();
				setState(175); ((ApplyContext)_localctx).l = expr();
				setState(176); match(RPAREN);
				}
				break;
			case 30:
				_localctx = new EqualQContext(_localctx);
				enterOuterAlt(_localctx, 30);
				{
				setState(178); match(LPAREN);
				setState(179); match(EQUALQ);
				setState(180); ((EqualQContext)_localctx).e1 = expr();
				setState(181); ((EqualQContext)_localctx).e2 = expr();
				setState(182); match(RPAREN);
				}
				break;
			case 31:
				_localctx = new SetBangContext(_localctx);
				enterOuterAlt(_localctx, 31);
				{
				setState(184); match(LPAREN);
				setState(185); match(SETBANG);
				setState(186); match(ID);
				setState(187); expr();
				setState(188); match(RPAREN);
				}
				break;
			case 32:
				_localctx = new DisplaylnContext(_localctx);
				enterOuterAlt(_localctx, 32);
				{
				setState(190); match(LPAREN);
				setState(191); match(DSPLYLN);
				setState(192); expr();
				setState(193); match(RPAREN);
				}
				break;
			case 33:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 33);
				{
				setState(195); match(LPAREN);
				setState(196); match(LOAD);
				setState(197); match(STRING);
				setState(198); match(RPAREN);
				}
				break;
			case 34:
				_localctx = new OtherExprContext(_localctx);
				enterOuterAlt(_localctx, 34);
				{
				setState(199); match(LPAREN);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << MINUS) | (1L << LPAREN) | (1L << STRING) | (1L << ELIST) | (1L << ID) | (1L << QUOTE))) != 0)) {
					{
					{
					setState(200); expr();
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(206); match(RPAREN);
				}
				break;
			case 35:
				_localctx = new QuoteContext(_localctx);
				enterOuterAlt(_localctx, 35);
				{
				setState(207); match(QUOTE);
				setState(208); ((QuoteContext)_localctx).e = quoteexpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuoteexprContext extends ParserRuleContext {
		public QuoteexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quoteexpr; }
	 
		public QuoteexprContext() { }
		public void copyFrom(QuoteexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QuoteStringContext extends QuoteexprContext {
		public TerminalNode STRING() { return getToken(ruseParser.STRING, 0); }
		public QuoteStringContext(QuoteexprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitQuoteString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuoteMinusIntContext extends QuoteexprContext {
		public TerminalNode INT() { return getToken(ruseParser.INT, 0); }
		public TerminalNode MINUS() { return getToken(ruseParser.MINUS, 0); }
		public QuoteMinusIntContext(QuoteexprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitQuoteMinusInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuoteIntContext extends QuoteexprContext {
		public TerminalNode INT() { return getToken(ruseParser.INT, 0); }
		public QuoteIntContext(QuoteexprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitQuoteInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuoteListContext extends QuoteexprContext {
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public QuoteexprContext quoteexpr(int i) {
			return getRuleContext(QuoteexprContext.class,i);
		}
		public List<QuoteexprContext> quoteexpr() {
			return getRuleContexts(QuoteexprContext.class);
		}
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public QuoteListContext(QuoteexprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitQuoteList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuoteIDContext extends QuoteexprContext {
		public TerminalNode ID() { return getToken(ruseParser.ID, 0); }
		public QuoteIDContext(QuoteexprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitQuoteID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuoteexprContext quoteexpr() throws RecognitionException {
		QuoteexprContext _localctx = new QuoteexprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_quoteexpr);
		int _la;
		try {
			setState(224);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new QuoteIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(211); match(INT);
				}
				break;
			case ID:
				_localctx = new QuoteIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(212); match(ID);
				}
				break;
			case STRING:
				_localctx = new QuoteStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(213); match(STRING);
				}
				break;
			case MINUS:
				_localctx = new QuoteMinusIntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(214); match(MINUS);
				setState(215); match(INT);
				}
				break;
			case LPAREN:
				_localctx = new QuoteListContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(216); match(LPAREN);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << MINUS) | (1L << LPAREN) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					{
					setState(217); quoteexpr();
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(223); match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineContext extends ParserRuleContext {
		public DefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define; }
	 
		public DefineContext() { }
		public void copyFrom(DefineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DefFuncRestContext extends DefineContext {
		public TerminalNode LPAREN(int i) {
			return getToken(ruseParser.LPAREN, i);
		}
		public TerminalNode DEFINE() { return getToken(ruseParser.DEFINE, 0); }
		public TerminalNode DOT() { return getToken(ruseParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN(int i) {
			return getToken(ruseParser.RPAREN, i);
		}
		public List<TerminalNode> ID() { return getTokens(ruseParser.ID); }
		public List<TerminalNode> RPAREN() { return getTokens(ruseParser.RPAREN); }
		public List<TerminalNode> LPAREN() { return getTokens(ruseParser.LPAREN); }
		public TerminalNode ID(int i) {
			return getToken(ruseParser.ID, i);
		}
		public DefFuncRestContext(DefineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitDefFuncRest(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefSimpleContext extends DefineContext {
		public TerminalNode DEFINE() { return getToken(ruseParser.DEFINE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(ruseParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public DefSimpleContext(DefineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitDefSimple(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefFuncContext extends DefineContext {
		public TerminalNode LPAREN(int i) {
			return getToken(ruseParser.LPAREN, i);
		}
		public TerminalNode DEFINE() { return getToken(ruseParser.DEFINE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN(int i) {
			return getToken(ruseParser.RPAREN, i);
		}
		public List<TerminalNode> ID() { return getTokens(ruseParser.ID); }
		public List<TerminalNode> RPAREN() { return getTokens(ruseParser.RPAREN); }
		public List<TerminalNode> LPAREN() { return getTokens(ruseParser.LPAREN); }
		public TerminalNode ID(int i) {
			return getToken(ruseParser.ID, i);
		}
		public DefFuncContext(DefineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitDefFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineContext define() throws RecognitionException {
		DefineContext _localctx = new DefineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_define);
		int _la;
		try {
			setState(258);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new DefSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(226); match(LPAREN);
				setState(227); match(DEFINE);
				setState(228); match(ID);
				setState(229); expr();
				setState(230); match(RPAREN);
				}
				break;
			case 2:
				_localctx = new DefFuncContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(232); match(LPAREN);
				setState(233); match(DEFINE);
				setState(234); match(LPAREN);
				setState(236); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(235); match(ID);
					}
					}
					setState(238); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(240); match(RPAREN);
				setState(241); expr();
				setState(242); match(RPAREN);
				}
				break;
			case 3:
				_localctx = new DefFuncRestContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(244); match(LPAREN);
				setState(245); match(DEFINE);
				setState(246); match(LPAREN);
				setState(248); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(247); match(ID);
					}
					}
					setState(250); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(252); match(DOT);
				setState(253); match(ID);
				setState(254); match(RPAREN);
				setState(255); expr();
				setState(256); match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaContext extends ParserRuleContext {
		public TerminalNode LPAREN(int i) {
			return getToken(ruseParser.LPAREN, i);
		}
		public TerminalNode DOT() { return getToken(ruseParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN(int i) {
			return getToken(ruseParser.RPAREN, i);
		}
		public List<TerminalNode> ID() { return getTokens(ruseParser.ID); }
		public List<TerminalNode> RPAREN() { return getTokens(ruseParser.RPAREN); }
		public TerminalNode LAMBDA() { return getToken(ruseParser.LAMBDA, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(ruseParser.LPAREN); }
		public TerminalNode ID(int i) {
			return getToken(ruseParser.ID, i);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_lambda);
		int _la;
		try {
			setState(288);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(260); match(LPAREN);
				setState(261); match(LAMBDA);
				setState(262); match(LPAREN);
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(263); match(ID);
					}
					}
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(269); match(RPAREN);
				setState(270); expr();
				setState(271); match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(273); match(LPAREN);
				setState(274); match(LAMBDA);
				setState(275); match(LPAREN);
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(276); match(ID);
					}
					}
					setState(281);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(282); match(DOT);
				setState(283); match(ID);
				setState(284); match(RPAREN);
				setState(285); expr();
				setState(286); match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LetbindingContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(ruseParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(ruseParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(ruseParser.LPAREN, 0); }
		public LetbindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letbinding; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruseVisitor ) return ((ruseVisitor<? extends T>)visitor).visitLetbinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetbindingContext letbinding() throws RecognitionException {
		LetbindingContext _localctx = new LetbindingContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_letbinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290); match(LPAREN);
			setState(291); match(ID);
			setState(292); expr();
			setState(293); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u012a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\5\2\23\n\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3@\n\3\f\3\16\3C\13\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3w\n\3\f\3\16\3z\13\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u0083\n\3\f\3\16\3\u0086\13\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3\u0094\n\3\r\3\16\3\u0095\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u00cc"+
		"\n\3\f\3\16\3\u00cf\13\3\3\3\3\3\3\3\5\3\u00d4\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\7\4\u00dd\n\4\f\4\16\4\u00e0\13\4\3\4\5\4\u00e3\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5\u00ef\n\5\r\5\16\5\u00f0\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\6\5\u00fb\n\5\r\5\16\5\u00fc\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5\u0105\n\5\3\6\3\6\3\6\3\6\7\6\u010b\n\6\f\6\16\6\u010e\13\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0118\n\6\f\6\16\6\u011b\13\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6\u0123\n\6\3\7\3\7\3\7\3\7\3\7\3\7\2\2\b\2\4\6"+
		"\b\n\f\2\2\u0157\2\22\3\2\2\2\4\u00d3\3\2\2\2\6\u00e2\3\2\2\2\b\u0104"+
		"\3\2\2\2\n\u0122\3\2\2\2\f\u0124\3\2\2\2\16\17\5\4\3\2\17\20\7\b\2\2\20"+
		"\23\3\2\2\2\21\23\5\b\5\2\22\16\3\2\2\2\22\21\3\2\2\2\23\3\3\2\2\2\24"+
		"\25\7\16\2\2\25\26\7\13\2\2\26\27\5\4\3\2\27\30\5\4\3\2\30\31\7\17\2\2"+
		"\31\u00d4\3\2\2\2\32\33\7\16\2\2\33\34\7\f\2\2\34\35\5\4\3\2\35\36\5\4"+
		"\3\2\36\37\7\17\2\2\37\u00d4\3\2\2\2 !\7\16\2\2!\"\7\t\2\2\"#\5\4\3\2"+
		"#$\5\4\3\2$%\7\17\2\2%\u00d4\3\2\2\2&\'\7\16\2\2\'(\7\n\2\2()\5\4\3\2"+
		")*\5\4\3\2*+\7\17\2\2+\u00d4\3\2\2\2,-\7\16\2\2-.\7\20\2\2./\5\4\3\2/"+
		"\60\7\17\2\2\60\u00d4\3\2\2\2\61\62\7\16\2\2\62\63\7\21\2\2\63\64\5\4"+
		"\3\2\64\65\7\17\2\2\65\u00d4\3\2\2\2\66\67\7\16\2\2\678\7\22\2\289\5\4"+
		"\3\29:\5\4\3\2:;\7\17\2\2;\u00d4\3\2\2\2<=\7\16\2\2=A\7\36\2\2>@\5\4\3"+
		"\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2D\u00d4"+
		"\7\17\2\2EF\7\16\2\2FG\7\23\2\2GH\5\4\3\2HI\5\4\3\2IJ\7\17\2\2J\u00d4"+
		"\3\2\2\2KL\7\16\2\2LM\7\24\2\2MN\5\4\3\2NO\5\4\3\2OP\7\17\2\2P\u00d4\3"+
		"\2\2\2QR\7\16\2\2RS\7\25\2\2ST\5\4\3\2TU\5\4\3\2UV\7\17\2\2V\u00d4\3\2"+
		"\2\2WX\7\16\2\2XY\7\26\2\2YZ\5\4\3\2Z[\5\4\3\2[\\\5\4\3\2\\]\7\17\2\2"+
		"]\u00d4\3\2\2\2^_\7\16\2\2_`\7\30\2\2`a\5\4\3\2ab\5\4\3\2bc\7\17\2\2c"+
		"\u00d4\3\2\2\2de\7\16\2\2ef\7\27\2\2fg\5\4\3\2gh\5\4\3\2hi\7\17\2\2i\u00d4"+
		"\3\2\2\2jk\7\16\2\2kl\7\31\2\2lm\5\4\3\2mn\7\17\2\2n\u00d4\3\2\2\2o\u00d4"+
		"\7\5\2\2pq\7\f\2\2q\u00d4\7\5\2\2r\u00d4\7&\2\2st\7\16\2\2tx\5\4\3\2u"+
		"w\5\4\3\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2"+
		"{|\7\17\2\2|\u00d4\3\2\2\2}\u00d4\7-\2\2~\177\7\16\2\2\177\u0080\7 \2"+
		"\2\u0080\u0084\7\16\2\2\u0081\u0083\5\f\7\2\u0082\u0081\3\2\2\2\u0083"+
		"\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2"+
		"\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7\17\2\2\u0088\u0089\5\4\3\2\u0089"+
		"\u008a\7\17\2\2\u008a\u00d4\3\2\2\2\u008b\u00d4\5\n\6\2\u008c\u008d\7"+
		"\16\2\2\u008d\u0093\7\37\2\2\u008e\u008f\7\16\2\2\u008f\u0090\5\4\3\2"+
		"\u0090\u0091\5\4\3\2\u0091\u0092\7\17\2\2\u0092\u0094\3\2\2\2\u0093\u008e"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\7\17\2\2\u0098\u00d4\3\2\2\2\u0099\u00d4\7"+
		"\'\2\2\u009a\u009b\7\16\2\2\u009b\u009c\7\"\2\2\u009c\u009d\5\4\3\2\u009d"+
		"\u009e\7\17\2\2\u009e\u00d4\3\2\2\2\u009f\u00a0\7\16\2\2\u00a0\u00a1\7"+
		"!\2\2\u00a1\u00a2\5\4\3\2\u00a2\u00a3\7\17\2\2\u00a3\u00d4\3\2\2\2\u00a4"+
		"\u00a5\7\16\2\2\u00a5\u00a6\7#\2\2\u00a6\u00a7\5\4\3\2\u00a7\u00a8\7\17"+
		"\2\2\u00a8\u00d4\3\2\2\2\u00a9\u00aa\7\16\2\2\u00aa\u00ab\7$\2\2\u00ab"+
		"\u00ac\5\4\3\2\u00ac\u00ad\7\17\2\2\u00ad\u00d4\3\2\2\2\u00ae\u00af\7"+
		"\16\2\2\u00af\u00b0\7%\2\2\u00b0\u00b1\5\4\3\2\u00b1\u00b2\5\4\3\2\u00b2"+
		"\u00b3\7\17\2\2\u00b3\u00d4\3\2\2\2\u00b4\u00b5\7\16\2\2\u00b5\u00b6\7"+
		"*\2\2\u00b6\u00b7\5\4\3\2\u00b7\u00b8\5\4\3\2\u00b8\u00b9\7\17\2\2\u00b9"+
		"\u00d4\3\2\2\2\u00ba\u00bb\7\16\2\2\u00bb\u00bc\7(\2\2\u00bc\u00bd\7-"+
		"\2\2\u00bd\u00be\5\4\3\2\u00be\u00bf\7\17\2\2\u00bf\u00d4\3\2\2\2\u00c0"+
		"\u00c1\7\16\2\2\u00c1\u00c2\7+\2\2\u00c2\u00c3\5\4\3\2\u00c3\u00c4\7\17"+
		"\2\2\u00c4\u00d4\3\2\2\2\u00c5\u00c6\7\16\2\2\u00c6\u00c7\7,\2\2\u00c7"+
		"\u00c8\7&\2\2\u00c8\u00d4\7\17\2\2\u00c9\u00cd\7\16\2\2\u00ca\u00cc\5"+
		"\4\3\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d4\7\17"+
		"\2\2\u00d1\u00d2\7.\2\2\u00d2\u00d4\5\6\4\2\u00d3\24\3\2\2\2\u00d3\32"+
		"\3\2\2\2\u00d3 \3\2\2\2\u00d3&\3\2\2\2\u00d3,\3\2\2\2\u00d3\61\3\2\2\2"+
		"\u00d3\66\3\2\2\2\u00d3<\3\2\2\2\u00d3E\3\2\2\2\u00d3K\3\2\2\2\u00d3Q"+
		"\3\2\2\2\u00d3W\3\2\2\2\u00d3^\3\2\2\2\u00d3d\3\2\2\2\u00d3j\3\2\2\2\u00d3"+
		"o\3\2\2\2\u00d3p\3\2\2\2\u00d3r\3\2\2\2\u00d3s\3\2\2\2\u00d3}\3\2\2\2"+
		"\u00d3~\3\2\2\2\u00d3\u008b\3\2\2\2\u00d3\u008c\3\2\2\2\u00d3\u0099\3"+
		"\2\2\2\u00d3\u009a\3\2\2\2\u00d3\u009f\3\2\2\2\u00d3\u00a4\3\2\2\2\u00d3"+
		"\u00a9\3\2\2\2\u00d3\u00ae\3\2\2\2\u00d3\u00b4\3\2\2\2\u00d3\u00ba\3\2"+
		"\2\2\u00d3\u00c0\3\2\2\2\u00d3\u00c5\3\2\2\2\u00d3\u00c9\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d4\5\3\2\2\2\u00d5\u00e3\7\5\2\2\u00d6\u00e3\7-\2\2"+
		"\u00d7\u00e3\7&\2\2\u00d8\u00d9\7\f\2\2\u00d9\u00e3\7\5\2\2\u00da\u00de"+
		"\7\16\2\2\u00db\u00dd\5\6\4\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2"+
		"\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de"+
		"\3\2\2\2\u00e1\u00e3\7\17\2\2\u00e2\u00d5\3\2\2\2\u00e2\u00d6\3\2\2\2"+
		"\u00e2\u00d7\3\2\2\2\u00e2\u00d8\3\2\2\2\u00e2\u00da\3\2\2\2\u00e3\7\3"+
		"\2\2\2\u00e4\u00e5\7\16\2\2\u00e5\u00e6\7\32\2\2\u00e6\u00e7\7-\2\2\u00e7"+
		"\u00e8\5\4\3\2\u00e8\u00e9\7\17\2\2\u00e9\u0105\3\2\2\2\u00ea\u00eb\7"+
		"\16\2\2\u00eb\u00ec\7\32\2\2\u00ec\u00ee\7\16\2\2\u00ed\u00ef\7-\2\2\u00ee"+
		"\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\7\17\2\2\u00f3\u00f4\5\4\3\2\u00f4"+
		"\u00f5\7\17\2\2\u00f5\u0105\3\2\2\2\u00f6\u00f7\7\16\2\2\u00f7\u00f8\7"+
		"\32\2\2\u00f8\u00fa\7\16\2\2\u00f9\u00fb\7-\2\2\u00fa\u00f9\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2"+
		"\2\2\u00fe\u00ff\7\6\2\2\u00ff\u0100\7-\2\2\u0100\u0101\7\17\2\2\u0101"+
		"\u0102\5\4\3\2\u0102\u0103\7\17\2\2\u0103\u0105\3\2\2\2\u0104\u00e4\3"+
		"\2\2\2\u0104\u00ea\3\2\2\2\u0104\u00f6\3\2\2\2\u0105\t\3\2\2\2\u0106\u0107"+
		"\7\16\2\2\u0107\u0108\7\33\2\2\u0108\u010c\7\16\2\2\u0109\u010b\7-\2\2"+
		"\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010d\u010f\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0110\7\17\2\2"+
		"\u0110\u0111\5\4\3\2\u0111\u0112\7\17\2\2\u0112\u0123\3\2\2\2\u0113\u0114"+
		"\7\16\2\2\u0114\u0115\7\33\2\2\u0115\u0119\7\16\2\2\u0116\u0118\7-\2\2"+
		"\u0117\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a"+
		"\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011d\7\6\2\2\u011d"+
		"\u011e\7-\2\2\u011e\u011f\7\17\2\2\u011f\u0120\5\4\3\2\u0120\u0121\7\17"+
		"\2\2\u0121\u0123\3\2\2\2\u0122\u0106\3\2\2\2\u0122\u0113\3\2\2\2\u0123"+
		"\13\3\2\2\2\u0124\u0125\7\16\2\2\u0125\u0126\7-\2\2\u0126\u0127\5\4\3"+
		"\2\u0127\u0128\7\17\2\2\u0128\r\3\2\2\2\21\22Ax\u0084\u0095\u00cd\u00d3"+
		"\u00de\u00e2\u00f0\u00fc\u0104\u010c\u0119\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}