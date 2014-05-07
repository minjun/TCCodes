import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee;

/*
http://java2practice.com/2013/03/23/spring-cacheable-and-cacheevict-explained-in-simple-terms/
http://www.codingpedia.org/ama/spring-caching-with-ehcache/
*/


@RestController
@EnableAutoConfiguration
@Configuration
@ComponentScan
@EnableCaching
public class Example {
	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		List<Cache> caches = new ArrayList<Cache>();
		caches.add(cacheBean().getObject());
		cacheManager.setCaches(caches);
		return cacheManager;
	}

	@Bean
	public ConcurrentMapCacheFactoryBean cacheBean() {
		ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
		cacheFactoryBean.setName("default");
		return cacheFactoryBean;
	}

	@Autowired
	Employee employee;

	@RequestMapping("/")
	String home() {
		return employee.getEmployee(1);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}
}