package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import uk.ac.uos.i2p.S211621.part1.MemoryContactTracer;
import uk.ac.uos.i2p.assignment.ContactTracer;

class ContactTracerTest { // ContactTracerTest class name for testing

	@Test
	void testAddCourse() {
		ContactTracer ct = new MemoryContactTracer();
		ct.addCourse("Soft01", "Software Engineering");
		assertEquals("Software Engineering", ct.getCourseName("Soft01"));

	}

	@Test
	void testAddStudent() {
		ContactTracer ct = new MemoryContactTracer();
		ct.addStudent("S101", "Clint Eastwood", "abc@uos.ac.uk");
		assertEquals("Clint Eastwood", ct.getStudentName("S101"));
		assertEquals("abc@uos.ac.uk", ct.getStudentEmail("S101"));

	}

	@Test
	void loadStudentCourseList() {
		ContactTracer ct = new MemoryContactTracer();
		Map<String, String> enrolments = new HashMap<>();
		enrolments.put("S101", "SOFT01");
		enrolments.put("S102", "NET02");
		enrolments.put("S103", "SOFT01");
		ct.loadStudentCourseList(enrolments);
		
		
		List<String> students = ct.findStudentsForCourse("SOFT01");
		assertEquals(2, students.size());
		assertTrue(students.contains("S101"));
		assertTrue(students.contains("S103"));

	}
	
	@Test
	void testloadStudentCourseListAfterAddingMultipleEnrollments() {
		ContactTracer ct = new MemoryContactTracer();
		Map<String, String> enrolments = new HashMap<>();
		enrolments.put("S101", "SOFT01");
		enrolments.put("S102", "NET02");
		
		ct.loadStudentCourseList(enrolments);
		
		Map<String, String> enrolments2 = new HashMap<>();
		enrolments2.put("S103", "SOFT01");
		ct.loadStudentCourseList(enrolments2);
		
		
		List<String> students = ct.findStudentsForCourse("NET02");
		assertEquals(1, students.size());
		assertTrue(students.contains("S102"));
		

	}

	@Test
	void findContacts() {
		ContactTracer ct = new MemoryContactTracer();
		ct.addCourse("SOFT01", "Software Engineering");
		ct.addCourse("NET02", "Network Engineering");
		ct.addCourse("CYB03", "Cyber Security"); //
		ct.addStudent("S101", "Clint Eastwood", "abc@uos.ac.uk");
		ct.addStudent("S102", "Jamie Foxx", "xyz@uos.ac.uk");
		ct.addStudent("S103", "Olivia Wilde", "klm@uos.ac.uk");
		Map<String, String> enrolments = new HashMap<>();
		enrolments.put("S101", "SOFT01");
		enrolments.put("S102", "NET02");
		enrolments.put("S103", "SOFT01");
		ct.loadStudentCourseList(enrolments);
		List<String> contacts = ct.findContacts("S101");
		assertEquals(1, contacts.size());
		assertTrue(contacts.contains("S103"));

		System.out.println(enrolments);
	}
}
