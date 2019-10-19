package com.alc.android.aadteam37animationchallenge.ui.training

import android.view.View
import com.alc.android.aadteam37animationchallenge.R
import com.alc.android.aadteam37animationchallenge.base.BaseController
import com.alc.android.aadteam37animationchallenge.ui.home.HomeAdapter
import com.alc.android.aadteam37animationchallenge.ui.home.mvp.HomeContract
import com.alc.android.aadteam37animationchallenge.ui.home.mvp.HomePresenter
import com.alc.android.aadteam37animationchallenge.ui.home.mvp.HomeViewState
import javax.inject.Inject
import javax.inject.Provider


class TrainingPlansController : BaseController<HomeContract.View, HomeContract.Presenter, HomeViewState>(), HomeContract.View {

    override fun setAdapter(adapter: HomeAdapter) {
    }

    @Inject
    lateinit var presenterProvider: Provider<HomePresenter>

    override fun createViewState(): HomeViewState = HomeViewState()

    override fun createPresenter(): HomeContract.Presenter = presenterProvider.get()

    override fun getLayoutId(): Int = R.layout.view_settings

    override fun onViewCreated(view: View) {

    }

    override fun animateOut() {

    }
}