package student.dao;

import java.util.List;

import student.dto.StudentDTO;

public interface StudentDAO {
	public List<StudentDTO> listStudent();
	public List<StudentDTO> findStudent(String name);
	public int insertStudent(StudentDTO dto);
	public int deleteStudent(String id);
	
}
