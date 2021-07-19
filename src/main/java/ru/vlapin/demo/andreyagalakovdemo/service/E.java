package ru.vlapin.demo.andreyagalakovdemo.service;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public abstract class E {

  @Lookup
  public abstract D get();

  @PostConstruct
  private void init() {
    System.out.println("get() = " + get());
    System.out.println("get() = " + get());
    System.out.println("get() = " + get());
    System.out.println("get() = " + get());
    System.out.println("get() = " + get());
    System.out.println("get() = " + get());
    System.out.println("get() = " + get());
  }
}
