package org.petShop.entities;

import javax.persistence.Column;

public class Fish extends Animal {
    @Column(name="living_env")
    private FishLivEnv livingEnv;
}
