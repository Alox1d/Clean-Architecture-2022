package com.alox1d.cleanarchitecture2022.data.repository

import com.alox1d.cleanarchitecture2022.data.storage.ImageStorage
import com.alox1d.cleanarchitecture2022.data.storage.models.Image
import com.alox1d.cleanarchitecture2022.domain.models.ImageDomain
import com.alox1d.cleanarchitecture2022.domain.models.SaveImageParams
import com.alox1d.cleanarchitecture2022.domain.repository.ImageRepository


//TODO 2 Паттерн по работе с данными. По сути реализует CRUD-операции.
// Связующее звено классов по работе с сетью и локальными хранилищем (network & storage).
// Здесь не должно быть никаких if'ов.
// TODO 2.1. Маппигш моделей domain-слоя в data и наоборот.
class ImageRepositoryImpl(val imageStorage:ImageStorage):ImageRepository {
    override fun save(params:SaveImageParams):Boolean{
        val data = mapToStorage(params)
        return imageStorage.save(data)
    }
    override fun get(): ImageDomain {

        val image = imageStorage.get()
        return mapToDomain(image)
    }

// TODO 2.2. Мапперы можно вынести в extension-функции
    private fun mapToDomain(image:Image):ImageDomain{
        return ImageDomain(image.URL,image.description)
    }
    private fun mapToStorage(saveParams:SaveImageParams):Image{
        return Image("IMG_URL_DEFAULT",saveParams.description)
    }
}