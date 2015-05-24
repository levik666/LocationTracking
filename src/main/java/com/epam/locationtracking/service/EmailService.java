package com.epam.locationtracking.service;

public interface EmailService {
	public void send(String userName, String userEmail, String confirmationLink);
}
