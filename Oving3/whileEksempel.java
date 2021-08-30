public class whileEksempel {
  public static void main(String[] args) {
    int test = 2;
    Boolean prim = true;
    int tall = 98723497;

    while (test < tall && tall % test == 0) {
      test++;
    }

    System.out.printf("%d er%s et primtall", tall, prim ? "" : " ikke");
  }
}
