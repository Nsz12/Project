
//Person class has name of type String , ID of type integer , password of type String ,  
//major of type String , toString Method ,and  getter and setter methods.
public class Person {
	private String Name;
	private int ID;
	private String Password;
	private String Major;

	public Person(String Name, int ID, String Major) {
		this.Name = Name;
		this.ID = ID;
		this.Major = Major;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getMajor() {
		return this.Major;
	}

	public void setMajor(String Major) {
		this.Major = Major;
	}

	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	@Override
	public String toString() {
		return String.format("Name: %s.  ID: %d.  Major: %s.", this.Name, this.ID, this.Major);
	}
}