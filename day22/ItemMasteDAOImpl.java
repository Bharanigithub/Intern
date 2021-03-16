package day22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class ItemMasteDAOImpl implements ItemMasterDAO {

	@Override
	public int insertItem(ItemMasterDTO itemMasterDTO) {
		int k = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			System.out.println("HI");
			String sql = "insert into ItemMaster values (?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, itemMasterDTO.getItemNo());
			st.setString(2, itemMasterDTO.getItemDesc());
			st.setInt(3, itemMasterDTO.getItemPrice());
			st.setInt(4, itemMasterDTO.getItemUnit());
			k = st.executeUpdate();
			System.out.println("Inserted!!");
			st.close();
			con.close();
		} catch (Exception e) {

		}
		return k;
	}

	@Override
	public int deleteItem(int itemno) {
		int k = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			String sql = "delete from ItemMaster where CustomerNo=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, itemno);
			k = st.executeUpdate();
			System.out.println("Deleted!!");
			st.close();
			con.close();
		} catch (Exception e) {

		}
		return k;
	}

	@Override
	public int updateItem(ItemMasterDTO itemMasterDTO) {
		int k = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			String sql = "update ItemMaster set ItemDesc=?,ItemPrice=?,ItemUnit=? where ItemNo=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(4, itemMasterDTO.getItemNo());
			st.setString(1, itemMasterDTO.getItemDesc());
			st.setInt(2, itemMasterDTO.getItemPrice());
			st.setInt(3, itemMasterDTO.getItemUnit());
			k = st.executeUpdate();
			System.out.println("Updated!!");
			st.close();
			con.close();
		} catch (Exception e) {

		}
		return k;
	}

	@Override
	public ItemMasterDTO getItemMaster(int itemno) {
		ItemMasterDTO itemMasterDTO = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			itemMasterDTO = new ItemMasterDTO();
			String sql = "select * from ItemMaster where CustomerNo=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, itemno);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				itemMasterDTO.setItemNo(rs.getInt("ItemNo"));
				itemMasterDTO.setItemDesc(rs.getString("ItemDesc"));
				itemMasterDTO.setItemPrice(rs.getInt("ItemPrice"));
				itemMasterDTO.setItemUnit(rs.getInt("ItemUnit"));
			}
			rs.close();
			con.close();
		} catch (Exception e) {

		}
		return itemMasterDTO;
	}

	@Override
	public Set<ItemMasterDTO> getItemMasterAll() {
		ItemMasterDTO itemMasterDTO = null;
		Set<ItemMasterDTO> hash_Set = new HashSet<ItemMasterDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			itemMasterDTO = new ItemMasterDTO();
			Statement st = con.createStatement();
			String sql = "select * from ItemMaster";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				itemMasterDTO.setItemNo(rs.getInt("ItemNo"));
				itemMasterDTO.setItemDesc(rs.getString("ItemDesc"));
				itemMasterDTO.setItemPrice(rs.getInt("ItemPrice"));
				itemMasterDTO.setItemUnit(rs.getInt("ItemUnit"));
				hash_Set.add(itemMasterDTO);
			}
			con.close();
		} catch (Exception e) {
		}
		return hash_Set;
	}

}
