package bookingsystem.core;

import java.util.Calendar;
import java.util.HashMap;


/**
 * Hairdresser class
 * Each hairdresser has a name
 */
public class HairDresser {
    private String name;

    /**
     * Constructor with parameter, name
     * @param name  Hairdressers name
     */
    public HairDresser(String name) {
        this.name = name;
    }

    /**
     * Constructor with no parameters
     */
    public HairDresser() {
    }
    
    /**
     * Method to return name
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method to set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}



