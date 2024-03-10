package web;


import java.util.List;

import javax.faces.bean.ManagedBean;
import Dao.EmployeeDaoImpl;
import metier.enteties.Employee;

import javax.faces.view.ViewScoped;


@ManagedBean(name="employeeModelAdd")
@ViewScoped
public class EmployeeModelAdd {
    private Employee employee=new Employee();
	private EmployeeDaoImpl edi=new EmployeeDaoImpl();
	private String message="";
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	boolean emailExiste(String email) {
	    List<Employee> employees = edi.SelectALL();
	    for (Employee emp : employees) {
	        if (email.equals(emp.getEmail())) {
	           
	            return true;
	        }
	    }
	    
	    return false;
	}

	public String AjouterEmployee() {
		
		if (emailExiste(employee.getEmail())) {
	        message="Changer l'email : cet email existe déjà.";
			return null;
	    }
		
		edi.save(employee);
		return "employee";
			
		}
	
	


}
