import java.util.Scanner;

public class Oppg2 {
  public static void main(String[] args) {
    int kanskjePrimtall;
    boolean prim = true;

    try (Scanner input = new Scanner(System.in)) {
      System.out.println("Primtall-tester\nSkriv inn et tall for å få testet om det er et primtall, 0 for å avslutte:");
      kanskjePrimtall = input.nextInt();

      while (kanskjePrimtall != 0) {
        prim = true;
        for (int tester = 2; tester < kanskjePrimtall; tester++) {
          if (kanskjePrimtall % tester == 0) {
            prim = false;
          }
        }
    
        System.out.printf("%d er%s et primtall\n\n", kanskjePrimtall, prim ? "" : " ikke");
        
        System.out.println("Primtall-tester\nSkriv inn et tall for å få testet om det er et primtall, 0 for å avslutte:");
        kanskjePrimtall = input.nextInt();
      }
    }
  }
}
