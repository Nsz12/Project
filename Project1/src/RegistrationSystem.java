import java.util.Random;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

/*
RegistrationSystem class which is a class to display the interfaces as scenes using JavaFX, 
it has four attribute object arrays which they are Students, Faculties,
RegistrationManagers and Courses which each array of type its class.
Each element of these arrays has been created most of its attributes randomly.
It also has a lot of methods which switch between scenes and other tasks.
*/

public class RegistrationSystem extends Application {
	static Student[] Students;
	static Faculty[] Faculties;
	static RegistrationManager[] RegistrationManagers;
	static Course[] Courses;

	public static void main(String[] args) throws InterruptedException {
		Students = new Student[6];
		Faculties = new Faculty[4];
		RegistrationManagers = new RegistrationManager[2];
		Courses = new Course[5];
		Students[0] = new Student(name(), id(), "SWE", gpa());
		Students[1] = new Student(name(), id(), "MATH", gpa());
		Students[2] = new Student(name(), id(), major(), gpa());
		Students[3] = new Student(name(), id(), major(), gpa());
		Students[4] = new Student(name(), id(), major(), gpa());
		Students[5] = new Student(name(), id(), major(), gpa());
		Faculties[0] = new Faculty(name(), id(), "SWE");
		Faculties[1] = new Faculty(name(), id(), "MATH");
		Faculties[2] = new Faculty(name(), id(), major());
		Faculties[3] = new Faculty(name(), id(), major());
		RegistrationManagers[0] = new RegistrationManager(name(), id(), "SWE");
		RegistrationManagers[1] = new RegistrationManager(name(), id(), "MATH");
		Courses[0] = new Course("SWE101", crn(), 4);
		Courses[1] = new Course("MATH101", crn(), 4);
		Courses[2] = new Course(title(), crn(), crh());
		Courses[3] = new Course(title(), crn(), crh());
		Courses[4] = new Course(title(), crn(), crh());
		for (int i = 0; i < Courses.length; i++)
			if (Courses[i].getTitle().charAt(0) == 'S')
				RegistrationManagers[0].AddCourseOffering(Courses[i]);
			else if (Courses[i].getTitle().charAt(0) == 'M')
				RegistrationManagers[1].AddCourseOffering(Courses[i]);
		for (int i = 0; i < Students.length; i++) {
			Students[i].AddRegistrationManager(RegistrationManagers[0]);
			Students[i].AddRegistrationManager(RegistrationManagers[1]);
		}
		for (int i = 0; i < Students.length; i++)
			Students[i].setPassword("password");
		for (int i = 0; i < Faculties.length; i++)
			Faculties[i].setPassword("password");
		for (int i = 0; i < RegistrationManagers.length; i++)
			RegistrationManagers[i].setPassword("password");
		launch(args);
	}

	private static String title() {
		return String.format("%s%d", major(), (int) (Math.random() * 389) + 101);
	}

	private static int crh() {
		return (int) (Math.random() * 4) + 1;
	}

	private static int crn() {
		return (int) (Math.random() * 33333);
	}

	private static String major() {
		String[] majors = { "SWE", "MATH" };
		Random r = new Random();
		int n = r.nextInt(100) + 1;
		if (n >= 50)
			return majors[0];
		else
			return majors[1];
	}

	private static double gpa() {
		return Math.random() * 4;
	}

	private static int id() {
		return 201000000 + (int) (Math.random() * 999999);
	}

	private static String name() {
		String[] names = { "Ali", "Ahmed", "Turki", "Fahad", "Abdullah", "Hussain", "Mohammed", "Saed" };
		return String.format("%s %s", names[(int) (Math.random() * 7)], names[(int) (Math.random() * 7)]);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Registrar Services");
		RegistrarServicesScene(stage);
		stage.show();
	}

	private void RegistrarServicesScene(Stage stage) {
		Image KFUPMImage = new Image("kfupm_logo.png", 150, 150, true, true);
		ImageView KFUPMImageView = new ImageView(KFUPMImage);
		KFUPMImageView.setFitHeight(150);
		KFUPMImageView.setFitWidth(150);
		Label UsernameLabel = new Label("Username:");
		UsernameLabel.setPrefSize(74, 21);
		UsernameLabel.setAlignment(Pos.CENTER_LEFT);
		TextField UsernameTextField = new TextField();
		UsernameTextField.setPrefSize(187, 31);
		UsernameTextField.setAlignment(Pos.CENTER);
		Label PasswordLabel = new Label("Password:");
		PasswordLabel.setPrefSize(74, 21);
		PasswordLabel.setAlignment(Pos.CENTER_LEFT);
		PasswordField PasswordTextField = new PasswordField();
		PasswordTextField.setPrefSize(187, 31);
		PasswordTextField.setAlignment(Pos.CENTER_LEFT);
		Button LoginButton = new Button("Log in");
		LoginButton.setPrefSize(61, 31);
		Button ShowUsersIDsButton = new Button("Show Users IDs");
		ShowUsersIDsButton.setPrefSize(122, 31);
		Button ChangePasswordButton = new Button("Change password");
		ChangePasswordButton.setPrefSize(152, 31);
		HBox UsernameHBox = new HBox();
		UsernameHBox.setPrefSize(600, 100);
		UsernameHBox.getChildren().addAll(UsernameLabel, UsernameTextField);
		UsernameHBox.setAlignment(Pos.CENTER);
		HBox PasswordHBox = new HBox();
		PasswordHBox.setPrefSize(600, 100);
		PasswordHBox.setAlignment(Pos.CENTER);
		UsernameHBox.getChildren().addAll(PasswordLabel, PasswordTextField);
		VBox RegistrarServicesLayout = new VBox();
		RegistrarServicesLayout.setPrefSize(600, 480);
		Text NoteText = new Text("The username is the ID");
		NoteText.setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, 14));
		Text NoteText2 = new Text(
				"The default password is \"password\", you can change it by clicking on \"Change password\" Button.");
		NoteText2.setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, 14));
		RegistrarServicesLayout.getChildren().addAll(KFUPMImageView, UsernameHBox, NoteText, NoteText2, PasswordHBox,
				LoginButton, ShowUsersIDsButton, ChangePasswordButton);
		RegistrarServicesLayout.setAlignment(Pos.CENTER);
		RegistrarServicesLayout.setPadding(new Insets(30));
		RegistrarServicesLayout.setSpacing(24);
		Scene RegistrarServicesScene = new Scene(RegistrarServicesLayout, 600, 480);
		LoginButton.setOnAction(e -> {
			if (UsernameTextField.getText().isEmpty())
				ShowMessage("Enter the username", 300, 150);
			else if (PasswordTextField.getText().isEmpty())
				ShowMessage("Enter the password", 300, 150);
			else {
				if (UsernameTextField.getText().charAt(0) == 's'
						&& !getStudent(UsernameTextField.getText()).equals(null)) {
					if (getStudent(UsernameTextField.getText()).getPassword().equals(PasswordTextField.getText()))
						StudentScene(stage, getStudent(UsernameTextField.getText()));
					else {
						ShowMessage("Wrong password, try again!!!", 300, 150);
						PasswordTextField.setText("");
					}
				} else if (UsernameTextField.getText().charAt(0) == 'f'
						&& !getFaculty(UsernameTextField.getText()).equals(null)) {
					if (getFaculty(UsernameTextField.getText()).getPassword().equals(PasswordTextField.getText()))
						FacultyScene(stage, getFaculty(UsernameTextField.getText()));
					else {
						ShowMessage("Wrong password, try again!!!", 300, 150);
						PasswordTextField.setText("");
					}
				} else if (UsernameTextField.getText().charAt(0) == 'm'
						&& !getRegistrationManager(UsernameTextField.getText()).equals(null)) {
					if (getRegistrationManager(UsernameTextField.getText()).getPassword()
							.equals(PasswordTextField.getText()))
						RegistrationManagerScene(stage, getRegistrationManager(UsernameTextField.getText()));
					else {
						ShowMessage("Wrong password, try again!!!", 300, 150);
						PasswordTextField.setText("");
					}
				} else {
					ShowMessage("Wrong username, try again!!!", 300, 150);
					UsernameTextField.setText("");
					PasswordTextField.setText("");
				}
			}
		});
		ShowUsersIDsButton.setOnAction(e -> ShowUsersIDs());
		ChangePasswordButton.setOnAction(e -> ChangePasswordPopWindow());
		stage.setScene(RegistrarServicesScene);
	}

	private void ShowUsersIDs() {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initStyle(StageStyle.UTILITY);
		stage.setTitle("IDs of users");
		stage.setMinWidth(600);
		stage.setMinHeight(560);
		VBox r = new VBox(10);
		r.setBackground(null);
		Label[] l = new Label[12];
		TextField[] t = new TextField[12];
		HBox[] h = new HBox[12];
		int j = 11;
		for (int i = 0; i < Students.length; i++) {
			l[j] = new Label(Students[i].getName() + ":");
			t[j] = new TextField("s" + Students[i].getID());
			h[j] = new HBox(50);
			h[j].getChildren().addAll(l[j], t[j]);
			h[j].setAlignment(Pos.CENTER);
			r.getChildren().add(h[j]);
			r.setAlignment(Pos.CENTER);
			j--;
		}
		for (int i = 0; i < Faculties.length; i++) {
			l[j] = new Label("Dr." + Faculties[i].getName() + ":");
			t[j] = new TextField("f" + Faculties[i].getID());
			h[j] = new HBox(50);
			h[j].getChildren().addAll(l[j], t[j]);
			h[j].setAlignment(Pos.CENTER);
			r.getChildren().add(h[j]);
			r.setAlignment(Pos.CENTER);
			j--;
		}
		for (int i = 0; i < RegistrationManagers.length; i++) {
			l[j] = new Label("Mr." + RegistrationManagers[i].getName() + ":");
			t[j] = new TextField("m" + RegistrationManagers[i].getID());
			h[j] = new HBox(50);
			h[j].getChildren().addAll(l[j], t[j]);
			h[j].setAlignment(Pos.CENTER);
			r.getChildren().add(h[j]);
			r.setAlignment(Pos.CENTER);
			j--;
		}
		Button btn = new Button("Close");
		btn.setOnAction(e -> stage.close());
		r.getChildren().add(btn);
		r.setAlignment(Pos.CENTER);
		r.setPrefSize(600, 560);
		Scene s = new Scene(r, 600, 560);
		stage.setScene(s);
		stage.showAndWait();
	}

	private void StudentScene(Stage stage, Student student) {
		VBox StudentLayout = new VBox();
		StudentLayout.setPadding(new Insets(10));
		StudentLayout.setSpacing(8);
		Text StudentText = new Text("Student: " + student.getName());
		StudentText.setFont(Font.font("Arial", FontWeight.BOLD, 35));
		StudentLayout.getChildren().add(StudentText);
		Button StudentButtons[] = new Button[] { new Button("Add a course"), new Button("Drop a course"),
				new Button("View schedule"), new Button("Search for a course"), new Button("View Transcript detail"),
				new Button("View course offering"), new Button("Log out") };
		for (int i = 0; i < StudentButtons.length; i++) {
			VBox.setMargin(StudentButtons[i], new Insets(0, 0, 0, 8));
			StudentLayout.getChildren().add(StudentButtons[i]);
		}
		Scene StudentScene = new Scene(StudentLayout, 600, 430);
		StudentButtons[0].setOnAction(e -> {
			Addcourse(student);
		});
		StudentButtons[1].setOnAction(e -> {
			Dropcourse(student);
		});
		StudentButtons[2]
				.setOnAction(e -> ShowMessage(StudentButtons[2].getText() + " is not available yet!!!", 300, 150));
		StudentButtons[3].setOnAction(e -> {
			SearchForCourse(student);
		});
		StudentButtons[4]
				.setOnAction(e -> ShowMessage(StudentButtons[4].getText() + " is not available yet!!!", 300, 150));
		StudentButtons[5].setOnAction(e -> {
			ViewCourseOffering(student);
		});
		StudentButtons[6].setOnAction(e -> RegistrarServicesScene(stage));
		stage.setScene(StudentScene);
	}

	private void SearchForCourse(Student student) {
		Stage stage = new Stage();
		stage.setTitle("Search For A Course");
		stage.setMinWidth(375);
		stage.setMinHeight(282);
		VBox r = new VBox(20);
		Label l = new Label("Departments:");
		Button[] b = new Button[RegistrationManagers.length + 1];
		for (int i = 0; i < b.length - 1; i++) {
			b[i] = new Button(RegistrationManagers[i].getMajor());
			RegistrationManager registrationManager = RegistrationManagers[i];
			b[i].setOnAction(e -> {
				CoursesOf(registrationManager);
				stage.close();
			});
		}
		b[b.length - 1] = new Button("Close");
		b[b.length - 1].setOnAction(e -> stage.close());
		r.getChildren().add(l);
		r.getChildren().addAll(b);
		r.setAlignment(Pos.CENTER);
		r.setPrefSize(375, 282);
		Scene s = new Scene(r, 375, 282);
		stage.setScene(s);
		stage.showAndWait();
	}

	private void CoursesOf(RegistrationManager registrationManager) {
		Stage stage = new Stage();
		stage.setTitle(registrationManager.getMajor() + "\'s Courses");
		stage.setMinWidth(375);
		stage.setMinHeight(282);
		VBox r = new VBox(20);
		Label l = new Label(registrationManager.getMajor() + "\'s Courses");
		Button[] b = new Button[registrationManager.getCourseOffering().size() + 1];
		for (int i = 0; i < b.length - 1; i++) {
			b[i] = new Button(registrationManager.getCourseOffering().get(i).getTitle());
			Course course = registrationManager.getCourseOffering().get(i);
			b[i].setOnAction(e -> {
				ShowMessage(course.toString(), 350, 150);
				stage.close();
			});
		}
		b[b.length - 1] = new Button("Close");
		b[b.length - 1].setOnAction(e -> stage.close());
		r.getChildren().add(l);
		r.getChildren().addAll(b);
		r.setAlignment(Pos.CENTER);
		r.setPrefSize(375, 282);
		Scene s = new Scene(r, 375, 282);
		stage.setScene(s);
		stage.showAndWait();
	}

	private void Dropcourse(Student student) {
		Stage stage = new Stage();
		stage.setTitle("Drop A Course");
		stage.setMinWidth(375);
		stage.setMinHeight(188);
		VBox r = new VBox(20);
		r.setBackground(null);
		Label l = new Label("Fill the spaces with course CRNs you want to drop:");
		r.getChildren().add(l);
		TextField[] t = new TextField[4];
		HBox h = new HBox(10);
		for (int i = 0; i < t.length; i++) {
			t[i] = new TextField();
			h.getChildren().add(t[i]);
		}
		Button[] b = new Button[2];
		b[0] = new Button("Submit");
		b[1] = new Button("Cancel");
		b[0].setOnAction(e -> {
			for (int i = 0; i < t.length; i++)
				if (!t[i].getText().isEmpty())
					student.DropCourse(Integer.parseInt(t[i].getText()));
			ShowMessage("Courses has been dropped!!", 300, 150);
		});
		b[1].setOnAction(e -> stage.close());
		r.getChildren().addAll(h, b[0], b[1]);
		r.setAlignment(Pos.CENTER);
		r.setPrefSize(375, 188);
		Scene s = new Scene(r, 375, 188);
		stage.setScene(s);
		stage.showAndWait();
	}

	private void ViewCourseOffering(Student student) {
		Stage stage = new Stage();
		VBox r = new VBox(20);
		TextArea t = new TextArea();
		t.setText(student.ViewCourseOffering());
		Button btn = new Button("Close");
		btn.setOnAction(e -> stage.close());
		r.getChildren().addAll(t, btn);
		r.setAlignment(Pos.CENTER);
		r.setPrefSize(400, 200);
		Scene s = new Scene(r, 400, 200);
		stage.setScene(s);
		stage.showAndWait();
	}

	private void Addcourse(Student student) {
		Stage stage = new Stage();
		stage.setTitle("Add A Course");
		stage.setMinWidth(1000);
		stage.setMinHeight(188);
		VBox r = new VBox(20);
		r.setBackground(null);
		Label l = new Label("Fill the spaces with course CRNs you want to add:");
		r.getChildren().add(l);
		TextField[] t = new TextField[8];
		HBox h = new HBox(10);
		for (int i = 0; i < t.length; i++) {
			t[i] = new TextField();
			h.getChildren().add(t[i]);
		}
		Button[] b = new Button[2];
		b[0] = new Button("Submit");
		b[1] = new Button("Cancel");
		b[0].setOnAction(e -> {
			for (int i = 0; i < t.length; i++)
				if (!t[i].getText().isEmpty())
					student.AddCourse(Integer.parseInt(t[i].getText()));
			ShowMessage("Courses has been added!!", 300, 150);
		});
		b[1].setOnAction(e -> stage.close());
		r.getChildren().addAll(h, b[0], b[1]);
		r.setAlignment(Pos.CENTER);
		r.setPrefSize(600, 560);
		Scene s = new Scene(r, 1000, 188);
		stage.setScene(s);
		stage.showAndWait();
	}

	private void FacultyScene(Stage stage, Faculty faculty) {
		VBox FacultyLayout = new VBox();
		FacultyLayout.setPadding(new Insets(10));
		FacultyLayout.setSpacing(8);
		Text FacultyText = new Text("Faculty: Dr." + faculty.getName());
		FacultyText.setFont(Font.font("Arial", FontWeight.BOLD, 35));
		FacultyLayout.getChildren().add(FacultyText);
		Button FacultyButtons[] = new Button[] { new Button("View schedule"), new Button("View course students"),
				new Button("Assign a grade"), new Button("Send warning"), new Button("Log out") };
		for (int i = 0; i < FacultyButtons.length; i++) {
			VBox.setMargin(FacultyButtons[i], new Insets(0, 0, 0, 8));
			FacultyLayout.getChildren().add(FacultyButtons[i]);
		}
		Scene FacultyScene = new Scene(FacultyLayout, 600, 430);
		FacultyButtons[0]
				.setOnAction(e -> ShowMessage(FacultyButtons[0].getText() + " is not available yet!!!", 300, 150));
		FacultyButtons[1]
				.setOnAction(e -> ShowMessage(FacultyButtons[1].getText() + " is not available yet!!!", 300, 150));
		FacultyButtons[2]
				.setOnAction(e -> ShowMessage(FacultyButtons[2].getText() + " is not available yet!!!", 300, 150));
		FacultyButtons[3]
				.setOnAction(e -> ShowMessage(FacultyButtons[3].getText() + " is not available yet!!!", 300, 150));
		FacultyButtons[4].setOnAction(e -> RegistrarServicesScene(stage));
		stage.setScene(FacultyScene);
	}

	private void RegistrationManagerScene(Stage stage, RegistrationManager registrationManager) {
		VBox RegistrationManagerLayout = new VBox();
		RegistrationManagerLayout.setPadding(new Insets(10));
		RegistrationManagerLayout.setSpacing(8);
		Text RegistrationManagerText = new Text("Course Management: Mr." + registrationManager.getName());
		RegistrationManagerText.setFont(Font.font("Arial", FontWeight.BOLD, 35));
		RegistrationManagerLayout.getChildren().add(RegistrationManagerText);
		Button RegistrationManagerButtons[] = new Button[] { new Button("Open the registration"),
				new Button("Close the registration"), new Button("Control the capacity of courses"),
				new Button("Assign final exam date"), new Button("Arrange courses schedule"),
				new Button("View course offering"), new Button("Set final exam location"), new Button("Log out") };
		for (int i = 0; i < RegistrationManagerButtons.length; i++) {
			VBox.setMargin(RegistrationManagerButtons[i], new Insets(0, 0, 0, 8));
			RegistrationManagerLayout.getChildren().add(RegistrationManagerButtons[i]);
		}
		Scene RegistrationManagerScene = new Scene(RegistrationManagerLayout, 650, 430);
		RegistrationManagerButtons[0].setOnAction(
				e -> ShowMessage(RegistrationManagerButtons[0].getText() + " is not available yet!!!", 300, 150));
		RegistrationManagerButtons[1].setOnAction(
				e -> ShowMessage(RegistrationManagerButtons[1].getText() + " is not available yet!!!", 300, 150));
		RegistrationManagerButtons[2].setOnAction(
				e -> ShowMessage(RegistrationManagerButtons[2].getText() + " is not available yet!!!", 300, 150));
		RegistrationManagerButtons[3].setOnAction(
				e -> ShowMessage(RegistrationManagerButtons[3].getText() + " is not available yet!!!", 300, 150));
		RegistrationManagerButtons[4].setOnAction(
				e -> ShowMessage(RegistrationManagerButtons[4].getText() + " is not available yet!!!", 300, 150));
		RegistrationManagerButtons[5].setOnAction(
				e -> ShowMessage(RegistrationManagerButtons[5].getText() + " is not available yet!!!", 300, 150));
		RegistrationManagerButtons[6].setOnAction(
				e -> ShowMessage(RegistrationManagerButtons[6].getText() + " is not available yet!!!", 300, 150));
		RegistrationManagerButtons[7].setOnAction(e -> RegistrarServicesScene(stage));
		stage.setScene(RegistrationManagerScene);
	}

	private void ChangePasswordPopWindow() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.initStyle(StageStyle.UTILITY);
		window.setTitle("Changing Password");
		window.setMinWidth(300);
		window.setMinHeight(250);
		Label lbl = new Label("Username:");
		TextField tf = new TextField();
		Label lbl2 = new Label("New password:");
		TextField tf2 = new TextField();
		Button btn = new Button("Change password");
		btn.setOnAction(e -> {
			if (tf.getText().charAt(0) == 's' && !getStudent(tf.getText()).equals(null)) {
				getStudent(tf.getText()).setPassword(tf2.getText());
				ShowMessage("Password of " + getStudent(tf.getText()) + " has been changed!!!", 700, 150);
				window.close();
			} else if (tf.getText().charAt(0) == 'f' && !getFaculty(tf.getText()).equals(null)) {
				getFaculty(tf.getText()).setPassword(tf2.getText());
				ShowMessage("Password of Dr." + getFaculty(tf.getText()) + " has been changed!!!", 700, 150);
				window.close();
			} else if (tf.getText().charAt(0) == 'm' && !getRegistrationManager(tf.getText()).equals(null)) {
				getRegistrationManager(tf.getText()).setPassword(tf2.getText());
				ShowMessage("Password of Mr." + getRegistrationManager(tf.getText()) + " has been changed!!!", 700,
						150);
				window.close();
			} else {
				ShowMessage("Wrong username, try again!!!", 300, 150);
				tf.setText("");
				tf2.setText("");
			}
		});
		VBox r = new VBox(10);
		r.setBackground(null);
		r.getChildren().addAll(lbl, tf, lbl2, tf2, btn);
		r.setAlignment(Pos.CENTER);
		Scene s = new Scene(r, Color.GAINSBORO);
		window.setScene(s);
		window.showAndWait();
	}

	private void ShowMessage(String message, int width, int hieght) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.initStyle(StageStyle.UTILITY);
		window.setTitle("Important information!!!");
		window.setMinWidth(width);
		window.setMinHeight(hieght);
		Text t = new Text(message);
		Button btn = new Button("Close");
		btn.setOnAction(e -> window.close());
		VBox r = new VBox(10);
		r.setBackground(null);
		r.getChildren().addAll(t, btn);
		r.setAlignment(Pos.CENTER);
		Scene s = new Scene(r, Color.GAINSBORO);
		window.setScene(s);
		window.showAndWait();
	}

	private Student getStudent(String id) {
		int ID = Integer.parseInt(id.substring(1));
		for (int i = 0; i < Students.length; i++)
			if (Students[i].getID() == ID)
				return Students[i];
		return null;
	}

	private Faculty getFaculty(String id) {
		int ID = Integer.parseInt(id.substring(1));
		for (int i = 0; i < Faculties.length; i++)
			if (Faculties[i].getID() == ID)
				return Faculties[i];
		return null;
	}

	private RegistrationManager getRegistrationManager(String id) {
		int ID = Integer.parseInt(id.substring(1));
		for (int i = 0; i < RegistrationManagers.length; i++)
			if (RegistrationManagers[i].getID() == ID)
				return RegistrationManagers[i];
		return null;
	}
}