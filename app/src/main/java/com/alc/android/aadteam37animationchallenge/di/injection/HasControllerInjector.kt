package com.alc.android.aadteam37animationchallenge.di.injection

import com.bluelinelabs.conductor.Controller
import dagger.android.AndroidInjector


interface HasControllerInjector {
    fun controllerInjector(): AndroidInjector<Controller>
}