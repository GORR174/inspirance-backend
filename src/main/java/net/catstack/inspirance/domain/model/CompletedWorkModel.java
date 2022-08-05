package net.catstack.inspirance.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "completed_works")
public class CompletedWorkModel extends BaseEntity {
    @ManyToOne
    private TaskModel task;
}
