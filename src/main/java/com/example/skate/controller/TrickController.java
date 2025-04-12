package com.example.skate.controller;

import com.example.skate.model.Trick;
import com.example.skate.repository.TrickRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tricks")
public class TrickController {

    private final TrickRepository trickRepo;

    public TrickController(TrickRepository trickRepo) {
        this.trickRepo = trickRepo;
    }

    @GetMapping
    public List<Trick> getAllTricks() {
        return trickRepo.findAll();
    }

    @PostMapping
    public Trick createTrick(@RequestBody Trick trick) {
        return trickRepo.save(trick);
    }

    @GetMapping("/{id}")
    public Trick getTrickById(@PathVariable Long id) {
        return trickRepo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Trick updateTrick(@PathVariable Long id, @RequestBody Trick updated) {
        Trick trick = trickRepo.findById(id).orElseThrow();
        trick.setName(updated.getName());
        trick.setStance(updated.getStance());
        trick.setDifficulty(updated.getDifficulty());
        return trickRepo.save(trick);
    }

    @DeleteMapping("/{id}")
    public void deleteTrick(@PathVariable Long id) {
        trickRepo.deleteById(id);
    }

    // PATCH → Aggiorna parzialmente un trick esistente
    @PatchMapping("/{id}")
    public Trick partialUpdateTrick(@PathVariable Long id, @RequestBody Trick updated) {
        Trick trick = trickRepo.findById(id).orElseThrow();

        // Aggiorna solo i campi che sono presenti nel corpo della richiesta
        if (updated.getName() != null) {
            trick.setName(updated.getName());
        }
        if (updated.getStance() != null) {
            trick.setStance(updated.getStance());
        }
        if (updated.getDifficulty() != null) {
            trick.setDifficulty(updated.getDifficulty());
        }

        return trickRepo.save(trick);
    }
}