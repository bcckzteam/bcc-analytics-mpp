package kz.bcc.appmetrica

import com.yandex.metrica.YandexMetrica
import kz.bcc.core.IProvider
import kz.bcc.core.ProviderEnum

actual class AppMetricaProvider : IProvider {

    override val provider: ProviderEnum
        get() = ProviderEnum.APPMETRICA

    override fun event(key: String, params: Map<String, Any>) {
        val eventProperties: MutableMap<String, Any> = mutableMapOf()
        params.forEach { item ->
            eventProperties[item.key] = item.value
        }
        YandexMetrica.reportEvent(key, eventProperties)
    }


}