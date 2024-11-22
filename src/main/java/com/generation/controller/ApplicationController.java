package com.generation.controller;

import com.generation.helpers.ControllerHelper;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ApplicationController
{

	private ControllerHelper helper = ControllerHelper.getInstance();


	@FXML
	private Text nomiEmp,nomiFree;

	public void caricaNomiEmp()
	{
		String cont = helper.nomiTutteAziende();
		nomiEmp.setText(cont);
	}

	public void caricaNomiFree()
	{
		String cont = helper.nomiTuttiFreelancer();
		nomiFree.setText(cont);
	}
}
