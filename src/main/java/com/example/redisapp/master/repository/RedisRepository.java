package com.example.redisapp.master.repository;

import com.example.redisapp.master.model.Filme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends CrudRepository<Filme, String> {


//    List<Filme> findAllFilmes();
//    void save(Filme filme);
//    void deleteById(String id);
//    void deleteAll();
//    Filme findFilmeById(String id);
}
