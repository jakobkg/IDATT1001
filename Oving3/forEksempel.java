public class forEksempel {
  public static void main(String[] args) {
    int start = 5;
    int slutt = 8;

    for (int tabell = start; tabell <= slutt; tabell++) {
      System.out.printf("%d-gangen!\n", tabell);

      for (int i = 1; i <= 10; i++) {
        System.out.printf("%d x %2d = %3d\n", tabell, i, tabell * i);
      }
    }

  } 
}
