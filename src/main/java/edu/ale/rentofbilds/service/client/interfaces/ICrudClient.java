package edu.ale.rentofbilds.service.client.interfaces;

import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;

import java.util.List;

public interface ICrudClient {
    Client create(Client client);
    Client get(String id);
    Client update(Client client);
    Client delete(String id);
    List<Client> getAll();
}
