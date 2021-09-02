package com.example.loanService_r2dbc.model;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;


public class Loan {
	
		@Id
		private long loanId;
		private String loanType;
		private double amount;
		private LocalDate startDate;
		private double rate;
		private double duration;
		private long customerId;
		
		public Loan() {
			
		}

		

		public Loan(long loanId, String loanType, double amount, LocalDate startDate, double rate, double duration,
				long customerId) {
			super();
			this.loanId = loanId;
			this.loanType = loanType;
			this.amount = amount;
			this.startDate = startDate;
			this.rate = rate;
			this.duration = duration;
			this.customerId = customerId;
		}



		public Loan( String loanType, double amount, LocalDate startDate, double rate, double duration
	) {
			super();
			
			this.loanType = loanType;
			this.amount = amount;
			this.startDate = startDate;
			this.rate = rate;
			this.duration = duration;
			
		}

		public long getLoanId() {
			return loanId;
		}



		public void setLoanId(long loanId) {
			this.loanId = loanId;
		}



		public String getLoanType() {
			return loanType;
		}

		public void setLoanType(String loanType) {
			this.loanType = loanType;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

	

		public double getDuration() {
			return duration;
		}

		public void setDuration(double duration) {
			this.duration = duration;
		}

		public long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}



		public LocalDate getStartDate() {
			return startDate;
		}



		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}



		public double getRate() {
			return rate;
		}



		public void setRate(double rate) {
			this.rate = rate;
		}




}
