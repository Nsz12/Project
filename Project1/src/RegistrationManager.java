import java.util.*;

/*
 * RegistrationManager class (inherent Person class) has two attributes resgistrationState of type enum, 
	and CourseOffering array of type Course.
	It also has six methods which are OpenRegistration, CloseRegistration AssignFinalExaminationDateForACourse, 
	SetFinalExaminationLocationForACourse, 
	ArrangeCourses and AddCourseOffering.
*/
public class RegistrationManager extends Person {
	public enum ResgistrationState {
		Open, Closed
	}

	private ResgistrationState resgistrationState;
	private ArrayList<Course> CourseOffering;

	public RegistrationManager(String Name, int ID, String Major) {
		super(Name, ID, Major);
		this.CourseOffering = new ArrayList<Course>();
	}

	public String getResgistrationStateAsString() {
		return this.resgistrationState.toString();
	}

	public void OpenRegistration() {
		this.resgistrationState = ResgistrationState.Open;
	}

	public void CloseRegistration() {
		this.resgistrationState = ResgistrationState.Closed;
	}

	public void AssignFinalExaminationDateForACourse(Course course, String date) {
		course.setFinalExaminationDate(date);
	}

	public void SetFinalExaminationLocationForACourse(Course course, String location) {
		course.setFinalExaminationLocation(location);
	}

	public void ArrangeCourses() {
	}

	public ArrayList<Course> getCourseOffering() {
		return this.CourseOffering;
	}

	public void AddCourseOffering(Course course) {
		this.CourseOffering.add(course);
	}
}