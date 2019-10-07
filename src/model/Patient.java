package model;

public class Patient {
	   private int patientID;
	   private String parent_fullname;
	   private String child_fullname;
	   private String email;
	   private String phone;
	   private String address;
	   private String weight;
	   private String height;
	   private String vaccinations;
	   
	   public Patient(){}
	   	
	public Patient(String pParent_fullname, String pChild_fullname, String pEmail, String pPhone, String pAddress, String pWeight, String pHeight, String pVaccinations){
		parent_fullname = pParent_fullname;
		child_fullname = pChild_fullname;
		email = pEmail;
		phone = pPhone;
		address = pAddress;
		weight = pWeight;
		height = pHeight;
		vaccinations = pVaccinations;
	}
	
	public Patient(int pPatientID, String pParent_fullname, String pChild_fullname, String pEmail, String pPhone, String pAddress, String pWeight, String pHeight, String pVaccinations){
		patientID = pPatientID;
		parent_fullname = pParent_fullname;
		child_fullname = pChild_fullname;
		email = pEmail;
		phone = pPhone;
		address = pAddress;
		weight = pWeight;
		height = pHeight;
		vaccinations = pVaccinations;
	}
	
	
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	
	public String getParent_fullname() {
		return parent_fullname;
	}
	public void setParent_fullname(String parent_fullname) {
		this.parent_fullname = parent_fullname;
	}
	
	public String getChild_fullname() {
		return child_fullname;
	}
	public void setChild_fullname(String child_fullname) {
		this.child_fullname = child_fullname;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(String vaccinations) {
		this.vaccinations = vaccinations;
	}


}
