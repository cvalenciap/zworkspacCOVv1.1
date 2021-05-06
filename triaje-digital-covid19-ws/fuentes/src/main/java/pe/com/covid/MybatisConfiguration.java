package pe.com.covid;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = { 
	    "classpath:/META-INF/mybatis-config.xml",
	    "classpath:/META-INF/infrastructure.xml",
	    "classpath:/META-INF/applicationContext.xml"
	    })
public class MybatisConfiguration {

}
