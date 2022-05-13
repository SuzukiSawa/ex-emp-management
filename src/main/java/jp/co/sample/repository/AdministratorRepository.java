package jp.co.sample.repository;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

@Repository
public class AdministratorRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper <Administrator>ADMINISTRATOR_ROWMAPPER
	=(rs,i)->{
		Administrator administrator = new Administrator();
		administrator.setId(re.getInt("id"));
		administrator.setName(re.getString("name"));
		administrator.set(re.getInt("age"));
		administrator.setGender(re.getString("gender"));
		administrator.setId(re.getInt(""));
		
		
		
		
	public Administrator save(Administrator administrator)
	{
		SqlParameterSource param
		= new BeanPropertySqlParameterSource(administrator);
		
		if(administrator.getId()==null) {
			String insertSql
			="INSERT INTO admini"
		}
	
	
}
