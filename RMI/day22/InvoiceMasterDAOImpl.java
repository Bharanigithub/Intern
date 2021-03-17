package day22;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import java.sql.ResultSet;
import java.sql.Statement;


public class InvoiceMasterDAOImpl implements InvoiceMasterDAO{
	
	@Override
	public int insertInvoice(InvoiceMasterDTO invMasterDTO) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtility.getConnection();
			String sql="insert into InvoiceMaster values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, invMasterDTO.getInvno());
			ps.setDate(2, Date.valueOf(invMasterDTO.getInvDate()));
			ps.setInt(3, invMasterDTO.getCustomerno());
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
	public int deleteInvoice(int invno) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtility.getConnection();
			String sql="DELETE FROM InvoiceMaster WHERE InvNo=? LIMIT 1;";
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
	public int updateInvoice(InvoiceMasterDTO invMasterDTO) {
		Connection con=null;
		int status=-1;
		try {
			con=DBUtility.getConnection();
			String sql="update InvoiceMaster set InvDate=?,CustomerNo=? where InvNo=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setDate(1, Date.valueOf(invMasterDTO.getInvDate()));
			ps.setInt(2, invMasterDTO.getCustomerno());
			ps.setInt(3, invMasterDTO.getInvno());
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
	public InvoiceMasterDTO getInvoiceMaster(int invo) {
		Connection con=null;
		InvoiceMasterDTO obj=null;
		try {
			obj=new InvoiceMasterDTO();
			con=DBUtility.getConnection();
			String sql="select * from InvoiceMaster where InvNo=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, invo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			Date date = rs.getDate(2);
			//System.out.println(date);
			LocalDate localDate = new java.sql.Date( date.getTime())
                    .toLocalDate();
			//System.out.println(localDate);
			obj.setInvno(rs.getInt(1));
			obj.setInvDate(localDate);
			obj.setCustomerno(rs.getInt("CustomerNo"));
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
	public Set<InvoiceMasterDTO> getInvoiceMasterAll() {
		Connection con=null;
		InvoiceMasterDTO obj=null;
		Set<InvoiceMasterDTO> s=null;
		try {
			s=new HashSet<InvoiceMasterDTO>();
			obj=new InvoiceMasterDTO();
			con=DBUtility.getConnection();
			String sql="select * from InvoiceMaster";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Date date = rs.getDate(2);
				ZoneId defaultZoneId = ZoneId.systemDefault();
				Instant instant = date.toInstant();
				LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
				obj.setInvno(rs.getInt(1));
				obj.setInvDate(localDate);
				obj.setCustomerno(rs.getInt("CustomerNo"));
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