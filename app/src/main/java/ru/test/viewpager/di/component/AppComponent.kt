package ru.test.viewpager.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.test.viewpager.App
import ru.test.viewpager.di.module.ActivityModule
import ru.test.viewpager.di.module.AppModule
import ru.test.viewpager.di.module.ScreenModule
import ru.test.viewpager.di.module.WidgetsModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityModule::class,
    WidgetsModule::class,
    ScreenModule::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: App): AppComponent
    }
}