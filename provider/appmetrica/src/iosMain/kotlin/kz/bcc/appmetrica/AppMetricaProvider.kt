package kz.bcc.appmetrica

import kz.bcc.core.IProvider
import kz.bcc.core.ProviderEnum

actual class AppMetricaProvider : IProvider {

    override val provider: ProviderEnum
        get() = ProviderEnum.APPMETRICA

    override fun event(key: String, params: Map<String, Any>) {
        TODO("Not yet implemented")
    }


//    override fun event(key: String, params: List<Param>) {
//        val eventProperties: MutableMap<Any?, Any> = mutableMapOf()
//        params.forEach {
//            eventProperties[it.key] = it.value
//        }
//        YMMYandexMetrica.reportEvent(key, eventProperties) {}
//    }
//
//    override fun event(key: String, param: Param) {
//        val eventProperties: MutableMap<Any?, Any> = mutableMapOf()
//        eventProperties[param.key] = param.value
//        YMMYandexMetrica.reportEvent(key, eventProperties) {}
//    }
//
//    override fun event(event: AnalyticsEvent) {
//        val eventProperties: MutableMap<Any?, Any> = mutableMapOf()
//        event.params.forEach {
//            eventProperties[it.key] = it.value
//        }
//        YMMYandexMetrica.reportEvent(event.key, eventProperties) {}
//    }
}