package Dao;

import java.util.List;

import metier.enteties.Employee;

public interface IEmployeeDao {
	public Employee save(Employee e);
	public List<Employee> employeeParMC(String mc);
	public Employee getEmployee(int id);
	public Employee update(Employee e);
	public void deleteEmployee(int id);
	public List<Employee> SelectALL();
}
