package ru.vlapin.demo.andreyagalakovdemo.dao;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vlapin.demo.andreyagalakovdemo.model.Dog;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class DogDaoImplTest {

  DogDao dogDao;

  Dog dog = new Dog("Шарик");

  @BeforeEach
  void setUp() {
    dogDao.save(dog);
  }

  @Test
  @SneakyThrows
  @DisplayName("Get by id works correctly")
  void getByIdWorksCorrectlyTest() {
    //noinspection unchecked
    assertThat(dogDao.get(dog.id())).isNotNull()
        .get().isNotNull()
        .isEqualTo(dog)
        .extracting(Dog::id, Dog::name)
        .contains(dog.id(), "Шарик");
  }

  @AfterEach
  void tearDown() {
    dogDao.delete(dog);
  }
}
