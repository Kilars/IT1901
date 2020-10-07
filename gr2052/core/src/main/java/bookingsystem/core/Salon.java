package bookingsystem.core;
import java.util.*;

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


}

public void addTreatment(String nameTreatment, double price) {
    Treatment newTreatment = new Treatment(nameTreatment, price);
    treatments.add(newTreatment);
}

public void removeTreatment(Treatment treatment) {
    treatments.remove(treatment);
}

public List<Treatment> getTreatmentList() {
    return this.treatments;
}

}