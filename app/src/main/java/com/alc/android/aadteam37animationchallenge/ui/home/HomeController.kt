package com.alc.android.aadteam37animationchallenge.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.doOnLayout
import androidx.core.view.updatePadding
import com.alc.android.aadteam37animationchallenge.R
import com.alc.android.aadteam37animationchallenge.base.BaseController
import com.alc.android.aadteam37animationchallenge.ui.home.mvp.HomeContract
import com.alc.android.aadteam37animationchallenge.ui.home.mvp.HomePresenter
import com.alc.android.aadteam37animationchallenge.ui.home.mvp.HomeViewState
import kotlinx.android.synthetic.main.view_home.*
import javax.inject.Inject
import javax.inject.Provider


class HomeController : BaseController<HomeContract.View, HomeContract.Presenter, HomeViewState>(), HomeContract.View {

    override fun setAdapter(adapter: HomeAdapter) {
        val lm = AnimatedLayoutManager(recycler_view.context)
        recycler_view.layoutManager = lm
        recycler_view.adapter = adapter
    }

    @Inject
    lateinit var presenterProvider: Provider<HomePresenter>

    override fun createViewState(): HomeViewState = HomeViewState()

    override fun createPresenter(): HomeContract.Presenter = presenterProvider.get()

    override fun getLayoutId(): Int = R.layout.view_home

    override fun onRestoreViewState(view: View, savedViewState: Bundle) {
        super.onRestoreViewState(view, savedViewState)
        recycler_view.layoutAnimation = null
        recycler_view.doOnLayout {
            (recycler_view.layoutManager as AnimatedLayoutManager).animateItemsIn()
        }
    }

    override fun onViewCreated(view: View) {
        recycler_view.updatePadding(top = 400)

        recycler_view.doOnLayout {
            tv_title?.animate()?.setDuration(650)?.alpha(1f)
            tv_subtitle?.animate()?.setDuration(650)?.alpha(1f)
        }

    }

    override fun animateOut() {
        tv_title.animate().alpha(0f)
        tv_subtitle.animate().alpha(0f)
        (recycler_view.layoutManager as AnimatedLayoutManager).animateItemsOut()
    }
}