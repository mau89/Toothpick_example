package com.example.toothpick.DI

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.toothpick.PrefUserRepository
import com.example.toothpick.UserRepository
import toothpick.config.Module

class RepositoryModule(context: Context) : Module() {
    init {

        val sharedPreferences =
            context.getSharedPreferences("app.prefs", MODE_PRIVATE)
        bind(SharedPreferences::class.java).toInstance(sharedPreferences)
        bind(UserRepository::class.java).to(
            PrefUserRepository::class.java
        ).singleton()
    }
}
