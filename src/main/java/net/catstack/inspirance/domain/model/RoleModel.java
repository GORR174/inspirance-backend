package net.catstack.inspirance.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class RoleModel extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<UserModel> users;
}
