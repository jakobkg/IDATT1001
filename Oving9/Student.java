public class Student {
    private String navn;
    private int antallOppgaver;

    public Student(String navn) {
        this.navn = navn;
        this.antallOppgaver = 0;
    }

    public String getNavn() {
        return this.navn;
    }

    public int getAntOppg() {
        return this.antallOppgaver;
    }

    public void økAntOppg() {
        this.antallOppgaver++;
    }

    @Override
    public String toString() {
        return String.format("%s, %d %s", this.navn, this.antallOppgaver,
        this.antallOppgaver == 1 ? "godkjent oppgave" : "godkjente oppgaver");
    }

    public static void main(String[] args) {
        Student student = new Student("Navn Navnesen");
        System.out.printf("Navn: %s\n", student.getNavn());
        System.out.printf("Antall godkjente oppgaver: %s\n", student.getAntOppg());
        System.out.printf("Objektets toString(): %s\n", student);
        System.out.println("Godkjenner en oppgave...");
        student.økAntOppg();
        System.out.println(student);
    }
}
