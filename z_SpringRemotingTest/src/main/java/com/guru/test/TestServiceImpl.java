/**
 * 
 */
package com.guru.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 * @author subbagu
 *
 */
public class TestServiceImpl implements TestService {

	/* (non-Javadoc)
	 * @see com.guru.test.TestService#sayHello()
	 */
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SimpleJdbcCall jdbcCaller;
	
	
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		//jdbcTemplate = new JdbcTemplate(dataSource);
		//jdbcCaller = new SimpleJdbcCall(dataSource);
	}

	
	
	public void sayHello() {
		System.out.println(">>>>>>>Hello from sayHello() in TestServiceImpl !!!!!!!!!!!");

	}
	
	public void testValidateEmpIdProc(String empId){
		
		System.out.println(">>> About to connect to database....");
		
		ResultSet resultSet = null;
		PreparedStatement statement =null;
		Connection connection = null;
		try {
			
			
			connection = dataSource.getConnection();
			System.out.println(">>> Database Connection successful....");
			
			System.out.println("Lookup started for employee id:"+empId);
			
			
			 statement = connection.prepareStatement("EXEC VALIDATE_EMP_ID ?",ResultSet.TYPE_SCROLL_SENSITIVE, 
						ResultSet.CONCUR_READ_ONLY);
			 statement.setString(1, empId);
			 if(statement.execute()) {
				 resultSet = statement.getResultSet();
					resultSet.last();
					int resultSetSize = resultSet.getRow();
					//log.info("Result Set Size: " + resultSetSize);
					
					if(resultSetSize>0)
						System.out.println("Employee found: " + resultSetSize);
					else
						System.out.println("Employee not found: " + resultSetSize);				 
			 }
			
			
/*			
			PreparedStatement storedProc = connection.prepareStatement(
					"{call VALIDATE_EMP_ID(?)}", 
					ResultSet.TYPE_SCROLL_SENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			storedProc.setNString(1, "510118");			
			
			
			ResultSet resultSet = storedProc.executeQuery();
			resultSet.last();
	*/					

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/*	
		SqlParameterSource inputParameters = new MapSqlParameterSource().addValue("@EMP_ID", empId);
		jdbcCaller.withFunctionName("VALIDATE_EMP_ID");//.declareParameters(new SqlParameter("@EMP_ID",Types.VARCHAR));
		String empNumber = jdbcCaller.executeFunction(String.class, inputParameters);

		System.out.println(">>> Return value: "+empNumber);
		//jdbcTemplate.update("call VALIDATE_EMP_ID (?)", empId);
		*/
	}
	
	public void getCrewCount() {
		
		int count = jdbcTemplate.queryForInt("select count(*) from crew");
		System.out.println(">>>>>>>> Total records in CREW table: "+count);
		
	}

	

}
