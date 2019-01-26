package ru.mirea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public class ConfigStorageController {

    @Autowired
    private ConfigStorageService configStorageService;

    @RequestMapping(value ="config", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getConfigs(){
        return configStorageService.getAll();
    }
}
