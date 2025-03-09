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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        // Определяем победителя битвы
        BattleResult battleResult = battleService.determineWinner();

        // Выводим результат в лог для отладки
        log.info("Результат битвы: {}", battleResult);

        // Проверяем, что battleResult не равен null
        if (battleResult != null) {
            // Передаем результат в модель для отображения в представлении
            model.addAttribute("winner", battleResult);
        } else {
            // Если battleResult равен null, передаем пустой объект
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
