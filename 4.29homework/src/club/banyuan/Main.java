package club.banyuan;
import club.banyuan.stu.Pupil;
import club.banyuan.stu.MiddleSchoolStudent;
import club.banyuan.stu.HighSchoolStudent;

public class Main {

    public static void main(String[] args) {
        Pupil pupil = new Pupil("张三");
        MiddleSchoolStudent middleSchoolStudent = new MiddleSchoolStudent("李四");
        HighSchoolStudent highSchoolStudent = new HighSchoolStudent("王五");

        pupil.methodStudy();
        middleSchoolStudent.methodStudy();
        highSchoolStudent.methodStudy();


    }
}
