package ru.test.viewpager.di.module

import dagger.Module
import ru.test.core.di.module.ViewModelFactoryModule

@Module(includes = [ViewModelFactoryModule::class])
abstract class ViewModelModule