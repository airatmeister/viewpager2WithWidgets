package ru.test.widget_one.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.test.core.di.util.ViewModelKey
import ru.test.widget_one.presentation.OneFragment
import ru.test.widget_one.presentation.OneViewModel

@Module
abstract class OneModule {

    @ContributesAndroidInjector
    abstract fun provideTwoFragment(): OneFragment

    @Binds
    @IntoMap
    @ViewModelKey(OneViewModel::class)
    abstract fun dashboardViewModel(viewModel: OneViewModel): ViewModel
}