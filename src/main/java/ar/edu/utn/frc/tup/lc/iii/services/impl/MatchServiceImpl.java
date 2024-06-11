package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lc.iii.entities.UserEntity;
import ar.edu.utn.frc.tup.lc.iii.models.MatchDificulty;
import ar.edu.utn.frc.tup.lc.iii.models.MatchModel;
import ar.edu.utn.frc.tup.lc.iii.models.MatchStatus;
import ar.edu.utn.frc.tup.lc.iii.models.UserModel;
import ar.edu.utn.frc.tup.lc.iii.repositories.MatchRepository;
import ar.edu.utn.frc.tup.lc.iii.services.MatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Random random = new Random();

    @Override
    public MatchModel getMatch(Long id) {
        return null;
    }

    @Override
    public List<MatchModel> getMatchList() {
        return List.of();
    }

    @Override
    public MatchModel createMatch(UserModel user, MatchDificulty dificulty) {
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setUserEntity(modelMapper.map(user, UserEntity.class));
        matchEntity.setDificulty(dificulty);
        matchEntity.setCreatedAt(LocalDateTime.now());
        matchEntity.setUpdatedAt(LocalDateTime.now());
        matchEntity.setStatus(MatchStatus.PLAYING);
        switch (dificulty) {
            case HARD -> matchEntity.setRemainingTries(5);
            case MEDIUM -> matchEntity.setRemainingTries(8);
            case EASY -> matchEntity.setRemainingTries(10);
        }
        matchEntity.setNumberToGuess(random.nextInt(100)+1);
        matchEntity= matchRepository.save(matchEntity);

        return modelMapper.map(matchEntity, MatchModel.class);
    }

    @Override
    public MatchModel updateMatch(MatchModel matchModel) {
        return null;
    }

    @Override
    public void deleteMatch(MatchModel matchModel) {

    }
}
