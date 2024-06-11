package ar.edu.utn.frc.tup.lc.iii.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchModel {

    private Long id;

    private UserModel user;

    private MatchDificulty dificulty;

    private int numberToGuess;

    private int remainingTries;

    private MatchStatus status;
}
