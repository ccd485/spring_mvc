package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;

public class MemberCheckController implements Controller{
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String name = req.getParameter("name");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		
		String url=null;
		boolean isMember = memberDAO.checkMember(name, ssn1, ssn2);
		if (isMember) {
			url = "member/index";
		}else {
			url = "member/memberSign";
			HttpSession session = req.getSession();	//message.jsp 들렸다 가면 session쓰지만 아니면 걍 req에담아도됨
			session.setAttribute("name", name);
			session.setAttribute("ssn1", ssn1);
			session.setAttribute("ssn2", ssn2);
		}
		return new ModelAndView(url);
	}

}
