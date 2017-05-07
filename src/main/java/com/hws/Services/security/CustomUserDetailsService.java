package com.hws.Services.security;

import com.hws.DAO.UserDAO;
import com.hws.DAO.interfaces.IUserDAO;
import com.hws.hibernate.models.Role;
import com.hws.hibernate.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by Ihor on 4/16/2017.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    IUserDAO _userDAO;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User domainUser = _userDAO.GetUserByLogin(login);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new org.springframework.security.core.userdetails.User(
                domainUser.getLogin(),
                domainUser.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(domainUser.getRoles())
        );
    }

    public Collection getAuthorities(List<Role> roles) {
        List authList = getGrantedAuthorities(roles);
        return authList;
    }

    public static List getGrantedAuthorities(List<Role> roles) {
        List authorities = new ArrayList();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return authorities;
    }

}
