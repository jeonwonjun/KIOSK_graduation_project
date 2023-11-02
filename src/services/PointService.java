package services;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Member;
import models.Point;

public class PointService extends DBConnection {
	

	public int updateAcc(Point point) {
	    int rowCount = 0;

	    this.connect();

	    try {
	      String sql = "UPDATE point SET point_recent = member_point, member_point = sumPrice * 0.05 WHERE member_id = ?, UseOrAcc = 0";
	      PreparedStatement stmt = this.con.prepareStatement(sql);
	      stmt.setInt(1, point.getPoint_recent());
	      stmt.setInt(1, point.getMember_point());
	      rowCount = stmt.executeUpdate();
	    } catch (SQLException e) {
	      System.out.println(e);
	    }

	    this.disconnect();

	    return rowCount;
	  }
	
}
