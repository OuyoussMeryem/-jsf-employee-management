package Dao;

import metier.enteties.Employee;

public class TestDao {

	public static void main(String[] args) {
		System.out.println("Hello world");
		EmployeeDaoImpl metier=new EmployeeDaoImpl();
		Employee emp=new Employee();
		
//		emp.setNom("said");
//		emp.setPrenom("said");
//		emp.setAge(34);
//		emp.setEmail("said@gmail.com");
//		emp.setDatenaissance("2004-02-15");
//		emp.setSalaire(3600);
		
		
		
		emp.setNom("teeeeest");
		emp.setPrenom("teeeeest");
		emp.setAge(15);
		emp.setEmail("teeeeeeest@gmail.com");
		emp.setDatenaissance("2004-02-15");
		emp.setSalaire(360);
	   
		metier.save(emp);
		
		
				
		System.out.println("success");
		
		
		
	}

}
