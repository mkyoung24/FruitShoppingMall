package mky20_mvc_fruit.model.fruit;

public class PurchaseDTO {
	private String purchase_id;
	private int purchase_num;
	private String purchase_sm_image;
	private String purchase_name;
	private int purchase_count;
	private int purchase_price;
	private String purchase_date;
	private String purchase_state;
	
	public PurchaseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseDTO(String purchase_id, int purchase_num, String purchase_sm_image, String purchase_name,
			int purchase_count, int purchase_price, String purchase_date, String purchase_state) {
		super();
		this.purchase_id = purchase_id;
		this.purchase_num = purchase_num;
		this.purchase_sm_image = purchase_sm_image;
		this.purchase_name = purchase_name;
		this.purchase_count = purchase_count;
		this.purchase_price = purchase_price;
		this.purchase_date = purchase_date;
		this.purchase_state = purchase_state;
	}
	
	public String getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(String purchase_id) {
		this.purchase_id = purchase_id;
	}
	public int getPurchase_num() {
		return purchase_num;
	}
	public void setPurchase_num(int purchase_num) {
		this.purchase_num = purchase_num;
	}
	public String getPurchase_sm_image() {
		return purchase_sm_image;
	}
	public void setPurchase_sm_image(String purchase_sm_image) {
		this.purchase_sm_image = purchase_sm_image;
	}
	public String getPurchase_name() {
		return purchase_name;
	}
	public void setPurchase_name(String purchase_name) {
		this.purchase_name = purchase_name;
	}
	public int getPurchase_count() {
		return purchase_count;
	}
	public void setPurchase_count(int purchase_count) {
		this.purchase_count = purchase_count;
	}
	public int getPurchase_price() {
		return purchase_price;
	}
	public void setPurchase_price(int purchase_price) {
		this.purchase_price = purchase_price;
	}
	public String getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	public String getPurchase_state() {
		return purchase_state;
	}
	public void setPurchase_state(String purchase_state) {
		this.purchase_state = purchase_state;
	}
	
	
}
