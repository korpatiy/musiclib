package com.weblabs.musiclib.module.service

import com.weblabs.musiclib.model.Music
import com.weblabs.musiclib.module.repo.MusicRepository
import org.springframework.stereotype.Service

@Service
class MusicService(
    private val musicRepository: MusicRepository
) {

    fun getMusic(musicId: Long): Music = musicRepository.findById(musicId).get()

    fun getAllMusic(): List<Music> = musicRepository.findAll().sortedBy { it.name }

    fun createMusic(music: Music): Music = musicRepository.save(music)

    fun deleteMusic(musicId: Long) = musicRepository.deleteById(musicId)
}