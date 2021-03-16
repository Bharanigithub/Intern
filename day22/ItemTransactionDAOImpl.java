package day22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class ItemTransactionDAOImpl implements ItemTransactionDAO {
	Connection con = null;

	@Override
	public int insertQty(ItemTransactionDTO itemTransactionDTO) {
		int k = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			String sql = "insert into ItemTransaction values (?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, itemTransactionDTO.getInvNo());
			st.setInt(2, itemTransactionDTO.getItemNo());
			st.setInt(3, itemTransactionDTO.getQty());
			k = st.executeUpdate();
			System.out.println("Inserted!!");
			st.close();
			con.close();
		} catch (Exception e) {

		}
		return k;
	}

	@Override
	public int deleteQty(int itemno, int invno) {
		int k = 0;
		try {
			String sql = "delete from ItemTransaction where InvNo=? and ItemNo=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, invno);
			st.setInt(2, itemno);
			k = st.executeUpdate();
			System.out.println("Deleted!!");
			st.close();
			con.close();
		} catch (Exception e) {

		}
		return k;
	}

	@Override
	public int updateQty(ItemTransactionDTO itemTransactionDTO) {
		int k = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			String sql = "update ItemTransaction set qty=? where ItemNo=? and InvNo=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(2, itemTransactionDTO.getItemNo());
			st.setInt(3, itemTransactionDTO.getInvNo());
			st.setInt(1, itemTransactionDTO.getQty());
			k = st.executeUpdate();
			System.out.println("Updated!!");
			st.close();
			con.close();
		} catch (Exception e) {

		}
		return k;
	}

	@Override
	public Set<ItemTransactionDTO> getItemTransaction(int itemno, int invno) {
		ItemTransactionDTO itemTransactionDTO = null;
		Set<ItemTransactionDTO> hash_Set = new HashSet<ItemTransactionDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			itemTransactionDTO = new ItemTransactionDTO();
			String sql = "select * from ItemTransaction where InvNo=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, invno);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				itemTransactionDTO.setItemNo(rs.getInt("ItemNo"));
				itemTransactionDTO.setInvNo(rs.getInt("InvNo"));
				itemTransactionDTO.setQty(rs.getInt("qty"));
				hash_Set.add(itemTransactionDTO);
			}
			rs.close();
			con.close();
		} catch (Exception e) {

		}
		return hash_Set;
	}

	@Override
	public Set<ItemTransactionDTO> getItemTransactionAll() {
		ItemTransactionDTO itemTransactionDTO = null;
		Set<ItemTransactionDTO> hash_Set = new HashSet<ItemTransactionDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			System.out.println("HI");
			itemTransactionDTO = new ItemTransactionDTO();
			Statement st = con.createStatement();
			String sql = "select * from ItemTransaction";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				itemTransactionDTO.setItemNo(rs.getInt("ItemNo"));
				itemTransactionDTO.setInvNo(rs.getInt("InvNo"));
				itemTransactionDTO.setQty(rs.getInt("qty"));
				hash_Set.add(itemTransactionDTO);
			}
			con.close();
		} catch (Exception e) {
		}
		return hash_Set;
	}

}
