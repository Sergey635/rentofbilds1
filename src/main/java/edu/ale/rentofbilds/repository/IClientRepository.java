package edu.ale.rentofbilds.repository;

import edu.ale.rentofbilds.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends MongoRepository<Client, String> {
}
