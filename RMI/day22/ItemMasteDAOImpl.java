package day22;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public class ItemMasteDAOImpl implements ItemMasterDAO {

	@Override
	public int insertItemDetailsMaster(ItemMasterDTO obj) {
		Connection con = null;
		int status = -1;
		try {
			con = DBUtility.getConnection();
			String sql = "insert into ItemMaster values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, obj.getItemno());
			ps.setString(2, obj.getDesc());
			ps.setInt(3, obj.getPrice());
			ps.setInt(4, obj.getUnits());
			status = ps.executeUpdate();
			DBUtility.closeConnection();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
		}
		return status;
	}

	@Override
	public int updateItemDetailsMaster(ItemMasterDTO obj) {
		Connection con = null;
		int status = -1;
		try {
			con = DBUtility.getConnection();
			String sql = "update ItemMaster set ItemDesc=?,ItemUnit=?,ItemPrice=? where ItemNo=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, obj.getDesc());
			ps.setInt(2, obj.getUnits());
			ps.setInt(3, obj.getPrice());
			ps.setInt(4, obj.getItemno());
			status = ps.executeUpdate();
			DBUtility.closeConnection();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
		}

		return status;
	}

	@Override
	public int deleteItemDetailsMaster(int itemno) {
		Connection con = null;
		int status = -1;
		try {
			con = DBUtility.getConnection();
			String sql = "DELETE FROM ItemMaster WHERE ItemNo=? LIMIT 1;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemno);
			status = ps.executeUpdate();
			DBUtility.closeConnection();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
		}

		return status;
	}

	@Override
	public ItemMasterDTO getItemDetailsMaster(int itemno) {
		Connection con = null;
		ItemMasterDTO obj = null;
		try {
			obj = new ItemMasterDTO();
			con = DBUtility.getConnection();
			String sql = "select * from ItemMaster where ItemNo=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				obj.setItemno(rs.getInt(1));
				obj.setDesc(rs.getString(2));
				obj.setPrice(rs.getInt(3));
				obj.setUnits(rs.getInt(4));
			}
			DBUtility.closeConnection();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
		return obj;
	}

	@Override
	public Set<ItemMasterDTO> getItemDetailsMasterAll() {
		Connection con = null;
		ItemMasterDTO obj = null;
		Set<ItemMasterDTO> s = null;
		try {
			s = new HashSet<>();
			obj = new ItemMasterDTO();
			con = DBUtility.getConnection();
			String sql = "select * from ItemMaster";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				obj.setItemno(rs.getInt(1));
				obj.setDesc(rs.getString(2));
				obj.setPrice(rs.getInt(3));
				obj.setUnits(rs.getInt(4));

				s.add(obj);
			}

			DBUtility.closeConnection();
			st.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}

		return s;
	}
	

}