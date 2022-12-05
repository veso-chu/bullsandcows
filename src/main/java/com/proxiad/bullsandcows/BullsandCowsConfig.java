package com.proxiad.bullsandcows;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.proxiad.bullsandcows.game.GameRepository;
import com.proxiad.bullsandcows.game.GameService;

@Configuration
public class BullsandCowsConfig {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
//	@Bean(name = "gameService")
//	public GameService getGameService() {
//		return new GameService(getGameRepository());
//	}
	
//	@Bean(name = "gameRepository")
//	public GameRepository getGameRepository() {
//		return new GameRepository();
//	}
}
