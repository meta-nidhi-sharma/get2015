package CaseStudy1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*
 * @author Nidhi
 * Date: 21 september 2015
 * Description: Helper class to execute queries
 */
public class HelperClass 
{
	/* execute query using prepared statement*/
	public static void executeQueryUsingPreparedStatement(Vehicle v2) throws SQLException 
	{
		System.out.println("\nFetching data using PreparedStatement ....");
		Connection con = null;
		PreparedStatement ps = null;
		int rs;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		
		String query1 = "INSERT INTO vehicle (vehicle_no,make,model,engineIn_CC,fuel_Capacity,milage,price,road_Tax,created_by) "
				+ "VALUES (?,?,?,?,?,?,?,?,?);";
		try
		{
			//System.out.println(v2.getVehicleNo());
			ps = con.prepareStatement(query1);
			/* set variable in prepared statement */
			ps.setInt(1, v2.getVehicleNo());
			ps.setInt(2, v2.getMake());
			ps.setString(3, v2.getModel());
			ps.setInt(4, v2.getEngineInCC());
			ps.setDouble(5, v2.getFuelCapacity());
			ps.setDouble(6, v2.getMilage());
			ps.setDouble(7, v2.getPrice());
			ps.setDouble(8, v2.getRoadTax());
			ps.setString(9, v2.getCreatedBy());
			
			
			// ps.setString(1,name);
			rs = ps.executeUpdate();
			System.out.println(rs);
		
			if(v2 instanceof Bike)
			{	
				String query2 = "INSERT INTO bike (vehicle_no,self_start,helmet_price) VALUES (?,?,?);";
		
				ps = con.prepareStatement(query2);
				/* set variable in prepared statement */
				ps.setInt(1, v2.getVehicleNo());
				ps.setString(2, ((Bike) v2).isSelfStart());
				ps.setInt(3, ((Bike) v2).getHelmetPrice());
				// ps.setString(1,name);
				rs = ps.executeUpdate();
				System.out.println(rs);
			}
			else  
			{	
				String query3 = "INSERT INTO car (vehicle_no,ac,power_stearing,accessory_kit) VALUES (?,?,?,?);";
	
				ps = con.prepareStatement(query3);
				/* set variable in prepared statement */
				ps.setInt(1, v2.getVehicleNo());
				ps.setString(2, ((Car) v2).isAC());
				ps.setString(3, ((Car) v2).isPowerStearing());
				ps.setString(4, ((Car) v2).isAccessoryKit());
				// ps.setString(1,name);
				rs = ps.executeUpdate();
				System.out.println(rs);
			}			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		finally
		{
			/* close connection */
			try 
			{
				if (con != null) 
				{
					con.close();
				}
				if (ps != null)
				{
					ps.close();
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}		
		}
	}
}

