package edu.ale.rentofbilds.service.client.impls;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.client.interfaces.ICrudClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientServiceImpl implements ICrudClient {
    @Autowired
    FakeData trash;

    @Override
    public Client create(Client client) {
        if (client.getId() != null) {
            this.getAll().add(client);
        }else {
            Integer id = //беремо список всіх ІТЕМОВ і перетворюємо у stream.
                    this.getAll().stream()//перетворюємо його у стрім айдішніків
                            .map(el -> el.getId())
                            //айдішніки перетворюємо зі стрінга в інтеджер
                            .mapToInt(el -> Integer.valueOf(el))
                            //нахожимо максимальний
                            .max().orElse(0);
            //максимальний айдішнік збільшуємо на 1 і перетворюємо в стрінг
            client.setId(String.valueOf(id + 1));
            //нашому айтему присвоюємо цей айдішнік
            //і закидуємо у список
            LocalDateTime now = LocalDateTime.now();
            client.setModified_at(now);
            client.setCreated_at(now);
            this.getAll().add(client);
        }

        return client;
    }

    @Override
    public Client get(String id) {
        return this.getAll().stream().filter(item -> item.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @Override
    public Client update(Client client) {
        String id = client.getId();
        Client clientToUpdate = this.getAll().stream().filter(el -> el.getId().equals(id))
                .findFirst().orElse(null);
        int index = this.getAll().indexOf(clientToUpdate);
        client.setModified_at(LocalDateTime.now());
        this.getAll().set(index, client);
        return client;
    }

    @Override
    public Client delete(String id) {
        Client client = this.get(id);
        this.getAll().remove(client);

        return client;
    }

    @Override
    public List<Client> getAll() {

        return trash.getClients();
    }

}
