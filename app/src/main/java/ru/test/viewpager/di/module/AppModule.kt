package ru.test.viewpager.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ru.test.viewpager.App

@Module
class AppModule {

    @Provides
    fun provideContext(app: App): Context {
        return app.applicationContext
    }

    @Provides
    fun provideApplication(app: App): Application {
        return app
    }
}