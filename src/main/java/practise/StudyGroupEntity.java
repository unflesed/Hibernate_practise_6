package practise;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "study_group", schema = "academy", catalog = "")
public class StudyGroupEntity {
    private int id;
    private int number;
    private List<StudentEntity> students = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "study_group", fetch = FetchType.EAGER)
    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyGroupEntity that = (StudyGroupEntity) o;
        return id == that.id && number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }

    @Override
    public String toString() {
        return "StudyGroupEntity{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
