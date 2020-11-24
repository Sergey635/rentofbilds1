package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.forms.ClientForm;
import edu.ale.rentofbilds.forms.RecordForm;
import edu.ale.rentofbilds.forms.SearchForm;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Gender;
import edu.ale.rentofbilds.model.Record;
import edu.ale.rentofbilds.service.record.impls.ServiceRecordMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/record/")
public class RecordWebController {
    @Autowired
    ServiceRecordMongoImpl service;

    @RequestMapping("/all")
    String  getAll(Model model) {
        model.addAttribute("records", service.getAll());
        //SearchForm search = new SearchForm();
        //model.addAttribute("search", search);
        return "recordsTable";
    }
    @PostMapping("/all")
    String getAll(Model model, @ModelAttribute("search") SearchForm form) {
        String name = form.getName();
        model.addAttribute("records", service.getByName(name));
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "recordsTable";
    }
    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);

        return "redirect:/web/record/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String create(Model model) {
        RecordForm recordForm = new RecordForm();
        model.addAttribute("form", recordForm);
        return "recordAddForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") RecordForm form, Model model) {
        Record record = new Record();
        record.setName(form.getName());
        //record.setStart();
        record.setDescription(form.getDescription());
        //record.setFinish();

        service.create(record);
        return "redirect:/web/record/all";
    }
    /*@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
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
    }*/

}
