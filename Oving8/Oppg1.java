import java.util.Scanner;
import klasser.Person;
import klasser.Arbeidstaker;

/**
 * Oppg1, klasse som bare inneholder en main() for å demonstrere oppgaven
 */
public class Oppg1 {
    public static void main(String[] args) {
        String felter[] = {"Fornavn", "Etternavn", "Fødselsår", "Ansettelsesår", "Månedslønn", "Skatteprosent"};
        Person person = new Person("Jens", "Jensen", 1992);
        Arbeidstaker personPåJobb = new Arbeidstaker(person, 2017, 24000, 23);

        Scanner input = new Scanner(System.in);
        int valg = 100;
        String inString;
        int inInt;
        double inDouble;
        Person nyPerson;
        Arbeidstaker nyPersonPåJobb;

        System.out.printf("La oss redigere %s!\n\n", person.getFornavn());
        do {
            System.out.printf("Dette er %s:\n%s\n", person, personPåJobb);
            System.out.println("Hvilket datafelt vil du redigere?\n");
            for (int i = 1; i < felter.length + 1; i++) {
                System.out.printf("%d: %s\n", i, felter[i - 1]);
            }
            System.out.printf("%d: Avslutt\n\nDitt valg: ", felter.length + 1);
            valg = input.nextInt();

            if (valg == 1) {
                System.out.print("Nytt fornavn: ");
                inString = input.next();
                nyPerson = new Person(inString, person.getEtternavn(), person.getFødselsår());
                person = nyPerson;
                nyPersonPåJobb = new Arbeidstaker(person, personPåJobb.getAnsettelsesår(), personPåJobb.getMånedslønn(), personPåJobb.getSkatteprosent());
                personPåJobb = nyPersonPåJobb;
            } else if (valg == 2) {
                System.out.print("Nytt etternavn: ");
                inString = input.next();
                nyPerson = new Person(person.getFornavn(), inString, person.getFødselsår());
                person = nyPerson;
                nyPersonPåJobb = new Arbeidstaker(person, personPåJobb.getAnsettelsesår(), personPåJobb.getMånedslønn(), personPåJobb.getSkatteprosent());
                personPåJobb = nyPersonPåJobb;
            } else if (valg == 3) {
                System.out.print("Nytt fødselsår: ");
                inInt = input.nextInt();
                nyPerson = new Person(person.getFornavn(), person.getEtternavn(), inInt);
                person = nyPerson;
                nyPersonPåJobb = new Arbeidstaker(person, personPåJobb.getAnsettelsesår(), personPåJobb.getMånedslønn(), personPåJobb.getSkatteprosent());
                personPåJobb = nyPersonPåJobb;
            } else if (valg == 4) {
                System.out.print("Nytt ansettelsesår: ");
                inInt = input.nextInt();
                nyPersonPåJobb = new Arbeidstaker(person, inInt, personPåJobb.getMånedslønn(), personPåJobb.getSkatteprosent());
                personPåJobb = nyPersonPåJobb;
            } else if (valg == 5) {
                System.out.print("Ny månedslønn: ");
                inDouble = input.nextDouble();
                nyPersonPåJobb = new Arbeidstaker(person, personPåJobb.getAnsettelsesår(), inDouble, personPåJobb.getSkatteprosent());
                personPåJobb = nyPersonPåJobb;
            } else if (valg == 6) {
                System.out.print("Ny skatteprosent: ");
                inDouble = input.nextDouble();
                nyPersonPåJobb = new Arbeidstaker(person, personPåJobb.getAnsettelsesår(), personPåJobb.getMånedslønn(), inDouble);
                personPåJobb = nyPersonPåJobb;                
            }
        } while (valg <= felter.length);

        input.close();
    }
}