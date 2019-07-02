package com.joseway.ngspringsec.services;

import java.util.List;

import com.joseway.ngspringsec.model.Adresse;

public interface AdresseService {

	public List<Adresse> findAll();
	public Adresse save(Adresse adresse);
	public Adresse findById(long id);
	public Adresse delete(long id);
}
