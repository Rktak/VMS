package com.management.VMS.controller;


import com.management.VMS.dto.AllVisitsByPageResponseBody;
import com.management.VMS.dto.VisitDto;
import com.management.VMS.enums.VisitStatus;
import com.management.VMS.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resident")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @PostMapping("/actOnVisit/{id}")
    public ResponseEntity<String> actOnVisit(@PathVariable Long id, @RequestParam VisitStatus visitStatus){
        return ResponseEntity.ok(residentService.updateVisit(visitStatus,id));
    }

    @GetMapping("/pendingVisits")
    public ResponseEntity<List<VisitDto>> getPendingVisits(@RequestHeader Long userId){
        return ResponseEntity.ok(residentService.getPendingVisits(userId));
    }


    @GetMapping("/allVisitsByPage")
    public ResponseEntity<AllVisitsByPageResponseBody> getPendingVisits(@RequestHeader Long userId, @RequestParam Integer pageNo, @RequestParam Integer pageSize){
        Pageable pageable = Pageable.ofSize(pageSize)
                .withPage(pageNo);
        return ResponseEntity.ok(residentService.getAllVisits(userId,pageable));
    }


}
