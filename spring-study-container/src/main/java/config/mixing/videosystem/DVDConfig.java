package config.mixing.videosystem;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.springcontainer.videosystem.Avengers;
import com.douzone.springcontainer.videosystem.BlankDisc;

@Configuration
public class DVDConfig {

	@Bean
	public Avengers avengers()
	{
		return new Avengers();
	}
	
	@Bean(name="avengersInfinityWar")
	public BlankDisc blankDisc()
	{
		BlankDisc blankDisc = new BlankDisc();
		blankDisc.setTitle("Avengers Infinity War");
		blankDisc.setStudio("MARVEL");
		blankDisc.setActors(Arrays.asList("로버트다우니주니어", "스칼렛요한슨", "사무엘 L 잭슨", "마크 러팔로"));
		
		return blankDisc;
	}
}
