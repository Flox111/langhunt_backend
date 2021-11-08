package ru.maltsev.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsev.myproject.model.Card;

public interface CardRepository extends JpaRepository<Card,Long> {
}
