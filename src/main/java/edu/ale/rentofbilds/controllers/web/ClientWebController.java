package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/client")
public class ClientWebController {
    List<Client> clients = Stream.of(
            new Client("1","Alex Sergeevich", "Chernivtsi","123445",
                    LocalDate.of(2003, Month.APRIL,2), "esche tot bomj"),
            new Client("2","Bomj Gena", "Chernivtsi pod mostom","16543241",
                    LocalDate.of(2001, Month.APRIL,8), "esche tot bomj"),
            new Client("3","Alex Sergeevich", "Chernivtsi","123445",
                    LocalDate.of(2003, Month.APRIL,2), "esche tot bomj"),
            new Client("1","Alex Sergeevich", "Chernivtsi","123445",
                    LocalDate.of(2003, Month.APRIL,2), "esche tot bomj"))
            .collect(Collectors.toList());

    @RequestMapping("/list")
    String getList(Model model){
        model.addAttribute("clients",clients);
        return "clientsTable";
    }
    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {

        Client item = clients.stream().filter(element -> element.getId().equals(id)).findFirst().orElse(null);
        clients.remove(item);
        return "redirect:/web/client/list";
    }
    @RequestMapping("/edit/{id}")
    String editById(@PathVariable("id") String id){
        return "hello";
    }
}
