import java.util.ArrayList;

public class PropertyRegistry {
    private ArrayList<Property> properties;

    /**
     * Initializes an empty registry, with no properties.
     */
    public PropertyRegistry() {
        this.properties = new ArrayList<Property>();
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder("Property registry:");
        for (Property property : this.properties) {
            buffer.append("\n\n");
            buffer.append(property);
        }

        return buffer.toString();
    }

    /**
     * Adds a new property to the registry, if the property does not already exist
     * "Already exists" is defined as "sharing a municipality number, lot number and section number"
     * 
     * @param property - The property to be added
     * 
     * @return false if the given property already exists in the registry, true otherwise
     */
    public boolean addProperty(Property property) {
        if (this.findProperty(property.getMunicipalityNo(), property.getLotNo(), property.getSectionNo()) != null) {
            return false;
        }

        properties.add(property);
        return true;
    }

    public void removeProperty(Property property) {
        this.properties.remove(property);
    }

    public int getNoOfProperties() {
        return this.properties.size();
    }

    /**
     * Search through the registry to see if a property is already registered
     * 
     * @param municipalityNo - Municipality number of the municipality the property is in
     * @param lotNo - The lot number of the property
     * @param sectionNo - The section number of the property
     * @return The property if it exists, null if no matching property was found in the registry
     */
    public Property findProperty(int municipalityNo, int lotNo, int sectionNo) {
        String searchterm = String.format("%d-%d/%d", municipalityNo, lotNo, sectionNo);

        for (Property property : this.properties) {
            if (searchterm.equals(property.getId())) {
                return property;
            }
        }

        return null;
    }

    /**
     * @return The average area of all properties in the registry
     */
    public double getAverageArea() {
        double sum = 0;

        for (Property property : this.properties) {
            sum += property.getArea();
        }

        return sum / this.getNoOfProperties();
    }

    /**
     * Finds all properties in the registry with a given lot number
     * @param lotNo - The lot number to search for
     * @return - An ArrayList of properties with the desired lot number
     */
    public ArrayList<Property> getPropertiesWithLotNo(int lotNo) {
        ArrayList<Property> resultbuffer = new ArrayList<Property>();

        for (Property property : this.properties) {
            if (property.getLotNo() == lotNo) {
                resultbuffer.add(property);
            }
        }

        return resultbuffer;
    }
}