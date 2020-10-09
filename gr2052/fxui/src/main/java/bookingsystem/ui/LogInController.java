package bookingsystem.ui;
import bookingsystem.core.Users;

/* Kontroller for LogIn.fxml */
public class LogInController {
    
    private Users users;

    public Users init_data(Users users){
        return this.users = users;
    }
}