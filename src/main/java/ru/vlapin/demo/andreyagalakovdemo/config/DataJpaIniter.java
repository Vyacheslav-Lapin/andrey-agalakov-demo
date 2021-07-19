package ru.vlapin.demo.andreyagalakovdemo.config;

import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springdoc.webmvc.ui.SwaggerWelcomeWebMvc;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.vlapin.demo.andreyagalakovdemo.dao.CatRepository;
import ru.vlapin.demo.andreyagalakovdemo.model.Cat;

@Component
@RequiredArgsConstructor
public class DataJpaIniter implements ApplicationRunner {

  CatRepository catRepository;

  SwaggerWelcomeWebMvc swaggerWelcome;

  @Override
  public void run(ApplicationArguments __) {
    Stream.of("Мурзик, Барсик, Матроскин".split(", "))
        .map(Cat::new)
        .forEach(catRepository::save);
  }
}
