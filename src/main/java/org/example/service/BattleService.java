package org.example.service;

import lombok.extern.slf4j.Slf4j;

import org.example.models.Archer;
import org.example.models.BattleResult;
import org.example.models.Mage;
import org.example.repositories.ArcherRepository;
import org.example.repositories.MageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@Transactional(readOnly = true)
public class BattleService {

    private final ArcherRepository archerRepository;
    private final MageRepository mageRepository;

    public BattleService(ArcherRepository archerRepository, MageRepository mageRepository) {
        this.archerRepository = archerRepository;
        this.mageRepository = mageRepository;
    }

    public BattleResult determineWinner() {
        Mage lastMage = mageRepository.findTopByOrderByIdDesc();
        Archer lastArcher = archerRepository.findTopByOrderByIdDesc();

        if (lastMage == null || lastArcher == null) {
            log.warn("Нет данных для определения победителя.");
            return new BattleResult(
                    null,         // winnerName
                    0L,           // winnerPower
                    null,         // winnerImageUrl
                    null,         // loserName
                    0L,           // loserPower
                    null,         // loserImageUrl
                    false,        // isWinner
                    false         // isDraw
            );
        }

        log.info("Сила мага: {}", lastMage.getPower());
        log.info("Сила лучника: {}", lastArcher.getPower());

        Long magePower = lastMage.getPower();
        Long archerPower = lastArcher.getPower();
        String mageName = lastMage.getName();
        String archerName = lastArcher.getName();

        if (magePower > archerPower) {
            log.info("Маг победил!");
            return new BattleResult(
                    mageName,
                    magePower,
                    lastMage.getMageImageUrl(),
                    archerName,
                    archerPower,
                    lastArcher.getArcherImageUrl(),
                    true, // isWinner
                    false // isDraw
            );
        } else if (archerPower > magePower) {
            log.info("Лучник победил!");
            return new BattleResult(
                    archerName,
                    archerPower,
                    lastArcher.getArcherImageUrl(),
                    mageName,
                    magePower,
                    lastMage.getMageImageUrl(),
                    true, // isWinner
                    false // isDraw
            );
        } else {
            log.info("Ничья!");
            return new BattleResult(
                    null,
                    0L,
                    "url_to_draw_image",
                    null,
                    0L,
                    null,
                    false, // isWinner
                    true   // isDraw
            );
        }
    }
}



