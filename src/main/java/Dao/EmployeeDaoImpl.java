package Dao;

import java.util.List;


import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.enteties.Employee;

public class EmployeeDaoImpl implements IEmployeeDao{
	

	@Override
	public Employee save(Employee e) {
		
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("INSERT into employee (nom,prenom,email,age,date_naissance,salaire) VALUES(?,?,?,?,?,?)");
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPrenom());
			ps.setString(3, e.getEmail());
			ps.setInt(4, e.getAge());
			ps.setString(5, e.getDatenaissance());
			ps.setInt(6, e.getSalaire());
			ps.executeUpdate();
			
			PreparedStatement ps1=conn.prepareStatement("SELECT MAX(id) AS MAX_ID FROM etudiant");
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next()) {
				e.setId(rs1.getInt("MAX_ID"));
			}
			ps.close();
			

		
		
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		return e;
	}

	@Override
	public List<Employee> employeeParMC(String mc) {
		
		List<Employee> employees=new ArrayList<Employee>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps =conn.prepareStatement("SELECT * FROM employee WHERE nom like ? ");
			ps.setString(1,mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setId(rs.getInt("id"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
				e.setEmail(rs.getString("email"));
				e.setAge(rs.getInt("age"));
				e.setDatenaissance(rs.getString("date_naissance"));
				e.setSalaire(rs.getInt("salaire"));
				employees.add(e);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public Employee getEmployee(int id) {
		
		Connection conn=SingletonConnection.getConnection();
		Employee e=new Employee();
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM employee WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
				e.setId(rs.getInt("id"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
				e.setEmail(rs.getString("email"));
				e.setAge(rs.getInt("age"));
				e.setDatenaissance(rs.getString("date_naissance"));
				e.setSalaire(rs.getInt("salaire"));
			}
			ps.close();
			rs.close();
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		return e;
	}

	@Override
	public Employee update(Employee e) {
		
		Connection conn =SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("Update employee SET nom=?,prenom=?,email=?,age=?,date_naissance=?,salaire=? WHERE id=?");
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPrenom());
			ps.setString(3, e.getEmail());
			ps.setInt(4,e.getAge());
			ps.setString(5, e.getDatenaissance());
			ps.setInt(6,e.getSalaire());
			ps.setInt(7,e.getId());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		
		return e;
	}

	@Override
	public void deleteEmployee(int id) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("DELETE FROM employee WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> SelectALL() {
		
		List<Employee> employees=new ArrayList<Employee>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps =conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setId(rs.getInt("id"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
				e.setEmail(rs.getString("email"));
				e.setAge(rs.getInt("age"));
				e.setDatenaissance(rs.getString("date_naissance"));
				e.setSalaire(rs.getInt("salaire"));
				employees.add(e);
				
			}
			ps.close();
			rs.close();
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		
		return employees;
	}

}
