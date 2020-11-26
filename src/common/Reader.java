package common;
import java.util.Scanner;

public class Reader {
	Scanner input;

//All threads share the same input stream
	public Reader() {
		input = new Scanner(System.in);
	}

	public String nextLine() {
		System.out.print("> ");
		return input.nextLine();
	}

	public boolean hasNext() {
		return input.hasNext();
	}
}
