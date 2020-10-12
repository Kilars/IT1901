package bookingsystem.core;
import java.util.*;


/**
 * Salon class
 * Each salon has a list of treatments, and a list of hairdressers.
 */
public class Salon{
    public List<Treatment> treatments = new ArrayList<>();
    public List<HairDresser> hairDressers = new ArrayList<>();


    /**
    * Constructor with no parameters. 
    * Calling the method {@initialize()} to set given treatments and hairdressers.
    */
    public Salon() {
        initialize();
    }

    /**
     * Method to set treatments and hairdresser
     */
    public void initialize(){
        addTreatment("Herreklipp", 299);
        addTreatment("Dameklipp", 399);
        addTreatment("Studentklipp", 249);
        addTreatment("Striping langt hår", 1400);
        addTreatment("Striping kort hår", 999);
        addTreatment("Farging av bryn", 199);
        addTreatment("Vask og føn", 149);
        addTreatment("Styling", 599);
        addHairdresser("Sofie Blond");
        addHairdresser("Marie Brunette");

    }

    /**
     * Method to add treatments
     * @param nameTreatment
     * @param price
     */
    private void addTreatment(String nameTreatment, double price) {
        Treatment newTreatment = new Treatment(nameTreatment, price);
        treatments.add(newTreatment);
    }

    /**
     * Method to remove treatment
     * @param treatment
     */
    private void removeTreatment(Treatment treatment) {
        treatments.remove(treatment);
    }

    /**
     * Method to return treatment list
     * @return  treatments
     */
    public List<Treatment> getTreatmentList() {
        return this.treatments;
    }

    /**
     * Method to add a hairdresser from the salon
     * @param name     Hairdressers name
     */
    private void addHairdresser(String name){
        HairDresser hairdresser = new HairDresser(name);
        hairDressers.add(hairdresser);
    }

    /**
     * Method to remove a hairdresser from the salon
     * @param hairdresser   Hairdresser object
     */
    private void removeHairdresser(HairDresser hairdresser) {
        hairDressers.remove(hairdresser);
    }

    /**
     * Method to return all hairdressers
     * @return hairdresser
     */
    public List<HairDresser> getHairdresserList(){
        return this.hairDressers;
    }

}