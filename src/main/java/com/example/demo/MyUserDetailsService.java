package com.example.demo;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    // @Autowired
    // private UserService userService;

    //构建用户，后续可以从数据库中读取记录来构建
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("user")) {
            return new User("user", "$2a$04$tJo9IkiCTuuq1B3zQCwRt.dJwS8pP9Yai/OnafpypR95pxn6dvJKO",
                    AuthorityUtils.createAuthorityList("ROLE_USER"));
        }
        if (username.equals("admin")) {
            return new User("admin", "$2a$04$gNkd8KGosXKsk6sOBJmEKuWJvF.s2D1xhazaRZkcjq/yhGwUge5EG",
                    AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER"));
        }

        throw new UsernameNotFoundException("UsernameNotFoundException");
        // return new User(sysUser.getUsername(), sysUser.getPassword(), authorities);
    }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception
    // {
    // auth.inMemoryAuthentication()//直接定义两个用户
    // .withUser("user").password("$2a$04$tJo9IkiCTuuq1B3zQCwRt.dJwS8pP9Yai/OnafpypR95pxn6dvJKO").roles("USER").and()
    // .withUser("admin").password("$2a$04$gNkd8KGosXKsk6sOBJmEKuWJvF.s2D1xhazaRZkcjq/yhGwUge5EG").roles("ADMIN","USER");
    // }

}