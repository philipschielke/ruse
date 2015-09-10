// Generated from /Users/phil/NetBeansProjects/ruse/ruse.g4 by ANTLR 4.4

package ruse;
import java.util.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ruseParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ruseVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ZeroQ}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZeroQ(@NotNull ruseParser.ZeroQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Displayln}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplayln(@NotNull ruseParser.DisplaylnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Load}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoad(@NotNull ruseParser.LoadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Cons}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCons(@NotNull ruseParser.ConsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(@NotNull ruseParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuoteInt}
	 * labeled alternative in {@link ruseParser#quoteexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuoteInt(@NotNull ruseParser.QuoteIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MinusInt}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusInt(@NotNull ruseParser.MinusIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuoteID}
	 * labeled alternative in {@link ruseParser#quoteexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuoteID(@NotNull ruseParser.QuoteIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link ruseParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(@NotNull ruseParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Car}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCar(@NotNull ruseParser.CarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Cdr}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCdr(@NotNull ruseParser.CdrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefSimple}
	 * labeled alternative in {@link ruseParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefSimple(@NotNull ruseParser.DefSimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleMinus}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleMinus(@NotNull ruseParser.SimpleMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OtherExpr}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherExpr(@NotNull ruseParser.OtherExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JustID}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJustID(@NotNull ruseParser.JustIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Cond}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(@NotNull ruseParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Quote}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuote(@NotNull ruseParser.QuoteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThan(@NotNull ruseParser.GreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuoteList}
	 * labeled alternative in {@link ruseParser#quoteexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuoteList(@NotNull ruseParser.QuoteListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Apply}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApply(@NotNull ruseParser.ApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code List}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull ruseParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(@NotNull ruseParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LambdaMatch}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaMatch(@NotNull ruseParser.LambdaMatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Def}
	 * labeled alternative in {@link ruseParser#eval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(@NotNull ruseParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualQ}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualQ(@NotNull ruseParser.EqualQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyQ}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyQ(@NotNull ruseParser.EmptyQContext ctx);
	/**
	 * Visit a parse tree produced by {@link ruseParser#letbinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetbinding(@NotNull ruseParser.LetbindingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Let}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(@NotNull ruseParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleTimes}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTimes(@NotNull ruseParser.SimpleTimesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuoteString}
	 * labeled alternative in {@link ruseParser#quoteexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuoteString(@NotNull ruseParser.QuoteStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuoteMinusInt}
	 * labeled alternative in {@link ruseParser#quoteexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuoteMinusInt(@NotNull ruseParser.QuoteMinusIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(@NotNull ruseParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListQ}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListQ(@NotNull ruseParser.ListQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Evaluate}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluate(@NotNull ruseParser.EvaluateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefFunc}
	 * labeled alternative in {@link ruseParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefFunc(@NotNull ruseParser.DefFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EList}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEList(@NotNull ruseParser.EListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleDivide}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleDivide(@NotNull ruseParser.SimpleDivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(@NotNull ruseParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimplePlus}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimplePlus(@NotNull ruseParser.SimplePlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefFuncRest}
	 * labeled alternative in {@link ruseParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefFuncRest(@NotNull ruseParser.DefFuncRestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfThenElse}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElse(@NotNull ruseParser.IfThenElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(@NotNull ruseParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull ruseParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SExpr}
	 * labeled alternative in {@link ruseParser#eval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSExpr(@NotNull ruseParser.SExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(@NotNull ruseParser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull ruseParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetBang}
	 * labeled alternative in {@link ruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetBang(@NotNull ruseParser.SetBangContext ctx);
}