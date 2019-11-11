import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDAOHibernate;
import com.model.Student;

public class StudentManagement {
	public static void main(String[] args) {
		final ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		// final StudentDAO bean = context.getBean("studentDAO", StudentDAO.class);
		StudentDAOHibernate bean = context.getBean("studentDAOHibernate", StudentDAOHibernate.class);
		Student student = new Student(2, "abc", "agagaG");
		bean.save(student);
	}
}
