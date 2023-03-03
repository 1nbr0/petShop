package org.petShop.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 10)
    private Long id;

    @Column(name="birth")
    private LocalDate birth;

    @Column(name="color")
    private String color;

    @ManyToOne
    @JoinColumn(name="PETSTORE_ID")
    private PetStore petStore;

    public Animal() {
    }

    public Animal(LocalDate birth, String color, PetStore petStore) {
        this.birth = birth;
        this.color = color;
        this.petStore = petStore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", color='" + color + '\'' +
                ", petStoreId=" + petStore.getId() +
                '}';
    }
}
