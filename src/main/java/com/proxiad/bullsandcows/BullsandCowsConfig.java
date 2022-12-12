package com.proxiad.bullsandcows;

import com.proxiad.bullsandcows.game.GameRepository;
import com.proxiad.bullsandcows.game.GameRepositoryImpl;
import com.proxiad.bullsandcows.game.GameServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
  public GameServiceImpl getGameService() {
    return new GameServiceImpl(getGameRepository());
  }

  @Bean(name = "gameRepository")
  public GameRepository getGameRepository() {
    return new GameRepositoryImpl();
  }
}
