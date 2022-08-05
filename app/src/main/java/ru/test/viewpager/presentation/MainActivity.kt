package ru.test.viewpager.presentation

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import ru.test.core.presentation.UiAction
import ru.test.core.presentation.base.BaseActivity
import ru.test.viewpager.R
import ru.test.viewpager.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initVB() = ActivityMainBinding.inflate(layoutInflater)

    override fun getNavController() = findNavController(R.id.nav_host_fragment_activity_main)

    override fun navigateTo(action: UiAction) {
        when (action.id){"fragment_screens" -> navigator.navigate(R.id.screens) }
    }

    override fun onSetupLayout() {
        setupActionBarWithNavController(navigator, AppBarConfiguration(setOf(R.id.screens)))
    }
}