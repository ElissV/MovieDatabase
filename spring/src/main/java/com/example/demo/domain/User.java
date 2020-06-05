package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(exclude = "roles")
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "userId")*/
public class User /*implements UserDetails*/{

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String password;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    //@JsonManagedReference(value = "user-role")
    //@JsonIgnore
    private Set<Role> roles = new HashSet<>();


    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities();
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }*/

    /*@JsonManagedReference
    public Set<Role> getRoles() {
        return roles;
    }*/
}
