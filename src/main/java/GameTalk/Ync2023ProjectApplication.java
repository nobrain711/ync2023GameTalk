package GameTalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.SecurityConfigurer;

// 아직 인증 단계 개발 전으로 Security중지
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableJpaAuditing
public class Ync2023ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ync2023ProjectApplication.class, args);
	}

}
