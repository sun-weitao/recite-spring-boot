package com.sun.recite.security;

import com.sun.recite.exception.LoginException;
import com.sun.recite.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminUserDetailsService implements UserDetailsService{
    @Autowired
    private Account account;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(account.getUsername().equals(s)){
            return new User(account.getUsername(),account.getPassword(),new ArrayList<>());
        }else{
            throw new LoginException("User not found "+s);
        }
    }
}
