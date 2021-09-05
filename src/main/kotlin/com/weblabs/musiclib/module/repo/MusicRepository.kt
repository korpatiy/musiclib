package com.weblabs.musiclib.module.repo

import com.weblabs.musiclib.model.Music
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MusicRepository : JpaRepository<Music, Long> {
}