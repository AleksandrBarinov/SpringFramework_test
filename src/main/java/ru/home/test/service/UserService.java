package ru.home.test.service;

import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.home.test.controller.pojo.NewUser;
import ru.home.test.dao.RoleRepository;
import ru.home.test.dao.UserRepository;
import ru.home.test.entity.Role;
import ru.home.test.entity.User;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

        this.bCryptPasswordEncoder =
                new BCryptPasswordEncoder();
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }

    public void addNewUser(NewUser newUser) throws NotFoundException {

        Set<Role> roles = new HashSet<>();
        Role role1 = roleRepository.findByName(newUser.getRole())
                .orElseThrow(() -> new NotFoundException("role not found"));
        roles.add(role1);

        Optional<User> user = userRepository.findByUsername(newUser.getName());
        if (user.isPresent() && user.get().getRoles().contains(role1)) {
            throw new NotFoundException("user with this role already exist");
        }

        User user1 = new User();
        user1.setUsername(newUser.getName());
        user1.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        user1.setRoles(roles);

        userRepository.save(user1);
    }
}