package com.weblabs.musiclib.rest.controller

import com.weblabs.musiclib.model.Music
import com.weblabs.musiclib.module.service.MusicService
import com.weblabs.musiclib.rest.mapper.MusicMapper
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.validation.BindingResult
import javax.validation.Valid

@Controller
@RequestMapping
class MusicController(
    private val musicService: MusicService,
    private val musicMapper: MusicMapper
) {

    @GetMapping("/")
    fun getMusicList(model: Model): String {
        model.addAttribute("music", musicService.getAllMusic())
        return "music-list"
    }

    @GetMapping("/newmusic")
    fun newMusic(@ModelAttribute("music") music: Music): String {
        return "music-create"
    }

    @PostMapping("/addmusic")
    @ResponseStatus(HttpStatus.OK)
    fun createMusic(@ModelAttribute("music") @Valid music: Music, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors())
            return "music-create"
        musicService.createMusic(music)
        return "redirect:/"
    }

    @GetMapping("/edit/{id}")
    fun showUpdateForm(@PathVariable("id") id: Long, model: Model): String {
        val music: Music = musicService.getMusic(id)
        model.addAttribute("music", music)
        return "music-update"
    }

    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateMusic(
        @PathVariable("id") id: Long,
        @ModelAttribute("music") @Valid music: Music,
        bindingResult: BindingResult
    ): String {
        if (bindingResult.hasErrors())
            return "music-update"
        musicService.createMusic(music)
        return "redirect:/"
    }

    @GetMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteMusic(@PathVariable("id") id: Long): String {
        musicService.deleteMusic(id)
        return "redirect:/"
    }
}