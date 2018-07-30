package org.trahim.spring.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final AuthGroupRepository groupRepository;

    public MyUserDetailsService(UserRepository userRepository, AuthGroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("can not find username: " + username);
        }

        List<AuthGroup> authGroups = groupRepository.findByUsername(username);

        return new MyUserPrincipal(user, authGroups);
    }
}
