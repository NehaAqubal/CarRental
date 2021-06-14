package com.car.rental.userApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.car.rental.userApp.dao.UserRepository;
import com.car.rental.userApp.model.MyUserPrincipal;
import com.car.rental.userApp.model.Users;
import java.util.*;


@Service
public class MyUserDetailsService implements  UserDetailsService  {

	@Autowired
	UserRepository usersRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		Users user = usersRepository.findByfullName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getFullName(),user.getPassword(),new ArrayList<>());
	}

}
