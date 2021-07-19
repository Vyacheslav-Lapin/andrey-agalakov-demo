package ru.vlapin.demo.andreyagalakovdemo.service;

import java.util.Map;
import lombok.val;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import ru.vlapin.demo.andreyagalakovdemo.common.B;
import ru.vlapin.demo.andreyagalakovdemo.common.Int1;

public interface Int2<I extends Int2<I>> extends ApplicationContextAware {

  I setA(Int1 a);

  @Autowired
  default void setB(B b) {
    setA(b);
  }

  @Override
  default void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    ;
    val of = Map.of();
    val entries = of.entrySet();

//    of.entrySet().stream().f

//    Tuple.of("kjhzdfg", 1243, true)
//        .
  }
}
