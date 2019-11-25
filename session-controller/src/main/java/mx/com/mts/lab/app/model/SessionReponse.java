package mx.com.mts.lab.app.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class SessionReponse {
	
	@NotNull
	private String name;
	private Date date;
	private String session;
	
	public SessionReponse() {
		
	}
	

	public SessionReponse(String name, Date date, String session) {
		super();
		this.name = name;
		this.date = date;
		this.session = session;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
	
	
	

}
