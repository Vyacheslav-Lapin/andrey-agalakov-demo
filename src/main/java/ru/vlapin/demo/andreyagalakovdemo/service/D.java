package ru.vlapin.demo.andreyagalakovdemo.service;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import javax.annotation.PostConstruct;
import lombok.Setter;
import lombok.experimental.NonFinal;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.vlapin.demo.andreyagalakovdemo.common.Int1;

@Setter
@Service
@Scope(SCOPE_PROTOTYPE)
public class D implements Int2<D> {

  @NonFinal
  Int1 a;

  @PostConstruct
  private void init() {
    System.out.println("a = " + a);
  }

  @EventListener
  public void afterContextInitialization(ContextRefreshedEvent __) {

  }

}
