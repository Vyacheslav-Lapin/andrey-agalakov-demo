package ru.vlapin.demo.andreyagalakovdemo.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.demo.andreyagalakovdemo.model.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}
