package bookingsystem.core;

/**
 * Class for treatments. Each treatment has a treatment name and a price
 * The class has to constructors, one with no parameters, and one with parameters.
 */
public class Treatment {

    public String treatment;
    public double price;

    public Treatment(String treatment, double price) {
        this.price = price;
        this.treatment = treatment;
    }

    public Treatment() {
        
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param treatment the treatment to set
     */
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    /**
     * @return the treatment
     */
    public String getTreatment() {
        return this.treatment;
    }
}