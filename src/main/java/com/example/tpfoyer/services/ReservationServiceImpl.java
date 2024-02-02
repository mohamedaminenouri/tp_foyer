package com.example.tpfoyer.services;

import com.example.tpfoyer.entity.Reservation;
import com.example.tpfoyer.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService{
   ReservationRepository reservationRepository;
    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll() ;
    }

    @Override
    public Reservation retrieveReservation(String reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).get();
        if (reservation != null) {
            return reservation;

        } else return null;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        Reservation  ch = reservationRepository.save(reservation);
        if (ch !=null){
            return  ch;
        }
        return null;
    }



    @Override
    public void removeReservation(String reservationId) {

        reservationRepository.deleteById(reservationId);
        System.out.println("reservation supprime");
    }

    @Override
    public Reservation modifyReservation(Reservation reservation) {
       return reservationRepository.save(reservation);
    }
}
