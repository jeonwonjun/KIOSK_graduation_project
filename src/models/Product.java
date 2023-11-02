package models;

public class Product {

	private String category_main;
	private String category_sub;
	private int product_id;
	private String product_name;
	private int product_price;
	private int amount_left;
	private int amount_sale;
	public String getCategory_main() {
		return category_main;
	}
	public void setCategory_main(String category_main) {
		this.category_main = category_main;
	}
	
	public String getCategory_sub() {
		return category_sub;
	}
	public void setCategory_sub(String category_sub) {
		this.category_sub = category_sub;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	
	public int getAmount_left() {
		return amount_left;
	}
	public void setAmount_left(int amount_left) {
		this.amount_left = amount_left;
	}
	
	public int getAmount_sale() {
		return amount_sale;
	}
	public void setAmount_sale(int amount_sale) {
		this.amount_sale = amount_sale;
	}
	
}
