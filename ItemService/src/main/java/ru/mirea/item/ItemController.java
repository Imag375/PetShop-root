package ru.mirea.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "item/{id}/sub", method = RequestMethod.POST)
    @ResponseBody
    public void subItem(@PathVariable int id) throws IOException {
        itemService.subItem(id);
    }

    @RequestMapping(value = "item/{id}/add", method = RequestMethod.POST)
    @ResponseBody
    public void addItem(@PathVariable int id) throws IOException {
        itemService.addItem(id);
    }
}
