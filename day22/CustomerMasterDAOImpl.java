package day22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class CustomerMasterDAOImpl implements CustomerMasterDAO {

	@Override
	public int insertCustomer(CustomerMasterDTO cusMasterDTO) {
		int k = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			System.out.println("HI");
			String sql = "insert into CustomerMaster values (?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cusMasterDTO.getCustomerNo());
			st.setString(2, cusMasterDTO.getCustomerAddress());
			st.setString(3, cusMasterDTO.getCustomerEmail());
			st.setString(4, cusMasterDTO.getCustomerPhone());
			st.setString(5, cusMasterDTO.getCustomerName());
			k = st.executeUpdate();
			System.out.println("Inserted!!");
			st.close();
			con.close();
		} catch (Exception e) {

		}
		return k;
	}

	@Override
	public int deleteCustomer(int cusno) {
		int k = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			String sql = "delete from CustomerMaster where CustomerNo=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cusno);
			k = st.executeUpdate();
			System.out.println("Deleted!!");
			st.close();
			con.close();
		} catch (Exception e) {

		}
		return k;
	}

	@Override
	public int updateCustomer(CustomerMasterDTO cusMasterDTO) {
		int k = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			String sql = "update CustomerMaster set CustomerAddress=?,CustomerEmail=?,CustomerPhone=?,CustomerName=? where CustomerNo=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(5, cusMasterDTO.getCustomerNo());
			st.setString(1, cusMasterDTO.getCustomerAddress());
			st.setString(2, cusMasterDTO.getCustomerEmail());
			st.setString(3, cusMasterDTO.getCustomerPhone());
			st.setString(4, cusMasterDTO.getCustomerName());
			k = st.executeUpdate();
			System.out.println("Updated!!");
			st.close();
			con.close();
		} catch (Exception e) {

		}
		return k;

	}

	@Override
	public CustomerMasterDTO getCustomerMaster(int cusno) {
		CustomerMasterDTO cusMasterDTO = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			cusMasterDTO = new CustomerMasterDTO();
			String sql = "select * from CustomerMaster where CustomerNo=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cusno);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				cusMasterDTO.setCustomerName(rs.getString("CustomerName"));
				cusMasterDTO.setCustomerNo(rs.getInt("CustomerNo"));
				cusMasterDTO.setCustomerAddress(rs.getString("CustomerAddress"));
				cusMasterDTO.setCustomerEmail(rs.getString("CustomerEmail"));
				cusMasterDTO.setCustomerPhone(rs.getString("CustomerPhone"));
			}
			rs.close();
			con.close();
		} catch (Exception e) {

		}
		return cusMasterDTO;
	}

	@Override
	public Set<CustomerMasterDTO> getCustomerMasterAll() {
		CustomerMasterDTO cusMasterDTO = null;
		Set<CustomerMasterDTO> hash_Set = new HashSet<CustomerMasterDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			cusMasterDTO = new CustomerMasterDTO();
			Statement st = con.createStatement();
			String sql = "select * from CustomerMaster";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				cusMasterDTO.setCustomerName(rs.getString("CustomerName"));
				cusMasterDTO.setCustomerNo(rs.getInt("CustomerNo"));
				cusMasterDTO.setCustomerAddress(rs.getString("CustomerAddress"));
				cusMasterDTO.setCustomerEmail(rs.getString("CustomerEmail"));
				cusMasterDTO.setCustomerPhone(rs.getString("CustomerPhone"));
				hash_Set.add(cusMasterDTO);
			}
			con.close();
		} catch (Exception e) {
		}
		return hash_Set;
	}

}
