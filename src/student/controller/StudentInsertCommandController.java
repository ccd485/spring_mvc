package student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import student.dao.StudentDAO;
import student.dto.StudentDTO;

public class StudentInsertCommandController extends AbstractCommandController {
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0, HttpServletResponse arg1, 
			Object arg2, BindException arg3)	//dto랑 연결시켜 자동으로 setter에 넣어
			throws Exception {
		StudentDTO dto = (StudentDTO)arg2;
		int res = studentDAO.insertStudent(dto);
		//ModelAndView mav = new ModelAndView(); mav.setViewName("nextPage"); mav.addObject("dto", dto);
		//ModelAndView mav = new ModelAndView("nextPage");
		//ModelAndView mav = new ModelAndView("nextPage","dto",dto);
		return new ModelAndView("redirect:student_list.do");
		//redirect : request와 response는 초기화 시키고 이동된다.
		//forward : request와 response유지
	}

}
