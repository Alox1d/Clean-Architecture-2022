package com.alox1d.cleanarchitecture2022.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alox1d.cleanarchitecture2022.data.repository.ImageRepositoryImpl
import com.alox1d.cleanarchitecture2022.data.storage.sharedprefs.SharedPrefImageStorage
import com.alox1d.cleanarchitecture2022.databinding.ActivityMainBinding
import com.alox1d.cleanarchitecture2022.domain.models.ImageDomain
import com.alox1d.cleanarchitecture2022.domain.models.SaveImageParams
import com.alox1d.cleanarchitecture2022.domain.usecase.GetImage
import com.alox1d.cleanarchitecture2022.domain.usecase.SaveImage
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private  val vm:MainViewModel by viewModels {MainViewModelFactory(applicationContext)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val dataTextView = binding.tvData
        val dataEditText = binding.etSave
        val sendButton = binding.btnSave
        val receiveButton = binding.btnGet

        //TODO 7. Использование LiveData
        //Избавляемся от прямого доступа: dataTextView.text = vm.result
        vm.resultLive.observe(this, {
            dataTextView.text = it
        })
        sendButton.setOnClickListener {
            val text = dataEditText.text.toString()
            vm.save(text)
        }
        receiveButton.setOnClickListener {
            vm.load()
        }
    }
}