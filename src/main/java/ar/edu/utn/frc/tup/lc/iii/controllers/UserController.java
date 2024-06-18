package ar.edu.utn.frc.tup.lc.iii.controllers;


import ar.edu.utn.frc.tup.lc.iii.dtos.*;
import ar.edu.utn.frc.tup.lc.iii.models.MatchModel;
import ar.edu.utn.frc.tup.lc.iii.models.RoundMatch;
import ar.edu.utn.frc.tup.lc.iii.models.UserModel;
import ar.edu.utn.frc.tup.lc.iii.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guess-number/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {

        return null;
    }

    @GetMapping("")
    public ResponseEntity<UserDto> getUserList() {

        return null;
    }

    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {
        UserModel user = userService.createUser(dto.getUserName(), dto.getEmail());

        UserDto userDtoReturn = modelMapper.map(user, UserDto.class);
        return ResponseEntity.ok(userDtoReturn);
    }


    @PostMapping("/{userId}/matches")
    public ResponseEntity<MatchDto> createUserMatch(@PathVariable Long userId,@RequestBody CreateUserMatchDto createUserMatchDto) {

        MatchModel match = userService.createUserMatch(userId,createUserMatchDto.getMatchDificulty());
        MatchDto matchDto = modelMapper.map(match, MatchDto.class);
        return ResponseEntity.ok(matchDto);
    }

    @PostMapping("/{userId}/matches/{matchId}")
    public ResponseEntity<RoundMatchDto> playUserMatch(@PathVariable Long userId, @PathVariable Long matchId, @RequestBody PlayUserMatchDo playUserMatchDo) {


        RoundMatch roundMatch = userService.playUserMatch(userId,matchId,playUserMatchDo.getNumber());
        MatchDto matchDto = modelMapper.map(roundMatch.getMatch(), MatchDto.class);
        RoundMatchDto roundMatchDto = modelMapper.map(roundMatch, RoundMatchDto.class);
        roundMatchDto.setMatchDto(matchDto);
        return ResponseEntity.ok(roundMatchDto);
    }




}
