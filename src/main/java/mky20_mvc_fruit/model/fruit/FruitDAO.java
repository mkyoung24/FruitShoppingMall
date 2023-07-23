package mky20_mvc_fruit.model.fruit;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.sql.*;
import javax.naming.*;
import mky20_mvc_fruit.model.fruit.MemberDTO;
import mky20_mvc_fruit.model.fruit.ProdDTO;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FruitDAO {
	private PreparedStatement pstmt = null;
	private Connection con = null;
	
	Context init = null;
	DataSource ds = null;
	
	ResultSet rs = null;
	
	public FruitDAO() {
		super();
		dbConnect();
	}
	
	public void dbConnect() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc_mariadb");
			con = ds.getConnection();
			//System.out.println("DB연결 성공!!!");
		}catch(Exception e) {
			//System.out.println("DB연결 실패!!!");
			e.printStackTrace();
		}
	}
	
	public void disConnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public MemberDTO login(String id, String pw) {				//로그인
		MemberDTO member = new MemberDTO();
		String sql = "select mem_id, mem_pw, mem_class from member where mem_id = ?";	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				member.setMem_id(rs.getString("mem_id"));
				member.setMem_pw(rs.getString("mem_pw"));
				member.setMem_class(rs.getInt("mem_class"));
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return member;
	}
	
	public boolean insertMember(MemberDTO member) {		//회원가입
		boolean success = false;
		
		String SQL = "select max(mem_num)+1 as num from member";
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			member.setMem_num(rs.getInt("num"));
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "insert into member(mem_id,mem_pw,mem_name,mem_num,mem_address,mem_phone) ";
		   sql += "values(?, ?, ?, ?, ?, ?)";
		   try {
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, member.getMem_id());
			   pstmt.setString(2, member.getMem_pw());
			   pstmt.setString(3, member.getMem_name());
			   pstmt.setInt(4, member.getMem_num());
			   pstmt.setString(5, member.getMem_address());
			   pstmt.setString(6, member.getMem_phone());
			   pstmt.executeUpdate();
			   success = true;
		   } catch (SQLException e) {
			   e.printStackTrace();
			   return success;
		   } finally {
			   disConnect();
		   }
		   return success;
		
	}
	
	public MemberDTO getMember(String id) {			//로그인한 회원정보 불러오기
		String SQL = "select * from member where mem_id = ?";
		MemberDTO member = new MemberDTO();
		
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			member.setMem_id(rs.getString("mem_id"));
			member.setMem_pw(rs.getString("mem_pw"));
			member.setMem_name(rs.getString("mem_name"));
			member.setMem_num(rs.getInt("mem_num"));
			member.setMem_phone(rs.getString("mem_phone"));
			member.setMem_address(rs.getString("mem_address"));
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return member;
	}
	
	public ArrayList<MemberDTO> getMemberList() {			//모든회원정보 열람

		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		String SQL = "select * from member";
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setMem_id(rs.getString("mem_id"));
				member.setMem_pw(rs.getString("mem_pw"));
				member.setMem_name(rs.getString("mem_name"));
				member.setMem_num(rs.getInt("mem_num"));
				member.setMem_address(rs.getString("mem_address"));
				member.setMem_phone(rs.getString("mem_phone"));
				member.setMem_class(rs.getInt("mem_class"));
				list.add(member);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	} 
	
	public boolean updateMember(MemberDTO member) {		//회원정보 수정	
		boolean success = false;
		String sql = "update member set mem_name=?, mem_pw=?, mem_phone=?, mem_address=? where mem_id=?";

		try {
			pstmt = con.prepareStatement(sql);
	    	pstmt.setString(1, member.getMem_name());
	    	pstmt.setString(2, member.getMem_pw());
	    	pstmt.setString(3, member.getMem_phone());
	    	pstmt.setString(4, member.getMem_address());
	    	pstmt.setString(5, member.getMem_id());
	    	int rowUdt = pstmt.executeUpdate();
	    	
	    	if(rowUdt == 1) success = true;
		}catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}
	
	public boolean deleteMember(String id) {			//회원탈퇴	
		boolean success = false;
		String sql1 = "delete from shop where mem_id=?";
		try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql2 = "delete from purchase where mem_id=?";
		try {
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "delete from member where mem_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}
	
	public boolean updateMemberClass(String id, int admin) {	//회원 등급 수정(관리자)
		boolean success = false;
		String sql = "update member set mem_class=? where mem_id=?";
		
		if(admin == 100) {
			try {
				pstmt = con.prepareStatement(sql);
		    	pstmt.setInt(1, 900);
		    	pstmt.setString(2, id);
		    	int rowUdt = pstmt.executeUpdate();
		    	
		    	if(rowUdt == 1) success = true;
			}catch (SQLException e) {
				e.printStackTrace();
				return success;
			} finally {
				disConnect();
			}
			return success;
		} else {
			try {
				pstmt = con.prepareStatement(sql);
		    	pstmt.setInt(1, 100);
		    	pstmt.setString(2, id);
		    	int rowUdt = pstmt.executeUpdate();
		    	
		    	if(rowUdt == 1) success = true;
			}catch (SQLException e) {
				e.printStackTrace();
				return success;
			} finally {
				disConnect();
			}
			return success;
		}
		
	}
	
	public boolean insertProduct(ProdDTO prod) {		//상품등록
		boolean success = false;
		String sql = "insert into prod(prod_name,prod_price,prod_kind,prod_description,prod_image,prod_sm_image) ";
		   sql += "values(?, ?, ?, ?, ?, ?)";
		   try {
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, prod.getProd_name());
			   pstmt.setInt(2, prod.getProd_price());
			   pstmt.setString(3, prod.getProd_kind());
			   pstmt.setString(4, prod.getProd_description());
			   pstmt.setString(5, prod.getProd_image());
			   pstmt.setString(6, prod.getProd_sm_image());
			   pstmt.executeUpdate();
			   success = true;
		   } catch (SQLException e) {
			   e.printStackTrace();
			   return success;
		   } finally {
			   disConnect();
		   }
		   return success;
	}
	
	public ArrayList<ProdDTO> getCupFruitList(FruitPageInfoVO fpiVO, String keyword) {		//컵과일 상품 출력
		ArrayList<ProdDTO> list = new ArrayList<ProdDTO>();
		ProdDTO prod;
		
		if(keyword.equals("NOT")) {
			String SQL = "select prod_num, prod_name, prod_price, prod_sm_image from prod where prod_kind = '컵과일' order by prod_num limit ?, ?";
			String SQL2 = "select count(*) from prod where prod_kind = '컵과일'";
			
			ResultSet rs;
			
			try {
				pstmt = con.prepareStatement(SQL2);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					fpiVO.setRecordCnt(rs.getInt(1));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			fpiVO.adjPageInfo();
			
			try {
				pstmt = con.prepareStatement(SQL);
				pstmt.setInt(1, fpiVO.getStartRecord());
				pstmt.setInt(2, fpiVO.getLimitCnt());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					prod = new ProdDTO();
					prod.setProd_num(rs.getInt("prod_num"));
					prod.setProd_name(rs.getString("prod_name"));
					prod.setProd_price(rs.getInt("prod_price"));
					prod.setProd_sm_image(rs.getString("prod_sm_image"));
					list.add(prod);
				}
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			}
		} else {
			ResultSet rs;
			String SQL1 = "select count(*) from prod where prod_kind = '컵과일' and prod_name like ?";
			try {
				pstmt = con.prepareStatement(SQL1);
				pstmt.setString(1, "%" + keyword + "%");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					fpiVO.setRecordCnt(rs.getInt(1));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			fpiVO.adjPageInfo();
			
			try {
				String sql = "select prod_num, prod_name, prod_price, prod_sm_image from prod where prod_kind = '컵과일' and prod_name like ? order by prod_num limit ?, ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, "%" + keyword + "%");
				pstmt.setInt(2, fpiVO.getStartRecord());
				pstmt.setInt(3, fpiVO.getLimitCnt());
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					prod = new ProdDTO();
					prod.setProd_num(rs.getInt("prod_num"));
					prod.setProd_name(rs.getString("prod_name"));
					prod.setProd_price(rs.getInt("prod_price"));
					prod.setProd_sm_image(rs.getString("prod_sm_image"));
					list.add(prod);
				}
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			}
		}
		return list;
	}
	
	public ArrayList<ProdDTO> getFruitBoxList(FruitPageInfoVO fpiVO, String keyword) {		//과일도시락 상품 출력
		ArrayList<ProdDTO> list = new ArrayList<ProdDTO>();
		ProdDTO prod;
		
		if(keyword.equals("NOT")) {
			String SQL = "select prod_num, prod_name, prod_price, prod_sm_image from prod where prod_kind = '과일도시락' order by prod_num limit ?, ?";
			String SQL2 = "select count(*) from prod where prod_kind = '과일도시락'";
			
			ResultSet rs;
			
			try {
				pstmt = con.prepareStatement(SQL2);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					fpiVO.setRecordCnt(rs.getInt(1));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			fpiVO.adjPageInfo();
			
			try {
				pstmt = con.prepareStatement(SQL);
				pstmt.setInt(1, fpiVO.getStartRecord());
				pstmt.setInt(2, fpiVO.getLimitCnt());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					prod = new ProdDTO();
					prod.setProd_num(rs.getInt("prod_num"));
					prod.setProd_name(rs.getString("prod_name"));
					prod.setProd_price(rs.getInt("prod_price"));
					prod.setProd_sm_image(rs.getString("prod_sm_image"));
					list.add(prod);
				}
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			}
		} else {
			ResultSet rs;
			String SQL1 = "select count(*) from prod where prod_kind = '과일도시락' and prod_name like ?";
			try {
				pstmt = con.prepareStatement(SQL1);
				pstmt.setString(1, "%" + keyword + "%");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					fpiVO.setRecordCnt(rs.getInt(1));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			fpiVO.adjPageInfo();
			
			try {
				String sql = "select prod_num, prod_name, prod_price, prod_sm_image from prod where prod_kind = '과일도시락' and prod_name like ? order by prod_num limit ?, ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, "%" + keyword + "%");
				pstmt.setInt(2, fpiVO.getStartRecord());
				pstmt.setInt(3, fpiVO.getLimitCnt());
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					prod = new ProdDTO();
					prod.setProd_num(rs.getInt("prod_num"));
					prod.setProd_name(rs.getString("prod_name"));
					prod.setProd_price(rs.getInt("prod_price"));
					prod.setProd_sm_image(rs.getString("prod_sm_image"));
					list.add(prod);
				}
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			}
		}
		return list;
	}
	
	public ProdDTO getProdList(int prod_num) {			//상품 상세 보기
		String SQL = "select prod_num, prod_name, prod_price, prod_kind, prod_description, prod_image from prod where prod_num = ?";
		ProdDTO prod = new ProdDTO();
		
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, prod_num);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			prod.setProd_num(rs.getInt("prod_num"));
			prod.setProd_name(rs.getString("prod_name"));
			prod.setProd_price(rs.getInt("prod_price"));
			prod.setProd_kind(rs.getString("prod_kind"));
			prod.setProd_description(rs.getString("prod_description"));
			prod.setProd_image(rs.getString("prod_image"));
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return prod;
	}
	
	public boolean insertBasket(BasketDTO basket) {		//장바구니 담기
		boolean success = false;
		
		String sql2 = "select * from shop where mem_id = ? and prod_num = ?";
		try {
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, basket.getShop_id());
			pstmt.setInt(2, basket.getShop_num());
			ResultSet rs1 = pstmt.executeQuery();
			if(rs1.next()) {
				String sql = "update shop set shop_amount = ?, shop_total_price = ? where mem_id = ? and prod_num = ?";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, basket.getShop_amount());
					pstmt.setInt(2, basket.getShop_total_price());
					pstmt.setString(3, basket.getShop_id());
					pstmt.setInt(4, basket.getShop_num());
					int rowUdt = pstmt.executeUpdate();
					
					if(rowUdt == 1) success = true;
					}catch (SQLException e) {
						e.printStackTrace();
						return success;
					} finally {
						disConnect();
					}
				
				
			} else {
				String SQL = "select prod_name, prod_sm_image from prod where prod_num = ?";
				try {
					pstmt = con.prepareStatement(SQL);
					pstmt.setInt(1, basket.getShop_num());
					ResultSet rs = pstmt.executeQuery();
					rs.next();
					basket.setShop_name(rs.getString("prod_name"));
					basket.setShop_sm_image(rs.getString("prod_sm_image"));
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
				String sql = "insert into shop (prod_num, mem_id ,shop_image,shop_name,shop_price,shop_amount,shop_total_price) ";
				   sql += "values(?, ?, ?, ?, ?, ?,?)";
				   try {
					   pstmt = con.prepareStatement(sql);
					   pstmt.setInt(1, basket.getShop_num());
					   pstmt.setString(2, basket.getShop_id());
					   pstmt.setString(3, basket.getShop_sm_image());
					   pstmt.setString(4, basket.getShop_name());
					   pstmt.setInt(5, basket.getShop_price());
					   pstmt.setInt(6, basket.getShop_amount());
					   pstmt.setInt(7, basket.getShop_total_price());
					   pstmt.executeUpdate();
					   success = true;
				   } catch (SQLException e) {
					   e.printStackTrace();
					   return success;
				   } 
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		
		   
		   return success;
	
	}
	
	public ArrayList<BasketDTO> getBasketList(String id) {			//장바구니 열람

		ArrayList<BasketDTO> list = new ArrayList<BasketDTO>();
		
		String SQL = "select * from shop where mem_id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BasketDTO basket = new BasketDTO();
				basket.setShop_num(rs.getInt("prod_num"));
				basket.setShop_id(rs.getString("mem_id"));
				basket.setShop_sm_image(rs.getString("shop_image"));
				basket.setShop_name(rs.getString("shop_name"));
				basket.setShop_price(rs.getInt("shop_price"));
				basket.setShop_amount(rs.getInt("shop_amount"));
				basket.setShop_total_price(rs.getInt("shop_total_price"));
				list.add(basket);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}
	
	public boolean deleteBasketList(String id, int num) {		//장바구니 선택 삭제
		boolean success = false;
		String sql = "delete from shop where mem_id=? and prod_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}
	
	public boolean deleteBasket(String id) {		//장바구니 전체 삭제
		boolean success = false;
		String sql = "delete from shop where mem_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}
	
	public boolean insertPurchase(String id) {			//결제 등록
		PurchaseDTO purchase;
		ArrayList<PurchaseDTO> list = new ArrayList<PurchaseDTO>();
		String pattern = "YYYY/MM/dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		boolean success = false;
		
		String SQL = "select prod_num, mem_id, shop_image, shop_name, shop_price, shop_amount from shop where mem_id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				purchase = new PurchaseDTO();
				purchase.setPurchase_num(rs.getInt("prod_num"));
				purchase.setPurchase_id(rs.getString("mem_id"));
				purchase.setPurchase_sm_image(rs.getString("shop_image"));
				purchase.setPurchase_name(rs.getString("shop_name"));
				purchase.setPurchase_price(rs.getInt("shop_price"));
				purchase.setPurchase_count(rs.getInt("shop_amount"));
				purchase.setPurchase_date(date);
				list.add(purchase);
			}			
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "insert into purchase (mem_id, prod_num,purchase_sm_image,purchase_name,purchase_price,purchase_count,purchase_date) ";
		   sql += "values(?, ?, ?, ?, ?, ?,(str_to_date(?, '%Y/%m/%d')))";
		   
			   try {
				   pstmt = con.prepareStatement(sql);
				   for(int i=0; i<list.size(); i++) {
					   purchase = list.get(i);
					   pstmt.setString(1, purchase.getPurchase_id());
					   pstmt.setInt(2, purchase.getPurchase_num());
					   pstmt.setString(3, purchase.getPurchase_sm_image());
					   pstmt.setString(4, purchase.getPurchase_name());
					   pstmt.setInt(5, purchase.getPurchase_price());
					   pstmt.setInt(6, purchase.getPurchase_count());
					   pstmt.setString(7, purchase.getPurchase_date());
					   pstmt.executeUpdate();
					   success = true;
				   }
			   } catch (SQLException e) {
				   e.printStackTrace();
				   return success;
			   } finally {
				   disConnect();
			   }
		   
		   return success;
	}
	
	public boolean updateComplete(String id) {		//결제완료
		boolean success = false;
		
		String sql = "update purchase set purchase_state=? where mem_id=?";		
		try {
			pstmt = con.prepareStatement(sql);
	    	pstmt.setString(1, "결제완료");
	    	pstmt.setString(2, id);
	    	int rowUdt = pstmt.executeUpdate();
	    	if(rowUdt != 0) success = true;
		}catch (SQLException e) {
			e.printStackTrace();
			return success;
		} 
		
		String SQL = "delete from shop where mem_id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		
		return success;
	}
	
	public ArrayList<PurchaseDTO> getPurchaseList(String id) {			//구매 내역

		ArrayList<PurchaseDTO> list = new ArrayList<PurchaseDTO>();
		
		String SQL = "select purchase_date, purchase_sm_image, purchase_name, purchase_price, purchase_count, purchase_state from purchase where mem_id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();			
			while(rs.next()) {
				PurchaseDTO purchase = new PurchaseDTO();
				purchase.setPurchase_date(rs.getString("purchase_date"));
				purchase.setPurchase_sm_image(rs.getString("purchase_sm_image"));
				purchase.setPurchase_name(rs.getString("purchase_name"));
				purchase.setPurchase_price(rs.getInt("purchase_price"));
				purchase.setPurchase_count(rs.getInt("purchase_count"));
				purchase.setPurchase_state(rs.getString("purchase_state"));
				list.add(purchase);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	public ArrayList<ProdDTO> getProdList() {		//상품 보기
		ArrayList<ProdDTO> list = new ArrayList<ProdDTO>();
		
		String SQL = "select * from prod";
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProdDTO prod = new ProdDTO();
				prod.setProd_num(rs.getInt("prod_num"));
				prod.setProd_name(rs.getString("prod_name"));
				prod.setProd_price(rs.getInt("prod_price"));
				prod.setProd_kind(rs.getString("prod_kind"));
				prod.setProd_description(rs.getString("prod_description"));
				prod.setProd_image(rs.getString("prod_image"));
				prod.setProd_sm_image(rs.getString("prod_sm_image"));
				list.add(prod);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}
	
	public ProdDTO getFruit(int num) {			//선택 상품 정보 불러오기
		String SQL = "select prod_num, prod_name, prod_price, prod_description from prod where prod_num = ?";
		ProdDTO prod = new ProdDTO();
		
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			prod.setProd_num(rs.getInt("prod_num"));
			prod.setProd_name(rs.getString("prod_name"));
			prod.setProd_price(rs.getInt("prod_price"));
			prod.setProd_description(rs.getString("prod_description"));
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return prod;
	}
	
	public boolean updateProduct(ProdDTO prod) {		//상품정보 수정	
		boolean success = false;
		String sql = "update prod set prod_name=?, prod_price=?, prod_kind=?, prod_description=? where prod_num=?";

		try {
			pstmt = con.prepareStatement(sql);
	    	pstmt.setString(1, prod.getProd_name());
	    	pstmt.setInt(2, prod.getProd_price());
	    	pstmt.setString(3, prod.getProd_kind());
	    	pstmt.setString(4, prod.getProd_description());
	    	pstmt.setInt(5, prod.getProd_num());
	    	int rowUdt = pstmt.executeUpdate();
	    	
	    	if(rowUdt == 1) success = true;
		}catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}
	
	public boolean deleteProduct(int num) {			//상품 삭제
		boolean success = false;
		String sql = "delete from prod where prod_num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}
	
	public int idCheck(String id) {		//아이디 중복 체크
		int result = -1;
		String sql = "select mem_id from member where mem_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
				//System.out.println("result 값: " + result);
			} else {
				result = 0;
				//System.out.println("result 값: " + result);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return result;
	}
	
	public boolean insertPurchaseDir(PurchaseDTO pr) {		//장바구니 거치지 않고 구매
		String pattern = "YYYY/MM/dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		pr.setPurchase_date(date);
		boolean success = false;
		
		String SQL = "select prod_name, prod_sm_image from prod where prod_num = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, pr.getPurchase_num());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				pr.setPurchase_name(rs.getString("prod_name"));
				pr.setPurchase_sm_image(rs.getString("prod_sm_image"));
			}			
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "insert into purchase (mem_id, prod_num,purchase_sm_image,purchase_name,purchase_price,purchase_count,purchase_date) ";
		   sql += "values(?, ?, ?, ?, ?, ?,(str_to_date(?, '%Y/%m/%d')))";
		   
			   try {
				   pstmt = con.prepareStatement(sql);
					   pstmt.setString(1, pr.getPurchase_id());
					   pstmt.setInt(2, pr.getPurchase_num());
					   pstmt.setString(3, pr.getPurchase_sm_image());
					   pstmt.setString(4, pr.getPurchase_name());
					   pstmt.setInt(5, pr.getPurchase_price());
					   pstmt.setInt(6, pr.getPurchase_count());
					   pstmt.setString(7, pr.getPurchase_date());
					   pstmt.executeUpdate();
					   success = true;
			   } catch (SQLException e) {
				   e.printStackTrace();
				   return success;
			   } finally {
				   disConnect();
			   }
		   
		   return success;
	}
	
}

