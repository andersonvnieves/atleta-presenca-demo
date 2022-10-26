package com.xinelovoador.atletapresenca.controllers;

import com.xinelovoador.atletapresenca.domain.Atleta;
import com.xinelovoador.atletapresenca.persistence.DAOs.AtletaDAO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("atleta")
public class AtletaController {
    private AtletaDAO atletaDAO;
    private String connectionString = "jdbc:mariadb://localhost:3306/ATLETA_DB";
    private String username = "root";
    private String password = "12345";

    public AtletaController(){
        this.atletaDAO = new AtletaDAO(connectionString, username, password);
    }

    @GetMapping("/{id}")
    public Atleta getAtletaById(@PathVariable int id) {
        return atletaDAO.getById(id);
    }

    @PostMapping("/save")
    public void postAtleta(@RequestBody Atleta atleta) {
        atletaDAO.save(atleta);
    }

    @GetMapping("/list")
    public List<Atleta> getAtletas() {
        return atletaDAO.listAll();
    }
}
