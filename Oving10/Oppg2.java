import klasser.MenyRegister;

public class Oppg2 {
    public static void main(String[] args) {
        MenyRegister register = new MenyRegister();
        register.registrerRett("Juice", "Drikke", 10);
        register.registrerRett("Kaffe", "Drikke", 20);
        register.registrerRett("Egg og bacon", "Frokost", 45);
        register.registrerRett("Toast", "Frokost", 20);

        register.registrerMeny("Frokostmeny", register.getRetter());
        
        System.out.println(register.finnMeny("Frokostmeny"));
        System.out.println(register.finnRetterAvType("Drikke"));
    }
}
