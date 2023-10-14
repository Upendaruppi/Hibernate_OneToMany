package Com.Hibernate.OneToMany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teachers {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "teacher_id")
     private int teacherId;
	

	@Column(name = "name")
    private String name;
	
	@OneToMany(mappedBy = "Teacher", cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<>();

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(Student newStudent) {
		this.students.add(newStudent);
	}
	
	
	
}
