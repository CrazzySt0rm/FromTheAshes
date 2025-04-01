package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.dto.ArcherDTO;
import org.example.dto.MageDTO;
import org.example.models.Archer;
import org.example.models.BattleResult;
import org.example.models.Mage;
import org.example.service.ArenaService;
import org.example.service.BattleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
@CrossOrigin(origins = "${MyLOCAL}")
public class ArenaController {

    private final ArenaService arenaService;
    private final BattleService battleService;

    private static final Logger log = LoggerFactory.getLogger(BattleController.class);

    @PostMapping("/mage/create")
    public String saveMage(MageDTO mageDTO, Model model) {
        Mage savedMage = arenaService.saveMage(mageDTO); // сохраняем мага
        model.addAttribute("savedMage", savedMage); // добавляем в модель
        return "redirect:/arena"; // переходим на страницу с результатом
    }

    @PostMapping("/archer/create")
    public String saveArcher(ArcherDTO archerDTO, Model model) {
        Archer savedArcher = arenaService.saveArcher(archerDTO); // сохраняем лучника
        model.addAttribute("savedArcher", savedArcher); // добавляем в модель
        return "redirect:/arena"; // переходим на страницу с результатом
    }

    @PostMapping("/archer/search")
    public String searchArcher(@RequestParam("cloudId") String cloudId, Model model) {
        Optional<Archer> archer = arenaService.readArcherByCloudId(cloudId);

        if (archer.isPresent()) {
            model.addAttribute("archer", archer.get());
            return "archer_details"; // Переход на страницу с детальной информацией
        } else {
            model.addAttribute("errorMessage", "Лучник с таким Cloud ID не найден.");
            return "redirect:/arena"; // Возвращаемся обратно на страницу поиска
        }
    }

    @PostMapping("/mage/search")
    public String searchMage(@RequestParam("cloudId") String cloudId, Model model) {
        Optional<Mage> mage = arenaService.readMageByCloudId(cloudId);

        if (mage.isPresent()) {
            model.addAttribute("mage", mage.get());
            return "mage_details"; // Переход на страницу с детальной информацией
        } else {
            model.addAttribute("errorMessage", "Маг с таким Cloud ID не найден.");
            return "redirect:/arena"; // Возвращаемся обратно на страницу поиска
        }
    }

    @GetMapping("/archer_details")
    public String getArcherDetails() {
        return "archer_details";
    }

    @GetMapping("/arena")
    public String getMage(Model model) {
        return "arena";
    }

    @GetMapping("/arena_form")
    public String getArenaForm() {
        return "arena_form";
    }

    @GetMapping("/results")
    public String getResults(Model model) {
        BattleResult battleResult = battleService.determineWinner();
        log.info("Результат битвы: {}", battleResult);

        if (battleResult != null && battleResult.isWon()) {
            // Победитель определен
            model.addAttribute("winner", battleResult);
        } else if (battleResult != null && battleResult.isTie()) {
            // Ничья
            model.addAttribute("winner", battleResult);
        } else {
            // Нет данных о бое
            model.addAttribute("winner", new BattleResult());
        }
        // Возвращаем имя представления
        return "battle_results";
    }


    @GetMapping("/battle_results")
    public String getBattleRes() {
        return "battle_results";
    }
}
