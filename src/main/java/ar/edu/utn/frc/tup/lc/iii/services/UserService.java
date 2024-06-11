package ar.edu.utn.frc.tup.lc.iii.services;

import ar.edu.utn.frc.tup.lc.iii.dtos.MatchDto;
import ar.edu.utn.frc.tup.lc.iii.models.MatchDificulty;
import ar.edu.utn.frc.tup.lc.iii.models.MatchModel;
import ar.edu.utn.frc.tup.lc.iii.models.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public interface UserService {

    UserModel getUser(Long id);

    List<UserModel> getUserList();

    UserModel createUser(String userName, String email);

    MatchModel createUserMatch(Long userId,MatchDificulty dificulty);

    UserModel updateUser(UserModel userModel);

    void deleteUser(UserModel userModel);
}
