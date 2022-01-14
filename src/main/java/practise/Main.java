package practise;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TeacherHelper th = new TeacherHelper();
        StudentHelper sh = new StudentHelper();
        StudyGroupHelper sgh = new StudyGroupHelper();

        List<TeacherEntity> list = th.listOfTeachers();

        for (TeacherEntity teacher: list) {
            System.out.println(teacher.getName() + " " + teacher.getPhoneNumber());
        }

        //th.deleteById(3);

        th.deleteCriteria();

        List<StudentEntity> list1 = sh.listOfStudents();
        System.out.println("Список студентов:");
        for (StudentEntity student: list1) {
            System.out.println(student.getName() + " " + student.getLastName());
        }

        List<StudyGroupEntity> list2 = sgh.listOfGroups();
        System.out.println("Список групп:");
        for (StudyGroupEntity group: list2) {
            System.out.println(group.getId() + " " + group.getNumber());
        }
    }
}
