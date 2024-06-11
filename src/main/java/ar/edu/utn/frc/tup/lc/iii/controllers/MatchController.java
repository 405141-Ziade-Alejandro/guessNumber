package ar.edu.utn.frc.tup.lc.iii.controllers;

import ar.edu.utn.frc.tup.lc.iii.dtos.DummyDto;
import ar.edu.utn.frc.tup.lc.iii.dtos.MatchDto;
import ar.edu.utn.frc.tup.lc.iii.models.Dummy;
import ar.edu.utn.frc.tup.lc.iii.services.MatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guess-number/match")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/{id}")
    public ResponseEntity<MatchDto> getMatch(@PathVariable Long id) {

        return null;
    }

    @GetMapping("")
    public ResponseEntity<MatchDto> getMatchList() {

        return null;
    }

    @PostMapping("")
    public ResponseEntity<MatchDto> createMatch(MatchDto dto) {

        return null;
    }

    @PutMapping("")
    public ResponseEntity<MatchDto> updateMatch(MatchDto dto) {

        return null;
    }

    @DeleteMapping("")
    public ResponseEntity<MatchDto> deleteMatch(MatchDto dto) {

        return null;
    }
}
