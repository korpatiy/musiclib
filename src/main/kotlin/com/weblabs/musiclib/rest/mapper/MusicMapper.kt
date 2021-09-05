package com.weblabs.musiclib.rest.mapper

import com.weblabs.musiclib.model.Music
import com.weblabs.musiclib.rest.dto.MusicUpdateDTO
import org.springframework.stereotype.Component

@Component
class MusicMapper {
    fun updateMusic(dto: MusicUpdateDTO): Music {
        var music = Music()
        music.name = dto.name ?: ""
        music.year = dto.year ?: ""
        return music
    }
}