package com.weglobal.entity;


import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_REG_TBL")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_id")
	private long requestId;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "enquiry_for")
	private String enquiryFor;
	@Column(name = "email_address")
	private String emailAddress;
	@Column(name = "mobile_number")
	private long mobileNumber;
	@Column(name = "message")
	private String message;
	@Column(name = "file")
	@Lob
	private byte[] file;
	@Column(name = "submitted_on")
	private Date submitedOn;

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEnquiryFor() {
		return enquiryFor;
	}

	public void setEnquiryFor(String enquiryFor) {
		this.enquiryFor = enquiryFor;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Date getSubmitedOn() {
		return submitedOn;
	}

	public void setSubmitedOn(Date submitedOn) {
		this.submitedOn = submitedOn;
	}

	public Customer(long requestId, String customerName, String enquiryFor, String emailAddress, long mobileNumber,
			String message, byte[] file, Date submitedOn) {
		super();
		this.requestId = requestId;
		this.customerName = customerName;
		this.enquiryFor = enquiryFor;
		this.emailAddress = emailAddress;
		this.mobileNumber = mobileNumber;
		this.message = message;
		this.file = file;
		this.submitedOn = submitedOn;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [requestId=" + requestId + ", customerName=" + customerName + ", enquiryFor=" + enquiryFor
				+ ", emailAddress=" + emailAddress + ", mobileNumber=" + mobileNumber + ", message=" + message
				+ ", file=" + Arrays.toString(file) + ", submitedOn=" + submitedOn + "]";
	}

}
