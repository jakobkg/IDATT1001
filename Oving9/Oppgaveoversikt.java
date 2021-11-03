import java.util.Scanner;

public class Oppgaveoversikt {
    private Student[] studenter;
    private int antallStudenter;

    public Oppgaveoversikt() {
        this.studenter = new Student[0];
        this.antallStudenter = 0;
    }

    public int getAntStud() {
        return this.antallStudenter;
    }

    public void registrerStudent(String navn) {
        Student[] nyeStudenter = new Student[this.antallStudenter + 1];
        
        for (int index = 0; index < this.antallStudenter; index++) {
            nyeStudenter[index] = this.studenter[index];
        }

        nyeStudenter[this.antallStudenter] = new Student(navn);

        this.studenter = nyeStudenter;
        this.antallStudenter++;
    }

    public void registrerStudent(Student nyStudent) {
        Student[] nyeStudenter = new Student[this.antallStudenter + 1];
        
        for (int index = 0; index < this.studenter.length; index++) {
            nyeStudenter[index] = this.studenter[index];
        }

        nyeStudenter[this.studenter.length] = nyStudent;

        this.studenter = nyeStudenter;
        this.antallStudenter++;
    }

    public Student finnStudent(String navn) {
        for (Student student : this.studenter) {
            if (student.getNavn().toLowerCase().equals(navn.toLowerCase())) {
                return student;
            }
        }

        return null;
    }

    public Student finnStudent(int studentnummer) {
        if (studentnummer <= this.antallStudenter) {
            return studenter[studentnummer];
        }

        return null;
    }

    public void godkjennForStudent(String navn) {
        Student funnetStudent = this.finnStudent(navn);
        if (funnetStudent != null) {
            funnetStudent.økAntOppg();
        }
    }

    public void godkjennForStudent(int studentnummer) {
        Student funnetStudent = this.finnStudent(studentnummer);
        if (funnetStudent != null) {
            funnetStudent.økAntOppg();
        }
    }

    public int antallGodkjenteForStudent(String navn) {
        Student funnetStudent = this.finnStudent(navn);
        if (funnetStudent != null) {
            return funnetStudent.getAntOppg();
        }

        return -1;
    }

    public int antallGodkjenteForStudent(int studentnummer) {
        Student funnetStudent = this.finnStudent(studentnummer);
        if (funnetStudent != null) {
            return funnetStudent.getAntOppg();
        }

        return -1;
    }

    @Override
    public String toString() {
        String buf = String.format("Oversikt over godkjente oppgaver, %d studenter:\n", this.antallStudenter);

        for (int index = 0; index < this.antallStudenter; index++) {
            buf = buf.concat(String.format("#%d: %s\n", index, this.studenter[index]));
        }

        return buf;
    }

    public static void main(String[] args) {
        Oppgaveoversikt oversikt = new Oppgaveoversikt();
        int valg = 0;
        Student valgtStudent;

        try (Scanner input = new Scanner(System.in).useDelimiter("\n");) {
            do {
                System.out.print("Hva vil du gjøre?\n1. Vis oversikt\n2. Vis spesifikk student\n3. Legg til student\n4. Godkjenn oppgave\n5. Avslutt\nValg: ");
                valg = input.nextInt();
                System.out.print("\n");

                if (valg == 1) {
                    System.out.println(oversikt);
                    System.out.print("\n");
                } else if (valg == 2) {
                    System.out.print("Finn student etter:\n1. navn\n2. studentnummer\nValg: ");
                    valg = input.nextInt();
                    System.out.print("\n");
                    if (valg == 1) {
                        System.out.print("Studentens navn: ");
                        valgtStudent = oversikt.finnStudent(input.next());
                    } else {
                        System.out.print("Studentnummer: ");
                        valgtStudent = oversikt.finnStudent(input.nextInt());
                    }

                    System.out.print("\n");

                    if (valgtStudent != null) {
                        System.out.printf("%s har %d godkjente oppgaver\n", valgtStudent.getNavn(), valgtStudent.getAntOppg());
                    } else {
                        System.out.println("Student ikke funnet\n");
                    }

                    System.out.print("\n");
                } else if (valg == 3) {
                    System.out.print("Studentens navn: ");
                    oversikt.registrerStudent(input.next());
                    System.out.print("\n");
                } else if (valg == 4) {
                    System.out.print("Søk etter:\n1. navn\n2. studentnummer\nValg: ");
                    valg = input.nextInt();
                    System.out.print("\n");
                    try {
                        if (valg == 1) {
                            System.out.print("Studentens navn: ");
                            valgtStudent = oversikt.finnStudent(input.next());
                        } else {
                            System.out.print("Studentnummer: ");
                            valgtStudent = oversikt.finnStudent(input.nextInt());
                        }

                        valgtStudent.økAntOppg();
                        System.out.print("\n");
                    } catch (Exception e) {
                        throw e;
                    }
                }
            } while (valg != 5);
        } catch (Exception e) {
            throw e;
        }
    }
}
