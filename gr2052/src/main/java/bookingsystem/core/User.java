package bookingsystem.core;
import java.util.regex.Pattern;
import java.util.*;

public class User {
    public String firstName;
    public String surname;
    public String email;
    public String phone;

    
    public User() {
	}

    public void setPhone(String phone) {
        if (Pattern.matches("\\d{8}", phone)) {
            this.phone = phone;
        }
        else {
            throw new IllegalArgumentException("Please enter a valid phone number");
        }
    }


    public void setFirstName(String firstName) {
        if (checkName(firstName)) {
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("Please enter a valid  first name starting with a capital letter");
        }
    }

    public void setSurname(String surname) {
        if (checkName(surname)) {
            this.surname = surname;
        }
        else {
            throw new IllegalArgumentException("Please enter a valid  surname starting with a capital letter");
        }
    }

    private boolean checkName(String name) {
        if (Pattern.matches("[A-Z]{1}[a-z]{2,}",name)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setEmail(String email) {
        if (Pattern.matches("^(.+)@(.+)$",email)) {
            this.email = email;
        }
        else {
            throw new IllegalArgumentException("Please enter a valid email.");
        }
    }

     @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
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

    public static void main(String[] args) {
    
        //TEST
   User user = new User();
    user.setFirstName("Ingrid"); 
    user.setSurname("Hagen"); 
    user.setEmail("ingrid-hagen99@hotmail.com");
    user.setPhone("97103994");
    System.out.println(user.toString());
    }
    


}

