import utilities.TastaturEingabe;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
		
		final int wert1 = TastaturEingabe.readInt("> ");
		final int wert2 = TastaturEingabe.readInt("> ");
		
		System.out.printf("%d + %d = %d", wert1, wert2, wert1 + wert2);
	}
}