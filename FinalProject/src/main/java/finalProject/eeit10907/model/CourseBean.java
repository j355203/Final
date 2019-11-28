package finalProject.eeit10907.model;

import java.util.Date;

public class CourseBean {
	private static final long serialVersionUID=1L;
	
	private int courseID; //查詢：學門名稱
	private int SubjectID;//入表格：學門名稱
	private String SubjectName;//入表格：學門分數
	private String CourseName;//查詢：學門名稱
	private Date StartDateTime;//查詢：課程名稱
	private Date EndDateTime; //查詢：開始時間
	private int RoomID;//查詢：結束時間
	private String RoomName;//入表格：學門名稱
	private String URL;//入表格：課程名稱
	private String CourseSummary;//入表格：滿意度
	private int SignUp;//入表格：滿意度
	private int SignUpT;//入表格：滿意度
	private int Credits;//入表格：滿意度
	private float Satisfaction;//入表格：滿意度
	private float SatisTeacher;//入表格：滿意度
	private float SatisContent;//入表格：滿意度
	private float SatisTeacherQ1;//入表格：滿意度
	private float SatisTeacherQ2;//入表格：滿意度
	private float SatisContentQ1;//入表格：滿意度
	private float SatisContentQ2;//入表格：滿意度
	
	
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getSubjectID() {
		return SubjectID;
	}
	public void setSubjectID(int subjectID) {
		SubjectID = subjectID;
	}
	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public Date getStartDateTime() {
		return StartDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		StartDateTime = startDateTime;
	}
	public Date getEndDateTime() {
		return EndDateTime;
	}
	public void setEndDateTime(Date endDateTime) {
		EndDateTime = endDateTime;
	}
	public int getRoomID() {
		return RoomID;
	}
	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
	public String getRoomName() {
		return RoomName;
	}
	public void setRoomName(String roomName) {
		RoomName = roomName;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getCourseSummary() {
		return CourseSummary;
	}
	public void setCourseSummary(String courseSummary) {
		CourseSummary = courseSummary;
	}
	public int getSignUp() {
		return SignUp;
	}
	public void setSignUp(int signUp) {
		SignUp = signUp;
	}
	public int getSignUpT() {
		return SignUpT;
	}
	public void setSignUpT(int signUpT) {
		SignUpT = signUpT;
	}
	public int getCredits() {
		return Credits;
	}
	public void setCredits(int credits) {
		Credits = credits;
	}
	public float getSatisfaction() {
		return Satisfaction;
	}
	public void setSatisfaction(float satisfaction) {
		Satisfaction = satisfaction;
	}
	public float getSatisTeacher() {
		return SatisTeacher;
	}
	public void setSatisTeacher(float satisTeacher) {
		SatisTeacher = satisTeacher;
	}
	public float getSatisContent() {
		return SatisContent;
	}
	public void setSatisContent(float satisContent) {
		SatisContent = satisContent;
	}
	public float getSatisTeacherQ1() {
		return SatisTeacherQ1;
	}
	public void setSatisTeacherQ1(float satisTeacherQ1) {
		SatisTeacherQ1 = satisTeacherQ1;
	}
	public float getSatisTeacherQ2() {
		return SatisTeacherQ2;
	}
	public void setSatisTeacherQ2(float satisTeacherQ2) {
		SatisTeacherQ2 = satisTeacherQ2;
	}
	public float getSatisContentQ1() {
		return SatisContentQ1;
	}
	public void setSatisContentQ1(float satisContentQ1) {
		SatisContentQ1 = satisContentQ1;
	}
	public float getSatisContentQ2() {
		return SatisContentQ2;
	}
	public void setSatisContentQ2(float satisContentQ2) {
		SatisContentQ2 = satisContentQ2;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
