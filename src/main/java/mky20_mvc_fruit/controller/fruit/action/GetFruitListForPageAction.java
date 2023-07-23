package mky20_mvc_fruit.controller.fruit.action;

import mky20_mvc_fruit.model.fruit.*;
import mky20_mvc_fruit.controller.fruit.Action;
import mky20_mvc_fruit.controller.fruit.ActionForward;
import java.util.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetFruitListForPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String currentPageNo = request.getParameter("currnetPageNo");
		int cpn = (currentPageNo == null) ? 0 : Integer.parseInt(currentPageNo);
		
		HttpSession session = request.getSession();
		FruitPageInfoVO fpiVO = (FruitPageInfoVO)session.getAttribute("fruitPageInfoVO");
		
		FruitDAO fruitDAO = new FruitDAO();
		
		fpiVO.setCurrentPageNo(cpn);
		fpiVO.adjPageInfo();
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team5/view/fruit/main.jsp");
		return forward;
	}

}
