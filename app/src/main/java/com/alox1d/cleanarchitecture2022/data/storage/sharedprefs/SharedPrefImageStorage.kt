package com.alox1d.cleanarchitecture2022.data.storage.sharedprefs

import android.content.Context
import com.alox1d.cleanarchitecture2022.data.storage.ImageStorage
import com.alox1d.cleanarchitecture2022.data.storage.models.Image

private const val SHARED_PREFS_DATA = "SHARED_PREFS_DATA"
private const val KEY_DATA_TITLE = "KEY_DATA_TITLE"
private const val KEY_DATA_DESCRIPTION = "KEY_DATA_DESC"

private const val DEFAULT_TITLE = "DEFAULT_TITLE"
private const val DEFAULT_DESC = "DEFAULT_DESC"

// TODO 4. Локальное хранилище. Реализация через SharedPreferences (можно ещё доавить БД)
class SharedPrefImageStorage(context:Context): ImageStorage {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_DATA, Context.MODE_PRIVATE)

    override fun save(saveParams: Image): Boolean {
        sharedPreferences.edit().putString(KEY_DATA_TITLE,saveParams.URL).apply()
        sharedPreferences.edit().putString(KEY_DATA_DESCRIPTION,saveParams.description).apply()
        return true
    }

    override fun get(): Image {
        val description = sharedPreferences.getString(KEY_DATA_DESCRIPTION,DEFAULT_DESC) ?: DEFAULT_DESC
        val title = sharedPreferences.getString(KEY_DATA_TITLE,DEFAULT_TITLE) ?: DEFAULT_TITLE
        return Image(title,description)

    }
}