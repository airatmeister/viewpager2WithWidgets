package ru.test.widget_three.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.test.core.di.util.ViewModelKey
import ru.test.widget_three.presentation.ThreeFragment
import ru.test.widget_three.presentation.ThreeViewModel

@Module
abstract class ThreeModule {

    @ContributesAndroidInjector
    abstract fun provideTwoFragment(): ThreeFragment

    @Binds
    @IntoMap
    @ViewModelKey(ThreeViewModel::class)
    abstract fun dashboardViewModel(viewModel: ThreeViewModel): ViewModel
}