package org.petShop.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Fish")
public class Fish extends Animal {
    @Enumerated( EnumType.STRING )
    @Column(name="living_env")
    private FishLivEnv livingEnv;

    public Fish() {
    }

    public Fish(LocalDate birth, String color, FishLivEnv livingEnv) {
        super(birth, color);
        this.livingEnv = livingEnv;
    }
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
