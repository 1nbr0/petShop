package org.petShop.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Pet_Store")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 10)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="manager_name")
    private String managerName;

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private Set<Animal> animals = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="PET_STO_PROD",
            joinColumns= @JoinColumn(name="ID_PET_STO", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_PROD", referencedColumnName="ID")
    )
    private Set<Product> products=  new HashSet<>();

    @OneToOne
    private Address address;

    public PetStore() {
    }

    public PetStore(String name) {
        this.name = name;
    }

    public PetStore(String name, String managerName, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", animals=" + animals +
                ", products=" + products +
                ", address=" + address +
                '}';
    }
}
