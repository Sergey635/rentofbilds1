package edu.ale.rentofbilds.repository;

import edu.ale.rentofbilds.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    //метод який повертає дані з бази

    List<Item> findByNameAndDescription(String name, String description);
    /*List<Item> findByCreated_atBetween(LocalDateTime start, LocalDateTime finish);*/
    List<Item> findByNameContaining(String str);
}
