package com.weblabs.musiclib.model

import org.hibernate.validator.constraints.Length
import javax.persistence.*
import javax.validation.constraints.*

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
    @field:NotEmpty(message = "Name should not be empty")
    @field:Size(min = 1, max = 50, message = "Название должно содержать хотя бы 1 символ и не превышать 50")
    var name: String = "",

    @Column(name = "year", length = 4)
    @field:NotEmpty(message = "Year should not be empty")
    @field:Pattern(regexp = "^[12][0-9]{3}\$", message = "Год должен быть в формате @2021")
    var year: String = "",
)