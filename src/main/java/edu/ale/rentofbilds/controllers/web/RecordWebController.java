package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.forms.ClientForm;
import edu.ale.rentofbilds.forms.RecordForm;
import edu.ale.rentofbilds.forms.SearchForm;
import edu.ale.rentofbilds.model.Build;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Gender;
import edu.ale.rentofbilds.model.Record;
import edu.ale.rentofbilds.service.client.impls.CrudClientMongoImpl;
import edu.ale.rentofbilds.service.record.impls.ServiceRecordMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/record/")
public class RecordWebController {
    @Autowired
    ServiceRecordMongoImpl service;

    @Autowired
    CrudClientMongoImpl clientService;

    @Autowired
    FakeData fakeData;

    Build standart = new Build("1", "build1", LocalDateTime.now(), LocalDateTime.now());

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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        List<String> clients = clientService.getAll()
                .stream().map(client -> client.getName() + " " + client.getPhone())
                .collect(Collectors.toList());

        Map<String, String> clientMap = new HashMap<>();
        for (Client client: clientService.getAll()){
            clientMap.put(client.getId(), client.getName() + " " + client.getPhone());
        }

        RecordForm recordForm = new RecordForm();
        model.addAttribute("form", recordForm);
        model.addAttribute("clients", clientMap);
        return "recordAddForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") RecordForm recordForm, Model model) {
        Record record = new Record();
        record.setName(recordForm.getName());
        record.setDescription(recordForm.getDescription());

        String startAsString = recordForm.getStart();
        LocalDate startAsDate = LocalDate.parse(startAsString);
        LocalDateTime startAsDateTime = startAsDate.atTime(0,0,0);
        record.setStart(startAsDateTime);

        record.setFinish(LocalDate.parse(recordForm.getFinish()).atTime(0,0,0));
        String clientId = recordForm.getClient();
        Client client = clientService.get(clientId);
        record.setClient(client);
        record.setBuild(standart);

        service.create(record);
        return "redirect:/web/record/all";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id) {
        Record record = service.get(id);
        RecordForm recordForm = new RecordForm();
        recordForm.setName(record.getName());
        recordForm.setDescription(record.getDescription());
        recordForm.setFinish(record.getFinish().toLocalDate().toString());
        recordForm.setStart(record.getStart().toLocalDate().toString());
        List<String> clients = clientService.getAll()
                .stream().map(client -> client.getName())
                .collect(Collectors.toList());
        String clientName = recordForm.getClient();
        Client client = clientService.getByName(clientName).get(0);
        clients.remove(clientName);
        clients.add(0,clientName);
        record.setClient(client);
       // recordForm.setBuild(record.getBuild());
        model.addAttribute("form", recordForm);
        model.addAttribute("clients", clients);
        return "updateRecord";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute ("form") RecordForm recordForm
            , @PathVariable("id") String id) {
        Record record = service.get(id);
        record.setName(recordForm.getName());
        record.setDescription(recordForm.getDescription());
        record.setFinish(LocalDate.parse(recordForm.getStart()).atTime(0, 0, 0));
        record.setStart(LocalDate.parse(recordForm.getStart()).atTime(0,0,0));
        String clientName = recordForm.getClient();
        Client client = clientService.getByName(clientName).get(0);
        record.setClient(client);
        service.update(record);
        return "redirect:/web/record/all";
    }
    @RequestMapping("/renew")
    String  renew(Model model) {
        model.addAttribute("records", fakeData.renewRecrds());
        return "recordsTable";}
}
