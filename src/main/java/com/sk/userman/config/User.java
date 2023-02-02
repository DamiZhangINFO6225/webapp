package com.sk.userman.config;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**

 */
@Data
public class User implements UserDetails {
 
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled = true;
    private Boolean accountNonExpired=  true;
    private Boolean accountNonLocked = true;
    private Boolean credentialsNonExpired = true;
    private List<Role> roles = new ArrayList<>();
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return authorities;
    }
 
    @Override
    public String getPassword() {
        return password;
    }
 
    @Override
    public String getUsername() {
        return username;
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
 
    @Override
    public boolean isEnabled() {
        return enabled;
    }
 
    //省略get/set方法
}
 
 
/**
 * @author tlh
 * @date 2022/11/17 23:47
 */
class Role {
 
    private Integer id;
    private String name;
    private String nameZh;
 
    //省略get/set方法
}