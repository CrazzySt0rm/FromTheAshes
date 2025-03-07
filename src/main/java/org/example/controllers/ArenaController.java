package org.example.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.dbreader.DbReader;
import org.example.dto.ArcherDTO;
import org.example.dto.MageDTO;
import org.example.dto.WarriorDTO;
import org.example.models.Archer;
import org.example.models.Mage;
import org.example.service.ArenaService;
import org.example.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.foreign.Arena;
import java.util.Map;

@Controller
@AllArgsConstructor
@CrossOrigin(origins = "${MyLOCAL}")
public class ArenaController {

    private final ArenaService arenaService;
    private final BattleService battleService;

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

    @GetMapping("/winner")
    public String showWinner(Model model) {
        String result = battleService.determineWinner();
        model.addAttribute("result", result);
        return "battle_results";
    }

    @GetMapping("/form")
    public String formPage(Model model) {
        model.addAttribute("mageForm", new MageDTO());
        model.addAttribute("archerForm", new ArcherDTO());
        return "arena_form";
    }

    @GetMapping("/arena_form")
    public String getArenaForm() {
        return "arena_form";
    }
}
