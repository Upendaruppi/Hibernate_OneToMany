package Com.Hibernate.OneToMany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Com.Hibernate.OneToMany.model.Teachers;

@Entity
@Table(name = "student")

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "student_id")
     private int studentId;
	
	@Column(name = "name")
    private String name;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id")
    private Teachers Teacher;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teachers getTeacher() {
		return Teacher;
	}

	public void setTeacher(Teachers teacher) {
		Teacher = teacher;
	}

}
