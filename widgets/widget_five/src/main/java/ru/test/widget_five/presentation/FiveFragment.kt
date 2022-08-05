package ru.test.widget_five.presentation

import android.os.Bundle
import ru.test.core.plugins.viewbinding.viewBinding
import ru.test.core.presentation.base.BaseFragment
import ru.test.widget_five.R
import ru.test.widget_five.databinding.FragmentFiveBinding

class FiveFragment : BaseFragment(R.layout.fragment_five) {

    private val binding by viewBinding(FragmentFiveBinding::bind)
    private val viewModel: FiveViewModel by settingsViewModels()

    override fun callOperations() = Unit
    override fun onSetupLayout(savedInstanceState: Bundle?)  = Unit

    override fun onBindViewModel() = Unit
}