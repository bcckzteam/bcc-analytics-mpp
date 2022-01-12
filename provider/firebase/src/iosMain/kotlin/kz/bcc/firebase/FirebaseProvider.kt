package kz.bcc.firebase

import cocoapods.FirebaseAnalytics.FIRAnalytics
import kz.bcc.core.IProvider
import kz.bcc.core.ProviderEnum

actual class FirebaseProvider : IProvider {

    override val provider: ProviderEnum
        get() = ProviderEnum.FIREBASE

    override fun event(key: String, params: Map<String, Any>) {
        val eventProperties: MutableMap<Any?, Any> = mutableMapOf()
        params.forEach {
            eventProperties[it.key] = it.value
        }
        FIRAnalytics.logEventWithName(key, eventProperties)
    }
}