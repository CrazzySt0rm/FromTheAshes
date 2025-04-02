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
    private String loserImageUrl; // Новое поле для изображения проигравшего
    private String loserName; // Новое поле для имени проигравшего
    private Long loserPower;  // Новое поле для силы проигравшего
    private boolean isWinner;
    private boolean isDraw;

    public BattleResult(String winnerName, Long winnerPower, String winnerImageUrl, String loserName, Long loserPower,
                        String loserImageUrl, boolean isWinner, boolean isDraw) {
        this.winnerName = winnerName;
        this.winnerPower = winnerPower;
        this.winnerImageUrl = winnerImageUrl;
        this.loserName = loserName;
        this.loserPower = loserPower;
        this.loserImageUrl = loserImageUrl;


        this.isWinner = isWinner;
        this.isDraw = isDraw;
    }

    public boolean isWon() {
        return isWinner;
    }

    public boolean isTie() {
        return isDraw;
    }
}
