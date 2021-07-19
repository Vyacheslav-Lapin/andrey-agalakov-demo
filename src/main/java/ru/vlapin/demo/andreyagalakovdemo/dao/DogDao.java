package ru.vlapin.demo.andreyagalakovdemo.dao;

import static ru.vlapin.demo.andreyagalakovdemo.model.Dog.Fields.id;
import static ru.vlapin.demo.andreyagalakovdemo.model.Dog.Fields.name;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.vlapin.demo.andreyagalakovdemo.common.jdbc.CrudDao;
import ru.vlapin.demo.andreyagalakovdemo.common.jdbc.NamedParameterJdbcDaoSupport;
import ru.vlapin.demo.andreyagalakovdemo.model.Dog;

public interface DogDao extends CrudDao<Dog, UUID> {

  //  Optional<Dog> findByCriteria(DogSearchCriteria criteria);
}

@Repository
class DogDaoImpl extends NamedParameterJdbcDaoSupport implements DogDao {

  private static final RowMapper<Dog> ROW_MAPPER =
      (rs, rowNum) -> new Dog(rs.getString(name))
                          .id(rs.getObject(id, UUID.class));

  @Override
  public @NotNull Stream<Dog> all() {
    return getJdbcTemplate().queryForStream("""
            select id, name
            from Dog""",
        ROW_MAPPER);
  }

  @Override
  public @NotNull Optional<Dog> get(@NotNull UUID uuid) {
    return Optional.ofNullable(
        getNamedParameterJdbcTemplate().queryForObject("""
            select id, name
            from Dog
            where id = :id""",
        Map.of(id, uuid),
        ROW_MAPPER));
  }

  @NotNull
  @Override
  public Dog add(@NotNull Dog dog) {
    dog.id(UUID.randomUUID());
    getNamedParameterJdbcTemplate().update("""
            insert into Dog (id, name)
            values (:id, :name)""",
        Map.of(id, dog.id(),
            name, dog.name()));

    return dog;
  }

  @NotNull
  @Override
  public Dog merge(@NotNull Dog dog) {
    getNamedParameterJdbcTemplate().update("""
            update Dog
            set name = :name
            where id = :id""",
        Map.of(id, dog.id(),
            name, dog.name()));

    return dog;
  }

  @NotNull
  @Override
  public Dog delete(@NotNull Dog dog) {
    getNamedParameterJdbcTemplate().update("""
            delete from Dog
            where id = :id""",
        Map.of(id, dog.id()));

    return dog;
  }
}
