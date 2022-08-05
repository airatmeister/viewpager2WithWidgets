package ru.test.viewpager.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.test.viewpager.presentation.MainActivity

@Module(includes = [ViewModelModule::class])
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}