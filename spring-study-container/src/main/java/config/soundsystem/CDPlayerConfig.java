package config.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.douzone.springcontainer.videosystem.Index;

@Configuration
@ComponentScan( basePackages="com.douzone.springcontainer.soundsystem") // 이 패키지를 스캐닝 찾아서 bean만듬
//@ComponentScan( basePackages= {"com.douzone.springcontainer.soundsystem", 
//							"com.douzone.springcontainer.videosystem"}) // 이 패키지를 스캐닝 찾아서 bean만듬

//error!!
// basePackageClasses에 지정한 클래스가 속한 패키지를 Base Package로 사용한다
// 여기에 지정해놓은 클래스가있는 패키지를 베이스로해서 스캐닝해라
//@ComponentScan( basePackageClasses=Index.class)
public class CDPlayerConfig {

	// 안에 내용이 없음
}
