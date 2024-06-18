package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.dtos.MatchDto;
import ar.edu.utn.frc.tup.lc.iii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lc.iii.entities.UserEntity;
import ar.edu.utn.frc.tup.lc.iii.models.*;
import ar.edu.utn.frc.tup.lc.iii.repositories.UserRepository;
import ar.edu.utn.frc.tup.lc.iii.services.MatchService;
import ar.edu.utn.frc.tup.lc.iii.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatchService matchService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserModel getUser(Long id) {
        return null;
    }

    @Override
    public List<UserModel> getUserList() {
        return List.of();
    }

    @Override
    public UserModel createUser(String userName, String email) {

        Optional<UserEntity> userOptional = userRepository.getByEmail(email);

        if (userOptional.isPresent()) {
            return null;//todo enviar error
        } else {
            UserEntity user = new UserEntity();
            user.setUserName(userName);
            user.setEmail(email);
            user = userRepository.save(user);
            return modelMapper.map(user, UserModel.class);
        }
    }

    @Override
    public MatchModel createUserMatch(Long userId, MatchDificulty dificulty) {

        Optional<UserEntity> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException();
        } else {
            UserModel user = modelMapper.map(userOptional.get(), UserModel.class);
            return matchService.createMatch(user,dificulty);
        }
    }

    @Override
    public RoundMatch playUserMatch(Long userId, Long matchId, Integer number) {
        MatchModel matchModel = matchService.getMatchById(matchId);
        if (matchModel.getUser().getId().equals(userId)) {
            return matchService.playMatch(matchModel,number);
        } else {
            return null;
        }

    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        return null;
    }

    @Override
    public void deleteUser(UserModel userModel) {

    }
}
