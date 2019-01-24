package com.capco.HROPS.model;

import org.springframework.stereotype.Component;

@Component
public class Mail {
	 private String reicever;
	    
	    private String subject;
	    
	    private String body;
	    private String setFrom;

		public String getReicever() {
			return reicever;
		}

		public void setReicever(String reicever) {
			this.reicever = reicever;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		public String getSetFrom() {
			return setFrom;
		}

		public void setSetFrom(String setFrom) {
			this.setFrom = setFrom;
		}
	        

}
