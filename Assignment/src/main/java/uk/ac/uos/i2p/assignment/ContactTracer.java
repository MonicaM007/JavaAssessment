package uk.ac.uos.i2p.assignment;

import java.util.List;
import java.util.Map;

public interface ContactTracer { // ContactTracer name created for interface
	public void addCourse(String courseID, String courseName);

	public void addStudent(String id, String name, String email);

	public void loadStudentCourseList(Map<String, String> enrolments);

	public String getStudentName(String studentID);

	public String getStudentEmail(String studentID);

	public String getCourseForStudent(String studentID);

	public String getCourseName(String courseID);

	public List<String> findStudentsForCourse(String courseID);

	public List<String> findContacts(String studentID);

}
