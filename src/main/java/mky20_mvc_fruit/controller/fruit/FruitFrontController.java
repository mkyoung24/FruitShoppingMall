package mky20_mvc_fruit.controller.fruit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mky20_mvc_fruit.model.fruit.*;
import mky20_mvc_fruit.controller.fruit.*;
import mky20_mvc_fruit.controller.fruit.action.*;

public class FruitFrontController extends HttpServlet implements Servlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		command = command.substring(command.lastIndexOf("/"));
		
		FruitPageInfoVO bpiVO;
		HttpSession session = request.getSession();
		
		if(session.getAttribute("fruitPageInfoVO") == null) {
			bpiVO = new FruitPageInfoVO();
			session.setAttribute("fruitPageInfoVO", bpiVO);
		} else {
			bpiVO = (FruitPageInfoVO)session.getAttribute("fruitPageInfoVO");
		}
		
		ActionForward forward = null;
		Action action = null;
		
		//System.out.println("command = " + command);
		
		switch(command) {
			case "/login.be":
				action = new LoginAction();
				break;
			case "/insertMember.be":
				action = new InsertMemberAction();
				break;
			case "/logout.be":
				action = new LogOutAction();
				break;
			case "/getMember.be":
				action = new GetMemberAction();
				break;
			case "/getMemberListDisplay.be":
				action = new GetMemberListDisplayAction();
				break;
			case "/updateMember.be":
				action = new UpdateMemberAction();
				break;
			case "/deleteMember.be":
				action = new DeleteMemberAction();
				break;
			case "/memberClassUpdate.be":
				action = new MemberClassUpdateAction();
				break;
			case "/prodUpload.be":
				action = new ProdUploadAction();
				break;
			case "/cupFruitList.be":
				action = new CupFruitListDisplayAction();
				break;
			case "/fruitBoxList.be":
				action = new FruitBoxListDisplayAction();
				break;
			case "/prodList.be":
				action = new ProdListDisplayAction();
				break;
			case "/insertBasket.be":
				action = new InsertBasketAction();
				break;
			case "/basketListDisplay.be":
				action = new BasketListDisplayAction();
				break;
			case "/deleteBasketForID.be":
				action = new DeleteBasketForIDAction();
				break;
			case "/deleteBasketList.be":
				action = new DeleteBasketListAction();
				break;
			case "/purchase.be":
				action = new InsertPurchaseAction();
				break;
			case "/purchaseComplete.be":
				action = new PurchaseCompleteAction();
				break;
			case "/purchaseListDisplay.be":
				action = new PurchaseListDisplayAction();
				break;
			case "/productListDisplay.be":
				action = new ProductListDisplayAction();
				break;
			case "/productGetList.be":
				action = new ProductGetListAction();
				break;
			case "/prodUpdate.be":
				action = new ProductUpdateAction();
				break;
			case "/productDelete.be":
				action = new ProductDeleteAction();
				break;
			case "/idCheck.be":
				action = new IdCheckAction();
				break;
			case "/purchaseDir.be":
				action = new PurchaseDirAction();
				break;
		}
		
		try {
			forward = action.execute(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doProcess(request, response);
	}
}

