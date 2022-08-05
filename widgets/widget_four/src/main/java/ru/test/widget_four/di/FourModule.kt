package ru.test.widget_four.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.test.core.di.util.ViewModelKey
import ru.test.widget_four.presentation.FourViewModel
import ru.test.widget_four.presentation.FourFragment

@Module
abstract class FourModule {

    @ContributesAndroidInjector
    abstract fun provideTwoFragment(): FourFragment

    @Binds
    @IntoMap
    @ViewModelKey(FourViewModel::class)
    abstract fun dashboardViewModel(viewModel: FourViewModel): ViewModel
}