package com.csbu.mvc_management.services;

import com.csbu.mvc_management.entities.UserModel;
import com.csbu.mvc_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = repository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with ID: " + username));

        return UserDetailsImpl.build(user);
    }
}
