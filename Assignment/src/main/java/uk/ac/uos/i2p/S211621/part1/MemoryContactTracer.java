package uk.ac.uos.i2p.S211621.part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.ac.uos.i2p.assignment.ContactTracer;

public class MemoryContactTracer implements ContactTracer {

	private Map<String, Course> courses = new HashMap<>(); // Collection of Map object is used to obtain a list which
															// maps keys to each values
	private Map<String, Student> students = new HashMap<>();

	private Map<String, String> enrolments = new HashMap<>();

	@Override
	public void addCourse(String courseID, String courseName) { // The 'put' method is used add students, courses and
		courses.put(courseID, new Course(courseID, courseName));// enrolments information into the contactTracer Object

	}

	@Override
	public void addStudent(String id, String name, String email) {
		students.put(id, new Student(id, name, email));

	}

	@Override
	public void loadStudentCourseList(Map<String, String> studentEnrolments) {
		if (this.enrolments.isEmpty()) {
			this.enrolments = studentEnrolments;
		} else {
			for (Map.Entry<String, String> entry : studentEnrolments.entrySet())
				this.enrolments.put(entry.getKey(), entry.getValue());
		}

	}

	@Override
	public String getStudentName(String studentID) { // The 'get' method is used to get things of out from the -

		return students.get(studentID).getName(); // contactTracer - students, courses and enrolments information

	}

	@Override
	public String getStudentEmail(String studentID) {
		return students.get(studentID).getEmailId();
	}

	@Override
	public String getCourseForStudent(String studentID) {
		return enrolments.get(studentID);

	}

	@Override
	public String getCourseName(String courseID) {
		return courses.get(courseID).getCourseName();

	}

	@Override
	public List<String> findStudentsForCourse(String courseID) {
		List<String> studentsInCourse = new ArrayList<>(); // ArrayList applied with keySet to obtain values of the
															// enrolments
		for (String key : enrolments.keySet()) {
			if (enrolments.get(key) == courseID) {
				studentsInCourse.add(key);

			}
		}
		return studentsInCourse;
	}

	@Override
	public List<String> findContacts(String studentID) {

		String courseId = getCourseForStudent(studentID);
		List<String> studentsEnrolledInCourse = findStudentsForCourse(courseId);
		studentsEnrolledInCourse.remove(studentID);
		return studentsEnrolledInCourse;

	}
}
