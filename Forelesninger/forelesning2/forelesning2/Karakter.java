import java.util.Scanner;

class Karakter {
  public static void main(String[] args) {
    int poeng;
    char karakter;

    if (args.length == 0) {
      try (Scanner input = new Scanner(System.in)) {
        System.out.println("Angi score i poeng for å sjekke karakter:");
        poeng = input.nextInt();
      }
    } else {
      poeng = Integer.parseInt(args[0]);
    }

    if (poeng >= 96) {
      karakter = 'A';
    } else if (poeng >= 86) {
      karakter = 'B';
    } else if (poeng >= 71) {
      karakter = 'C';
    } else if (poeng >= 55) {
      karakter = 'D';
    } else if (poeng >= 36) {
      karakter = 'E';
    } else {
      karakter = 'F';
    }

    System.out.printf("Med %d poeng får man karakteren %c", poeng, karakter);
  }
}
