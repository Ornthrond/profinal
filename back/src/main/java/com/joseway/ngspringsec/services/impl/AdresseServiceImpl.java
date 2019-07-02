package com.joseway.ngspringsec.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseway.ngspringsec.model.Adresse;
import com.joseway.ngspringsec.repository.AdresseRepository;
import com.joseway.ngspringsec.services.AdresseService;

@Service
public class AdresseServiceImpl implements AdresseService{
	
	@Autowired
	private AdresseRepository adresseRepository;

	@Override
	public List<Adresse> findAll() {
		return adresseRepository.findAll();
	}

	@Override
	public Adresse save(Adresse adresse) {
		return adresseRepository.save(adresse);
	}

	@Override
	public Adresse findById(long id) {
		return adresseRepository.findById(id).get();
	}

	@Override
	public Adresse delete(long id) {
		Adresse adresse = findById(id);
		adresseRepository.deleteById(id);
		return adresse;
	}

}
