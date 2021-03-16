package day22;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO {
	

	@Override
	public int insertInvoice(InvoiceMasterDTO invMasterDTO) {
		int k = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			String sql = "insert into InvoiceMaster values (?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, invMasterDTO.getInvno());
			LocalDate ld = invMasterDTO.getInvdate();
			java.sql.Date sqlDate = java.sql.Date.valueOf(ld);
			st.setDate(2, sqlDate);
			st.setInt(3, invMasterDTO.getCustomerno());
			k = st.executeUpdate();
			System.out.println("Inserted!!");
			st.close();
			con.close();
		} catch (Exception e) {

		}
		return k;
	}

	@Override
	public int deleteInvoice(int invno) {
		int k = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			String sql = "delete from InvoiceMaster where InvNo=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, invno);
			k = st.executeUpdate();
			System.out.println("Deleted!!");
			st.close();
			con.close();
		} catch (Exception e) {

		}
		return k;
	}

	@Override
	public int updateInvoice(InvoiceMasterDTO invMasterDTO) {
		int k = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			String sql = "update InvoiceMaster set InvDate=?,CustomerNo=? where InvNo=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(3, invMasterDTO.getInvno());
			LocalDate ld = invMasterDTO.getInvdate();
			java.sql.Date sqlDate = java.sql.Date.valueOf(ld);
			st.setDate(1, sqlDate);
			st.setInt(2, invMasterDTO.getCustomerno());
			k = st.executeUpdate();
			System.out.println("Updated!!");
			st.close();
			con.close();
		} catch (Exception e) {

		}
		return k;
	}

	@Override
	public InvoiceMasterDTO getInvoiceMaster(int invo) {
		InvoiceMasterDTO invMasterDTO = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			invMasterDTO = new InvoiceMasterDTO();
			String sql = "select * from InvoiceMaster where InvNo=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, invo);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				invMasterDTO.setInvno(rs.getInt("InvNo"));
				Date dt = rs.getDate("InvDate");
				invMasterDTO.setInvdate(dt.toLocalDate());
				invMasterDTO.setCustomerno(rs.getInt("CustomerNo"));
			}
			rs.close();
			con.close();
		} catch (Exception e) {

		}
		return invMasterDTO;
	}

	@Override
	public Set<InvoiceMasterDTO> getInvoiceMasterAll() {
		InvoiceMasterDTO invMasterDTO = null;
		Set<InvoiceMasterDTO> hash_Set = new HashSet<InvoiceMasterDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			invMasterDTO = new InvoiceMasterDTO();
			Statement st = con.createStatement();
			String sql = "select * from InvoiceMaster";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				invMasterDTO.setCustomerno(rs.getInt("CustomerNo"));
				Date dt = rs.getDate("InvDate");
				invMasterDTO.setInvdate(dt.toLocalDate());
				invMasterDTO.setInvno(rs.getInt("InvNo"));
				hash_Set.add(invMasterDTO);
			}
			con.close();
		} catch (Exception e) {
		}
		return hash_Set;
	}
}