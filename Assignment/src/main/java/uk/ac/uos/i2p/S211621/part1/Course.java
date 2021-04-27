package uk.ac.uos.i2p.S211621.part1;

public class Course {

	private String courseId;
	private String courseName;

	public Course(String courseId, String courseName) {
		super();// parent class constructor
		this.courseId = courseId;
		this.courseName = courseName;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
