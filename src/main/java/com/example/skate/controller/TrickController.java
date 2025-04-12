package com.example.skate.controller; // Declares the package for the TrickController class

import com.example.skate.model.Trick; // Imports the Trick entity
import com.example.skate.repository.TrickRepository; // Imports the repository interface to interact with the DB
import org.springframework.web.bind.annotation.*; // Imports Spring annotations for building REST API

import java.util.List; // Import for handling lists

@RestController
@RequestMapping("/api/tricks") // Base URL path for all endpoints in this controller (e.g., localhost:8080/api/tricks)
public class TrickController {

    private final TrickRepository trickRepo; // Dependency injection

    // Constructor to initialize the TrickRepository
    public TrickController(TrickRepository trickRepo) {
        this.trickRepo = trickRepo;
    }

    @GetMapping // GET request to return all tricks in the list at /api/tricks
    public List<Trick> getAllTricks() {
        return trickRepo.findAll(); // Retrieves all tricks from the database
    }

    @PostMapping // POST create trick in full
    public Trick createTrick(@RequestBody Trick trick) {
        return trickRepo.save(trick); // Saves a new trick to the database
    }

    @GetMapping("/{id}") // GET request for a specific trick by ID
    public Trick getTrickById(@PathVariable Long id) {
        return trickRepo.findById(id).orElseThrow(); // Retrieves trick by ID or throws exception if not found
    }

    @PutMapping("/{id}") // PUT update a full trick by ID
    public Trick updateTrick(@PathVariable Long id, @RequestBody Trick updated) {
        Trick trick = trickRepo.findById(id).orElseThrow(); // Finds the existing trick or throws if not found
        trick.setName(updated.getName()); // Updates the name
        trick.setStance(updated.getStance()); // Updates the stance
        trick.setDifficulty(updated.getDifficulty()); // Updates the difficulty
        return trickRepo.save(trick); // Saves the updated trick
    }

    @PatchMapping("/{id}") // PATCH partially update a trick
    public Trick patchTrick(@PathVariable Long id, @RequestBody Trick partialUpdate) {
        Trick trick = trickRepo.findById(id).orElseThrow(); // Gets the trick or throws if not found

        // Updates only if the new value is not null
        if (partialUpdate.getName() != null) trick.setName(partialUpdate.getName());
        if (partialUpdate.getStance() != null) trick.setStance(partialUpdate.getStance());
        if (partialUpdate.getDifficulty() != null) trick.setDifficulty(partialUpdate.getDifficulty());

        return trickRepo.save(trick); // Saves the partially updated trick
    }

    @DeleteMapping("/{id}") // DELETE a trick by ID
    public void deleteTrick(@PathVariable Long id) {
        trickRepo.deleteById(id); // Deletes the trick from the database
    }
}