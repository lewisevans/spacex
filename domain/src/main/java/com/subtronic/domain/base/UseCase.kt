package com.subtronic.domain.base

interface UseCase<out T : Any> {
    suspend fun execute(): DomainResponse<T>
}