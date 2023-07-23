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

public class CupFruitListDisplayAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String keyword = request.getParameter("keyword");
		if(keyword == null) keyword = "NOT";
		String currentPageNo = request.getParameter("currentPageNo");
		int cpn = (currentPageNo == null) ? 0 : Integer.parseInt(currentPageNo);
		//System.out.println(keyword);
		
		HttpSession session = request.getSession();
		FruitPageInfoVO fpiVO = (FruitPageInfoVO)session.getAttribute("fruitPageInfoVO");
		
		FruitDAO fruitDAO = new FruitDAO();
		ArrayList<ProdDTO> fruitList;
		
		fpiVO.setCurrentPageNo(cpn);
		fpiVO.adjPageInfo();
		
		fruitList = fruitDAO.getCupFruitList(fpiVO, keyword);
		request.setAttribute("fruitList", fruitList);
		request.setAttribute("keyword", keyword);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team5/view/fruit/cupFruitList.jsp");
		return forward;
	}

}
