package day22;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public class ItemTransactionDAOImpl implements ItemTransactionDAO{

	@Override
	public int insertItem(ItemTransactionDTO obj) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtility.getConnection();
			String sql="insert into ItemTransaction values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, obj.getInvno());
			ps.setInt(2,obj.getItemno());
			ps.setInt(3,obj.getQty());
			status=ps.executeUpdate();
			DBUtility.closeConnection();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
		}
		return status;
	}

	@Override
	public int deleteItem(int invno) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtility.getConnection();
			String sql="DELETE FROM ItemTransaction WHERE InvNo=? LIMIT 1;";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, invno);
			status=ps.executeUpdate();
			DBUtility.closeConnection();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
		}
		return status;
	}
	@Override
	public int updateInvoice(ItemTransactionDTO obj) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtility.getConnection();
			String sql="update ItemTransaction set ItemNo=?,qty=? where InvNo=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, obj.getItemno());
			ps.setInt(2,obj.getQty());
			ps.setInt(3, obj.getInvno());
			status=ps.executeUpdate();
			DBUtility.closeConnection();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
		}
		return status;
	}
	@Override
	public Set<ItemTransactionDTO> getItemDetails(int invno) {
		Connection con=null;
		ItemTransactionDTO obj=null;
		Set<ItemTransactionDTO> s=null;
		try {
			s=new HashSet<>();
			
			con=DBUtility.getConnection();
			String sql="select * from ItemTransaction where InvNo=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, invno);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			obj=new ItemTransactionDTO();
			obj.setInvno(invno);
			obj.setItemno(rs.getInt(2));
			obj.setQty(rs.getInt(3));
			s.add(obj);
			}
			DBUtility.closeConnection();
			ps.close();
			rs.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
		return s;
	}

	@Override
	public Set<ItemTransactionDTO> getItemDetailsAll(String invno) {
		Connection con=null;
		ItemTransactionDTO obj=null;
		Set<ItemTransactionDTO> s=null;
		try {
			s=new HashSet<>();
			obj=new ItemTransactionDTO();
			con=DBUtility.getConnection();
			String sql="select * from ItemTransaction where InvNo=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setLong(1, Long.parseLong(invno));
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				obj=new ItemTransactionDTO();
				obj.setInvno(rs.getInt(1));
				obj.setItemno(rs.getInt(2));
				obj.setQty(rs.getInt(3));
				s.add(obj);
			}

			DBUtility.closeConnection();
			st.close();
			rs.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
		
		return s;
	}
	
}