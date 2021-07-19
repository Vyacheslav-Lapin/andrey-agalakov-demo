package ru.vlapin.demo.andreyagalakovdemo.service;

import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;

@Data
//@Service
//@AllArgsConstructor
public class Bean1 {

  @NonFinal
  @Setter(onMethod_ = @Autowired)
  Bean2 bean2;

  @PostConstruct
  private void init() {
    System.out.println("bean2 = " + bean2);
  }
}
