package bookingsystem.core;
import java.util.regex.Pattern;


/**
 * User class
 * Each object has a first name, surname, email, phone and password
 * The class has two different constructors
 */
public class User {
    public String firstName;
    public String surname;
    public String email;
    public String phone;
    public String password;
    
    /**
     * User constructor with no paramaters. 
     * Sets all attributes to Null.
     */
    public User() {
    }

    /**
     * Creates a new object taking in all parameters
     * @param firstName
     * @param surname
     * @param email
     * @param phone
     * @param password
     */
    
     public User(String firstName, String surname, String email, String phone, String password) {
        /*if (firstName != "") setFirstName(firstName);
        if (surname != "") setSurname(surname);
        if (email != "") setEmail(email);
        if (phone != "") setPhone(phone);
        if (password != "") setPassword(password);*/
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    /**
     * User constructor that converts a String to an object. 
     * Fills all attributes.
     * @param string    String with format "firstName;surname;email;phone;password"
     */
    public User(String string) {
        String[] userInfo = string.split(";");
        setFirstName(userInfo[0]);
        setSurname(userInfo[1]);
        setEmail(userInfo[2]);
        setPhone(userInfo[3]);
        setPassword(userInfo[4]);
    }

    /**
     * Checks if password contains at least 8 characters, and consists only of letters and digits. 
     * Sets the attribute "password" if the input is valid. 
     * Throws an exception if the input is invalid.
     * @param password 
     */
    public void setPassword(String password) {
        if (Pattern.matches("\\w{8,}", password)) {
            this.password = password;
        }
        else {
            throw new IllegalArgumentException("Vennligst skriv inn et gyldig passord");
        }
    }

    /**
     * Checks if password contains 8 digits.
     * Sets the attribute "phone" if the input is valid.
     * Throws an exception if the input is invalid
     * @param phone
     */
    public void setPhone(String phone) {
        if (Pattern.matches("\\d{8}", phone)) {
            this.phone = phone;
        }
        else {
            throw new IllegalArgumentException("Vennligst skriv inn et gyldig telefonnummer");
        }
    }

    /**
     * Checks if a name starts with a capital letter, consists only of letters, and is at least 2 characters long.
     * @param name
     * @return res      True if name is valid, False if name is invalid
     */
    private boolean checkName(String name) {
        boolean res = false;
        String[] nameLst = name.split(" ");
        for (String nam : nameLst) {     
            if (Pattern.matches("[A-Z]{1}[a-z]{2,}",nam)) {
                res = true;
            }
        }
        return res;
    }

    /**
     * Checks if name is valid using method {@link #checkName(String)}
     * Sets the attribute "firstName" if input is valid.
     * Throw an exception if input is invalid
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if (checkName(firstName)) {
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("Vennligst skriv inn et gydlig fornavn");
        }
    }

    /**
     * Checks if name is valid using method {@link #checkName(String)}
     * Sets the attribute "surname" if input is valid
     * Throw an exception if input is invalid
     * @param surname
     */
    public void setSurname(String surname) {
        if (checkName(surname)) {
            this.surname = surname;
        }
        else {
            throw new IllegalArgumentException("Vennligst skriv inn et gyldig etternavn");
        }
    }

    
    /**
     * Checks if email has characters before and after "@".
     * Sets the attribute "email" if input is valid
     * Throw an exception if input is invalid
     * @param email
     */
    public void setEmail(String email) {
        if (Pattern.matches("^(.+)@(.+)$",email)) {
            this.email = email;
        }
        else {
            throw new IllegalArgumentException("Vennligst skriv inn en gyldig email-adresse");
        }
    }
    /**
     * Converts string to format "firstname;surname;email;phone;password".
     */
    @java.lang.Override
    public java.lang.String toString() {
        return (firstName + ';' + surname + ';' + email + ';' + phone + ';' + password);
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Test
     * @param args
     */
    public static void main(String[] args) {
    
    
    //User user = new User();
    //user.setFirstName("Ingrid"); 
    //user.setSurname("Hagen"); 
    //user.setEmail("ingrid-hagen99@hotmail.com");
    //user.setPhone("97103994");
    //user.setPassword("H");
    //System.out.println(user.toString());
    }
}
