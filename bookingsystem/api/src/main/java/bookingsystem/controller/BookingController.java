package bookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookingsystem.core.User;
import bookingsystem.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingController {

  @Autowired
  BookingService bookingService;

  @GetMapping(value = "/users")
  public ResponseEntity<User> getUser() {
    User user = bookingService.getUser();
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

}