package com.quiz;


/**
 * クイズ出題インターフェース定義
 *
 * @author t.yoshida
 */
public interface QuizMaster
{
	/**
	 * クイズのタイトルを返す。
	 *
	 * @return クイズのタイトル
	 */
	public String getTitle();

	/**
	 * クイズを１つ取り出す。
	 *
	 * @return クイズ（出題するクイズがなくなったら null）
	 */
	public Quiz poll();

	/**
	 * 正解率を計算する。
	 *
	 * @return 正解率
	 */
	public float calcCorrectRate();
}
