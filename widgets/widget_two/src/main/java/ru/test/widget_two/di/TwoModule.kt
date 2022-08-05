package ru.test.widget_two.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.test.core.di.util.ViewModelKey
import ru.test.widget_two.presentation.TwoFragment
import ru.test.widget_two.presentation.TwoViewModel

@Module
abstract class TwoModule {

    @ContributesAndroidInjector
    abstract fun provideTwoFragment(): TwoFragment

    @Binds
    @IntoMap
    @ViewModelKey(TwoViewModel::class)
    abstract fun dashboardViewModel(viewModel: TwoViewModel): ViewModel
}