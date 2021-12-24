package kz.bcc.appsflayer

import com.appsflyer.AppsFlyerLib
import kz.bcc.core.AnalyticsExt.context
import kz.bcc.core.IProvider
import kz.bcc.core.ProviderEnum

actual class AppsFlayerProvider : IProvider {

    override val provider: ProviderEnum
        get() = ProviderEnum.APPSFLAYER

    override fun event(key: String, params: Map<String, Any>) {
        AppsFlyerLib.getInstance().logEvent(context, key, params)
    }

}