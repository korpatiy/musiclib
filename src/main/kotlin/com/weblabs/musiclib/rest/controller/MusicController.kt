package com.weblabs.musiclib.rest.controller

import com.weblabs.musiclib.model.Music
import com.weblabs.musiclib.module.service.MusicService
import com.weblabs.musiclib.rest.dto.MusicUpdateDTO
import com.weblabs.musiclib.rest.mapper.MusicMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/music")
class MusicController(
    private val musicService: MusicService,
    private val musicMapper: MusicMapper
) {

    @GetMapping
    fun getMusicList(model: Model): List<Music> {
        return musicService.getAllMusic()
    }

    @GetMapping("/{music_id}")
    fun getMusic(@PathVariable("music_id") musicId: Long): Music {
        return musicService.getMusic(musicId)
    }

    @PutMapping
    fun updateMusic(@Validated @RequestBody dto: MusicUpdateDTO): Music {
        return musicService.createMusic(musicMapper.updateMusic(dto))
    }

    @DeleteMapping("/{music_id}")
    fun deleteMusic(@PathVariable("music_id") musicId: Long): ResponseEntity<String> {
        musicService.deleteMusic(musicId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}