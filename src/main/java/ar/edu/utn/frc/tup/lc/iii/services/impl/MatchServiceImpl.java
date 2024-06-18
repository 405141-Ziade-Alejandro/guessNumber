package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lc.iii.entities.UserEntity;
import ar.edu.utn.frc.tup.lc.iii.models.*;
import ar.edu.utn.frc.tup.lc.iii.repositories.MatchRepository;
import ar.edu.utn.frc.tup.lc.iii.services.MatchService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Random random = new Random();

    @Override
    public MatchModel getMatchById(Long id) {
        Optional<MatchEntity> matchEntityOptional = matchRepository.findById(id);
        if (matchEntityOptional.isPresent()) {
            return modelMapper.map(matchEntityOptional.get(), MatchModel.class);
        } else {
            throw new EntityNotFoundException();
        }

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
    public RoundMatch playMatch(MatchModel match, Integer number) {
        RoundMatch roundMatch = new RoundMatch();
        roundMatch.setMatch(match);
        if (match.getStatus().equals(MatchStatus.FINISH)){
            //todo error
            return null;
        }
        if (match.getNumberToGuess().equals(number)) {
            //todo dar respuesta y calcular score
            match.setStatus(MatchStatus.FINISH);
            roundMatch.setRespuesta("Gano");
            return null;
        } else {
            match.setRemainingTries(match.getRemainingTries() - 1);
            if (match.getRemainingTries() == 0) {
                match.setStatus(MatchStatus.FINISH);
                roundMatch.setRespuesta("sin mas intentos, ust perdio");
            } else {
                if(number>match.getNumberToGuess()){
                    roundMatch.setRespuesta("Menor");

                } else {
                    roundMatch.setRespuesta("Mayor");

                }
            }
        }
        UserEntity userEntity = modelMapper.map(match.getUser(), UserEntity.class);
        MatchEntity matchEntity = modelMapper.map(match, MatchEntity.class);
        matchEntity.setUserEntity(userEntity);
        matchRepository.save(matchEntity);

        return roundMatch;
    }

    @Override
    public MatchModel updateMatch(MatchModel matchModel) {
        return null;
    }

    @Override
    public void deleteMatch(MatchModel matchModel) {

    }
}
