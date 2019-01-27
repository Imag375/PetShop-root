package ru.mirea.configStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ConfigStorageController {

    @Autowired
    private ConfigStorageService configStorageService;

    @RequestMapping(value ="config", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getConfigs(){
        return configStorageService.getAll();
    }
}
