package com.generation.helpers;

import com.generation.model.entities.Employer;
import com.generation.model.entities.Freelancer;
import com.generation.model.repositories.EmployerRepository;
import com.generation.model.repositories.FreelancerRepository;

import java.util.List;

public class ControllerHelper
{

	private static ControllerHelper instance;
	public static ControllerHelper getInstance()
	{
		if(instance == null)
			instance = new ControllerHelper();
		return instance;
	}
	private ControllerHelper(){}

	FreelancerRepository fRepo 	= FreelancerRepository.getInstance();
	EmployerRepository eRepo 	= EmployerRepository.getInstance();

	public String nomiTuttiFreelancer()
	{
		List<Freelancer> freelancers = fRepo.findAll();
		String nomi = "";

		for(Freelancer freelancer : freelancers)
			nomi+=freelancer.getName()+"\n";

		return nomi;
	}

	public String nomiTutteAziende()
	{
		List<Employer> aziende = eRepo.findAll();
		String nomi = "";

		for(Employer e : aziende)
			nomi+=e.getName()+"\n";

		return nomi;
	}
}
