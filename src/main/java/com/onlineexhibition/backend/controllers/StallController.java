package com.onlineexhibition.backend.controllers;

import com.onlineexhibition.backend.entity.Stalls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.onlineexhibition.backend.services.StallService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/stalls")
public class StallController {

   @Autowired
   private StallService stallService;
   @Autowired
   private StallService theStallService;

   @GetMapping("/{id}")
   public Stalls findStallByGivenId(@PathVariable long id) {
      return theStallService.findGivenStallById(id);
   }

   @GetMapping("/")
   public List<Stalls> findAllStall() {
      return theStallService.getAllStalls();
   }

   @PostMapping("/add")
   public ResponseEntity<Stalls> addStall(@RequestBody Stalls stall) {
      Stalls newStall = stallService.addStall(stall);
      return ResponseEntity.created(URI.create("/stall/" + newStall.getId()))
              .body(newStall);
   }


}
