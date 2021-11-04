import java.util.Scanner;

import klasser.Arrangement;
import klasser.ArrangementRegister;

public class Oppg1 {
    public static void main(String[] args) {
        ArrangementRegister register = new ArrangementRegister();
        register.registrerArrangement("Jaga Jazzist til UKA", "Storsalen", "UKA", "Konsert", 202110182130L);
        register.registrerArrangement("Baristakurs", "Edgar", "UKA", "Kurs", 202110191600L);
        register.registrerArrangement("Klovner i Kamp til UKA", "Storsalen", "UKA", "Konsert", 202110202130L);
        register.registrerArrangement("Stein Torleif Bjella", "Byscenen", "Byscenen", "Konsert", 202110282100L);

        int valg, dato, fraDato, tilDato;
        String navn, sted, arrangør, type;
        long tidspunkt;

        try (Scanner input = new Scanner(System.in).useDelimiter("\n")) {
            do {
                System.out.println("Meny for arrangementregister");
                System.out.println("1. Vis register\n2. Vis sortert register\n3. Legg til arrangement\n4. Finn arrangement\n5. Avslutt");
                System.out.print("Valg: ");
                valg = input.nextInt();
                System.out.println();

                switch (valg) {
                    case 1:
                        System.out.print(register);
                        break;

                    case 2:
                        System.out.println("Sortert etter:\n1. Sted\n2. Type\n3. Tidspunkt");
                        System.out.print("Valg: ");
                        valg = input.nextInt();

                        switch (valg) {
                            case 1:
                                for (Arrangement arrangement : register.sorterPåSted()) {
                                    System.out.println(arrangement);
                                    System.out.println();
                                }
                                break;

                            case 2:
                                for (Arrangement arrangement : register.sorterPåType()) {
                                    System.out.println(arrangement);
                                    System.out.println();
                                }
                                break;

                            case 3:
                                for (Arrangement arrangement : register.sorterPåTidspunkt()) {
                                    System.out.println(arrangement);
                                    System.out.println();
                                }
                                break;
                        
                            default:
                                break;
                        }
                        break;
                    
                    case 3:
                        System.out.print("Navn på arrangement: ");
                        navn = input.next();

                        System.out.print("Sted: ");
                        sted = input.next();

                        System.out.print("Arrangør: ");
                        arrangør = input.next();

                        System.out.print("Type arrangement: ");
                        type = input.next();

                        System.out.print("Tidspunkt: ");
                        tidspunkt = input.nextLong();

                        register.registrerArrangement(navn, sted, arrangør, type, tidspunkt);
                        break;
                    
                    case 4:
                        System.out.print("1. Søk på sted\n2. Søk på dato\n3. Søk mellom datoer\nValg: ");
                        valg = input.nextInt();
                        System.out.println();

                        switch (valg) {
                            case 1:
                                System.out.print("Sted: ");
                                sted = input.next();
                                for (Arrangement arrangement : register.finnArrangementPåSted(sted)) {
                                    System.out.println(arrangement);
                                    System.out.println();
                                }
                                break;

                            case 2:
                                System.out.println("Format: ÅÅÅÅMMDD");
                                System.out.print("Dato: ");
                                dato = input.nextInt();
                                for (Arrangement arrangement : register.finnArrangementPåDato(dato)) {
                                    System.out.println(arrangement);
                                    System.out.println();
                                }
                                break;

                            case 3:
                                System.out.println("Format: ÅÅÅÅMMDD");
                                System.out.print("Fra: ");
                                fraDato = input.nextInt();
                                System.out.print("Til: ");
                                tilDato = input.nextInt();
                                for (Arrangement arrangement : register.finnArrangementMellomDatoer(fraDato, tilDato)) {
                                    System.out.println(arrangement);
                                    System.out.println();
                                }
                        }
                        break;
                
                    default:
                        break;
                }
                System.out.println();
            } while (valg != 5);
        } catch (Exception e) {
            throw e;
        }
    }
}
