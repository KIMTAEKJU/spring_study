package config.mixing.videosystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.douzone.springcontainer.videosystem.DVDPlayer;
import com.douzone.springcontainer.videosystem.DigitalVideoDisc;

@Configuration
@Import(DVDConfig.class)

public class DVDPlayerConfig {

	@Bean
	public DVDPlayer dvdPlayer(@Qualifier("avengersInfinityWar") DigitalVideoDisc dvd) 
	// DigitalVideoDisc 빈이 2개니까 구별하기위해  @Qualifier를 붙임
	{
		return new DVDPlayer(dvd);
	}
}
