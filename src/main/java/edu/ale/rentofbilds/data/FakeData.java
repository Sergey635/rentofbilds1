package edu.ale.rentofbilds.data;

import edu.ale.rentofbilds.model.Build;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.model.Record;
import edu.ale.rentofbilds.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Repository
public class FakeData {
    @Autowired
    RecordRepository recordRepository;

    private List<Build> builds = Stream.of(
            new Build("1","build","center",LocalDateTime.now(),LocalDateTime.now()),
            new Build("2","build1","est",LocalDateTime.now(),LocalDateTime.now()),
            new Build("3","build2","west",LocalDateTime.now(),LocalDateTime.now()),
            new Build("4","build3","center",LocalDateTime.now(),LocalDateTime.now()))
            .collect(Collectors.toList());



    private List<Item> items = Stream.of(
            new Item("1", "Coca-Cola", "Drink",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("2", "Pepsi", "Drink",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("3", "Sprite", "Drink",
                    LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

   private List<Client> clients = Stream.of(
            new Client("1","Alex Sergeevich","", "Chernivtsi","123445",
                    LocalDate.of(2003, Month.APRIL,2),"esche tot bomj"),
            new Client("2","Bomj Gena","", "Chernivtsi pod mostom","16543241",
                    LocalDate.of(2001, Month.APRIL,8), "esche tot bomj"),
            new Client("3","Alex Sergeevich","", "Chernivtsi","123445",
                    LocalDate.of(2003, Month.APRIL,2), "esche tot bomj"),
            new Client("4","Alex Sergeevich","", "Chernivtsi","123445",
                    LocalDate.of(2003, Month.APRIL,2), "esche tot bomj"))
            .collect(Collectors.toList());

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    private List<Record> records = Stream.of(
            new Record("1","record1","desk1",LocalDateTime.now(),LocalDateTime.now(),
                    clients.get(0), builds.get(0),LocalDateTime.now(), LocalDateTime.now()),
            new Record("2","record2","desk2",LocalDateTime.now(),LocalDateTime.now(),
                    clients.get(1), builds.get(1),LocalDateTime.now(), LocalDateTime.now()),
            new Record("3","record3","desk3",LocalDateTime.now(),LocalDateTime.now(),
                    clients.get(2), builds.get(2),LocalDateTime.now(), LocalDateTime.now()),
            new Record("4","record4","desk4",LocalDateTime.now(),LocalDateTime.now(),
                    clients.get(3), builds.get(3),LocalDateTime.now(), LocalDateTime.now()))
            .collect(Collectors.toList());

        @PostConstruct
        void init(){
            recordRepository.saveAll(records);
        }





    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
