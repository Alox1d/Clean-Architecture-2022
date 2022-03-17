package com.alox1d.cleanarchitecture2022.data.storage

import com.alox1d.cleanarchitecture2022.data.storage.models.Image


interface ImageStorage {
    fun save(saveParams: Image):Boolean
    fun get(): Image
}