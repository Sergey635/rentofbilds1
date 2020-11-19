package edu.ale.rentofbilds.repository;

import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.model.Record;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends MongoRepository<Record, String> {

}
