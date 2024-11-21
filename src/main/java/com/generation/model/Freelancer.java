package com.generation.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@Table( name = "freelancer") DEL TUTTO OPZIONALE
public class Freelancer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id") OPZIONALE SE nomeProprieta=nomeColonna
	private Integer id;

	private String name,surname,p_iva;

	@OneToMany(mappedBy = "freelancer")
	private List<Contract> contracts = new ArrayList<>();

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getP_iva()
	{
		return p_iva;
	}

	public void setP_iva(String p_iva)
	{
		this.p_iva = p_iva;
	}

	public List<Contract> getContracts()
	{
		return contracts;
	}

	public void setContracts(List<Contract> contracts)
	{
		this.contracts = contracts;
	}

	public Set<Employer> getAllEmployers()
	{
		Set<Employer> res = new HashSet<>();

		for(Contract contract : contracts)
			res.add(contract.getEmployer());

		return res;
	}
}
