package com.anahoret.effectiveandroidtesting

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner
import com.anahoret.effectiveandroidtesting.injection.TestRecipeApplication

class CustomTestRunner : AndroidJUnitRunner() {
    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application =
            super.newApplication(cl, TestRecipeApplication::class.java.name, context)
}