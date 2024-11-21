package com.generation.model;

import jakarta.persistence.*;

@Entity
public class Contract
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String commission;
	private int payment;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne
	@JoinColumn(name = "freelancer_id")
	private Freelancer freelancer;

	public Employer getEmployer()
	{
		return employer;
	}

	public void setEmployer(Employer employer)
	{
		this.employer = employer;
	}

	public Freelancer getFreelancer()
	{
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer)
	{
		this.freelancer = freelancer;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getCommission()
	{
		return commission;
	}

	public void setCommission(String commission)
	{
		this.commission = commission;
	}

	public int getPayment()
	{
		return payment;
	}

	public void setPayment(int payment)
	{
		this.payment = payment;
	}
}
