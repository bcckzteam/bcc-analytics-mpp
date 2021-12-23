package kz.bcc.amplitude

import com.amplitude.api.Amplitude
import kz.bcc.core.AnalyticsExt.context

actual class AmplitudeConfigure actual constructor(key: String) {
    init {
        Amplitude
            .getInstance()
            .initialize(context, key)
            .enableForegroundTracking(context)
    }
}