package com.example.msastudypointservice.common

import com.example.orderservice.common.DomainEvent

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/26
 * */
interface DomainEventPublisher <T: DomainEvent>{

    fun publish(aggregateType: String, events : Iterable<T>)

}