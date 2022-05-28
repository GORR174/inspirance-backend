package net.catstack.inspirance.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity {
    public static final String ROLE_USER = "role_user";
    public static final String ROLE_ADMIN = "role_admin";
    public static final String ROLE_MODERATOR = "role_moderator";

    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<UserModel> users;
}
