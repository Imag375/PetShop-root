package ru.mirea.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import java.util.List;

import org.springframework.stereotype.Service;
import ru.mirea.domain.Pet;

@Service
public class PetService {

    private PetDAO petDAO;

    @Autowired
    public PetService(PetDAO petDAO){
        this.petDAO = petDAO;
    }

    @Nullable
    public List<Pet> findAll() {
        return petDAO.findAll();
    }

    @Nullable
    public List<Pet> findPetByID(int id) {
        return petDAO.findPetByID(id);
    }

    @Nullable
    public List<Pet> findThePriceOfPet(int id) {
        return petDAO.findThePriceOfPet(id);
    }
}
