package org.example.service;

import org.example.dto.ArcherDTO;
import org.example.dto.MageDTO;
import org.example.dto.WarriorDTO;
import org.example.models.Archer;
import org.example.models.Mage;
import org.example.models.Warrior;
import org.example.repositories.ArcherRepository;
import org.example.repositories.MageRepository;
import org.example.repositories.WarriorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ArenaService {

    private final ArcherRepository archerRepository;
    private final WarriorRepository warriorRepository;
    private final MageRepository mageRepository;


    public ArenaService(ArcherRepository archerRepository, WarriorRepository warriorRepository, MageRepository mageRepository) {
        this.archerRepository = archerRepository;
        this.warriorRepository = warriorRepository;
        this.mageRepository = mageRepository;

    }

    //POST
    @Transactional
    public Archer saveArcher(ArcherDTO archerDTO) {
        return archerRepository.save(Archer.builder()
                .archerImageUrl(archerDTO.getArcherImageUrl())
                .cloudId(archerDTO.getCloudId())
                .name(archerDTO.getName())
                .power(archerDTO.getPower())
                .defence(archerDTO.getDefence())
                .type(archerDTO.getType())
                .element(archerDTO.getElement())
                .build());
    }

    @Transactional
    public Mage saveMage(MageDTO mageDTO) {
        return mageRepository.save(Mage.builder()
                .mageImageUrl(mageDTO.getMageImageUrl())
                .cloudId(mageDTO.getCloudId())
                .name(mageDTO.getName())
                .power(mageDTO.getPower())
                .defence(mageDTO.getDefence())
                .type(mageDTO.getType())
                .element(mageDTO.getElement())
                .build());

    }

    @Transactional
    public Warrior saveWarrior(WarriorDTO warriorDTO) {
        return warriorRepository.save(Warrior.builder()
                .warriorImageUrl(warriorDTO.getWarriorImageUrl())
                .cloudId(warriorDTO.getCloudId())
                .name(warriorDTO.getName())
                .power(warriorDTO.getPower())
                .defence(warriorDTO.getDefence())
                .type(warriorDTO.getType())
                .element(warriorDTO.getElement())
                .build());
    }

    //GET
    public List<Archer> readArcher() {
        return archerRepository.findAll();
    }

    public Optional<Archer> readArcherByCloudId(String cloudId) {
        return archerRepository.findByCloudId(cloudId);
    }

    public Optional<Mage> readMageByCloudId(String cloudId) {
        return mageRepository.findByCloudId(cloudId);
    }

    public List<Mage> readMage() {
        return mageRepository.findAll();
    }

    public List<Warrior> readWarrior() {
        return warriorRepository.findAll();
    }

    //UPDATE
    public Archer updateArcher(Archer archer) {
        return archerRepository.save(archer);
    }

    public Mage updateMage(Mage mage) {
        return mageRepository.save(mage);
    }

    public Warrior updateWarrior(Warrior warrior) {
        return warriorRepository.save(warrior);
    }

    //DELETE
    public void deleteArcher(@PathVariable(value = "id") Long id) {
        archerRepository.deleteById(id);
    }

    public void deleteMAge(@PathVariable(value = "id") Long id) {
        mageRepository.deleteById(id);
    }

    public void deleteWarrior(@PathVariable(value = "id") String id) {
        warriorRepository.deleteById(id);
    }

    public String fight(MageDTO mageDTO, ArcherDTO archerDTO) {


        if (mageDTO.getPower() > archerDTO.getPower()) {

            System.out.println(mageDTO.getName() + " " + "winner");
        }
        return mageDTO.getName() + " " + "winner";
    }
}
