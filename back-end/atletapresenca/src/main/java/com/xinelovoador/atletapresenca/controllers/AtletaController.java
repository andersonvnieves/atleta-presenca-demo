package com.xinelovoador.atletapresenca.controllers;

import com.xinelovoador.atletapresenca.domain.DTO.AtletaDTO;
import com.xinelovoador.atletapresenca.domain.Entities.Atleta;
import com.xinelovoador.atletapresenca.persistence.DAOs.AtletaDAO;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin(origins = "*")
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

    @PostMapping("/save")
    public void postAtleta(@ModelAttribute AtletaDTO atletaDTO) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Atleta atleta = new Atleta();
        atleta.setNomeCompleto(atletaDTO.getNomeCompleto());
        atleta.setDataNascimento(format.parse(atletaDTO.getDataNascimento()));
        atleta.setEmail(atletaDTO.getEmail());
        atleta.setCelular(atletaDTO.getCelular());
        atletaDAO.save(atleta);
    }

    @GetMapping("/list")
    public List<Atleta> getAtletas() {
        return atletaDAO.listAll();
    }
}
