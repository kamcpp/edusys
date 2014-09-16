package org.labcrypto.edusys.domain.jpa.entity.education;

import org.labcrypto.edusys.domain.jpa.DomainConstants;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "tag", schema = "education")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "english_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
    private String englishName;
    @Column(name = "persian_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
    private String persianName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_tag_id", nullable = true)
    private Tag parent;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
    private Set<Tag> children;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tags")
    private Set<Course> courses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getPersianName() {
        return persianName;
    }

    public void setPersianName(String persianName) {
        this.persianName = persianName;
    }

    public Tag getParent() {
        return parent;
    }

    public void setParent(Tag parent) {
        this.parent = parent;
    }

    public Set<Tag> getChildren() {
        return children;
    }

    public void setChildren(Set<Tag> children) {
        this.children = children;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
