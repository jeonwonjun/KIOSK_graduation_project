package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Product;

public class ProductService extends DBConnection {
	
	private final String queryItems = "";
	
	public ArrayList<Product> getAll() {
		ArrayList<Product> productList = new ArrayList<Product>();
		
		this.connect();
		
		String SQL = "SELECT * From product ORDER BY product_id"; //product 데이터 가져오기
		
		try {
			PreparedStatement pstmt = this.con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				productList.add(mapResultOneProduct(rs));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList; //데이터베이스 오류
	}
	
	
	private Product mapResultOneProduct(ResultSet result) {
	    Product product = null;

	    try {
	      product = new Product();
	      product.setCategory_main(result.getString("category_main"));
	      product.setCategory_sub(result.getString("category_sub"));
	      product.setProduct_id(result.getInt("product_id"));
	      product.setProduct_name(result.getString("product_name"));
	      product.setProduct_price(result.getInt("product_price"));
	      product.setAmount_left(result.getInt("amount_left"));
	      product.setAmount_sale(result.getInt("amount_sale"));
	      
	    } catch (Exception e) {
	      System.out.println(e);
	    }

	    return product;
	  }

}
