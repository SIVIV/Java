package universityDB.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Colleague {
    @Column(name = "average_grade")
    private Double averageGrade;

    @Column(name = "attendance_points")
    private Integer attendance;

    @ManyToMany
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id" ),
            inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id"))
    private Set<Course> coursesEnrolled;

    public Double getAverageGrade() {
        return this.averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public Integer getAttendance() {
        return this.attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public Set<Course> getCoursesEnrolled() {
        return this.coursesEnrolled;
    }

    public void setCoursesEnrolled(Set<Course> enrolledCourses) {
        this.coursesEnrolled = enrolledCourses;
    }
}
