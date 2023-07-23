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


public class ProductUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ProdDTO prod = new ProdDTO();
		prod.setProd_name(request.getParameter("prod_name"));
		prod.setProd_price(Integer.parseInt(request.getParameter("prod_price")));
		prod.setProd_kind(request.getParameter("prod_kind"));
		prod.setProd_description(request.getParameter("prod_description"));
		prod.setProd_num(Integer.parseInt(request.getParameter("prod_num")));
		FruitDAO fruitDAO = new FruitDAO();
		boolean result = fruitDAO.updateProduct(prod);
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
