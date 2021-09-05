package com.example.demo.controllers;

import com.example.demo.dto.SongInfoDto;
import com.example.demo.model.entity.SongInfo;
import com.example.demo.model.service.ISongInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class SongController {

    @Autowired
    private ISongInfoService iSongInfoService;

    @GetMapping("/list")
    public ModelAndView showList() {
        return new ModelAndView("list", "songList", this.iSongInfoService.findAll());
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songInfoDto", new SongInfoDto());
        return "create";
    }

    @PostMapping("/create")
    public String createNew(@Valid @ModelAttribute("songInfoDto") SongInfoDto songInfoDto, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            SongInfo songInfo = new SongInfo();
            BeanUtils.copyProperties(songInfoDto, songInfo);
            this.iSongInfoService.save(songInfo);
            attributes.addFlashAttribute("message", "Song added.");
            return "redirect:/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        SongInfo songInfo = this.iSongInfoService.findById(id);
        SongInfoDto songInfoDto = new SongInfoDto();
        BeanUtils.copyProperties(songInfo, songInfoDto);
        model.addAttribute("songInfoDtoEdit", songInfoDto);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("songInfoDtoEdit") SongInfoDto songInfoDtoEdit, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        } else {
            SongInfo songInfo = new SongInfo();
            BeanUtils.copyProperties(songInfoDtoEdit, songInfo);
            this.iSongInfoService.save(songInfo);
            attributes.addFlashAttribute("message", "Song edited.");
            return "redirect:/list";
        }
    }
}
