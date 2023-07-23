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

public class DeleteBasketForIDAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		int num = Integer.parseInt(request.getParameter("num"));
		
		FruitDAO fruitDAO = new FruitDAO();
		boolean result = fruitDAO.deleteBasketList(id, num);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		if(result == true) {
			forward.setPath("/com/yju/2wda/team5/view/fruit/main.jsp");
		} else {
			forward.setPath("/com/yju/2wda/team5/view/etc/error.jsp");
		}
		return forward;
	}

}
