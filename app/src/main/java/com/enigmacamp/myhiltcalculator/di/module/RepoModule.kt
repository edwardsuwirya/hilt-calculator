package com.enigmacamp.myhiltcalculator.di.module

import com.enigmacamp.myhiltcalculator.data.repository.CalculatorRepository
import com.enigmacamp.myhiltcalculator.data.repository.CalculatorRepositoryGetImpl
import com.enigmacamp.myhiltcalculator.data.repository.CalculatorRepositoryPostImpl
import com.enigmacamp.myhiltcalculator.di.qualifier.GetCalculator
import com.enigmacamp.myhiltcalculator.di.qualifier.PostCalculator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {
    @GetCalculator
    @Binds
    abstract fun bindsRepositoryGet(calculatorRepositoryGetImpl: CalculatorRepositoryGetImpl): CalculatorRepository

    @PostCalculator
    @Binds
    abstract fun bindsRepositoryPost(calculatorRepositoryPostImpl: CalculatorRepositoryPostImpl): CalculatorRepository
}