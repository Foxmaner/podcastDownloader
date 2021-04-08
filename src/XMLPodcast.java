
public class XMLPodcast {
	String title;
	String description;
	String programUrl;
	
	public XMLPodcast(String title, String description, String programUrl) {
		super();
		this.title = title;
		this.description = description;
		this.programUrl = programUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProgramUrl() {
		return programUrl;
	}

	public void setProgramUrl(String programUrl) {
		this.programUrl = programUrl;
	}

	@Override
	public String toString() {
		return "XMLPodcast [title=" + title + ", description=" + description + ", programUrl=" + programUrl + "]";
	}
	
	
	
}
