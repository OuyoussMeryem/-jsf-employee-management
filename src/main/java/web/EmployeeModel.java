package web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import Dao.EmployeeDaoImpl;
import metier.enteties.Employee;

@ManagedBean(name="employeeModel")
@SessionScoped
public class EmployeeModel {
    private Employee employee;
    private EmployeeDaoImpl edi=new EmployeeDaoImpl();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> fingAllEmployee() {
		List<Employee> employees=edi.SelectALL();
		return employees;
	}
	
	public String deleteEmployee(Employee emp) {
		edi.deleteEmployee(emp.getId());
		return "employee";
	}
	
	public String modifier(Employee emp) {
        this.employee=edi.getEmployee(emp.getId());
        
        return "modifier-employee";
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
	
	public String ModifierEmployee() {
		if (emailExiste(employee.getEmail())) {
			return null;
	    }
		
		edi.update(employee);
		return "employee";
	}
	
}
