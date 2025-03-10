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
            return new BattleResult(null, 0L, null, false, false);
        }

        log.info("Сила мага: {}", lastMage.getPower());
        log.info("Сила лучника: {}", lastArcher.getPower());

        Long magePower = lastMage.getPower();
        Long archerPower = lastArcher.getPower();

        String mageName = lastMage.getName();
        String archerName = lastArcher.getName();

        if (magePower > archerPower) {
            log.info("Маг победил!");
            return new BattleResult(mageName, magePower, lastMage.getMageImageUrl(), true, false);
        } else if (archerPower > magePower) {
            log.info("Лучник победил!");
            return new BattleResult(archerName, archerPower, lastArcher.getArcherImageUrl(), true,false);
        } else {
            log.info("Ничья!");
            return new BattleResult(null, 0L, "https://sun9-88.userapi.com/impg/643uDudAs3Jc2FboCkqS2seL-" +
                    "8_yd6Jhz7djQw/T-QrFsaV5zs.jpg?size=1280x720&quality=96&sign=2f8d52b87567e8a340bb4e7fdadf693e&c_uniq_tag=O18DlKR1pmbXv-Gmcw9D_" +
                    "FuhBbgE1-j3Qc9mIRgxKBE&type=album", false, true);
        }
    }
}



