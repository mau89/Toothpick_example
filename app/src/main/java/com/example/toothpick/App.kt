package com.example.toothpick

import android.app.Application
import com.example.toothpick.DI.RepositoryModule
import com.example.toothpick.DI.Scopes
import toothpick.Toothpick

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val appScope = Toothpick.openScope(Scopes.APP)
        appScope.installModules(RepositoryModule(applicationContext))
    }
}