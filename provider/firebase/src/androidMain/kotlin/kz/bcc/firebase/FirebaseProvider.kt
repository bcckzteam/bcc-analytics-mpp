package kz.bcc.firebase

import android.os.Bundle
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import kz.bcc.core.IProvider
import kz.bcc.core.ProviderEnum

actual class FirebaseProvider : IProvider {


    override val provider: ProviderEnum
        get() = ProviderEnum.FIREBASE

    override fun event(key: String, params: Map<String, Any>) {
        val firebaseAnalytics = Firebase.analytics
        firebaseAnalytics.logEvent(key,params.toBundle())
    }


}