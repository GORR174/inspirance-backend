package net.catstack.inspirance.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "categories")
public class CategoryModel extends BaseEntity {
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    private List<TaskModel> tasks;
}
