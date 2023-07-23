package mky20_mvc_fruit.controller.fruit.action;

import mky20_mvc_fruit.model.fruit.*;
import mky20_mvc_fruit.controller.fruit.Action;
import mky20_mvc_fruit.controller.fruit.ActionForward;
import java.util.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InsertMemberAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		FruitDAO fruitDAO = new FruitDAO();
		MemberDTO member = new MemberDTO();
		
		member.setMem_id(request.getParameter("mem_id"));
		member.setMem_pw(request.getParameter("mem_pw"));
		member.setMem_name(request.getParameter("mem_name"));
		member.setMem_address(request.getParameter("mem_address"));
		member.setMem_phone(request.getParameter("mem_phone"));
		
		boolean result = fruitDAO.insertMember(member);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		if(result == true) {
			forward.setPath("/com/yju/2wda/team5/view/fruit/main.jsp");
		} else {
			forward.setPath("/com/yju/2wda/team5/view/fruit/etc/error.jsp");
		}
		return forward;
	}

}
