import java.util.Scanner;

public class Oppg2 {
  public static void main(String[] args) {
    System.out.println("Primtall-tester\nSkriv inn et tall for å få testet om det er et primtall:");

    int kanskjePrimtall;
    Boolean prim = true;

    try (Scanner input = new Scanner(System.in)) {
      kanskjePrimtall = input.nextInt();
    }

    for (int tester = 2; tester < kanskjePrimtall; tester++) {
      if (kanskjePrimtall % tester == 0) {
        prim = false;
      }
    }

    System.out.printf("%d er%s et primtall", kanskjePrimtall, prim ? "" : " ikke");
  }
}
