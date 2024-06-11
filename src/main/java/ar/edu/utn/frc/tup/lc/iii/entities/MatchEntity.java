package ar.edu.utn.frc.tup.lc.iii.entities;

import ar.edu.utn.frc.tup.lc.iii.models.MatchDificulty;
import ar.edu.utn.frc.tup.lc.iii.models.MatchStatus;
import ar.edu.utn.frc.tup.lc.iii.models.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "matches")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity userEntity;

    @Enumerated(EnumType.STRING)
    private MatchDificulty dificulty;

    private Integer numberToGuess;

    private Integer remainingTries;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;
}
