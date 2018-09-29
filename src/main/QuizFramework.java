package main;

import java.util.Scanner;

import com.quiz.Quiz;
import com.quiz.QuizMaster;
import com.quiz.SampleQuizMaster;

/**
 * クイズフレームワーク
 *
 * @author t.yoshida
 */
public class QuizFramework
{
	/**
	 * クイズを出題し、正解/不正解の判定をする。
	 */
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		// クイズ出題クラスの生成
		QuizMaster master = new SampleQuizMaster();

		// クイズ出題のタイトル表示
		System.out.println(master.getTitle());

		// 改行コード取得
		String retCode = System.getProperty("line.separator");

		/*
		 * クイズ出題クラスからクイズを取り出し出題する。
		 * ユーザの回答から正解/不正解を判定し、最終的に正解率を表示する。
		 */
		Quiz quiz;
		while((quiz = master.poll()) != null)
		{
			System.out.print("Q. " + quiz.getQuestion() + retCode + " ⇒ ");
			String reply = scanner.nextLine();
			if(quiz.isCorrect(reply.trim()))
			{
				System.out.println("○ 正解！");
			}
			else
			{
				System.out.println("Ｘ 残念…  A. " + quiz.getAnswer());
			}
			System.out.println();
		}

		System.out.println("☘ 正解率: " + String.format("%.2f", master.calcCorrectRate() * 100) + "%");
	}
}
