import java.time.chrono.MinguoChronology;

import klasser.NyString;

public class Oppg1 {
    public static void main(String[] args) {
        NyString nystring = new NyString("Dette er    en teststring med mange ord i.");

        System.out.println(nystring);
        System.out.println(nystring.antallOrd());
        System.out.println(nystring.forkort());
        System.out.println(nystring.fjern('e'));
    }
}