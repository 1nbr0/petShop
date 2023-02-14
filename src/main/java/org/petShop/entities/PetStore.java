package org.petShop.entities;

import javax.persistence.*;
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
    @ManyToMany
    @JoinTable(name="PET_STO_PROD",
            joinColumns= @JoinColumn(name="ID_PET_STO", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_PROD", referencedColumnName="ID")
    )
    private Set<Product> products;

    @OneToOne
    private Address address;

    public PetStore() {
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

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", products=" + products +
                ", address=" + address +
                '}';
    }
}
