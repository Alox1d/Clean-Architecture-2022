package com.alox1d.cleanarchitecture2022.domain.repository

import com.alox1d.cleanarchitecture2022.domain.models.ImageDomain
import com.alox1d.cleanarchitecture2022.domain.models.SaveImageParams


//Задаёт интерфейс для репозитория в data-слое
interface ImageRepository {
    fun save(params: SaveImageParams):Boolean
    fun get(): ImageDomain
}