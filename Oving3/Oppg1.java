import java.util.Scanner;

class Oppg1 {
  public static void main(String[] args) {
    int start, slutt;

    System.out.println("Gangetabeller!");
    try (Scanner input = new Scanner(System.in)) {
      System.out.println("Hvilken tabell skal vi starte med?");
      start = input.nextInt();

      System.out.println("Hvilken tabell skal vi slutte med?");
      slutt = input.nextInt();
    }

    for (int tabell = start; tabell <= slutt; tabell++) {
      System.out.printf("%d-gangen:\n", tabell);

      for (int multiplikator = 1; multiplikator <= 10; multiplikator++) {
        System.out.printf("%d x %d = %d\n", tabell, multiplikator, tabell * multiplikator);
      }
    }
  }
}