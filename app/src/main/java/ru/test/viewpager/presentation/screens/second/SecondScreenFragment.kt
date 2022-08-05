package ru.test.viewpager.presentation.screens.second

import android.os.Bundle
import ru.test.core.presentation.base.BaseFragment
import ru.test.viewpager.R

class SecondScreenFragment: BaseFragment(R.layout.fragment_second_screen) {

    companion object { fun newInstance() = SecondScreenFragment() }

    override fun callOperations() = Unit

    override fun onSetupLayout(savedInstanceState: Bundle?) = Unit

    override fun onBindViewModel() = Unit
}