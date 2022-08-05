package ru.test.viewpager.di.module

import dagger.Module
import ru.test.viewpager.di.module.widgets.*

@Module(includes = [
    WidgetOneModule::class,
    WidgetTwoModule::class,
    WidgetThreeModule::class,
    WidgetFourModule::class,
    WidgetFiveModule::class
])
abstract class WidgetsModule