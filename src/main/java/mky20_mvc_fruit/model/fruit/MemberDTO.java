package mky20_mvc_fruit.model.fruit;

public class MemberDTO {
	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private int mem_num;
	private String mem_address;
	private String mem_phone;
	private int mem_class;
	private String userID;
	private String userPW;
	
	public MemberDTO() {
		super();
	}
	
	public MemberDTO(String mem_id, String mem_pw, String mem_name, int mem_num, String mem_address, String mem_phone,
			int mem_class, String userID, String userPW) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_num = mem_num;
		this.mem_address = mem_address;
		this.mem_phone = mem_phone;
		this.mem_class = mem_class;
		this.userID = userID;
		this.userPW = userPW;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getMem_address() {
		return mem_address;
	}
	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public int getMem_class() {
		return mem_class;
	}
	public void setMem_class(int mem_class) {
		this.mem_class = mem_class;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}	
}
