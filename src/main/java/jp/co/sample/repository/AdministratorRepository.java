package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

@Repository
public class AdministratorRepository {
	

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
		
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mail_address"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};
	
	

	public Administrator save(Administrator administrator) {
		SqlParameterSource param
		=new BeanPropertySqlParameterSource(administrator);

		if (administrator.getId() == null) {
			String insertSql 
				= "INSERT INTO administrators(name, mail_address, password) VALUES(:name, :mailAddress, :password)";

			template.update(insertSql, param);

		} else {
			String updateSql 
				= "UPDATE administrators SET name=:name, mail_address=:mailAddress, password=:password WHERE id=:id";

			template.update(updateSql, param);
		}

		return administrator;
	}

	public Administrator findByMailAndPassword(String mailAddress,String password) {
		String sql
			="SELECT id,name,mail_address,password FROM administrator WHERE mailAddress=:mailAddress,password=:password";
		
		SqlParameterSource param
			=new MapSqlParameterSource().addValue("mailAddress",mailAddress).addValue("password",password);

		
		List<Administrator>administratorList
			=template.query(sql, param,ADMINISTRATOR_ROW_MAPPER);
		if(administratorList.size()==0) {

			return null;
		}
		return administratorList.get(0);

	}
}
	
