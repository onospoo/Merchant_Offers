package com.lwp.merge_datasource.config

import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ForkJoinPool


@Configuration
class AppConfig {

    @Bean
    fun createDispatcher(): ExecutorCoroutineDispatcher =
            ForkJoinPool.ForkJoinWorkerThreadFactory {
                ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(it)
            }.let {
                ForkJoinPool(4, it, null, true)
            }.asCoroutineDispatcher()
}