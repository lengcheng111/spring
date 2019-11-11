import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.ClassDAOHibernate;
import com.dao.StudentDAOHibernate;
import com.model.ClassDTO;
import com.model.Student;

public class StudentManagement {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context.xml");
		StudentDAOHibernate studentDAO = context.getBean("studentDAOHibernate", StudentDAOHibernate.class);
		//createClass(studentDAO);

		createStudent(studentDAO, 1);

	}

	private static void createClass(StudentDAOHibernate studentDAO) {
		ClassDAOHibernate classDAO = context.getBean("classDAOHibernate", ClassDAOHibernate.class);
		ClassDTO classDTO = new ClassDTO();
		classDTO.setName("PT01");
		classDTO.setNote("note 1");
		Set<Student> students = new HashSet<Student>();
		students.addAll(studentDAO.findAll());
		classDTO.setStudents(students);

		classDAO.save(classDTO);
	}

	private static void createStudent(StudentDAOHibernate studentDAO, int classId) {
		Student student = new Student("first name", "last name");
		student.setClassId(classId);
		studentDAO.save(student);
	}
}
