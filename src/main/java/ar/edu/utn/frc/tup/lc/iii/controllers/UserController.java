package ar.edu.utn.frc.tup.lc.iii.controllers;


import ar.edu.utn.frc.tup.lc.iii.dtos.MatchDto;
import ar.edu.utn.frc.tup.lc.iii.dtos.UserDto;
import ar.edu.utn.frc.tup.lc.iii.models.MatchDificulty;
import ar.edu.utn.frc.tup.lc.iii.models.MatchModel;
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


    @PostMapping("/{userId}/matches/{dificulty}")
    public ResponseEntity<MatchDto> createUserMatch(@PathVariable Long userId,@PathVariable MatchDificulty dificulty) {

        MatchModel match = userService.createUserMatch(userId,dificulty);
        MatchDto matchDto = modelMapper.map(match, MatchDto.class);
        return ResponseEntity.ok(matchDto);
    }

    @PutMapping("")
    public ResponseEntity<UserDto> updateUser(UserDto dto) {

        return null;
    }

    @DeleteMapping("")
    public ResponseEntity<UserDto> deleteUser(UserDto dto) {

        return null;
    }
}
