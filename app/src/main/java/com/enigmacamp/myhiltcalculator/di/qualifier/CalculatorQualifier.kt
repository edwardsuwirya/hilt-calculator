package com.enigmacamp.myhiltcalculator.di.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PostCalculator

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class GetCalculator