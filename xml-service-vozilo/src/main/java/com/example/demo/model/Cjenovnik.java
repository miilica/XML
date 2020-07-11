package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cjenovnik {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double cijenaPoDanu;

    @Column
    private double cijenaPoKM;

    @Column
    private double cijenaCDW;

    @Column
    private double popust;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cjenovnik", fetch = FetchType.LAZY)
    private Set<Oglas> oglasi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCijenaPoDanu() {
        return cijenaPoDanu;
    }

    public void setCijenaPoDanu(double cijenaPoDanu) {
        this.cijenaPoDanu = cijenaPoDanu;
    }

    public double getCijenaPoKM() {
        return cijenaPoKM;
    }

    public void setCijenaPoKM(double cijenaPoKM) {
        this.cijenaPoKM = cijenaPoKM;
    }

    public double getCijenaCDW() {
        return cijenaCDW;
    }

    public void setCijenaCDW(double cijenaCDW) {
        this.cijenaCDW = cijenaCDW;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Oglas> getOglasi() {
        return oglasi;
    }

    public void setOglasi(Set<Oglas> oglasi) {
        this.oglasi = oglasi;
    }
}
