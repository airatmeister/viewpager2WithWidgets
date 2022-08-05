package ru.test.viewpager.presentation.screens.first

import android.os.Bundle
import ru.test.core.presentation.base.BaseFragment
import ru.test.viewpager.R

class FirstScreenFragment: BaseFragment(R.layout.fragment_first_screen) {

    companion object { fun newInstance() = FirstScreenFragment() }

    override fun callOperations() = Unit

    override fun onSetupLayout(savedInstanceState: Bundle?) = Unit

    override fun onBindViewModel() = Unit
}