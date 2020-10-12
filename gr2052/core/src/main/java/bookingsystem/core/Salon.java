package bookingsystem.core;
import java.util.*;


/**
 * Salon class
 * Each salon has a list of treatments, and a list of hairdressers.
 */
public class Salon{
    public List<Treatment> treatments = new ArrayList<>();
    public List<HairDresser> hairDressers = new ArrayList<>();


public Salon() {
    initialize();
}

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

private void addTreatment(String nameTreatment, double price) {
    Treatment newTreatment = new Treatment(nameTreatment, price);
    treatments.add(newTreatment);
}

private void removeTreatment(Treatment treatment) {
    treatments.remove(treatment);
}

public List<Treatment> getTreatmentList() {
    return this.treatments;
}

private void addHairdresser(String name){
    HairDresser hairdresser = new HairDresser(name);
    hairDressers.add(hairdresser);
}

private void removeHairdresser(HairDresser hairdresser) {
    hairDressers.remove(hairdresser);
}

public List<HairDresser> getHairdresserList(){
    return this.hairDressers;
}

}