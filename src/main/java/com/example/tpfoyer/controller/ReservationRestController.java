package com.example.tpfoyer.controller;

import com.example.tpfoyer.entity.Reservation;
import com.example.tpfoyer.services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    IReservationService reservationService;

    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        List<Reservation> listReservations = reservationService.retrieveAllReservations();
        if (listReservations.size()>0){
            return listReservations;
        }
        return listReservations;
    }

    // http://localhost:8089/tpfoyer/reservation/retrieve-reservation/8
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public ResponseEntity<Object> retrieveReservation(@PathVariable("reservation-id") String chId) {
        Reservation reservation = reservationService.retrieveReservation(chId);
        if (reservation !=null){
            return  new ResponseEntity<>(reservation, HttpStatus.OK);
        }
      return new ResponseEntity<>("error ",HttpStatus.CONFLICT);
    }

    @PostMapping("/add-reservation")
    public ResponseEntity<Object> addReservation(@RequestBody Reservation c) {
        Reservation reservation = reservationService.addReservation(c);
        if(reservation!=null){
            return new ResponseEntity<>(reservation,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(" error ",HttpStatus.CONFLICT);
    }

    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String chId) {
        reservationService.removeReservation(chId);
    }

    @PutMapping("/modify-reservation")
    public ResponseEntity modifyReservation(@RequestBody Reservation c) {
        if  (reservationService.modifyReservation(c) !=null){
            return new ResponseEntity(reservationService.modifyReservation(c),HttpStatus.OK);
        }

       return new ResponseEntity("error ",HttpStatus.CONFLICT);
    }

}
