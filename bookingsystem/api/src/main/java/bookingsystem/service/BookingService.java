package bookingsystem.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import bookingsystem.core.User;
import bookingsystem.core.Users;

@Service
public class BookingService {
  
  public User getUser() {
    return new User("Magnus", "Holta", "magnus.holta@sdødlsfhjsafdljhsadfølkjasdfølkstud.ntnu.no", "48052730", "aaaaaaaa");
  }
}  