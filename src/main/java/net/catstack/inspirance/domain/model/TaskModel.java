package net.catstack.inspirance.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "tasks")
public class TaskModel extends BaseEntity {
    @ManyToOne
    private CategoryModel category;
    @ManyToOne
    private ThemeModel theme;
    private String name;
    private String aboutCompany;
    private String taskDescription;
    private Date deadline;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tasks_applicants",
            joinColumns = { @JoinColumn(name = "task_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") })
    private List<UserModel> applicants;
    @OneToMany
    private List<CompletedWorkModel> completedWorks;
}
