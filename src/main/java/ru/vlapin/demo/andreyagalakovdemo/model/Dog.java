package ru.vlapin.demo.andreyagalakovdemo.model;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.NonFinal;
import ru.vlapin.demo.andreyagalakovdemo.common.jdbc.Entity;

@Value
@FieldNameConstants
@RequiredArgsConstructor
@Accessors(fluent = true)
public class Dog implements Entity<Dog, UUID> {

  @Setter
  @NonFinal
  UUID id;

  String name;

//  public static class Fields {
//    public static final String id = "id";
//    public static final String name = "name";
//  }
}
