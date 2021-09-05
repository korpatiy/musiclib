package com.weblabs.musiclib.rest.controller

import com.weblabs.musiclib.model.Music
import com.weblabs.musiclib.module.service.MusicService
import com.weblabs.musiclib.rest.dto.MusicUpdateDTO
import com.weblabs.musiclib.rest.mapper.MusicMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.web.bind.annotation.GetMapping
import liquibase.pro.packaged.id


@Controller
@RequestMapping
class MusicController(
    private val musicService: MusicService,
    private val musicMapper: MusicMapper
) {

    @GetMapping
    fun getMusicList(model: Model): String {
        model.addAttribute("music", musicService.getAllMusic())
        return "music-list"
    }

    @GetMapping("/newmusic")
    fun createMusic(music: Music): String {
        return "music-create"
    }

    @PostMapping("/addmusic")
    fun createMusic(music: Music, model: Model): String {
        musicService.createMusic(music)
        return "redirect:/"
    }

    @GetMapping("/edit/{id}")
    fun showUpdateForm(@PathVariable("id") id: Long, model: Model): String? {
        val music: Music = musicService.getMusic(id)
        model.addAttribute("music", music)
        return "music-update"
    }

    @PostMapping("/update/{id}")
    fun updateMusic(@PathVariable("id") musicId: Long, music: Music, model: Model): String {
        musicService.createMusic(music)
        return "redirect:/"
    }

    @GetMapping("/{music_id}")
    fun getMusic(@PathVariable("music_id") musicId: Long): Music {
        return musicService.getMusic(musicId)
    }

    @GetMapping("/delete/{id}")
    fun deleteMusic(@PathVariable("id") musicId: Long): String {
        musicService.deleteMusic(musicId)
        return "redirect:/"
    }
}