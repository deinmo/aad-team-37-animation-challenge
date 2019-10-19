package com.alc.android.aadteam37animationchallenge.ui.home.mvp

import com.alc.android.aadteam37animationchallenge.ui.home.HomeAdapter
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

class HomeContract {
    interface View : MvpView {
        fun setAdapter(adapter: HomeAdapter)
    }

    interface Presenter : MvpPresenter<View>
}