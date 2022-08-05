package ru.test.widget_three.presentation

import android.os.Bundle
import ru.test.core.plugins.viewbinding.viewBinding
import ru.test.core.presentation.base.BaseFragment
import ru.test.widget_three.R
import ru.test.widget_three.databinding.FragmentThreeBinding

class ThreeFragment : BaseFragment(R.layout.fragment_three) {

    private val binding by viewBinding(FragmentThreeBinding::bind)
    private val viewModel: ThreeViewModel by settingsViewModels()

    override fun callOperations() = Unit
    override fun onSetupLayout(savedInstanceState: Bundle?)  = Unit

    override fun onBindViewModel() = Unit
}