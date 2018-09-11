package com.XMsystem.Service;

import com.XMsystem.Model.Administrator;
import com.XMsystem.Repository.AdministratorRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService implements UserDetailsService {

    private final AdministratorRepository administratorRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public static final String ADMIN_ROLE = "ADMIN";

    public AdministratorService(AdministratorRepository administratorRepository, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.administratorRepository = administratorRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    public List<Administrator> getAllAdministrators(){
        List<Administrator> administrators = new ArrayList<>();
        administratorRepository.findAll().forEach(administrators::add);
        return administrators;
    }

    public Administrator addAdministrator (Administrator administrator){
        String encodedPassword = passwordEncoder.encode(administrator.getPassword());
        administrator.setPassword(encodedPassword);
        administrator.setRole(roleService.getRoleByName(ADMIN_ROLE));
        return administratorRepository.save(administrator);
    }

//    public Administrator getAdministrator(String id) {
//        Optional<Administrator> administrator = administratorRepository.findById(Long.valueOf(id));
//        if(administrator.isPresent()){
//            return administrator.get();
//        }
//        return null;
//    }

    public void deleteById(String adminId) {
        administratorRepository.deleteById(Long.valueOf(adminId));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator administrator = administratorRepository.findByUserName(username);

        if(administrator==null){
            throw new UsernameNotFoundException("User name "+username+" Not found");
        }
        else {
            return new User(administrator.getUserName(), administrator.getPassword(),
                    getGrantedAuthorities(administrator));
        }
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(Administrator administrator){
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (administrator.getRole().getName().equals(ADMIN_ROLE)){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return grantedAuthorities;
    }

}
