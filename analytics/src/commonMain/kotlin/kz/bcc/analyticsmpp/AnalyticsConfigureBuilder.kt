package kz.bcc.analyticsmpp

import kz.bcc.amplitude.AmplitudeConfigure
import kz.bcc.amplitude.AmplitudeProvider
import kz.bcc.appmetrica.AppMetricaConfigure
import kz.bcc.appmetrica.AppMetricaProvider
import kz.bcc.appsflayer.AppsFlayerConfigure
import kz.bcc.appsflayer.AppsFlayerProvider
import kz.bcc.core.AnalyticsLogger
import kz.bcc.firebase.FirebaseConfigure
import kz.bcc.firebase.FirebaseProvider

class AnalyticsConfigureBuilder private constructor() {

    private var amplitudeKey: String? = null
    private var appsFlayerKey: String? = null
    private var appMetricaKey: String? = null
    private var firebaseKey: String? = null
    private var huaweiMetrics: String? = null

    companion object {
        fun builder() = AnalyticsConfigureBuilder()

    }

    fun setFireBase(): AnalyticsConfigureBuilder {
        firebaseKey = ""
        return this
    }

    fun setAmplitude(key: String): AnalyticsConfigureBuilder {
        this.amplitudeKey = key
        return this
    }

    fun setAppsFlayer(key: String): AnalyticsConfigureBuilder {
        this.appsFlayerKey = key
        return this
    }

    fun setAppMetrica(key: String): AnalyticsConfigureBuilder {
        this.appMetricaKey = key
        return this
    }

    fun setHuawei(key: String): AnalyticsConfigureBuilder {
        this.huaweiMetrics = key
        return this
    }

    fun build() {
        AnalyticsLogger.log("start build")
        amplitudeKey?.let { key ->
            AnalyticsLogger.log("start configure amplitude")
            AmplitudeConfigure(key)
            AnalyticsKit.registerProvider(AmplitudeProvider())
            AnalyticsLogger.log("end configure amplitude")
        }
        appsFlayerKey?.let { key ->
            AnalyticsLogger.log("start configure appsFlayer")
            AppsFlayerConfigure(key)
            AnalyticsKit.registerProvider(AppsFlayerProvider())
            AnalyticsLogger.log("end configure appsFlayer")
        }
        appMetricaKey?.let { key ->
            AnalyticsLogger.log("start configure appMetric")
            AppMetricaConfigure(key)
            AnalyticsKit.registerProvider(AppMetricaProvider())
            AnalyticsLogger.log("end configure appMetric")
        }
        firebaseKey?.let { key ->
            AnalyticsLogger.log("start configure firebase")
            FirebaseConfigure()
            AnalyticsKit.registerProvider(FirebaseProvider())
            AnalyticsLogger.log("end configure firebase")
        }

        huaweiMetrics?.let {

        }
        AnalyticsLogger.log("end build")
    }

}

