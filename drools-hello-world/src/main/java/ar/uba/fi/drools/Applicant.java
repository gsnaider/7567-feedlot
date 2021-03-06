package ar.uba.fi.drools;

public class Applicant {
	
	private String name;
	private int age;
	private boolean valid;
	private boolean validName;

	public Applicant(String name, int age) {
		this.name = name;
		this.age = age;
		valid = true;
		validName = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	public void setValidName(boolean valid) {
		this.validName = valid;
	}
	
	public boolean isValidName() {
		return validName;
	}

}
