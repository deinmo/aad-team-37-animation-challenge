package com.alc.android.aadteam37animationchallenge

import android.app.Application
import com.alc.android.aadteam37animationchallenge.di.DaggerAppComponent
import com.alc.android.aadteam37animationchallenge.di.injection.HasControllerInjector
import com.bluelinelabs.conductor.Controller
import dagger.android.DispatchingAndroidInjector
import timber.log.Timber
import javax.inject.Inject


class ChallengeApp : Application(), HasControllerInjector {

    @Inject
    lateinit var dispatchingControllerInjector: DispatchingAndroidInjector<Controller>

    override fun controllerInjector(): DispatchingAndroidInjector<Controller> {
        return dispatchingControllerInjector
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
       DaggerAppComponent.builder().create(this).inject(this)
    }
}