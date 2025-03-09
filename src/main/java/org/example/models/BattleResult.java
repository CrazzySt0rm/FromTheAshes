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
    private boolean isMageWinner;

    public BattleResult(String winnerName, long winnerPower, String winnerImageUrl, boolean isMageWinner) {
        this.winnerName = winnerName;
        this.winnerPower = winnerPower;
        this.winnerImageUrl = winnerImageUrl;
        this.isMageWinner = isMageWinner;
    }
}
