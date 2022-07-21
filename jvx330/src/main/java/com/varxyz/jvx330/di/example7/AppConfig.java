package com.varxyz.jvx330.di.example7;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.varxyz.jvx330.di.example7"}) //여기안에서 빈을 찾으라고 명령
//빈등록을 없앴음 얘랑 뒤에 지정하는애로
public class AppConfig {

}
