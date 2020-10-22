package edu.ale.rentofbilds.controllers.rest;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/item")
public class ItemRestController {
 @Autowired

 ItemServiceImpl service;

    @RequestMapping("get/all")
    List<Item> getAll() {
        return service.getAll();
    }



    @RequestMapping("/delete/{id}")
    Item deleteById(@PathVariable("id") String id) {
       /* Item item = service.getAll().stream().filter(element -> element.getId().equals(id)).findFirst().orElse(null);
        service.getAll().remove(item);*/
        return service.delete(id);
    }
    @RequestMapping("/get/{id}")
    Item getById(@PathVariable("id") String id) {

        return service.get(id);
    }
    @PostMapping("/create")
    Item create(@RequestBody Item item) {
        return service.create(item);

    }
    @PutMapping("/update")
        Item update(@RequestBody Item item) {
            return service.update(item);
    }
}
