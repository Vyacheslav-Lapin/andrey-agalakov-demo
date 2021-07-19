package ru.vlapin.demo.andreyagalakovdemo.service;

import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vlapin.demo.andreyagalakovdemo.common.Int1;

@Service
@AllArgsConstructor
public class C {

//  List<Int1> int1List;
  Int1[] int1List;

  @PostConstruct
  private void init() {
    System.out.println("int1List = " + int1List);
    for (Int1 int1 : int1List) {
      System.out.println("int1 = " + int1);
    }
  }
}
