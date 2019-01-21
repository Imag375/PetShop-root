package ru.mirea.stuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import ru.mirea.domain.Stuff;

@Controller
public class StuffController {

    @Autowired
    private StuffDAO stuffDAO;

    @RequestMapping(value = "stuff",method = RequestMethod.GET)
    @ResponseBody
    public List<Stuff> getAllStuffs(){
        return stuffDAO.findAll();
    }

    @RequestMapping(value = "stuff/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Stuff> getStuff(@PathVariable int id){
        return stuffDAO.findStuffByID(id);
    }

    @RequestMapping(value = "stuff/{id}/price",method = RequestMethod.GET)
    @ResponseBody
    public List<Stuff> getPriceOfStuff(@PathVariable int id){
        return stuffDAO.findThePriceOfStuff(id);
    }
}
