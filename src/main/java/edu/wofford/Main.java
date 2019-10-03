package edu.wofford;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		TicTacToeModel t = new TicTacToeModel();
		System.out.println(t.toString());



		while ( t.getResult() == TicTacToeModel.Result.NONE){
			Scanner keyboard = new Scanner(System.in);
			System.out.println(t.toString());
			System.out.println("enter a row ");

			System.out.println("enter a column");
			int a = keyboard.nextInt();
			int b = keyboard.nextInt();


			if (t.setMarkAt(a,b) == true){
				t.setMarkAt(a,b);
			}
			else{
				continue;
			}
		}

		if(t.getResult() == TicTacToeModel.Result.XWIN){
			System.out.println("X wins");
		}
		else if(t.getResult() == TicTacToeModel.Result.OWIN){
			System.out.println("O wins");
		}
		else{
			System.out.println("Tie");
		}



	}
}