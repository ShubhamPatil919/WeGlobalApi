package com.weglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.weglobal.entity.Customer;
import com.weglobal.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired(required = false)
	public CustomerService customerService;

	/*
	 * @Autowired private CustomerFileUploadService customerFileUploadService;
	 */

	@PostMapping(value = "/saveCustomer", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public Customer saveCustomer(@RequestPart("jsonData") String customerData, @RequestPart("file") MultipartFile file)
			throws Exception {
		Customer customer = customerService.saveCustomer(customerData, file);
		return customer;
	}

	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer() {

		return customerService.getAllCustomer();
	}

}
