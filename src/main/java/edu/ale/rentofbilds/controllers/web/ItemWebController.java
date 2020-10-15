package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/item")
public class ItemWebController {
    List<Item> items = Stream.of(
            new Item("1", "Coca-Cola", "Drink",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("2", "Pepsi", "Drink",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("3", "Sprite", "Drink",
                    LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());

    @RequestMapping("/all") // rest возращает JASON
    String  getAll(Model model) {
        model.addAttribute("items", items);
        return "itemsTable";
    }
    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        Item item = items.stream().filter(element -> element.getId().equals(id)).findFirst().orElse(null);
        items.remove(item);
        return "redirect:/web/item/all";
    }


}
