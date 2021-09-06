import types.Currency;
import java.util.Scanner;

public class Oppg1 {
    public static void main(String[] args) {
        Currency EUR = new Currency("EUR", 10.2568);
        Currency USD = new Currency("USD", 8.6491);
        Currency YEN = new Currency("YEN", 0.0786);

        Currency[] currencyList = {EUR, USD, YEN};

        int selection;
        double amount;

        try (Scanner input = new Scanner(System.in)) {
            selection = currencyPrompt(currencyList, input);

            while (selection < currencyList.length) {
                amount = amountPrompt(currencyList[selection], input);
                
                System.out.printf("\n%.2f %3s er %.2f NOK\n\n",
                                    amount, currencyList[selection],
                                    currencyList[selection].toNOK(amount));

                selection = currencyPrompt(currencyList, input);
            }
        }
    }

    static int currencyPrompt(Currency[] currencies, Scanner input) {
        System.out.println("Velg hvilken valuta du vil konvertere til NOK:");
        
        for (int i = 0; i < currencies.length; i++) {
            System.out.printf("%d. %3s\n", i + 1, currencies[i]);
        }

        System.out.printf("%d. Avslutt\nDitt valg: ", currencies.length + 1);

        int response = -1;

        if(input.hasNextInt()) {
            response = input.nextInt() - 1;
        }

        return response;
    }

    static double amountPrompt(Currency chosenCurrency, Scanner input) {
        System.out.printf("Hvor mange %3s vil du konvertere til NOK?\nDitt valg: ", chosenCurrency);

        double response = -1;

        if (input.hasNextDouble()) {
            response = input.nextDouble();
        }

        return response;
    }
}
