package com.sammy.domain.usecases

interface BaseUseCase<in Parameter,out Result> {
    suspend operator fun invoke(parameter:Parameter):Result
}