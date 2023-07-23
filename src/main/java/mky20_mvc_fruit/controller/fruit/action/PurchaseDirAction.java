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

public class PurchaseDirAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		FruitDAO fruitDAO = new FruitDAO();
		PurchaseDTO pr = new PurchaseDTO();
		int count = Integer.parseInt(request.getParameter("count"));
		int price = Integer.parseInt(request.getParameter("price"));
		int sum = price * count;
		pr.setPurchase_num(Integer.parseInt(request.getParameter("num")));
		pr.setPurchase_id(request.getParameter("id"));
		pr.setPurchase_count(Integer.parseInt(request.getParameter("count")));
		pr.setPurchase_price(Integer.parseInt(request.getParameter("price")));
		
		
		boolean result = fruitDAO.insertPurchaseDir(pr);
		request.setAttribute("sum", sum);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		if(result == true) {
			forward.setPath("/com/yju/2wda/team5/view/fruit/purchase.jsp");
		} else {
			forward.setPath("/com/yju/2wda/team5/view/etc/error.jsp");
		}
		return forward;
	}

}
