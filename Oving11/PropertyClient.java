import java.util.Scanner;

public class PropertyClient {
    public static void main(String[] args) {
        /**
         * Initialize the registry and add some pre-loaded properties as test data
         */
        PropertyRegistry registry = new PropertyRegistry();
        registry.addProperty(new Property("Gloppen", 1445, 77, 631, 1017.6, "Jens Olsen"));
        registry.addProperty(new Property("Gloppen", 1445, 77, 131, 661.3, "Syningom", "Nicolay Madsen"));
        registry.addProperty(new Property("Gloppen", 1445, 75, 19, 650.6,"Fugletun", "Evilyn Jensen"));
        registry.addProperty(new Property("Gloppen", 1445, 74, 188, 1457.2, "Karl Ove Bråten"));
        registry.addProperty(new Property("Gloppen", 1445, 69, 47, 1339.4, "Elsa Indregård"));

        /**
         * Initialize some variables, these will be helpful in the main loop.
         * Initializing these now means we don't have to waste time allocating and re-allocating memory later,
         * saving performance and memory usage
         */
        int choice, municipalityNo, lotNo, sectionNo;
        double area;
        String municipality, name, owner;
        Property foundProperty;

        /**
         * The main program loop, which shows the menu, gets input and responds accordingly
         */
        try (Scanner input = new Scanner(System.in).useDelimiter("\n")) {
            do {
                System.out.println("Welcome to the property registry!\nWhat would you like to do?");
                System.out.println("1. Add property\n2. List all properties");
                System.out.println("3. Search for property\n4. Calculate average area of registered properties");
                System.out.println("5. Quit");
                System.out.print("Selection: ");

                choice = input.nextInt();

                System.out.println();

                switch (choice) {
                    /**
                     * Get info from user to add a new property
                     * This routine does simple checks to ensure input data is valid
                     */
                    case 1:
                        System.out.println("Adding new property");

                        System.out.print("Municipality: ");
                        municipality = input.next();

                        do {
                            System.out.print("Municipality number [101 - 5054]: ");
                            municipalityNo = input.nextInt();
                        } while (municipalityNo < 101 || municipalityNo > 5054);

                        do {
                            System.out.print("Lot number: ");
                            lotNo = input.nextInt();
                        } while (lotNo < 0);

                        do {
                            System.out.print("Section number: ");
                            sectionNo = input.nextInt();
                        } while (sectionNo < 0);

                        System.out.print("Area of property: ");
                        area = input.nextDouble();

                        System.out.print("Property name (optional): ");
                        name = input.next();

                        System.out.print("Owner: ");
                        owner = input.next();

                        if (registry.addProperty(new Property(municipality, municipalityNo, lotNo, sectionNo, area, name, owner))) {
                            System.out.println("Property added successfully!");
                        } else {
                            System.out.println("Property was not added to the registry, likely because a property of the same ID already exists");
                        }
                        break;
                    
                    /**
                     * To list all properties, we use the handy toString() method of the registry
                     */
                    case 2:
                        System.out.println(registry);
                        break;

                    /**
                     * This routine gets the info needed to perform a search in the registry, performs the search and prints the result if any
                     */
                    case 3:
                        System.out.print("Municipality number: ");
                        municipalityNo = input.nextInt();

                        System.out.print("Lot number: ");
                        lotNo = input.nextInt();

                        System.out.print("Section number: ");
                        sectionNo = input.nextInt();

                        foundProperty = registry.findProperty(municipalityNo, lotNo, sectionNo);

                        /**
                         * registry.findProperty() will return a null object if no property is found, so we check if the 
                         * return value is null here, and respond accordingly
                         */
                        System.out.println(foundProperty != null ? String.format("Found property:\n%s", foundProperty) : "No property found");
                        break;

                    /**
                     * Getting the average area is simple thanks to the built-in getAverageArea() method of the registry
                     */
                    case 4:
                        System.out.println(String.format("The average area of the registered properties is %.2f m^2", registry.getAverageArea()));
                        break;
                
                    default:
                        break;
                }
                System.out.println();
            } while (choice != 5);
        } catch (Exception e) {
            System.out.println("An error has occurred in the application loop!");
            throw e;
        }
    }
}
