package com.customerportalservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Raise {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer ticketNumber;
	    private String summary;
	    private String status;
	    private String date;
	    private String type;
	    private String customername;
		public Integer getTicketNumber() {
			return ticketNumber;
		}
		public void setTicketNumber(Integer ticketNumber) {
			this.ticketNumber = ticketNumber;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getCustomername() {
			return customername;
		}
		public void setCustomername(String customername) {
			this.customername = customername;
		}
	    
	    
}