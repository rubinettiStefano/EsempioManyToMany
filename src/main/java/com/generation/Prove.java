package com.generation;

import com.generation.model.Contract;
import com.generation.model.Employer;
import com.generation.model.Freelancer;
import com.generation.model.FreelancerRepository;

public class Prove
{
	public static void main(String[] args)
	{
		FreelancerRepository repo = FreelancerRepository.getInstance();

		Freelancer stefano = repo.findFreelancer(3);

		System.out.println(stefano.getName()+" "+stefano.getSurname());
		System.out.println(stefano.getContracts().size()+" contracts");
		System.out.println("Ho lavorato per: ");
//		for(Contract contract : stefano.getContracts())
//			System.out.println(contract.getEmployer().getName());
		for(Employer e : stefano.getAllEmployers())
			System.out.println(e.getName());

	}
}
