package com.siedlecki.mateusz.uproszczonaewidencjakosztowbackend.przychod;

import com.siedlecki.mateusz.uproszczonaewidencjakosztowbackend.przychod.dto.DaneDoTabeliDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"https://ewinat.herokuapp.com","http://localhost:4200"})
@RestController
@RequestMapping("/przychod")
public class PrzychodRestController {

    private final PrzychodService przychodService;

    public PrzychodRestController(PrzychodService przychodService) {
        this.przychodService = przychodService;
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Integer id){
        Optional<PrzychodEntity> wpisOpt = przychodService.findById(id);
        if (wpisOpt.isPresent()){
            return ResponseEntity.ok(wpisOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    ResponseEntity<List<PrzychodEntity>> getAll(){
        return ResponseEntity.ok(przychodService.findAll());
    }

    @PostMapping
    ResponseEntity<PrzychodEntity> save(@RequestBody PrzychodEntity wpis){
        PrzychodEntity saved = przychodService.save(wpis);
        return ResponseEntity.created(URI.create("/"+saved.getId())).body(saved);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteById(@PathVariable Integer id){
        przychodService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pobierzDaneDoTabeli")
    ResponseEntity<DaneDoTabeliDto> getDaneDoTabeli(@RequestParam(required = false) Integer rok,
                                                    @RequestParam(required = false) Integer miesiac){
        return ResponseEntity.ok(przychodService.getDaneDoTabeli(rok,miesiac));
    }
}
