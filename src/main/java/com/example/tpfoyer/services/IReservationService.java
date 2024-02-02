package com.example.tpfoyer.services;

import com.example.tpfoyer.entity.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation retrieveReservation(String reservationId);
    Reservation addReservation(Reservation reservation);
    void removeReservation(String reservationId);

    Reservation modifyReservation(Reservation reservation);
}
