package com.proxiad.bullsandcows;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.proxiad.bullsandcows.game.GameRepo;
import com.proxiad.bullsandcows.game.GameService;
import com.proxiad.bullsandcows.game.GameServiceImpl;
import com.proxiad.bullsandcows.game.InMemoryGameRepo;

@Configuration
@EnableWebMvc
public class BullsandCowsConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");

		return resolver;
	}

	@Bean(name = "gameService")
	public GameService getGameService() {
		return new GameServiceImpl(getGameRepository());
	}

	@Bean(name = "gameRepository")
	public GameRepo getGameRepository() {
		return new InMemoryGameRepo();
	}
}
