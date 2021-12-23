package kz.bcc.amplitude

import kz.bcc.core.IProvider
import kz.bcc.core.ProviderEnum

actual class AmplitudeProvider : IProvider {

    override val provider: ProviderEnum
        get() = ProviderEnum.AMPLITUDE

    override fun event(key: String, params: Map<String, Any>) {
        TODO("Not yet implemented")
    }


//
//    override fun event(key: String, params: List<Param>) {
//        val eventProperties: MutableMap<Any, Any> = mutableMapOf()
//        params.forEach {
//            eventProperties[it.key] = it.value
//        }
//        Amplitude.instance().logEvent(key, eventProperties)
//    }
//
//    override fun event(key: String, param: Param) {
//        val eventProperties: MutableMap<Any, Any> = mutableMapOf()
//        eventProperties[param.key] = param.value
//        Amplitude.instance().logEvent(key, eventProperties)
//    }
//
//    override fun event(event: AnalyticsEvent) {
//        val eventProperties: MutableMap<Any, Any> = mutableMapOf()
//        event.params.forEach {
//            eventProperties[it.key] = it.value
//        }
//        Amplitude.instance().logEvent(event.key, eventProperties)
//    }
}