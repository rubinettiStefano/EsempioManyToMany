package com.generation;

import com.generation.model.*;

public class ProvaInserimento
{
	public static void main(String[] args)
	{
		FreelancerRepository fRepo 	= FreelancerRepository.getInstance();
		EmployerRepository eRepo 	= EmployerRepository.getInstance();
		ContractRepository cRepo 	= ContractRepository.getInstance();

		Freelancer f = new Freelancer();
		f.setName("Tea");
		f.setSurname("Di Giacomo");
		f.setP_iva("789Stalla");

		fRepo.insertFreelancer(f);

		Employer amiciDiOgniCosa = eRepo.findEmployer(2);

		Contract contract = new Contract();
		contract.setEmployer(amiciDiOgniCosa);
		contract.setFreelancer(f);
		contract.setCommission("NON RICICLAGGIO DI DENARO");
		contract.setPayment(1000000);

		cRepo.insertContract(contract);
	}
}
