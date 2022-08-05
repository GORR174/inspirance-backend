package net.catstack.inspirance.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "awards")
public class AwardModel extends BaseEntity {
    private String imageUrl;
    private String name;
}
