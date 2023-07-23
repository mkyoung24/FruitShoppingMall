package mky20_mvc_fruit.model.fruit;

public class BasketDTO {
	private int shop_num;
	private String shop_id;
	private int shop_price;
	private String shop_name;
	private int shop_amount;
	private String shop_sm_image;
	private int shop_total_price;
		
	public BasketDTO(int shop_num, String shop_id, int shop_price, String shop_name, int shop_amount,
			String shop_sm_image, int shop_total_price) {
		super();
		this.shop_num = shop_num;
		this.shop_id = shop_id;
		this.shop_price = shop_price;
		this.shop_name = shop_name;
		this.shop_amount = shop_amount;
		this.shop_sm_image = shop_sm_image;
		this.shop_total_price = shop_total_price;
	}

	public BasketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getShop_num() {
		return shop_num;
	}
	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public int getShop_price() {
		return shop_price;
	}
	public void setShop_price(int shop_price) {
		this.shop_price = shop_price;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public int getShop_amount() {
		return shop_amount;
	}
	public void setShop_amount(int shop_amount) {
		this.shop_amount = shop_amount;
	}
	public String getShop_sm_image() {
		return shop_sm_image;
	}
	public void setShop_sm_image(String shop_sm_image) {
		this.shop_sm_image = shop_sm_image;
	}
	public int getShop_total_price() {
		return shop_total_price;
	}
	public void setShop_total_price(int shop_total_price) {
		this.shop_total_price = shop_total_price;
	}
		
	
	
}
