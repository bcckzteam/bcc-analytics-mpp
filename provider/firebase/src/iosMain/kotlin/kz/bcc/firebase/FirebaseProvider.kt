package kz.bcc.firebase

import kz.bcc.core.IProvider
import kz.bcc.core.ProviderEnum

actual class FirebaseProvider : IProvider {

    override val provider: ProviderEnum
        get() = ProviderEnum.FIREBASE

    override fun event(key: String, params: Map<String, Any>) {
        TODO("Not yet implemented")
    }

//    override fun event(key: String, params: List<Param>) {
//        val eventProperties: MutableMap<Any?, Any> = mutableMapOf()
//        params.forEach {
//            eventProperties[it.key] = it.value
//        }
//        FIRAnalytics.logEventWithName(key, eventProperties)
//    }
//
//    override fun event(key: String, param: Param) {
//        val eventProperties: MutableMap<Any?, Any> = mutableMapOf()
//        eventProperties[param.key] = param.value
//        FIRAnalytics.logEventWithName(key, eventProperties)
//    }
//
//    override fun event(event: AnalyticsEvent) {
//        val eventProperties: MutableMap<Any?, Any> = mutableMapOf()
//        event.params.forEach {
//            eventProperties[it.key] = it.value
//        }
//        FIRAnalytics.logEventWithName(event.key, eventProperties)
//    }
}