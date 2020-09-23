package com.example.corso.flow.viewmodel;

import java.io.Serializable;

public class HelloFlowBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
