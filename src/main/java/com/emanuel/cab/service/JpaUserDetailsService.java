package com.emanuel.cab.service;

import com.emanuel.cab.model.Userr;
import com.emanuel.cab.model.Role;
import com.emanuel.cab.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author EmanuelBotea
 * <p>
 * Ce am rezolvat:
 * - atunci cand metoda loadUserByUsername() returna un nou Userr(), metoda nu stia la care
 * constructor de la Userr ma refer. In cazul meu trebuia sa returnez constructorul
 * clasei Userr care implementeaza interfata UserDetails, dar cum eu am creat deja o clasa
 * Userr in pachetul model si am adaugat un obiect de tip Userr(model) in metoda mea, imi apareau erori.
 * De asta a returnat la inceput "org.springframework.security.core.userdetails.Userr" prietenul nostru indian.
 * <p>
 * O simpla redenumire a clasei "Userr" din pachetul model si s-a rezolvat.
 */

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public JpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Userr userr = repository.findByUsername(username);

        if (userr != null) {
            return new User(userr.getUsername(),
                    userr.getPassword(),
                    mapRolesToAuthorities(userr.getRoles()));
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }


    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
