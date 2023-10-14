package Com.Hibernate.OneToMany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import Com.Hibernate.OneToMany.HibernateUtil;
import Com.Hibernate.OneToMany.model.Student;


import Com.Hibernate.OneToMany.model.Teachers;

/**
 * Author: Gajam_upendar
 * Concept: Relationship between one teacher and many students.
 */
public class App {
    public static void main(String[] args) {
     
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            
            session.beginTransaction();

          
            Teachers newTeacher = new Teachers();
            Student newStudent = new Student();
            Student newStudent1 = new Student();

            newTeacher.setName("Anirudh");

            newTeacher.getStudents().add(newStudent);

            newStudent.setName("Upendar");
            newStudent.setTeacher(newTeacher);
            
            newStudent1.setName("Uppi");
            newStudent1.setTeacher(newTeacher);

            
            session.save(newTeacher);
            session.save(newStudent);
            session.save(newStudent1);

            session.getTransaction().commit();

            session.clear();

            Student retrievedStudent = session.get(Student.class, newStudent.getStudentId());
            Teachers retrievedTeacher = session.get(Teachers.class, newTeacher.getTeacherId());
            List<Student> retrievedStudents = retrievedTeacher.getStudents();

            for (Student student : retrievedStudents) {
                System.out.println("Student: " + student.getName());
                System.out.println("Student's Teacher: " + student.getTeacher().getName());
            }

            
            
            System.out.println("Retrieved Student: " + retrievedStudent.getName());
            System.out.println("Student's Teacher: " + retrievedStudent.getTeacher().getName());
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
