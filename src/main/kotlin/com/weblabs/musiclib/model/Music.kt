package com.weblabs.musiclib.model

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

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
    @NotEmpty(message = "Name should not be empty")
    @field:Size(min = 1, max = 50, message = "Название должно содержать хотя бы 1 символ и не превышать 50")
    var name: String = "",

    @Column(name = "year", length = 4)
    @NotEmpty(message = "Year should not be empty")
    @field:Size(min = 4, max = 4, message = "Год должен состоять из 4 символов")
    var year: String = "",
)