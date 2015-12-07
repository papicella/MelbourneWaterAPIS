package pas.ctp.bluemix.melbwater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("pas.ctp.bluemix.melbwater")
public class MelbourneWaterApisApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MelbourneWaterApisApplication.class, args);
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("melbdataapis")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/melbdata.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Melbourne Data with API's on Bluemix")
                .description("Melbourne Data with API's on Bluemix")
                .contact("Pas Apicella")
                .license("Apache License Version 2.0")
                .version("1.0")
                .build();
    }
}
