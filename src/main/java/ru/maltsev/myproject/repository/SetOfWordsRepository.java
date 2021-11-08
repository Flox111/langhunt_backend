package ru.maltsev.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maltsev.myproject.model.SetOfWords;

@Repository
public interface SetOfWordsRepository extends JpaRepository<SetOfWords, Long> {
}
