package com.joseway.ngspringsec.services;

import java.util.List;

import com.joseway.ngspringsec.model.Don;

public interface DonService {
	
	public List<Don> findAll();
	public Don save(Don don);
	public Don findById(long id);
	public Don delete(long id);

}
