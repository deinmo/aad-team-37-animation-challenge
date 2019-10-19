package com.alc.android.aadteam37animationchallenge.ui.menu


import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import com.alc.android.aadteam37animationchallenge.R
import com.alc.android.aadteam37animationchallenge.base.BaseController
import com.alc.android.aadteam37animationchallenge.commons.withEndActionOnce
import com.alc.android.aadteam37animationchallenge.ui.menu.mvp.MenuContract
import com.alc.android.aadteam37animationchallenge.ui.menu.mvp.MenuPresenter
import com.alc.android.aadteam37animationchallenge.ui.menu.mvp.MenuViewState
import kotlinx.android.synthetic.main.view_menu.*
import javax.inject.Inject
import javax.inject.Provider


class MenuController : BaseController<MenuContract.View, MenuContract.Presenter, MenuViewState>(), MenuContract.View {

    @Inject
    lateinit var presenterProvider: Provider<MenuPresenter>

    override fun createViewState(): MenuViewState = MenuViewState()

    override fun createPresenter(): MenuContract.Presenter = presenterProvider.get()

    override fun getLayoutId(): Int = R.layout.view_menu

    override fun onViewCreated(view: View) {
        img_flame.animate().setDuration(350).alpha(1f)
        pulse_view.animate().setDuration(350).alpha(1f)
        tv_title.animate().setDuration(350).alpha(1f)

        training_container.animate().setStartDelay(100).alpha(1f)
        reminder_container.animate().setStartDelay(150).alpha(1f)
        settings_container.animate().setStartDelay(200).alpha(1f)

        training_container.setOnClickListener { animatePromise() }
        reminder_container.setOnClickListener { animatePromise() }
        settings_container.setOnClickListener { animatePromise() }
    }

    override fun animateOut() {
        pulse_view.visibility = View.INVISIBLE
        img_flame.animate().alpha(0f)
        tv_title.animate().alpha(0f)

        settings_container.animate().setStartDelay(0).alpha(0f)
        reminder_container.animate().setStartDelay(75).alpha(0f)
        training_container.animate().setStartDelay(100).alpha(0f)
    }

    private fun animatePromise() {
        pulse_view.startPulse()
        val fadeIn = AlphaAnimation(0f, 0.8f)
        fadeIn.duration = 450

        val fadeOut = AlphaAnimation(0.8f, 0f)
        fadeOut.startOffset = 650
        fadeOut.duration = 450

        val animation = AnimationSet(false)
        animation.addAnimation(fadeIn)
        animation.addAnimation(fadeOut)
        promise.visibility = View.VISIBLE
        animation.withEndActionOnce { promise.visibility = View.INVISIBLE }
        promise.startAnimation(animation)
    }
}