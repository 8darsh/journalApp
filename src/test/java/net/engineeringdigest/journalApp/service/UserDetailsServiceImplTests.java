//package net.engineeringdigest.journalApp.service;
//
//import net.engineeringdigest.journalApp.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class UserDetailsServiceImplTests {
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @Test
//    void loadUserByUsernameTest(){
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn((net.engineeringdigest.journalApp.Entity.User) User.builder().username("Gargi").password("gargi").roles(String.valueOf(new ArrayList<>())).build());
//        UserDetails user = userDetailsService.loadUserByUsername("Gargi");
//        Assertions.assertNotNull(user);
//    }
//}
