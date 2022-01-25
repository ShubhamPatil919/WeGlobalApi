package com.weglobal.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weglobal.entity.Customer;
import com.weglobal.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	public JavaMailSender emailSender;

	@Override
	public Customer saveCustomer(String jsonData, MultipartFile file) throws Exception {

		Customer customer = new Customer();
		try {

			ObjectMapper mapper = new ObjectMapper();
			customer = mapper.readValue(jsonData, Customer.class);
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			// System.out.println("Date " + date);
			customer.setSubmitedOn(date);
			customer.setFile(file.getBytes());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("spatil0617@gmail.com");
		simpleMailMessage.setCc("aakashtare07@gmail.com", "rt38092@gmail.com");
		simpleMailMessage.setSubject("Enquiry from " + customer.getCustomerName() + " On www.weglobal.com");
		simpleMailMessage.setText(customer.getMessage());
		emailSender.send(simpleMailMessage);

		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customer = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customer1 -> customer.add(customer1));
		return customer;
	}

}
