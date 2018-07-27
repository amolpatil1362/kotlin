package com.test.kotlinlistview.di.appmodule

import com.test.kotlinlistview.main.MainActivity
import com.test.kotlinlistview.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActvityBuilder {

  @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
  abstract fun bindMainActivity(): MainActivity

  //@ContributesAndroidInjector -> With this annotation, we can easily attach activities/fragments to dagger graph
  // initially we were creating the module for each class to bridge it to graph but with the help of this annotation no need to create separate module for each class
}