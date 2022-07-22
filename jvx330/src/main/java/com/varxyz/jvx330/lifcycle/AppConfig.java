package com.varxyz.jvx330.lifcycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifcycle.example1.Dog;
import com.varxyz.jvx330.lifcycle.example2.Eagle;
import com.varxyz.jvx330.lifcycle.example3.Goat;
import com.varxyz.jvx330.lifcycle.example3.Horse;

@Configuration
public class AppConfig {
	/**
	 * <bean name="dog" class="com.varxyz.jvx330.lifecycle.example1.Dog">
	 * 	<constructor-arg index=0 type="java.lang.String" value="플루토"/>
	 * 	<propety name="name" value="볼트">
	 * </bean>
	 * @return
	 */
	@Bean
	public Dog dog() {
		Dog d = new Dog("플루토");
		d.setName("볼트");
		return d;
	}
	
	@Bean (initMethod = "attachWings", destroyMethod = "detachWings")
	
	public Eagle eagle() {
		Eagle e = new Eagle();
		e.setName("에디");
		return e;
	}
	
	@Bean
	@Scope("singleton") //싱글톤으로 설정해서 빈을 여러번 호출해도 count가 1, 이거 설정안해도 디폴트값이 싱글톤임
	public Goat goat() {
		return new Goat();
	}

	@Bean
	@Scope("prototype") //빈을 호출하는만큼 카운트 값이 올라감. destroy는 잘 호출하지 않음
	public Horse horse() {
		return new Horse();
	}

}
