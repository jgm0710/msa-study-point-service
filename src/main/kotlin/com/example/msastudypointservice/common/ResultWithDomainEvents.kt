package com.example.orderservice.common

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/21
 * */
class ResultWithDomainEvents<T, R : DomainEvent>(val domain: T, val events: Iterable<R>){

}