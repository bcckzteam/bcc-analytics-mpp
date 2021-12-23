package kz.bcc.analyticsmpp

import android.app.Application
import kz.bcc.core.AnalyticsExt


fun AnalyticsConfigureBuilder.setContext(context: Application): AnalyticsConfigureBuilder {
    AnalyticsExt.context = context
    return this
}