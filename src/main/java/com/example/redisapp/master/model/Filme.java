package com.example.redisapp.master.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RedisHash("Filme")
@TypeAlias("filmes")
public class Filme implements Serializable {

//    private static final long serialVersionUID = 1L;
//    private static long longId = 100;

    @Id
    private String id;

    private String nome;
    private Long duração;




    //    public Filme(String id) {
//        this.id = id;
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getDuração() {
        return duração;
    }

    public void setDuração(Long duração) {
        this.duração = duração;
    }

//    public static String generateNextId() {
//        return String.valueOf(longId++);
//    }
}
