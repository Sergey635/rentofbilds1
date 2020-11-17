package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.forms.ClientForm;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Gender;
import edu.ale.rentofbilds.service.client.impls.CrudClientMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/client")
public class ClientWebController {
    @Autowired
    CrudClientMongoImpl service;

    @RequestMapping("/all") // rest возращает JASON
    String  getAll(Model model) {
        model.addAttribute("clients", service.getAll());
        return "clientsTable";
    }
    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);

        return "redirect:/web/client/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String create(Model model) {
        List<String> genders = Stream.of(Gender.values()).map(Gender::name).collect(Collectors.toList());
        ClientForm clientForm = new ClientForm();
        model.addAttribute("form", clientForm);
        model.addAttribute("genders", genders);
        return "clientAddForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") ClientForm form, Model model) {
        Client client = new Client();
        client.setName(form.getName());
        client.setGender(form.getGender());
        client.setDescription(form.getDescription());
        client.setAdres(form.getAdres());
        client.setBirthday(LocalDate.parse(form.getBirthday()));
        client.setPhone(form.getPhone());
        service.create(client);
        return "redirect:/web/client/all";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id) {
        Client client = service.get(id);
        List<String> genders = Stream.of(Gender.values()).map(Gender::name).collect(Collectors.toList());
        ClientForm clientForm = new ClientForm();
        clientForm.setId(client.getId());
        clientForm.setName(client.getName());
        clientForm.setGender(client.getGender());
        clientForm.setDescription(client.getDescription());
        clientForm.setAdres(client.getAdres());
        clientForm.setBirthday(client.getBirthday().toString());
        clientForm.setPhone(client.getPhone());
        model.addAttribute("form", clientForm);
        model.addAttribute("genders", genders);
        return "updateClient";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute ("form") ClientForm form
            , @PathVariable("id") String id) {
        Client client = service.get(id);
        client.setName(form.getName());
        client.setGender(form.getGender());
        client.setDescription(form.getDescription());
        client.setAdres(form.getAdres());
        client.setBirthday(LocalDate.parse(form.getBirthday()));
        client.setPhone(form.getPhone());
        service.update(client);
        return "redirect:/web/client/all";
    }
}
