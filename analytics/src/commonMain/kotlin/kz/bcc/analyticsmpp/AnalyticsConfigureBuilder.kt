package kz.bcc.analyticsmpp

import kz.bcc.amplitude.AmplitudeConfigure
import kz.bcc.amplitude.AmplitudeProvider
import kz.bcc.appmetrica.AppMetricaConfigure
import kz.bcc.appmetrica.AppMetricaProvider
import kz.bcc.appsflayer.AppsFlayerConfigure
import kz.bcc.appsflayer.AppsFlayerProvider
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

        amplitudeKey?.let { key ->
            AmplitudeConfigure(key)
            AnalyticsKit.registerProvider(AmplitudeProvider())
        }
        appsFlayerKey?.let { key ->
            AppsFlayerConfigure(key)
            AnalyticsKit.registerProvider(AppsFlayerProvider())
        }
        appMetricaKey?.let { key ->
            AppMetricaConfigure(key)
            AnalyticsKit.registerProvider(AppMetricaProvider())
        }
        firebaseKey?.let { key ->
            FirebaseConfigure(key)
            AnalyticsKit.registerProvider(FirebaseProvider())
        }

        huaweiMetrics?.let {

        }
    }

}

