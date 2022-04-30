package com.crabee.backend.model;

import javax.persistence.*;

@Entity(name = "Company")
@Table(name = "Company",
        uniqueConstraints = {
        @UniqueConstraint(name = "company_name_unique", columnNames = "company_name")
        }
)
public class Company {
    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "company_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "company_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "introduction",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String intro;

    @Column(
            name = "website",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String link;

    public Company() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public Company(Long id, String name, String intro, String link) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.link = link;
    }
    public Company(String name, String intro, String link) {
        this.name = name;
        this.intro = intro;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
