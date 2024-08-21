package org.ojl3g.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("simple")
@NoArgsConstructor
public class SimpleMatter extends Case { //простое дело


    public SimpleMatter(String description) {
        super(description);
    }
}
