package com.joseway.ngspringsec.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseway.ngspringsec.model.Don;
import com.joseway.ngspringsec.repository.DonRepository;
import com.joseway.ngspringsec.services.DonService;

@Service
public class DonServiceImpl implements DonService{
	
	@Autowired
	private DonRepository donRepository;

	@Override
	public List<Don> findAll() {
		return donRepository.findAll();
	}

	@Override
	public Don save(Don don) {
		return donRepository.save(don);
	}

	@Override
	public Don findById(long id) {
		return donRepository.findById(id).get();
	}

	@Override
	public Don delete(long id) {
		Don don = findById(id);
		donRepository.deleteById(id);
		return don;
	}

}
