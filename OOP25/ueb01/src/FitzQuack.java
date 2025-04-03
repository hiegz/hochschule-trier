/**
 * Schreiben Sie ein Programm, welches das Spiel "FitzQuack" spielt. Das Programm zaehlt von 1 bis 100 und ersetzt dabei jedes Vielfache von
 * fuenf durch das Wort "Fitz", jedes Vielfache von sieben durch das Wort "Quack" und jedes Vielfache von fuenf und sieben durch das Wort
 * "FitzQuack". Das Programm benutzt den Modulo-Operator (%), um zu bestimmen, ob eine Zahl durch eine andere teilbar ist.
 **/

public class FitzQuack {
  public static void main(String[] args) {
    for (int i = 1; i <= 100; i++) { // von 1 bis 100 zaehlen
      if (((i % 5) == 0) && ((i % 7) == 0)) // Vielfaches von beiden?
        System.out.print("FitzQuack");
      else if ((i % 5) == 0) // sonst Vielfaches von 5?
        System.out.print("Fitz");
      else if ((i % 7) == 0) // sonst Vielfaches von 7?
        System.out.print("Quack");
      else 
        System.out.print(i); // sonst einfach ausgeben
    }
    System.out.print(" ");
  }
}

