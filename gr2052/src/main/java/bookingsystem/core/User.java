package bookingsystem.core;
import java.util.regex.Pattern;

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
            System.err.println("Please enter a valid phone number that contains 8 digits");
        }
    }

    public void setFirstName(String firstName) {
        if (checkName(firstName)) {
            this.firstName = firstName;
        }
        else {
            System.err.println("Please enter a valid name starting with a capital letter");
        }
    }

    public void setSurname(String surname) {
        if (checkName(surname)) {
            this.surname = surname;
        }
        else {
            System.err.println("Please enter a valid name starting with a capital letter");
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
            System.err.println("Please enter a valid email.");
        }
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
    
    User user = new User();

    user.setFirstName("Ingrid");
    user.setSurname("Hagen");
    user.setEmail("ingrid-hagen99@hotmail.com");
System.out.println("hIe");
}

}

