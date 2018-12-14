package com.example.redisapp.master.controller;

import com.example.redisapp.master.model.Filme;
import com.example.redisapp.master.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmeController {

    @Autowired
    private RedisRepository redisRepository;

//    @PostConstruct
    public void start(){
//        System.out.println("entrou --------------");
//        Filme filme = new Filme("5");
//        filme.setNome("Pinoquio4");
//        filme.setDuração(Long.valueOf(768));
////       redisRepository.save(filme);
////       System.out.println("salvo");
////       redisRepository.deleteById("135");
////       redisRepository.deleteAll();
//
//        List<Filme> allFilmes = redisRepository.findAllFilmes();
//        allFilmes.forEach(filme1 -> {
//            System.out.println("id : " + filme1.getId() + " nome : " + filme1.getNome() + " duracao " + filme1.getDuração());
//        });
//        Filme filme1 = redisRepository.findFilmeById("5");


        Filme filme = new Filme();
        filme.setNome("Pinoquio4");
        filme.setDuração(Long.valueOf(768));
//        redisRepository.save(filme);


//        Iterable<Filme> filmes = redisRepository.findAll();

    }


    @GetMapping("/get")
    ResponseEntity<?> get() {
//
//        Filme filme = new Filme();
//        filme.setNome("novo");
//        filme.setDuração(Long.valueOf(768));
//
//
//        redisRepository.save(filme);

        return ResponseEntity.status(HttpStatus.OK).body(redisRepository.findAll());
    }

    @GetMapping("/save")
    ResponseEntity<?> save() {

        Filme filme = new Filme();
        filme.setNome("novo");
        filme.setDuração(Long.valueOf(768));


        redisRepository.save(filme);

        return ResponseEntity.status(HttpStatus.OK).body(redisRepository.findAll());
    }

}
