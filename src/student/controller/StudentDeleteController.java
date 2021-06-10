package student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import student.dao.StudentDAO;
import student.dto.StudentDTO;

public class StudentDeleteController implements Controller{
	private StudentDAO studentDAO;
	
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int res = studentDAO.deleteStudent(req.getParameter("id"));
		
		return new ModelAndView("redirect:student_list.do");
	}

}
