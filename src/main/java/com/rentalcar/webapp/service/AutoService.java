package com.rentalcar.webapp.service;

import com.rentalcar.webapp.entity.Automezzo;
import com.rentalcar.webapp.entity.Utente;

import java.util.List;

public interface AutoService {

    List<Automezzo> getAllAutomezzi();

    List<Automezzo> getAllAutoFromCategoria(String categoria);

    Automezzo getAutomezzo(Long id);

    void save(Automezzo automezzo);

    void update(Automezzo automezzo);

    void delete(Long id);

}
