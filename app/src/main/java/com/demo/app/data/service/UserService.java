/**
 * 
 */
package com.demo.app.data.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.app.data.model.User;
import com.demo.app.data.repository.UserRepository;

/**
 * @author vinay
 *
 */
@Service
public class UserService implements UserDetailsService {
	
	private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Could not find user " + username);
        }
        return new CustomUserDetails(user);
	}
	
	private final static class CustomUserDetails extends User implements UserDetails {

        /**
		 * 
		 */
		private static final long serialVersionUID = -4557368741948815153L;

		private CustomUserDetails(User user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
        	if(getUsername().contains("admin")){
        		return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
        	}
            return AuthorityUtils.createAuthorityList("ROLE_USER");
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

     
    }

}
