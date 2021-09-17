package klasser;

public class Tekst {
    public Tekst(String tekst) {
        this.tekst = tekst;
        char[] ch = tekst.toLowerCase().toCharArray();
        this.fordeling = new int[30];

        for (char c : ch) {
            if (c >= 'a' && c <= 'z') {
                this.fordeling[c - 'a']++;
            } else if (c == 'æ') {
                this.fordeling[26]++;
            } else if (c == 'ø') {
                this.fordeling[27]++;
            } else if (c == 'å') {
                this.fordeling[28]++;
            } else {
                this.fordeling[29]++;
            }
        }
    }

    public void visFordeling() {
        for (int i = 0; i < this.alfabetet.length; i++) {
            System.out.printf("%c: %d\n", this.alfabetet[i], this.fordeling[i]);
        }
    }

    public int forskjelligeBokstaver() {
        int sum = 0;

        for (int i = 0; i < 29; i++) {
            sum += this.fordeling[i] == 0 ? 0 : 1;
        }

        return sum;
    }

    public int antallBokstaver() {
        int sum = 0;

        for (int i = 0; i < 29; i++) {
            sum += this.fordeling[i];
        }

        return sum;
    }

    public double andelIkkeBokstaver() {
        return 1.0 - ((double)this.antallBokstaver() / this.tekst.length());
    }

    public int antallAvBokstav(char bokstav) {
        switch (bokstav) {
            case 'æ':
                return this.fordeling[26];
        
            case 'ø':
                return this.fordeling[27];
    
            case 'å':
                return this.fordeling[28];
        
            default:
                return this.fordeling[bokstav - 'a'];
        }
    }

    public char[] vanligsteBokstav() {
        return new char[0];
    }

    public String toString() {
        return this.tekst;
    }

    private final String tekst;
    private final int[] fordeling;
    private final char[] alfabetet = {'a', 'b', 'c', 'd', 'e', 'f',
                                      'g', 'h', 'i', 'j', 'k', 'l',
                                      'm', 'n', 'o', 'p', 'q', 'r',
                                      's', 't', 'u', 'v', 'w', 'x',
                                      'y', 'z', 'æ', 'ø', 'å', '?'};
}
