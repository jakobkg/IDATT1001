package types;

public class Currency {
    private final double CONVERSION_RATE;
    private final String NAME;
    
    public Currency(String name, double conversionRate) {
        this.NAME = name;
        this.CONVERSION_RATE = conversionRate;
    }

    public String getName() {
        return this.NAME;
    }

    public double getConversionRate() {
        return this.CONVERSION_RATE;
    }

    public double toNOK(double amount){
        return amount * this.CONVERSION_RATE;
    }

    public String toString() {
        return this.getName();
    }

    public double fromNOK(double amount) {
        return amount / this.CONVERSION_RATE;
    }

    public double fromCurrency(Currency otherCurrency, double amount) {
        return amount * (otherCurrency.getConversionRate() / this.getConversionRate());
    }

    public double toCurrency(Currency otherCurrency, double amount) {
        return amount * (this.getConversionRate() / otherCurrency.getConversionRate());
    }
}
