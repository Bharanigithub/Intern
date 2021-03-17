package day22;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public class CustomerMasterDAOImpl implements CustomerMasterDAO{

	@Override
	public int insertCustomerDetials(CustomerMasterDTO obj) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtility.getConnection();
			String sql="insert into CustomerMaster values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, obj.getCustno());
			ps.setString(2, obj.getAddress());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getPhone());
			ps.setString(5, obj.getName());
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
	public int deleteCustomerDetials(int custno) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtility.getConnection();
			String sql="DELETE FROM CustomerMaster WHERE CustomerNo=? LIMIT 1;";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, custno);
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
	public int updateCustomerDetials(CustomerMasterDTO obj) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtility.getConnection();
			String sql="update CustomerMaster set CustomerName=?,CustomerAddress=?,CustomerEmail=?,CustomerPhone=? where CustomerNo=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getAddress());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getPhone());
			ps.setLong(5, obj.getCustno());
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
	public CustomerMasterDTO getCustomerDetials(int custno) {
		Connection con=null;
		CustomerMasterDTO obj=null;
		try {
			obj=new CustomerMasterDTO();
			con=DBUtility.getConnection();
									  //CustomerDetails
			String sql="select * from CustomerMaster where CustomerNo=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, custno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				obj.setCustno(rs.getInt(1));
				obj.setAddress(rs.getString(2));
				obj.setEmail(rs.getString(3));
				obj.setPhone(rs.getString(4));
				obj.setName(rs.getString(5));
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
		return obj;
	}

	@Override
	public Set<CustomerMasterDTO> getCustomerDetialsAll() {
		Connection con=null;
		CustomerMasterDTO obj=null;
		Set<CustomerMasterDTO> s=null;
		try {
			s=new HashSet<>();
			obj=new CustomerMasterDTO();
			con=DBUtility.getConnection();
			String sql="select * from CustomerMaster";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				obj.setCustno(rs.getInt(1));
				obj.setAddress(rs.getString(2));
				obj.setEmail(rs.getString(3));
				obj.setPhone(rs.getString(4));
				obj.setName(rs.getString(5));
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