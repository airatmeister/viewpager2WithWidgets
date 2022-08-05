package ru.test.widget_five.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.test.core.di.util.ViewModelKey
import ru.test.widget_five.presentation.FiveFragment
import ru.test.widget_five.presentation.FiveViewModel

@Module
abstract class FiveModule {

    @ContributesAndroidInjector
    abstract fun provideTwoFragment(): FiveFragment

    @Binds
    @IntoMap
    @ViewModelKey(FiveViewModel::class)
    abstract fun dashboardViewModel(viewModel: FiveViewModel): ViewModel
}