package com.weblabs.musiclib.module.service

import com.weblabs.musiclib.model.Music
import com.weblabs.musiclib.module.repo.MusicRepository
import org.springframework.stereotype.Service

@Service
class MusicService(
    private val musicRepository: MusicRepository
) {

    fun getMusic(id: Long): Music = musicRepository.findById(id).orElseThrow {
        throw IllegalArgumentException("Invalid music id: $id")
    }

    fun getAllMusic(): List<Music> = musicRepository.findAll().sortedBy { it.name }

    fun createMusic(music: Music): Music = musicRepository.save(music)

    fun deleteMusic(id: Long) = musicRepository.deleteById(id)
}