package kz.bcc.appsflayer

import com.appsflyer.AppsFlyerLib
import kz.bcc.core.AnalyticsExt.context

actual class AppsFlayerConfigure actual constructor(key: String) {
    init {
        AppsFlyerLib.getInstance().init(key, null, context)
        AppsFlyerLib.getInstance().setDebugLog(true)
        AppsFlyerLib.getInstance().start(context)
    }
}