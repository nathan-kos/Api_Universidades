package nks.rest_universidades.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Statuscontroller {
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/universidades/status")
    public String getStatus(){
        return "servidor ativo";
    }
}
