package com.example.redisapp.master.service;

import com.example.redisapp.master.model.Filme;
import com.example.redisapp.master.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RedisService {

    @Autowired
    private RedisRepository redisRepository;

//    @Transactional
    public Filme save (Filme filme) throws Exception {

        Filme filme1 = new Filme();
        filme1.setNome("Batmam");
        filme1.setDuração(Long.valueOf(10));

        redisRepository.save(filme1);

//        if (2 == 2) {
//            throw new Exception("teste erro");
//        }

        Filme filme2 = new Filme();
        filme2.setNome("Superman");
        filme2.setDuração(Long.valueOf(10));

        redisRepository.save(filme2);

        return redisRepository.save(filme);
    }
}
