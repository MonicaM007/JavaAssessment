package uk.ac.uos.i2p.S211621.part1;

public class Student {
	
	private String studentId;
	private String name;
	private String emailId;
	
	public Student(String studentId, String name, String emailId) {
		super();//parent class constructor
		this.studentId = studentId;
		this.name = name;
		this.emailId = emailId;
	}
	

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	public String getStudentDeatils() {
		
		String line1 = "**Student Info**";
		String line2 = this.studentId + " " + this.name + ("+ this.emailId");
		return line1 + "\n" + line2  + "\n";
				
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", emailId=" + emailId + "]";
	}
	
	
	

}
