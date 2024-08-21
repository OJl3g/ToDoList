package org.ojl3g.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@DiscriminatorValue("important")
public class ImportantMatter extends Case { //важное дело


    public ImportantMatter(String description) {
        super(description);
    }
}
