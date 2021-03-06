package fr.sparna.rdf.skosplay.log;

/**
 * Cette classe permet de définir les entrées  à insérer dans la base
 * 
 * @author clarvie
 *
 */

public class LogEntry {
	public String name;
	public String output;
	public String  actiondate;
	public String displayType;
	public String langue;
	public String email;
	public String rendu;
	public String url;

	public String uri;
	public Integer iduser;



	public LogEntry(String language, String format, String rendu, String url, String type, String uri) {
		this.langue = language;
		this.output = format;
		this.rendu = rendu;
		this.url = url;
		this.displayType = type;
		this.uri=uri;
	}
	
	public LogEntry() {
		
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRendu() {
		return rendu;
	}

	public void setRendu(String rendu) {
		this.rendu = rendu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getActiondate() {
		return actiondate;
	}
	public void setActiondate(String actiondate) {
		this.actiondate = actiondate;
	}


	public String getType() {
		return displayType;
	}

	public void setType(String display) {
		this.displayType = display;
	}


	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer idconvert) {
		this.iduser = idconvert;
	}
	
	
	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public String getLangue() {
		return langue;
	}
	public void setLangue(String lang) {
		this.langue = lang;
	}




}
