package ru.test.viewpager.presentation.screens.main

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_screens.*
import ru.test.core.plugins.viewbinding.viewBinding
import ru.test.core.presentation.base.BaseFragment
import ru.test.viewpager.R
import ru.test.viewpager.databinding.FragmentScreensBinding

class ScreensFragment: BaseFragment(R.layout.fragment_screens) {

    private val binding by viewBinding(FragmentScreensBinding::bind)

    override fun callOperations() = Unit

    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding){
        viewPagerMenu.offscreenPageLimit = 2
        viewPagerMenu.apply {
            registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                    }
                }
            )
            adapter = MainMenuPagerAdapter(this@ScreensFragment)
        }
        Unit
    }

    override fun onBindViewModel() = Unit
}