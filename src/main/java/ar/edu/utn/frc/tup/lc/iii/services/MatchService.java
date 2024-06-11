package ar.edu.utn.frc.tup.lc.iii.services;

import ar.edu.utn.frc.tup.lc.iii.entities.UserEntity;
import ar.edu.utn.frc.tup.lc.iii.models.MatchDificulty;
import ar.edu.utn.frc.tup.lc.iii.models.MatchModel;
import ar.edu.utn.frc.tup.lc.iii.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {

    MatchModel getMatch(Long id);

    List<MatchModel> getMatchList();

    MatchModel createMatch(UserModel user, MatchDificulty dificulty);

    MatchModel updateMatch(MatchModel matchModel);

    void deleteMatch(MatchModel matchModel);
}
