package models;

public class Point {

	private int member_id;
	private int member_point;
	private int point_recent;
	private boolean UseOrAcc;
	
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	public int getMember_point() {
		return member_point;
	}
	public void setMember_point(int member_point) {
		this.member_point = member_point;
	}
	
	public int getPoint_recent() {
		return point_recent;
	}
	public void setPoint_recent(int point_recent) {
		this.point_recent = point_recent;
	}
	
	public boolean isUseOrAcc() {
		return UseOrAcc;
	}
	public void setUseOrAcc(boolean useOrAcc) {
		UseOrAcc = useOrAcc;
	}
	
}
