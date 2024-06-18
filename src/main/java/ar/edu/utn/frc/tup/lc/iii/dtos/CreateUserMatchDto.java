package ar.edu.utn.frc.tup.lc.iii.dtos;

import ar.edu.utn.frc.tup.lc.iii.models.MatchDificulty;
import lombok.Data;

@Data
public class CreateUserMatchDto {

    private MatchDificulty matchDificulty;
}
