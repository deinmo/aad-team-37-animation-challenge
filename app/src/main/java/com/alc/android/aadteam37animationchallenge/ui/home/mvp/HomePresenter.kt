package com.alc.android.aadteam37animationchallenge.ui.home.mvp

import com.alc.android.aadteam37animationchallenge.base.mvp.BasePresenter
import com.alc.android.aadteam37animationchallenge.model.MainItem
import com.alc.android.aadteam37animationchallenge.ui.home.HomeAdapter
import javax.inject.Inject


class HomePresenter @Inject constructor() : BasePresenter<HomeContract.View>(),
    HomeContract.Presenter {

    private val adapter: HomeAdapter = HomeAdapter(MainItem.getItems())

    override fun attachView(view: HomeContract.View) {
        super.attachView(view)
        ifViewAttached {
            it.setAdapter(adapter)
        }
    }
}