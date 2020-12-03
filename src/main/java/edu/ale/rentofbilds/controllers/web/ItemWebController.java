package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.forms.ItemForm;
import edu.ale.rentofbilds.forms.SearchForm;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.item.impls.CrudItemMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/item")
public class ItemWebController {
    @Autowired
    CrudItemMongoImpl service;

    @RequestMapping("/all")
        // rest возращает JASON
    String getAll(Model model) {
        model.addAttribute("items", service.getAll());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }
    @PostMapping("/all")
    String getAll(Model model, @ModelAttribute("search") SearchForm form) {
        String name = form.getName();
        model.addAttribute("items", service.getByName(name));
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);
      /*  Item item = service.getAll().stream().filter(element -> element.getId().equals(id)).findFirst().orElse(null);
        service.getAll().remove(item);*/
        return "redirect:/web/item/all";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        ItemForm itemForm = new ItemForm();
        model.addAttribute("form", itemForm);
        return "itemAddForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") ItemForm form, Model model) {
        Item item = new Item();
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        service.create(item);
        return "redirect:/web/item/all";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id) {
        Item item = service.get(id);
        ItemForm itemForm = new ItemForm();
        itemForm.setId(item.getId());
        itemForm.setName(item.getName());
        itemForm.setDescription(item.getDescription());
        model.addAttribute("form", itemForm);
        return "updateItem";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("form") ItemForm form
            , @PathVariable("id") String id) {
        Item item = service.get(id);
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        service.update(item);
        return "redirect:/web/item/all";
    }

    @RequestMapping(value = "/all/sort", method = RequestMethod.GET)
    public String sortedByName(Model model) {
        model.addAttribute("items", service.getAllSorted());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }
}
