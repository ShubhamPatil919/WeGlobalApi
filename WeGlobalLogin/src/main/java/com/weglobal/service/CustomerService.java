package com.weglobal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.weglobal.entity.Customer;

public interface CustomerService {

	// Save the Customer information & Send Email from Enquiry
	public Customer saveCustomer(String customer, MultipartFile file) throws Exception;

	public List<Customer> getAllCustomer();

}
