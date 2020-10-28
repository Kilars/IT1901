package bookingsystem.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Hairdresser class
 * Each hairdresser has a name
 */
public class HairDresser {
    public String name;
    public HashMap<LocalDate, List<Integer>> timetable = new HashMap<>();
    public ArrayList<Integer> defaultTime  = new ArrayList<Integer>();
    

    /**
     * Constructor with parameter, name
     * @param name  Hairdressers name
     */
    public HairDresser(String name) {
        this.name = name;
        initializeDefault();
    }

    /**
     * Constructor with no parameters
     */
    public HairDresser() {
    }

    public void initializeDefault() {
       for (int i = 0; i<8; i++) {
         defaultTime.set(i, i+1);
       }
    }

    public ArrayList<Integer> getAvailable(LocalDate date) {
      ArrayList<Integer> availableTime  = new ArrayList<Integer>();
      if (this.timetable.containsKey(date)){

        for (int i = 0; i<=8; i++) {
            if (this.timetable.get(date).contains(i)) {
              availableTime.add(i);
            }
        }
      }
      else {
        this.timetable.put(date,this.defaultTime); 
      }
      return availableTime;
    }

    /**
     * Method that books an appointment
     * @param date  LocalDate object
     * @param time  Integer representing times from 1-8
     */
    public void bookAppointment(LocalDate date, int time){
      if (timetable.get(date).contains(time)) {
        timetable.get(date).remove(time);
      }
      else {
        throw new IllegalArgumentException("Appointment is not available");
      }
      
    }
    /**
     * Method that cancels an appointment for a hairdresser
     * @param date  LocalDate object
     * @param time  Integer representing times from 1-8
     */
    public void cancelAppointment(LocalDate date, int time){
      if (!(timetable.get(date).contains(time))) {
        timetable.get(date).add(time);
      }
      else {
        throw new IllegalArgumentException("Appointment is not booked");
      }
      
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



