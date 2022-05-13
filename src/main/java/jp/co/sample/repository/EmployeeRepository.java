package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper <Employee> EMPLOYEE_ROW_MAPPER 
			= new BeanPropertyRowMapper<>(Employee.class);
		
	
	public List<Employee> findAll() {
		String sql 
			= "select id,name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,dependents_count from employee order by age";

		List<Employee> EmployeeList 
			= template.query(sql, EMPLOYEE_ROW_MAPPER); // ←ここに実行の処理を書く
		if(EmployeeList.size()==0) {
			return null;
		}
		return EmployeeList;
	}

	public Employee load(Integer id) {
		String sql = 
			"select select id,name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,dependents_count  where id = :id";

		SqlParameterSource param 
			= new MapSqlParameterSource().addValue("id", id); 

		Employee employee 
			= template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER); // ←ここに実行処理を書く

		return employee;
	}


	public Employee save(Employee employee) {
	SqlParameterSource param = new BeanPropertySqlParameterSource(employee);

	if(employee.getId() == null) {
		String insertSql = "INSERT INTO employee(name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,dependents_count) VALUES(:name,:image,:gender,:hireDdate,:mailAddress,:zipCode,:address,:telephone,:salary,:characteristics,:dependentsCount)";

		template.update(insertSql, param);

	} else {
		String updateSql = "UPDATE employee SET name=:name,image=:image,:gender=:gender,hireDate=:hireDate,:mailAddress=:mailAddress,zipCode=:zipCode,address=:address,telephone=:telephone,:salary=:salary,characteristics=:characteristics,dependentsCount=:dependentsCount WHERE id=:id";

		template.update(updateSql, param);
	}

	return employee;
}
}