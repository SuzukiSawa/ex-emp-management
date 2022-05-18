package jp.co.sample.domain;

public class Employee {

	private Integer id;
	private String name;
	private String image;
	private String gender;
	private java.util.Date hiredate;
	private String mailAddress;
	private String zipcode;
	private String address;
	private String telephone;
	private Integer salary;
	private String characteristics;
	private Integer dependents_count;

	Employee() {

	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", image=" + image + ", gender=" + gender + ", hiredate="
				+ hiredate + ", mailAddress=" + mailAddress + ", zipcode=" + zipcode + ", address=" + address
				+ ", telephone=" + telephone + ", salary=" + salary + ", characteristics=" + characteristics
				+ ", dependents_count=" + dependents_count + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public java.util.Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(java.util.Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public Integer getDependents_count() {
		return dependents_count;
	}

	public void setDependents_count(Integer dependents_count) {
		this.dependents_count = dependents_count;
	}

}
