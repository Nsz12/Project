import java.util.*;

public class Student extends Person {
	private double GPA;
	private ArrayList<Course> Courses;
	private ArrayList<RegistrationManager> RegistrationManagers;

	public Student(String Name, int ID, String Major, double GPA) {
		super(Name, ID, Major);
		this.GPA = GPA;
		this.Courses = new ArrayList<Course>();
		this.RegistrationManagers = new ArrayList<RegistrationManager>();
	}

	public String ViewScheule() {
		String str = "";
		for (int i = 0; i < this.Courses.size(); i++)
			str += String.format("%s.%n", this.Courses.get(i).getTitle());
		return str;
	}

	public String ViewTranscript() {
		return this.toString();
	}

	public void AddCourse(int CRN) {
		for (int i = 0; i < this.getCourseOffering().size(); i++)
			if (this.getCourseOffering().get(i).getCRN() == CRN)
				this.Courses.add(this.getCourseOffering().get(i));
	}

	public void DropCourse(int CRN) {
		for (int i = 0; i < this.Courses.size(); i++)
			if (this.Courses.get(i).getCRN() == CRN)
				this.Courses.remove(i);
	}

	public Course SearchForCourse(Course course) {
		for (int i = 0; i < this.getCourseOffering().size(); i++)
			if (this.getCourseOffering().get(i).getCRN() == course.getCRN())
				return this.getCourseOffering().get(i);
		return null;
	}

	public double getGPA() {
		return this.GPA;
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}

	public ArrayList<Course> getCourses() {
		return this.Courses;
	}

	public int getEarnedHours() {
		int EarnedHours = 0;
		for (int i = 0; i < this.Courses.size(); i++)
			EarnedHours += Courses.get(i).getCreditHour();
		return EarnedHours;
	}

	public void AddRegistrationManager(RegistrationManager registrationManager) {
		this.RegistrationManagers.add(registrationManager);
	}

	public ArrayList<Course> getCourseOffering() {
		ArrayList<Course> Crs = new ArrayList<Course>();
		for (int i = 0; i < this.RegistrationManagers.size(); i++)
			for (int j = 0; j < this.RegistrationManagers.get(i).getCourseOffering().size(); j++)
				Crs.add(this.RegistrationManagers.get(i).getCourseOffering().get(j));
		return Crs;
	}

	public String ViewCourseOffering() {
		String str = "";
		for (int i = 0; i < this.getCourseOffering().size(); i++)
			str += String.format("%s%n", this.getCourseOffering().get(i).toString());
		return str;
	}

	@Override
	public String toString() {
		return String.format("%s  GPA: %.2f.", super.toString(), this.GPA);
	}
}