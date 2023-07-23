package mky20_mvc_fruit.model.fruit;

public class ProdDTO {
	private int prod_num;
	private String prod_name;
	private int prod_price;
	private String prod_kind;
	private String prod_description;
	private String prod_image;
	private String prod_sm_image;
	
	
	
	public ProdDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdDTO(int prod_num, String prod_name, int prod_price, String prod_kind, String prod_description,
			String prod_image, String prod_sm_image) {
		super();
		this.prod_num = prod_num;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_kind = prod_kind;
		this.prod_description = prod_description;
		this.prod_image = prod_image;
		this.prod_sm_image = prod_sm_image;
	}
	
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public String getProd_kind() {
		return prod_kind;
	}
	public void setProd_kind(String prod_kind) {
		this.prod_kind = prod_kind;
	}
	public String getProd_description() {
		return prod_description;
	}
	public void setProd_description(String prod_description) {
		this.prod_description = prod_description;
	}
	public String getProd_image() {
		return prod_image;
	}
	public void setProd_image(String prod_image) {
		this.prod_image = prod_image;
	}
	public String getProd_sm_image() {
		return prod_sm_image;
	}
	public void setProd_sm_image(String prod_sm_image) {
		this.prod_sm_image = prod_sm_image;
	}
	
	
}
