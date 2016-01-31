package restapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{Import, Configuration, ComponentScan}
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.boot.autoconfigure.EnableAutoConfiguration

@ComponentScan
@Configuration
@EnableJpaRepositories
@Import(value = Array(classOf[RepositoryRestMvcConfiguration]))
@EnableAutoConfiguration
@SpringBootApplication
class MySpringApplication

object Application {
    def main(args:Array[String]):Unit =
        SpringApplication.run(classOf[MySpringApplication])        
}
