package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "roleId")*/
public class Role /*implements GrantedAuthority*/ {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String name;

    @ManyToMany(mappedBy = "roles")
    //@JsonBackReference(value = "user-role")
    //@JsonIgnore
    private Set<User> users = new HashSet<>();


    /*@Override
    public String getAuthority() {
        return name;
    }*/

    //@JsonBackReference
    public Set<User> getUsers() {
        return users;
    }
}
