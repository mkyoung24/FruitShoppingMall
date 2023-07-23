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

public class ProdListDisplayAction  implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int prod_num = Integer.parseInt(request.getParameter("prod_num"));
		
		FruitDAO fruitDAO = new FruitDAO();
		ProdDTO prod = new ProdDTO();
		prod = fruitDAO.getProdList(prod_num);
		
		request.setAttribute("prod", prod);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team5/view/fruit/product.jsp");
		return forward;
	}
	
}
