package ru.vlapin.demo.andreyagalakovdemo.common.jdbc;

public interface Entity<E extends Entity<E, ID>, ID> {
  ID id();
  E id(ID id);
}
