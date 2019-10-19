package com.alc.android.aadteam37animationchallenge.di

import com.alc.android.aadteam37animationchallenge.ChallengeApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ControllersBuilder::class])
interface AppComponent : AndroidInjector<ChallengeApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ChallengeApp>()
}