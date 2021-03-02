package com.techmojo.assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {

	private String transactionId;
	private String transactionDate;
	private LocalDate txDate;
	private String transactionTime;
	private LocalTime txTime;
	private String transactionType;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		LocalDate parse = LocalDate.parse(transactionDate.replaceAll("\\s+",""));
		setTxDate(parse);
		this.transactionDate = transactionDate;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
		String display = format.format(parseFormat.parse(transactionTime));
		setTxTime(LocalTime.parse(display));
		
		this.transactionTime = display;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTxDate() {
		return txDate;
	}

	public void setTxDate(LocalDate txDate) {
		this.txDate = txDate;
	}

	public LocalTime getTxTime() {
		return txTime;
	}

	public void setTxTime(LocalTime txTime) {
		this.txTime = txTime;
	}

	

}
