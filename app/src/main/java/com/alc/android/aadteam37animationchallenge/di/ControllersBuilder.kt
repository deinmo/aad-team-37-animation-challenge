package com.alc.android.aadteam37animationchallenge.di

import com.alc.android.aadteam37animationchallenge.ui.home.HomeController
import com.alc.android.aadteam37animationchallenge.ui.menu.MenuController
import com.alc.android.aadteam37animationchallenge.ui.reminder.ReminderController
import com.alc.android.aadteam37animationchallenge.ui.settings.SettingsController
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ControllersBuilder {

    @ContributesAndroidInjector
    abstract fun contributeHome(): HomeController

    @ContributesAndroidInjector
    abstract fun contributeMenu(): MenuController

    @ContributesAndroidInjector
    abstract fun contributeSettings(): SettingsController

    @ContributesAndroidInjector
    abstract fun contributeReminder(): ReminderController
}