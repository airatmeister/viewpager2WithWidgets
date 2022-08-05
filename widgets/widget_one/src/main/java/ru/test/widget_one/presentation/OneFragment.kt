package ru.test.widget_one.presentation

import android.os.Bundle
import ru.test.core.plugins.viewbinding.viewBinding
import ru.test.core.presentation.base.BaseFragment
import ru.test.widget_one.R
import ru.test.widget_one.databinding.FragmentOneBinding

class OneFragment : BaseFragment(R.layout.fragment_one) {

    private val binding by viewBinding(FragmentOneBinding::bind)
    private val viewModel: OneViewModel by settingsViewModels()

    override fun callOperations() = Unit
    override fun onSetupLayout(savedInstanceState: Bundle?)  = Unit

    override fun onBindViewModel() = Unit
}