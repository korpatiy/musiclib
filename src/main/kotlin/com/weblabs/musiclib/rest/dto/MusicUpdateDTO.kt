package com.weblabs.musiclib.rest.dto

import javax.validation.constraints.Size

/**
 * DTO для редактирования музыки
 */
@Deprecated(message = "thymleaf error")
//todo fix thymleaf error
class MusicUpdateDTO(

    @field:Size(min = 1, max = 50, message = "Название должно содержать хотя бы 1 символ и не превышать 50")
    var name: String? = "",

    @field:Size(min = 4, max = 4, message = "Год должен состоять из 4 символов")
    var year: String? = ""
)