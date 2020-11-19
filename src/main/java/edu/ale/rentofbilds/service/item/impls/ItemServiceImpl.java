package edu.ale.rentofbilds.service.item.impls;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.item.interfaces.ICrudItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ItemServiceImpl implements ICrudItem {

    //@Autowired
    FakeData trash;

    @Override
    public Item create(Item item) {
        if (item.getId() != null) {
            this.getAll().add(item);
        }else {
             Integer id = //беремо список всіх ІТЕМОВ і перетворюємо у stream.
                    this.getAll().stream()//перетворюємо його у стрім айдішніків
                            .map(el -> el.getId())
                            //айдішніки перетворюємо зі стрінга в інтеджер
                    .mapToInt(el -> Integer.valueOf(el))
                            //нахожимо максимальний
                            .max().orElse(0);
             //максимальний айдішнік збільшуємо на 1 і перетворюємо в стрінг
            item.setId(String.valueOf(id + 1));
            //нашому айтему присвоюємо цей айдішнік
            //і закидуємо у список
            LocalDateTime now = LocalDateTime.now();
            item.setModified_at(now);
            item.setCreated_at(now);
            this.getAll().add(item);
        }

        return item;
    }

    @Override
    public Item get(String id) {
        return this.getAll().stream().filter(item -> item.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @Override
    public Item update(Item item) {
        String id = item.getId();
        Item itemToUpdate = this.getAll().stream().filter(el -> el.getId().equals(id))
                .findFirst().orElse(null);
        int index = this.getAll().indexOf(itemToUpdate);
        item.setModified_at(LocalDateTime.now());
        this.getAll().set(index, item);
        return item;
    }

    @Override
    public Item delete(String id) {
        Item item = this.get(id);
        this.getAll().remove(item);

        return item;
    }

    @Override
    public List<Item> getAll() {

        return trash.getItems();
    }
}
