import java.util.*;

//Faculty class (inherent Person class) has courses attribute array of type Course and three methods ViewSchedule,
//ViewCourseStudents, AssignGrade and SendWarning

public class Faculty extends Person {
	private ArrayList<Course> Courses;

	public Faculty(String Name, int ID, String Major) {
		super(Name, ID, Major);
		this.Courses = new ArrayList<Course>();
	}

	public String ViewSchedule() {
		String str = "";
		for (int i = 0; i < this.Courses.size(); i++)
			str += String.format("%s.%n", this.Courses.get(i).getTitle());
		return str;
	}

	public String ViewCourseStudents(Course course) {
		String str = "";
		for (int i = 0; i < this.Courses.size(); i++)
			if (this.Courses.get(i).equals(course))
				for (int j = 0; j < this.Courses.get(i).getStudents().size(); j++)
					str += String.format("%s.%n", this.Courses.get(i).getStudents().get(j).getName());
		return str;
	}

	public void AssignGrade(Student student, String grade) {
	}

	public void SendWarning(Student student, String warning) {
	}

	public ArrayList<Course> getCourses() {
		return this.Courses;
	}

	public void setCourses(ArrayList<Course> Courses) {
		this.Courses = Courses;
	}
}