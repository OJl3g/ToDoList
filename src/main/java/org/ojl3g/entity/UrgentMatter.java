package org.ojl3g.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("urgent")
@NoArgsConstructor
public class UrgentMatter extends Case { //срочное дело


    public UrgentMatter(String description) {
        super(description);
    }
}
