package com.alc.android.aadteam37animationchallenge.ui.menu.mvp

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

class MenuContract {
    interface View : MvpView

    interface Presenter : MvpPresenter<View>
}