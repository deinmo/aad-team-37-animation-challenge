package com.alc.android.aadteam37animationchallenge.ui.activity

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.content.ContextCompat
import com.alc.android.aadteam37animationchallenge.R
import com.alc.android.aadteam37animationchallenge.base.BaseController
import com.alc.android.aadteam37animationchallenge.base.Navigator
import com.alc.android.aadteam37animationchallenge.commons.getStatusBarHeight
import com.alc.android.aadteam37animationchallenge.ui.home.HomeController
import com.alc.android.aadteam37animationchallenge.ui.menu.MenuController
import com.alc.android.aadteam37animationchallenge.ui.reminder.ReminderController
import com.alc.android.aadteam37animationchallenge.ui.settings.SettingsController
import com.alc.android.aadteam37animationchallenge.ui.training.TrainingPlansController
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var router: Router
    private var isAnimated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        setContentView(R.layout.activity_main)

        (img_menu.layoutParams as ViewGroup.MarginLayoutParams).topMargin = getStatusBarHeight()

        img_menu.setOnClickListener { changeController() }

        loadImage(R.drawable.bg)

        router = Conductor.attachRouter(this, controller_container, savedInstanceState)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(HomeController()))
        }
    }

    private fun changeController() {
        val backstack = router.backstack
        when (backstack[backstack.size - 1].controller()) {
            is HomeController -> animateController { router.pushController(RouterTransaction.with(MenuController())) }
            is MenuController -> animateController { router.handleBack() }

            is ReminderController -> router.handleBack()
            is SettingsController -> router.handleBack()
        }
    }

    private fun loadImage(@DrawableRes resId: Int) {
        Picasso.get().load(resId).into(img_background)
    }

    override fun onBackPressed() {
        if (isAnimated) return
        if (router.backstack.size == 1) super.onBackPressed()
        else changeController()
    }

    private fun animateController(endAction: () -> (Unit)) {
        img_menu.morph()
        (router.backstack.last().controller() as BaseController<*, *, *>).animateOut()
        val color = if (router.backstack.size == 1) R.color.bg_menu else R.color.bg_color_home
        animateBackground(color, endAction)
        arc_view.startAnimation()
    }

    private fun animateBackground(@ColorRes color: Int, endAction: () -> Unit) {
        val startColor = (background.background as ColorDrawable).color
        val endColor = ContextCompat.getColor(this, color)
        val animator = ObjectAnimator.ofInt(background, "backgroundColor", startColor, endColor)
        animator.doOnEnd {
            endAction.invoke()
            isAnimated = false
        }
        animator.duration = 450
        animator.setEvaluator(ArgbEvaluator())
        isAnimated = true
        animator.start()
    }

    override fun showMenu() {
    }

    override fun showTrainingPlans() {
        router.pushController(RouterTransaction.with(TrainingPlansController()))
    }

    override fun showReminder() {
        router.pushController(RouterTransaction.with(ReminderController()))
    }

    override fun showSettings() {
        router.pushController(RouterTransaction.with(SettingsController()))
    }
}
