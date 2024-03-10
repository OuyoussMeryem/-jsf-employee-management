package metier.enteties;

public class Employee {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private int age;
	private String datenaissance;
	private int salaire;

    


	public String getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

	public Employee(String nom, String prenom, String email, int age, String datenaissance, int salaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.age = age;
		this.datenaissance = datenaissance;
		this.salaire = salaire;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", age=" + age + "]";
	}
	

}
