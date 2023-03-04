package dev.contentcalenar;

import dev.contentcalenar.config.ContentCalendarProperties;
import dev.contentcalenar.model.Content;
import dev.contentcalenar.model.Status;
import dev.contentcalenar.model.Type;
import dev.contentcalenar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext content = SpringApplication.run(ContentCalendarApplication.class, args);
//		Arrays.stream(content.getBeanDefinitionNames()).forEach(System.out::println);

	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository contentRepository){
		return args -> {
			Content content = new Content(null,
					"My chat GPT",
					"All about chat GPT",
					Status.IDEA,
					Type.VIDEO,
					LocalDateTime.now(),
					null,
					"");
			contentRepository.save(content);
		};
	}

}
