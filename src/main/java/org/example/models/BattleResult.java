package org.example.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BattleResult {

    private String winnerName;
    private Long winnerPower;
    private String winnerImageUrl;
    private boolean isWon;
    private boolean isTie;

    public BattleResult(String winnerName, Long winnerPower, String winnerImageUrl, boolean isWon, boolean isTie) {
        this.winnerName = winnerName;
        this.winnerPower = winnerPower;
        this.winnerImageUrl = winnerImageUrl;
        this.isWon = isWon;
        this.isTie = isTie;
    }

    public boolean isWon() {
        return isWon;
    }

    public boolean isTie() {
        return isTie;
    }
}
