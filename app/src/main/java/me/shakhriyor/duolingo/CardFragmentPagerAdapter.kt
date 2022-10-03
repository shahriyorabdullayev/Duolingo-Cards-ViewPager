package me.shakhriyor.duolingo

import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class CardFragmentPagerAdapter(fm: FragmentManager?, baseElevation: Float) :
    FragmentStatePagerAdapter(fm!!), CardAdapter {

    private var mFragments: ArrayList<CardFragment>? = null
    private var mBaseElevation = 0f

    init {
        mFragments = ArrayList()
        mBaseElevation = baseElevation
        for (i in 0..4) {
            addCardFragment(CardFragment())
        }

    }

    override fun getBaseElevation(): Float {
        return mBaseElevation
    }

    override fun getCount(): Int {
        return mFragments!!.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position)
        mFragments?.set(position, fragment as CardFragment)
        return fragment
    }


    override fun getItem(position: Int): Fragment {
        return mFragments?.get(position)!!
    }

    override fun getCardViewAt(position: Int): CardView? {
        return mFragments?.get(position)!!.getCardView()
    }

    private fun addCardFragment(fragment: CardFragment) {
        mFragments?.add(fragment)
    }
}
