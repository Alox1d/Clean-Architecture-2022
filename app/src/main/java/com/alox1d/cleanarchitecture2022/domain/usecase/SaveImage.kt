package com.alox1d.cleanarchitecture2022.domain.usecase

import com.alox1d.cleanarchitecture2022.domain.models.SaveImageParams
import com.alox1d.cleanarchitecture2022.domain.repository.ImageRepository

class SaveImage(private val imageRepository: ImageRepository) {
    fun execute(params:SaveImageParams): Boolean {
        if (imageRepository.get().description == params.description){
            return true
        }

        return imageRepository.save(params)
    }
}