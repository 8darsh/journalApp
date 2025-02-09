//package net.engineeringdigest.journalApp.service;
//
//import net.engineeringdigest.journalApp.repository.UserRepository;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//public class UserServiceTests {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Disabled /// if we want to disable any test we just write disable
//    @Test
//
//    public void testFindByUserName(){
//        assertNotNull(userRepository.findByUserName("Hunny"));
//
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2",
//            "2,10,12",
//            "1,1,5"
//    })
//    public void test(int a, int b, int expected){
//        assertEquals(expected,a + b);
//    }
//
//}
