package com.proxiad.bullsandcows;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.proxiad.bullsandcows.game.GameRepository;
import com.proxiad.bullsandcows.game.GameService;

@Configuration
@EnableWebMvc
public class BullsandCowsConfig implements WebMvcConfigurer {

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
		return new GameService(getGameRepository());
	}

	@Bean(name = "gameRepository")
	public GameRepository getGameRepository() {
		return new GameRepository();
	}
}
