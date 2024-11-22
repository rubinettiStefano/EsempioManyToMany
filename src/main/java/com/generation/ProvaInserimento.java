package com.generation;

import com.generation.model.entities.Contract;
import com.generation.model.entities.Employer;
import com.generation.model.entities.Freelancer;
import com.generation.model.repositories.ContractRepository;
import com.generation.model.repositories.EmployerRepository;
import com.generation.model.repositories.FreelancerRepository;

public class ProvaInserimento
{
	public static void main(String[] args)
	{
		FreelancerRepository fRepo 	= FreelancerRepository.getInstance();
		EmployerRepository eRepo 	= EmployerRepository.getInstance();
		ContractRepository cRepo 	= ContractRepository.getInstance();

		Freelancer f = new Freelancer();
		f.setName("Alessandro");
		f.setSurname("Annino");
		f.setP_iva("012Steppa");

		fRepo.insert(f);

		Employer amiciDiOgniCosa = eRepo.find(2);

		Contract contract = new Contract();
		contract.setEmployer(amiciDiOgniCosa);
		contract.setFreelancer(f);
		contract.setCommission("NON RICICLAGGIO DI DENARO");
		contract.setPayment(1000000);

		cRepo.insert(contract);

	}
}
