package SpringProj;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBDao {
	private DataSource dataSource;

	public final DataSource getDataSource() {
		return dataSource;
	}

	public final void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	JdbcTemplate jdbcTemplate;
	public void firstTest() {
		jdbcTemplate=new JdbcTemplate(dataSource);
		int n=jdbcTemplate.queryForInt("select count(*) from users");
		System.out.println("No.of rows:"+n);
		n=jdbcTemplate.queryForInt("select count(*) from users where uname=?","bharani");
		System.out.println("Name like Bharani in Users Table:"+n);
		String name=jdbcTemplate.queryForObject("select uname from users where uid=?", new Object[] {1}, String.class);
		System.out.println(name);
	}
}
