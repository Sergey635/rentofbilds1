package edu.ale.rentofbilds.controllers.rest;

import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.service.client.impls.CrudClientMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {
    @Autowired

    CrudClientMongoImpl service;

    @RequestMapping("get/all")
    List<Client> getAll() {
        return service.getAll();
    }



    @RequestMapping("/delete/{id}")
    Client deleteById(@PathVariable("id") String id) {
        return service.delete(id);
    }
    @RequestMapping("/get/{id}")
    Client getById(@PathVariable("id") String id) {

        return service.get(id);
    }
    @PostMapping("/create")
    Client create(@RequestBody Client client) {

        return service.create(client);

    }
    @PutMapping("/update")
    Client update(@RequestBody Client client) {
        return service.update(client);
    }
  }
