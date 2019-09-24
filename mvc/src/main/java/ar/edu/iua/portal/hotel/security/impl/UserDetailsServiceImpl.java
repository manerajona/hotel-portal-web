package ar.edu.iua.portal.hotel.security.impl;

import ar.edu.iua.portal.hotel.entity.Role;
import ar.edu.iua.portal.hotel.entity.User;
import ar.edu.iua.portal.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
            for (Role role : user.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
            }
        }

        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
