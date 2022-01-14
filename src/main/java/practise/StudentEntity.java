package practise;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "academy", catalog = "")
public class StudentEntity {
    private int id;
    private String name;
    private String lastName;
    private StudyGroupEntity study_group;

    @ManyToOne
    @JoinColumn(name = "study_group_id")
    public StudyGroupEntity getStudy_group() {
        return study_group;
    }

    public void setStudy_group(StudyGroupEntity study_group) {
        this.study_group = study_group;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName);
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", study_group=" + study_group +
                '}';
    }
}
