package com.rentalcar.webapp.service;

import com.rentalcar.webapp.dao.TipologiaAutoDao;
import com.rentalcar.webapp.dao.TipologiaUtenteDao;
import com.rentalcar.webapp.entity.TipologiaAutomezzo;
import com.rentalcar.webapp.entity.TipologiaUtente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("TipologiaAutoService")
@Transactional
public class TipologiaAutoServiceImpl implements TipologiaAutoService{

    @Autowired
    private TipologiaAutoDao tipologiaAutoDao;

    @Override
    public List<TipologiaAutomezzo> getAllTipologie() {
        return tipologiaAutoDao.getAllTipologie();
    }

    @Override
    public TipologiaAutomezzo getCategoria(String categoria) {
        return tipologiaAutoDao.getCategoria(categoria);
    }
}
