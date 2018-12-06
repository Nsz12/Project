import java.util.*;

public class Course {
	private int CRN;
	private String Title;
	private int CreditHour;
	private int Capacity;
	private ArrayList<Student> Students;
	private Faculty Faculty;
	private ArrayList<Course> Pre_Requests;
	private String FinalExaminationDate;
	private String FinalExaminationLocation;

	public Course(String Title, int CRN, int CreditHour) {
		this.Title = Title;
		this.CRN = CRN;
		this.CreditHour = CreditHour;
		this.Students = new ArrayList<Student>();
		this.Pre_Requests = new ArrayList<Course>();
	}

	public int getCRN() {
		return this.CRN;
	}

	public String getTitle() {
		return this.Title;
	}

	public int getCapacity() {
		return this.Capacity;
	}

	public void setCapacity(int Capacity) {
		this.Capacity = Capacity;
	}

	public int getCreditHour() {
		return this.CreditHour;
	}

	public ArrayList<Student> getStudents() {
		return this.Students;
	}

	public void getStudents(ArrayList<Student> Students) {
		this.Students = Students;
	}

	public void AddStudent(Student student) {
		this.Students.add(student);
	}

	public Faculty getFaculty() {
		return this.Faculty;
	}

	public void setFaculty(Faculty Faculty) {
		this.Faculty = Faculty;
	}

	public ArrayList<Course> getPre_Requests() {
		return this.Pre_Requests;
	}

	public void setPre_Requests(ArrayList<Course> Pre_Requests) {
		this.Pre_Requests = Pre_Requests;
	}

	public String getFinalExaminationDate() {
		return this.FinalExaminationDate;
	}

	public void setFinalExaminationDate(String FinalExaminationDate) {
		this.FinalExaminationDate = FinalExaminationDate;
	}

	public String getFinalExaminationLocation() {
		return this.FinalExaminationLocation;
	}

	public void setFinalExaminationLocation(String FinalExaminationLocation) {
		this.FinalExaminationLocation = FinalExaminationLocation;
	}

	@Override
	public String toString() {
		return String.format("Title: %s.  CRN: %d.  CreditHours: %d.", this.Title, this.CRN, this.CreditHour);
	}
}