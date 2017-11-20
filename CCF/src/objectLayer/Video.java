package objectLayer;

public class Video {
	private int id = 0;
	private String embedURL = null;
	
	public Video(int id, String embedURL) {
		this.id = id;
		this.embedURL = embedURL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmbedURL() {
		return embedURL;
	}

	public void setEmbedURL(String embedURL) {
		this.embedURL = embedURL;
	}
}
