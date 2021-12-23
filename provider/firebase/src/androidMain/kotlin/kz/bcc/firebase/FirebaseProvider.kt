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
        //TODO
        val firebaseAnalytics = Firebase.analytics
        firebaseAnalytics.logEvent(key) {
            params.forEach { item ->
                val bundle = Bundle()
                when(val value = item.value){
                    is String -> {
                        bundle.putString(item.key,value)
                    }
                    is Int -> {
                        bundle.putInt(item.key,value)
                    }
                    is Float -> {
                        bundle.putFloat(item.key,value)
                    }
                    is Map<*, *> -> {
                        //TODO
                    }
                }
                param(item.key,  bundle)
            }
        }
    }


}