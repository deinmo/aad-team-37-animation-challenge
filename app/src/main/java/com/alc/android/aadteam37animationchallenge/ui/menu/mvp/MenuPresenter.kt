package com.alc.android.aadteam37animationchallenge.ui.menu.mvp

import com.alc.android.aadteam37animationchallenge.base.mvp.BasePresenter
import javax.inject.Inject


class MenuPresenter @Inject constructor() : BasePresenter<MenuContract.View>(),
    MenuContract.Presenter {

    override fun attachView(view: MenuContract.View) { }
}