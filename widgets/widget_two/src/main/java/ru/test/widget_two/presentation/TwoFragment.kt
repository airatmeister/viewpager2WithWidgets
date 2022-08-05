package ru.test.widget_two.presentation

import android.os.Bundle
import ru.test.core.plugins.viewbinding.viewBinding
import ru.test.core.presentation.base.BaseFragment
import ru.test.widget_two.R
import ru.test.widget_two.databinding.FragmentTwoBinding

class TwoFragment : BaseFragment(R.layout.fragment_two) {

    private val binding by viewBinding(FragmentTwoBinding::bind)
    private val viewModel: TwoViewModel by settingsViewModels()

    override fun callOperations() = Unit
    override fun onSetupLayout(savedInstanceState: Bundle?)  = Unit

    override fun onBindViewModel() = Unit
}