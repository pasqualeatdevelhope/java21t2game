package com.pasqualehorse.gioco.muorimale.input;

import java.util.Scanner;

public class Iutils {

	private static final Scanner scanner = new Scanner(System.in);

	public static int getInt() {
		return scanner.nextInt();
	}

	public static double getDouble() {
		return scanner.nextDouble();
	}

	public static String getString() {
		return scanner.nextLine();
	}
}
