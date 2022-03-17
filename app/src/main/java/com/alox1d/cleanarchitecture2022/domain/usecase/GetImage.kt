package com.alox1d.cleanarchitecture2022.domain.usecase

import com.alox1d.cleanarchitecture2022.domain.models.ImageDomain
import com.alox1d.cleanarchitecture2022.domain.repository.ImageRepository

// TODO 1. Разбиваем на usecase-классы,
//  чтобы код был распределённым. Почему:
//  экран должен знать только то, что ему положено.
//  Если всё делать в одном классе, один экран сможет и логиниться, и получать картинки и т.д.

// TODO 3. Domain & data слои имеют свои модельки.
class GetImage(private val imageRepository: ImageRepository) {
    fun execute():ImageDomain{
        return imageRepository.get()
    }

}