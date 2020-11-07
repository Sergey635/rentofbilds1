package edu.ale.rentofbilds.service.client.impls;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.repository.IClientRepository;
import edu.ale.rentofbilds.repository.ItemRepository;
import edu.ale.rentofbilds.service.client.impls.ClientServiceImpl;
import edu.ale.rentofbilds.service.client.interfaces.ICrudClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class CrudClientMongoImpl implements ICrudClient {
    @Autowired
    FakeData trash;

    @Autowired
    IClientRepository repository;

    private List<Client> list = new ArrayList<>();

    @PostConstruct
    void init(){
        list = trash.getClients();
        list.size();
        repository.saveAll(list);
    }

    @Override
    public Client create(Client client) {
        client.setCreated_at(LocalDateTime.now());
        client.setModified_at(LocalDateTime.now());
        return repository.save(client);
    }



    @Override
    public Client get(String id) {
        return repository.findById(id).orElse(null);
    }


    @Override
    public Client update(Client client) {
        client.setModified_at(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client delete(String id) {
        Client client = this.get(id);
        repository.deleteById(id);
        return client;
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }
}
