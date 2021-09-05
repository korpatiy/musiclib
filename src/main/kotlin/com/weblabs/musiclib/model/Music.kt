package com.weblabs.musiclib.model

import javax.persistence.*

/**
 * Music
 */
@Entity
@Table(name = "t_music")
data class Music(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_id")
    var id: Long = 0,

    @Column(name = "name", length = 200)
    var name: String = "",

    @Column(name = "year", length = 4)
    var year: String = "",
)