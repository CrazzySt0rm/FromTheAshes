package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dbreader.DbReader;
import org.example.dto.ArcherDTO;
import org.example.dto.MageDTO;
import org.example.models.Archer;
import org.example.models.Mage;
import org.example.repositories.ArcherRepository;
import org.example.repositories.MageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.Map;
import java.util.Optional;

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

    public String determineWinner() {
        Mage lastMage = mageRepository.findTopByOrderByIdDesc();
        Archer lastArcher = archerRepository.findTopByOrderByIdDesc();

        if (lastMage == null || lastArcher == null) {
            return "Нет данных для определения победителя.";
        }
        System.out.println("Сила мага: " + lastMage.getPower());
        System.out.println("Сила лучника: " + lastArcher.getPower());

        int magePower = (int) lastMage.getPower();
        int archerPower = (int) lastArcher.getPower();

        if (magePower > archerPower) {
            return "Победил маг: " + lastMage.getName() + " (" + magePower + ")" + lastMage.getMageImageUrl();
        } else if (archerPower > magePower) {
            return "Победил лучник: " + lastArcher.getName() + " (" + archerPower + ")" + lastArcher.getArcherImageUrl();
        } else {
            return "Ничья!";
        }
    }
}



