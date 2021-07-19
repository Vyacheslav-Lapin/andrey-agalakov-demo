package ru.vlapin.demo.andreyagalakovdemo.common;

import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Component
public class A implements Int1 {

  @Override
  public void run() {
    System.out.println("!");
  }
}
