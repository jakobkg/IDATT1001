package klasser;

public final class NyString {
    private final String innhold;
    
    public NyString(String tekst) {
        this.innhold = tekst;
    }

    public int antallOrd() {
        int sum = 0;

        for (String ord : this.innhold.split(" ")) {
            sum += ord.length() > 0 ? 1 : 0;
        }

        return sum;
    }

    public NyString forkort() {
        String buf = new String();

        for (String ord : this.innhold.split(" ")) {
            if (ord.length() > 0) {
                buf = buf.concat(String.valueOf(ord.toCharArray()[0]));
            }
        }

        return new NyString(buf);
    }

    public NyString fjern(char c) {
        String buf = new String();

        for (char bokstav : this.innhold.toCharArray()) {
            if (bokstav != c) {
                buf = buf.concat(String.valueOf(bokstav));
            }
        }

        return new NyString(buf);
    }

    public String toString() {
        return this.innhold;
    }
}