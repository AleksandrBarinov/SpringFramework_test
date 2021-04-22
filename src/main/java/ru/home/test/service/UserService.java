package ru.home.test.service;

import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.home.test.service.dto.UserDto;
import ru.home.test.domain.repository.RoleRepository;
import ru.home.test.domain.repository.UserRepository;
import ru.home.test.domain.model.Role;
import ru.home.test.domain.model.User;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

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

    @Transactional
    public String addNewUser(UserDto userDto) throws NotFoundException {

        Set<Role> roles = new HashSet<>();

        Role role = roleRepository.findByName(userDto.getRole())
                .orElseThrow(() -> new NotFoundException("role not found"));
        roles.add(role);

        Optional<User> foundUser = userRepository.findByUsername(userDto.getName());

        if (foundUser.isPresent() && foundUser.get().getRoles().contains(role)) {
            return "user with this role already exist";
        }

        User newUser;
        User userToUpdate;

        if (foundUser.isPresent()) {
            userToUpdate = foundUser.get();
            userToUpdate.getRoles().add(role);
            userRepository.save(userToUpdate);
            return "user " + userDto.getName()
                    + " is assigned " + userDto.getRole() + " role";
        } else {

            newUser = new User();

            newUser.setUsername(userDto.getName());
            newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
            newUser.setRoles(roles);

            userRepository.save(newUser);
            return "user " + userDto.getName()
                    + " with role " + userDto.getRole()
                    + " was created";
        }
    }
}
