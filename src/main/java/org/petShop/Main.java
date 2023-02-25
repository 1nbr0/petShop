package org.petShop;

import org.petShop.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        // PetStore 1
        Address address1 = new Address("6", "Avenue De L'os", "44000", "Nantes");
        em.persist(address1);
        PetStore petStore1 = new PetStore("WhoLetTheDogsOut", "Stephano", address1);
        em.persist(petStore1);

        // PetStore 2
        Address address2 = new Address("19", "Rue des champs des tulipes", "44400", "Nantes");
        em.persist(address2);
        PetStore petStore2 = new PetStore("Jardiland", "Louis", address2);
        em.persist(petStore2);

        // PetStore 3
        Address address3 = new Address("1", "Rue du Général Leclerc", "44115", "Nantes");
        em.persist(address3);
        PetStore petStore3 = new PetStore("Pet'ale", "Josef", address3);
        em.persist(petStore3);

        // Products
        Product productFoodCat1 = new Product("5250", "Sac de croquettes 55kg", ProdType.FOOD, 64.99);
        Product productFoodFish1 = new Product("5042", "20kg de granulés pour poisson", ProdType.FOOD, 29.99);
        Product productFoodCat2 = new Product("4366", "Sac de Friandises pour chats 50kg", ProdType.FOOD, 99.99);
        Product productAccessoryCat1 = new Product("3453", "Distributeur de croquettes pour chat", ProdType.ACCESSORY, 44.99);
        Product productAccessoryFish1 = new Product("4564", "Filtre pour aquarium", ProdType.ACCESSORY, 50.00);
        Product productAccessoryFish2 = new Product("6677", "Éclairage", ProdType.ACCESSORY, 20.49);
        Product productCleaningCat1 = new Product("7677", "Shampoing pour chat", ProdType.CLEANING, 8.99);
        Product productCleaningCat2 = new Product("7780", "Nettoyant pour litière ", ProdType.CLEANING, 17.49);
        Product productCleaningCat3 = new Product("1435", "Détachant pour chat x10", ProdType.CLEANING, 48.99);

        // Persit products
        em.persist(productFoodCat1);
        em.persist(productFoodFish1);
        em.persist(productFoodCat2);
        em.persist(productAccessoryCat1);
        em.persist(productAccessoryFish1);
        em.persist(productAccessoryFish2);
        em.persist(productCleaningCat1);
        em.persist(productCleaningCat2);
        em.persist(productCleaningCat3);

        // Animal
        Cat cat1 = new Cat(LocalDate.now(), "Noir", "001");
        Cat cat2 = new Cat(LocalDate.now(), "Roux", "002");
        Cat cat3 = new Cat(LocalDate.now(), "Blanc", "003");
        Fish fishLiveFresh1 = new Fish(LocalDate.now(), "Rouge", FishLivEnv.FRESH_WATER);
        Fish fishLiveFresh2 = new Fish(LocalDate.now(), "Jaune", FishLivEnv.FRESH_WATER);
        Fish fishLiveFresh3 = new Fish(LocalDate.now(), "Argent", FishLivEnv.FRESH_WATER);
        Fish fishLiveSea1 = new Fish(LocalDate.now(),"Argent" , FishLivEnv.SEA_WATER);
        Fish fishLiveSea2 = new Fish(LocalDate.now(),"Noir" , FishLivEnv.SEA_WATER);
        Fish fishLiveSea3 = new Fish(LocalDate.now(),"blanc" , FishLivEnv.SEA_WATER);

        em.persist(cat1);
        em.persist(cat2);
        em.persist(cat3);
        em.persist(fishLiveFresh1);
        em.persist(fishLiveFresh2);
        em.persist(fishLiveFresh3);
        em.persist(fishLiveSea1);
        em.persist(fishLiveSea2);
        em.persist(fishLiveSea3);

        // Animalerie 1
        petStore1.getProducts().add(productFoodCat1);
        petStore1.getProducts().add(productAccessoryFish2);
        petStore1.getProducts().add(productCleaningCat1);
        petStore1.getAnimals().add(cat1);
        petStore1.getAnimals().add(fishLiveFresh1);
        petStore1.getAnimals().add(fishLiveSea1);

        em.persist(petStore1);

        // Animalerie 2
        petStore2.getProducts().add(productFoodFish1);
        petStore2.getProducts().add(productAccessoryFish1);
        petStore2.getProducts().add(productCleaningCat2);
        petStore2.getAnimals().add(cat2);
        petStore2.getAnimals().add(fishLiveFresh2);
        petStore2.getAnimals().add(fishLiveSea2);
        petStore2.getAnimals().add(fishLiveSea3);
        petStore2.getAnimals().add(fishLiveFresh3);
        petStore2.getAnimals().add(fishLiveSea1);
        em.persist(petStore2);

        // Animalerie 3
        petStore3.getProducts().add(productFoodCat2);
        petStore3.getProducts().add(productAccessoryCat1);
        petStore3.getProducts().add(productCleaningCat3);
        petStore3.getAnimals().add(cat3);
        petStore3.getAnimals().add(cat2);
        petStore3.getAnimals().add(cat1);
        petStore3.getAnimals().add(fishLiveFresh3);
        em.persist(petStore3);


        et.commit();

        // lister les animaux de l'animalerie 2
        PetStore petStoreJardiland = em.find(PetStore.class, 2L);
        if(petStoreJardiland != null) {
            System.out.println("__________________________________________________________________________");
            System.out.println("| Liste des animaux présent dans l'animalerie " + petStoreJardiland.getName() +" situé à " + petStoreJardiland.getAddress().getCity());
            System.out.println("|  ------------------------------------------------------------------------");
            for(Animal item : petStoreJardiland.getAnimals()) {
                System.out.println("| " + item.toString());
            }
            System.out.println("__________________________________________________________________________");
        }

        em.close();
        emf.close();
    }
}