package com.joseway.ngspringsec.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseway.ngspringsec.model.Contribution;
import com.joseway.ngspringsec.repository.ContributionRepository;
import com.joseway.ngspringsec.services.ContributionService;

@Service
public class ContributionServiceImpl implements ContributionService{
	
	@Autowired
	private ContributionRepository contributionRepository;

	@Override
	public List<Contribution> findAll() {
		return contributionRepository.findAll();
	}

	@Override
	public Contribution save(Contribution contribution) {
		return contributionRepository.save(contribution);
	}

	@Override
	public Contribution findById(long id) {
		return contributionRepository.findById(id).get();
	}

	@Override
	public Contribution delete(long id) {
		Contribution contribution = findById(id);
		contributionRepository.deleteById(id);
		return contribution;
	}

}
