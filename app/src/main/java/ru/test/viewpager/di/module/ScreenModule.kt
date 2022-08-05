package ru.test.viewpager.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.test.viewpager.presentation.screens.first.FirstScreenFragment
import ru.test.viewpager.presentation.screens.main.ScreensFragment
import ru.test.viewpager.presentation.screens.second.SecondScreenFragment

@Module
abstract class ScreenModule {

    @ContributesAndroidInjector
    abstract fun provideFirstScreenFragment(): FirstScreenFragment
    @ContributesAndroidInjector
    abstract fun provideSecondScreenFragment(): SecondScreenFragment

    @ContributesAndroidInjector
    abstract fun provideScreensFragment(): ScreensFragment
}