package com.joseway.ngspringsec.services;

import java.util.List;

import com.joseway.ngspringsec.model.Contribution;

public interface ContributionService {
	
	public List<Contribution> findAll();
	public Contribution save(Contribution contribution);
	public Contribution findById(long id);
	public Contribution delete(long id);

}
