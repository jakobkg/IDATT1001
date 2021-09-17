import klasser.Matrise;

public class Oppg3 {
    public static void main(String[] args) {
        double[][] verdierA = {{1, 0, -1}, {1, 2, 0}};
        double[][] verdierB = {{1, 0, -1}, {3, 2, 0}, {-1, 1, 2}};
        Matrise A = new Matrise(verdierA);
        Matrise B = new Matrise(verdierB);

        System.out.println("Matrise A: " + A);
        System.out.println("Matrise B: " + B);
        System.out.println("A + A: " + A.adder(A));
        System.out.println("A * B: " + A.multipliser(B));
        System.out.println("A^T: " + A.transponer());
    }
}
