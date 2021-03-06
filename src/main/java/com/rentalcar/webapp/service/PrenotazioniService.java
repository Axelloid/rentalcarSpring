package com.rentalcar.webapp.service;

import com.rentalcar.webapp.entity.Prenotazioni;
import com.rentalcar.webapp.entity.Utente;

import java.util.Date;
import java.util.List;

public interface PrenotazioniService {

    List<Prenotazioni> getPrenotazioniByUser(Long id);

    List<Prenotazioni> getAllPrenotazioni();

    void save(Prenotazioni prenotazione);

    void update(Prenotazioni prenotazione);

    void delete(Long id);

    void approve(Prenotazioni prenotazione);

    Prenotazioni getPrenotazione(Long id);

    boolean checkEditableOrDeletableBeforeXDaysPrenotazione(Date start);

    boolean checkAvailableVehicleInDatePrenotazione(Prenotazioni prenotazione);

    boolean checkDataEndAfterDataStart(Prenotazioni prenotazione);
}
