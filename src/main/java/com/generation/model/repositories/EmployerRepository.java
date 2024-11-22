package com.generation.model.repositories;

import com.generation.helpers.HibernateHelper;
import com.generation.model.entities.Employer;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EmployerRepository extends RepositoryGenerica<Employer>
{
	//SINGLETON
	private static EmployerRepository instance;

	public static EmployerRepository getInstance()
	{
		if (instance == null)
			instance = new EmployerRepository();
		return instance;
	}

	private EmployerRepository()
	{
		super(Employer.class);
	}
	//FINE SINGLETON


}
