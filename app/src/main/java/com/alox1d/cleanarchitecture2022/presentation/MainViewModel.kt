package com.alox1d.cleanarchitecture2022.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alox1d.cleanarchitecture2022.domain.models.ImageDomain
import com.alox1d.cleanarchitecture2022.domain.models.SaveImageParams
import com.alox1d.cleanarchitecture2022.domain.usecase.GetImage
import com.alox1d.cleanarchitecture2022.domain.usecase.SaveImage

class MainViewModel(private val getImageUseCase:GetImage, private val saveImageUseCase:SaveImage): ViewModel() {

//TODO 5. Лучше не передавать сюда контекст, а сразу usecase'ы, чтобы проще было тестировать (подавать фейковые usecase'ы).
// Для передачи параметров нужно создать фабирку.
// private val imageRepository by lazy {  ImageRepositoryImpl(SharedPrefImageStorage(context = applicationContext))  }
// private val getImageUseCase by lazy { GetImage(imageRepository) }
// private val saveImageUseCase by lazy { SaveImage(imageRepository) }
    init {
        Log.e("VM","VW Created")
    }

    // TODO 8. Соблюдение инкапсуляции
    private val _resultLive = MutableLiveData<String>()
    val resultLive:LiveData<String> = _resultLive

    fun save(text:String){
        val params = SaveImageParams(description = text)
        val resultData = saveImageUseCase.execute(params)
        _resultLive.value = "Save result = $resultData"
    }
    fun load(){
        val imageDomain: ImageDomain =getImageUseCase.execute()
        _resultLive.value = "Title: ${imageDomain.title}, Description: ${imageDomain.description}"

    }

    // TODO 7. Неверно. ViewModel НЕ должно возвращать ничего в активити, иначе получается спагетти-код.
//    var result = ""
//    fun save(text:String):String{
//        val params = SaveImageParams(description = text)
//        val resultData = saveImageUseCase.execute(params)
//        result = "Save result = $result"
//        return result
//    }
//    fun load():String{
//        val imageDomain: ImageDomain =getImageUseCase.execute()
//        result = "Title: ${imageDomain.title}, Description: ${imageDomain.description}"
//        return result
//
//    }

}