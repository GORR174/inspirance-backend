package net.catstack.inspirance.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
public class UserModel extends BaseEntity {
    private String username;
    private String password;
    private String firstName;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private Set<RoleModel> roles;

    private String imageUrl;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_followings",
            joinColumns = { @JoinColumn(name = "follower_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "following_id", referencedColumnName = "id") })
    private List<UserModel> followers;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "followers")
    private List<UserModel> following;

    @OneToMany(fetch = FetchType.LAZY)
    private List<CompletedWorkModel> completedWorks;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "applicants")
    private List<TaskModel> tasks;

    @OneToMany(fetch = FetchType.LAZY)
    private List<CompletedWorkModel> favorites;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_awards",
            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "award_id", referencedColumnName = "id") })
    private List<AwardModel> awards;
}
