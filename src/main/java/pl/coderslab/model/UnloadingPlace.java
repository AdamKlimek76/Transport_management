package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "unloading_places")
public class UnloadingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String company;
    @NotEmpty
    private String postCode;

    private String post;
    @NotEmpty
    private String place;
    @NotEmpty
    private String country;

    private String alias;

    public UnloadingPlace(@NotEmpty String company, @NotEmpty String postCode, String post, @NotEmpty String place, @NotEmpty String country, String alias) {
        this.company = company;
        this.postCode = postCode;
        this.post = post;
        this.place = place;
        this.country = country;
        this.alias = alias;
    }

    public UnloadingPlace(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "UnloadingPlace{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", postCode='" + postCode + '\'' +
                ", post='" + post + '\'' +
                ", place='" + place + '\'' +
                ", country='" + country + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
