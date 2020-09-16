package bookingsystem.core;
import java.util.regex.Pattern;

public class User {
    public String firstName;
    public String surname;
    public String email;
    public String phone;
    public String password;

    public User() {
    }
    
    public User(String string) {

        String[] userInfo = string.split(";");
        setFirstName(userInfo[0]);
        setSurname(userInfo[1]);
        setEmail(userInfo[2]);
        setPhone(userInfo[3]);
        setPassword(userInfo[4]);
    }

    public void setPassword(String password) {
        if (Pattern.matches("\\w{8,}", password)) {
            this.password = password;
        }
        else {
            throw new IllegalArgumentException("Vennligst skriv inn et gyldig passord");
        }
    }

    public void setPhone(String phone) {
        if (Pattern.matches("\\d{8}", phone)) {
            this.phone = phone;
        }
        else {
            throw new IllegalArgumentException("Vennligst skriv inn et gyldig telefonnummer");
        }
    }


    public void setFirstName(String firstName) {
        if (checkName(firstName)) {
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("Vennligst skriv inn et gydlig fornavn");
        }
    }

    public void setSurname(String surname) {
        if (checkName(surname)) {
            this.surname = surname;
        }
        else {
            throw new IllegalArgumentException("Vennligst skriv inn et gyldig etternavn");
        }
    }

    private boolean checkName(String name) {
        boolean res = false;
        String[] nameLst = name.split(" ");
        for (String nam : nameLst) {     
            if (Pattern.matches("[A-Z]{1}[a-z]{3,}",nam)) {
                res = true;
            }
        }
        return res;
    }

    public void setEmail(String email) {
        if (Pattern.matches("^(.+)@(.+)$",email)) {
            this.email = email;
        }
        else {
            throw new IllegalArgumentException("Vennligst skriv inn en gyldig email-adresse");
        }
    }

     @java.lang.Override
    public java.lang.String toString() {
        return (firstName + ';' + surname + ';' + email + ';' + phone + ';' + password);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) {
    
        //TEST
   User user = new User();
    //user.setFirstName("Ingrid"); 
    //user.setSurname("Hagen"); 
    //user.setEmail("ingrid-hagen99@hotmail.com");
    //user.setPhone("97103994");
    //user.setPassword("H");
    System.out.println(user.toString());
    }
}
