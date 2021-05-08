package ar.edu.iua.portal.hotel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration
@ActiveProfiles("dev")
public class WebApplicationTest {
    @Test
    public void contextLoads() {
    }
}
