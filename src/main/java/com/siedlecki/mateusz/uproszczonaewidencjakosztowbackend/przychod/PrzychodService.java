package com.siedlecki.mateusz.uproszczonaewidencjakosztowbackend.przychod;

import com.siedlecki.mateusz.uproszczonaewidencjakosztowbackend.przychod.dto.DaneDoTabeliDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrzychodService {

    private final PrzychodRepository repository;

    public PrzychodService(PrzychodRepository repository) {
        this.repository = repository;
    }

    List<PrzychodEntity> findAll(){
        return repository.findAll();
    }

    PrzychodEntity save(PrzychodEntity wpis){
        return repository.save(wpis);
    }

    void deleteById(Integer id){
        repository.deleteById(id);
    }

    Optional<PrzychodEntity> findById(Integer id){
        return repository.findById(id);
    }

    public DaneDoTabeliDto getDaneDoTabeli(Integer rok, Integer miesiac) {
        List<PrzychodEntity> all = repository.findAll();
        if (rok!=null){
            all = all.stream().filter(przychod->przychod.getDate().getYear()==rok).collect(Collectors.toList());
        }
        if (miesiac!=null){
            all = all.stream().filter(przychod->przychod.getDate().getMonth().getValue()==miesiac).collect(Collectors.toList());
        }
        return new DaneDoTabeliDto(all);
    }
}
