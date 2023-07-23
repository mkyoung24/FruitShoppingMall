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

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FruitDAO fruitDAO = new FruitDAO();
		String id = request.getParameter("mem_id");
		String pw = request.getParameter("mem_pw");
		MemberDTO member;
		
		member = fruitDAO.login(id, pw);
		HttpSession session = request.getSession();
		
		if(id.equals(member.getMem_id())){
    		if(pw.equals(member.getMem_pw())){	    				    		
    			session.setAttribute("loginState", "login");
    			session.setAttribute("userID", id);
    			session.setAttribute("userPW", pw);
    			session.setAttribute("class", member.getMem_class());
    		}else{
    			session.setAttribute("loginState", "errorPW");
    		}
		} else {
    		session.setAttribute("loginState", "errorID");
    	}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team5/view/fruit/main.jsp");
		return forward;
	}
}
