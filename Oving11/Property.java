/**
 * Property
 * A container class, containing the relevant info to identify a Norwegian property
 * As this is a container class, it has only setters and getters, as well as a toString() method
 * All fields are mutable, as properties can change owners, can have their borders redrawn which changes the area,
 * and even the municipality could change for political reasons
 */
public class Property {

    private int municipalityNo, lotNo, sectionNo;
    private String municipality, owner, name;
    private double area;

    /**
     * Simple constructor, which also checks that the municipality, lot and section numbers are valid
     * 
     * @param municipality - Name of municipality the property is in
     * @param municipalityNo - Municipality number of the municipality the property is in
     * @param lotNo - Lot number of the property
     * @param sectionNo - Section number of the property
     * @param area - Area of the property [m^2]
     * @param name (Optional) - Name of the property
     * @param owner - Name of the owner of the property
     */
    public Property(String municipality, int municipalityNo, int lotNo, int sectionNo, double area, String name, String owner) {
        if (municipalityNo < 101 || municipalityNo > 5054) {
            throw new IllegalArgumentException("Municipality number must be between 101 and 5054");
        }

        if (lotNo < 0) {
            throw new IllegalArgumentException("Lot number must be a positive integer");
        }

        if (sectionNo < 0) {
            throw new IllegalArgumentException("Section number must be a positive integer");
        }

        this.area = area;
        this.lotNo = lotNo;
        this.municipalityNo = municipalityNo;
        this.municipality = municipality;
        this.name = name;
        this.owner = owner;
        this.sectionNo = sectionNo;
    }

    /**
     * Extra constructor for properties with no name.
     * Simply calls the above constructor with an empty string in the name field, for convenience
     */
    public Property(String municipality, int municipalityNo, int lotNo, int sectionNo, double area, String owner) {
        this(municipality, municipalityNo, lotNo, sectionNo, area, "", owner);
    }

    /**
     * toString() method to provide property info in an easily readable format
     */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(String.format("%s: %s\n", this.getId(), this.name));
        buffer.append(String.format("Owner: %s", this.owner));
        buffer.append(String.format("Municipality: %s\n", this.municipality));
        buffer.append(String.format("Area: %.2f m^2\n", this.area));

        return buffer.toString();
    }

    /**
     * Returns the necessary data to uniquely identify a property, in the format
     * {municipality number}-{lot number}/{section number}
     */
    public String getId() {
        return String.format("%d-%d/%d", this.municipalityNo, this.lotNo, this.sectionNo);
    }

    /**
     * @return The area of the property in square meters
     */
    public double getArea() {
        return area;
    }

    /**
     * @return The lot number of the property
     */
    public int getLotNo() {
        return lotNo;
    }

    /**
     * @return The municipality number of the municipality the property is in
     */
    public int getMunicipalityNo() {
        return this.municipalityNo;
    }

    /**
     * @return The name of the municipality the property is in
     */
    
    public String getMunicipality() {
        return this.municipality;
    }

    /**
     * @return The property's name (might be empty)
     */
    
    public String getName() {
        return this.name;
    }

    /**
     * @return The name of the property owner
     */
    public String getOwner() {
        return this.owner;
    }

    /**
     * @return The section number of the property
     */
    public int getSectionNo() {
        return this.sectionNo;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setLot(int lot) {
        this.lotNo = lot;
    }

    public void setMnr(int mnr) {
        this.municipalityNo = mnr;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setSection(int section) {
        this.sectionNo = section;
    }
}