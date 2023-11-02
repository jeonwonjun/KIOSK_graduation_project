package models;

public class Member {

	private int member_id;
	private String member_name;
	private String Member_phone;
	
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	public String getMember_phone() {
		return Member_phone;
	}
	public void setMember_phone(String member_phone) {
		Member_phone = member_phone;
	}
}
