package com.alox1d.cleanarchitecture2022.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alox1d.cleanarchitecture2022.data.repository.ImageRepositoryImpl
import com.alox1d.cleanarchitecture2022.data.storage.sharedprefs.SharedPrefImageStorage
import com.alox1d.cleanarchitecture2022.domain.usecase.GetImage
import com.alox1d.cleanarchitecture2022.domain.usecase.SaveImage

//TODO 6. Фабирка ViewModel для передачи параметров
class MainViewModelFactory(context:Context):ViewModelProvider.Factory{
        private val imageRepository by lazy {  ImageRepositoryImpl(SharedPrefImageStorage(context = context))  }
    private val getImageUseCase by lazy { GetImage(imageRepository) }
    private val saveImageUseCase by lazy { SaveImage(imageRepository) }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getImageUseCase,saveImageUseCase) as T
    }
}