package config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conexao extends DriverManagerDataSource {
	
	public Conexao(){
		
		/*this.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		this.setUrl("jdbc:derby://localhost:1527/banco1");
		this.setUsername("APP");
		this.setPassword("APP");*/
		
		this.setDriverClassName("com.mysql.jdbc.Driver");
		this.setUrl("jdbc:mysql://ec2-23-21-211-172.compute-1.amazonaws.com:3306/fargwebdb");
		this.setUsername("fargweb");
		this.setPassword("fargweb");
		
		
	}
	
}
