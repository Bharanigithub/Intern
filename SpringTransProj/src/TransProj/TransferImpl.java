package TransProj;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class TransferImpl implements Transfer{
	private DataSource datasource;
	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public void credit(int accid, int amt) throws Exception {
		JdbcTemplate jdbc=new JdbcTemplate(datasource);
		Integer oldamount=jdbc.queryForObject("select amount from accounts where accid=?",
				new Object[] {accid},Integer.class);
		int newamt=oldamount+amt;
		
		NamedParameterJdbcTemplate njdbc=new NamedParameterJdbcTemplate(datasource);
		
		MapSqlParameterSource mps=new MapSqlParameterSource();
		mps.addValue("amtt", newamt);
		mps.addValue("id", accid);
		njdbc.update("update accounts set amount=:amtt where accid=:id", mps);
	}

	@Override
	public void debit(int accid, int amt) throws Exception {
		//datasource.getConnection().setAutoCommit(false);
		JdbcTemplate jdbc=new JdbcTemplate(datasource);
		Integer oldamount=jdbc.queryForObject("select amount from accounts where accid=?",
				new Object[] {accid},Integer.class);
		if(oldamount<amt) {
			throw new InsufficientMoneyException("The user does not have enough balance...");
		}
		int newamount=oldamount-amt;
		NamedParameterJdbcTemplate njdbc=new NamedParameterJdbcTemplate(datasource);
		
		MapSqlParameterSource mps=new MapSqlParameterSource();
		mps.addValue("amtt", newamount);
		mps.addValue("id", accid);
		njdbc.update("update accounts set amount=:amtt where accid=:id", mps);
		
	}

}
