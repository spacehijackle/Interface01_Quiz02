package com.quiz.type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.quiz.Quiz;

/**
 * いかなるクイズも必ず不正解にするクイズ
 * <p>
 * 指定されたクイズの解答を無視し、どんな回答でも不正解にするラッパークラス
 * </p>
 *
 * @author t.yoshida
 */
public class NoCorrectAnswerQuiz implements Quiz
{
	// 対象クイズ
	private Quiz _target;

	/**
	 * NoCorrectAnswerQuiz を生成する。
	 *
	 * @param target 対象クイズ
	 */
	public NoCorrectAnswerQuiz(Quiz target)
	{
		_target = target;
	}

	@Override
	public String getQuestion()
	{
		return _target.getQuestion();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * 正解してようが、してまいが、絶対不正解にする！
	 * </p>
	 */
	@Override
	public boolean isCorrect(String reply)
	{
		// 対象クイズによっては引数である回答を
		// 必要とする場合もあるので必ず呼び出す。
		_target.isCorrect(reply);

		// 必ず不正解とするため false を返す。
		return false;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * 正解でも無理やり不正解にしているため、正解していることがバレないよう、
	 * 解答の文字列を黒塗りの四角で返す（行政文書でよくある、いわゆる"のり弁"）。
	 * </p>
	 */
	@Override
	public String getAnswer()
	{
		String answer = _target.getAnswer();

		Pattern p = Pattern.compile("[^, （）]");
		Matcher m = p.matcher(answer);

		return m.replaceAll("■");
	}
}
