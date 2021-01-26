package bbyGrocery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepo repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Product("Banana", 100, 2.5f)));
            log.info("Preloading " + repository.save(new Product("Apple", 100, 5.0f)));
            log.info("Preloading " + repository.save(new Product("Pomegranate", 100, 3.0f)));
        };
    }
}
