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

public class InsertBasketAction  implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		FruitDAO fruitDAO = new FruitDAO();
		BasketDTO basket = new BasketDTO();
		int count = Integer.parseInt(request.getParameter("count"));
		int price = Integer.parseInt(request.getParameter("price"));
		//System.out.println(count);
		//System.out.println(price);
		int total = price * count;
		basket.setShop_id(request.getParameter("id"));
		basket.setShop_num(Integer.parseInt(request.getParameter("num")));
		basket.setShop_amount(Integer.parseInt(request.getParameter("count")));
		basket.setShop_price(Integer.parseInt(request.getParameter("price")));
		basket.setShop_total_price(total);
		
		boolean result = fruitDAO.insertBasket(basket);
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
