package ru.test.viewpager.presentation.screens.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.test.viewpager.presentation.screens.first.FirstScreenFragment
import ru.test.viewpager.presentation.screens.second.SecondScreenFragment

class MainMenuPagerAdapter(activity: Fragment) : FragmentStateAdapter(activity) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FirstScreenFragment.newInstance()
            1 -> SecondScreenFragment.newInstance()
            else -> FirstScreenFragment.newInstance()
        }
    }

}