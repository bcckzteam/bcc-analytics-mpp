package kz.bcc.core

interface IEvent {

    fun event(key: String, params: Map<String, Any>)
}