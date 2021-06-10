package member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberUpdateController implements Controller{
	private MemberDAO memberDAO;
	
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		MemberDTO dto = memberDAO.getMember(Integer.parseInt(req.getParameter("no")));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/member_update");
		mav.addObject("getMember", dto);
		return mav;
	}

}
