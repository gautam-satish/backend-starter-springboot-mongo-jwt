package com.sabarigrand.core.models.entities;

import com.sabarigrand.core.models.entities.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Document(collection = "users")
@TypeAlias("sabariGrand.v1.users")
public class UserEntity extends BaseEntity implements UserDetails {

    public enum Role {
        ADMIN, USER
    }

    @Field("username")
    private String username;

    @Field("email")
    private String email;

    @Field("firstName")
    private String firstName;

    @Field("lastName")
    private String lastName;

    @Field("password")
    private String password;

    @Field("role")
    private Role role;

    @Field("enabled")
    private boolean enabled;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
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
        return enabled;
    }
}
