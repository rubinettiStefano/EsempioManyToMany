package com.generation.model.repositories;

import com.generation.helpers.HibernateHelper;
import com.generation.model.entities.Contract;
import com.generation.model.entities.Freelancer;
import jakarta.persistence.EntityManager;

import java.util.List;

public class FreelancerRepository extends RepositoryGenerica<Freelancer>
{
	private static FreelancerRepository instance;

	public static FreelancerRepository getInstance()
	{
		if (instance == null)
			instance = new FreelancerRepository();
		return instance;
	}

	private FreelancerRepository()
	{
		//ogni COSTRUTTORE di un SOTTOTIPO
		//è OBBLIGATO a richiamare un COSTRUTTORE del SUPERTIPO
		super(Freelancer.class);
	}

}
