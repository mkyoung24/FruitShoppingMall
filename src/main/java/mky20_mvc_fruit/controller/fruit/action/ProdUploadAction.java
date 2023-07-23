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

import java.util.Enumeration;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;

public class ProdUploadAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String imgDirPath = "D:\\Dev\\WorkSpace\\mky20_mvc_shoppingMall\\src\\main\\webapp\\com\\yju\\2wda\\team5\\Image"; 
		int maxSize = 1024 * 1024* 5;
		
		MultipartRequest multi = new MultipartRequest(request, imgDirPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		Enumeration<?> files = multi.getFileNames();
		FruitDAO fruitDAO = new FruitDAO();
		ProdDTO prod = new ProdDTO();
		
		prod.setProd_name(multi.getParameter("prod_name"));
		prod.setProd_price(Integer.parseInt(multi.getParameter("prod_price")));
		prod.setProd_kind(multi.getParameter("prod_kind"));
		prod.setProd_description(multi.getParameter("prod_description"));
		
		String element = "";
		String filesystemName = "";
		if(files.hasMoreElements()) {
			element = (String)files.nextElement();
			filesystemName = multi.getFilesystemName(element);;
		}
		
		prod.setProd_image(filesystemName);
		prod.setProd_sm_image("sm_"+filesystemName);
		
		File saveFile = new File(imgDirPath, filesystemName);
		
		File thumbnailName = new File(imgDirPath,"sm_" + filesystemName);
		
		BufferedImage bo_image = ImageIO.read(saveFile);
		
		double ratio = 3;
		int width = (int)(bo_image.getWidth() / ratio);
		int height = (int)(bo_image.getHeight() / ratio);
		BufferedImage bt_image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		
		Graphics2D graphic = bt_image.createGraphics();
		graphic.drawImage(bo_image, 0, 0, width, height, null);
		
		ImageIO.write(bt_image, "png", thumbnailName);
		
		boolean result = fruitDAO.insertProduct(prod);
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
