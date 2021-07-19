package ru.vlapin.demo.andreyagalakovdemo.common.jdbc;

import java.util.Optional;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

public interface CrudDao<E extends Entity<E, ID>, ID> {

  @NotNull Stream<@NotNull E> all();
  @NotNull Optional<@NotNull E> get(@NotNull ID id);
  @NotNull E add(@NotNull E e);
  @NotNull E merge(@NotNull E e);

  @SuppressWarnings("UnusedReturnValue")
  @NotNull E delete(@NotNull E e);

  @SuppressWarnings("UnusedReturnValue")
  @NotNull default E save(@NotNull E e) {
    return e.id() == null ? add(e) : merge(e);
  }
}
