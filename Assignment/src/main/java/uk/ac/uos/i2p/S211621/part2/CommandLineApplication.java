
package uk.ac.uos.i2p.S211621.part2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import uk.ac.uos.i2p.S211621.part1.MemoryContactTracer;
import uk.ac.uos.i2p.assignment.ContactTracer;

public class CommandLineApplication {

	static String datePattern = "yyyy-MM-dd";
	static String timePattern = "HH:mm:ss";

	static SimpleDateFormat simpleDateFormatDatePattern = new SimpleDateFormat(datePattern);
	static SimpleDateFormat simpleDateFormatTimePattern = new SimpleDateFormat(timePattern);

	public static void main(String[] args) throws Exception {

		// checkArguments(args);
		if (args.length < 4) {
			System.out.println("results:");
			System.exit(0);
		}

		String studentId = args[0];
		String testResults = args[1];
		String testResultsCSVFileName = args[2];
		String contactsCSVFileName = args[3];

//		args = S101 Positive, tests.csv results.csv 
		ContactTracer tracer = loadDataForEnrollment();

		createCSVFileForTestResults(testResultsCSVFileName, tracer, studentId, testResults);

		// if (testResults.equalsIgnoreCase("Positive")) {
		List<String> studentsIdsInContact = tracer.findContacts(studentId);
		createCSVFileForContacts(contactsCSVFileName, tracer, testResults, studentsIdsInContact);
		// }
		// output

	}

	private static ContactTracer loadDataForEnrollment() {
		ContactTracer tracer = new MemoryContactTracer();

		tracer.addCourse("SOFT01", "Software Engineering");
		tracer.addCourse("NET02", "Network Engineering");
		tracer.addCourse("CYB03", "Cyber Security");

		tracer.addStudent("S101", "Clint Eastwood", "abc@uos.ac.uk");
		tracer.addStudent("S102", "Jamie Foxx", "xyz@uos.ac.uk");
		tracer.addStudent("S103", "Olivia Wilde", "klm@uos.ac.uk");

		Map<String, String> enrolments = new HashMap<>();
		enrolments.put("S101", "SOFT01");
		enrolments.put("S102", "NET02");
		enrolments.put("S103", "SOFT01");
		tracer.loadStudentCourseList(enrolments);
		return tracer;
	}

	private static void createCSVFileForTestResults(String testResultsCSVFileName, ContactTracer tracer,
			String studentId, String testResults) throws FileNotFoundException {
		String testResultString = tracer.getStudentName(studentId) + ", " + studentId + ", " + testResults + " , "
				+ simpleDateFormatDatePattern.format(new Date()) + " , "
				+ simpleDateFormatTimePattern.format(new Date());

		File csvOutputFile = new File(testResultsCSVFileName);
		try (PrintWriter pw = new PrintWriter(csvOutputFile)) {

			pw.print(testResultString);
		}

	}

	public boolean accept(File dir, String name) {
		String extension = null;
		return name.endsWith(extension);

	}

//The try-with-resources statement is a try statement that declares one or more resources
	// how many declarations are there?

	private static void createCSVFileForContacts(String contactsCSVFileName, ContactTracer tracer, String testResults,
			List<String> studentsIdsInContact) throws FileNotFoundException {
		List<String> contacts = new ArrayList<>();

		for (int i = 0; i < studentsIdsInContact.size(); i++) {
			String contact = tracer.getStudentName(studentsIdsInContact.get(0)) + " ," + studentsIdsInContact.get(0)
					+ " , " + testResults + " , " + simpleDateFormatDatePattern.format(new Date()) + " , "
					+ simpleDateFormatTimePattern.format(new Date());

			contacts.add(contact);
		}

		File csvOutputFile = new File(contactsCSVFileName);
		try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
			contacts.stream().forEach(pw::println);
		}

		System.out.println("Test Results output has been created in contacts.csv");
	}

}

// https://www.baeldung.com/java-csv tutorial on csv file which I used for help
