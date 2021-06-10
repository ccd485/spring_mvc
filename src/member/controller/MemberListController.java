package member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberListController implements Controller{
	private MemberDAO memberDAO;
	
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String mode = req.getParameter("mode");
		String search = null, searchString = null;
		if (mode != null) {
			search = req.getParameter("search");
			searchString = req.getParameter("searchString");
		}
		List<MemberDTO> list = null;
		if (mode == null) {
			list = memberDAO.listMember();
		}else {
			list = memberDAO.findMember(search, searchString);
		}
		return new ModelAndView("member/memberAll", "listMember", list);
	}

}
