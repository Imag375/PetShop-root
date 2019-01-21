package ru.mirea.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import ru.mirea.domain.Pet;

@Controller
public class PetController {

    @Autowired
    private PetDAO petDAO;

    @RequestMapping(value = "pet",method = RequestMethod.GET)
    @ResponseBody
    public List<Pet> getAllPets(){
        return petDAO.findAll();
    }

    @RequestMapping(value = "pet/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Pet> getPet(@PathVariable int id){
        return petDAO.findPetByID(id);
    }

    @RequestMapping(value = "pet/{id}/price",method = RequestMethod.GET)
    @ResponseBody
    public List<Pet> getPriceOfPet(@PathVariable int id){
        return petDAO.findThePriceOfPet(id);
    }
}
