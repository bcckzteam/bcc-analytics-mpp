package kz.bcc.appmetrica

import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import kz.bcc.core.AnalyticsExt.context

actual class AppMetricaConfigure actual constructor(key: String) {

    init {
        val config = YandexMetricaConfig.newConfigBuilder(key).withLogs().build()
        YandexMetrica.activate(context, config)
        YandexMetrica.getReporter(context, key)
    }
}