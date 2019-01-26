package ru.mirea.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.mirea.Item;
import ru.mirea.Pet;

import java.util.List;



@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @RequestMapping(value = "pet",method = RequestMethod.GET)
    @ResponseBody
    public List<Pet> getAllPets(){
        return petService.findAll();
    }

    @RequestMapping(value = "pet/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Pet> getPet(@PathVariable int id){
        return petService.findPetByID(id);
    }

    @RequestMapping(value = "pet/{id}/price",method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getPriceOfPet(@PathVariable int id){
        return petService.findThePriceOfPet(id);
    }
}
