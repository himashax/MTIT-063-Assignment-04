package com.MTIT.Assignment.HallBooking.controller;

import com.MTIT.Assignment.HallBooking.exception.ResourceNotFoundException;
import com.MTIT.Assignment.HallBooking.model.Hall;
import com.MTIT.Assignment.HallBooking.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/halls")
public class HallController {

    @Autowired
    private HallRepository hallRepository;

    /*
    getAllMovieHallDetails
     */
    @GetMapping
    public List<Hall> getAllHalls(){
        return hallRepository.findAll();
    }

    /*Add Hall method
     */
    @PostMapping
    public Hall addHall(@RequestBody Hall hall){
        return hallRepository.save(hall);
    }

    /*Get Hall by id method
     */
    @GetMapping("/{id}")
    public ResponseEntity<Hall> getHallById(@PathVariable Long id){
        Hall hall = hallRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hall is not existing with this id:" + id));
        return ResponseEntity.ok(hall);
    }


    /*Update Hall Details method
     */
    @PutMapping("{id}")
    public ResponseEntity<Hall> updateHallDetails(@PathVariable long id, @RequestBody Hall hallDetails){
        Hall updateHallDetails = hallRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hall is not existing with this id:" + id));
        updateHallDetails.setHallName(hallDetails.getHallName());
        updateHallDetails.setHallType(hallDetails.getHallType());
        updateHallDetails.setLocation(hallDetails.getLocation());
        updateHallDetails.setAvailability(hallDetails.getAvailability());
        updateHallDetails.setSeatCapacity(hallDetails.getSeatCapacity());

        hallRepository.save(updateHallDetails);
        return ResponseEntity.ok(updateHallDetails);
    }

    /*Delete HallDetails method
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Hall> deleteHall(@PathVariable long id){
        Hall hall =  hallRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hall not exists with id:" + id));
        hallRepository.delete(hall);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
