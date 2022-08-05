package ru.test.widget_four.presentation

import android.os.Bundle
import ru.test.core.plugins.viewbinding.viewBinding
import ru.test.core.presentation.base.BaseFragment
import ru.test.widget_four.R
import ru.test.widget_four.databinding.FragmentFourBinding

class FourFragment : BaseFragment(R.layout.fragment_four) {

    private val binding by viewBinding(FragmentFourBinding::bind)
    private val viewModel: FourViewModel by settingsViewModels()

    override fun callOperations() = Unit
    override fun onSetupLayout(savedInstanceState: Bundle?)  = Unit

    override fun onBindViewModel() = Unit
}