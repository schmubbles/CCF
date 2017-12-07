package objectLayer;

import java.sql.Date;

public class Tournament {
	private int id = 0;
	private String EmbedCode;
	private Date date;
	
	public Tournament(int id, String EmbedCode, Date date) {
		this.id = id;
		this.EmbedCode = EmbedCode;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmbedCode() {
		return EmbedCode;
	}

	public void setEmbedCode(String embedCode) {
		EmbedCode = embedCode;
	}
	
	
}
