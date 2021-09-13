package helpers;

import java.util.Random;

public class MinRandom {
    public MinRandom() {
        this.m_generator = new Random();
    }

    public int nesteHeltall(int nedre, int øvre) {
        return m_generator.nextInt(øvre - nedre + 1) + nedre;
    }

    public double nesteDesimaltall(double nedre, double øvre) {
        return m_generator.nextDouble() * (øvre - nedre) + nedre;
    }

    private Random m_generator;
}
