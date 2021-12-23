package kz.bcc.firebase

import com.google.firebase.FirebaseApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import kz.bcc.core.AnalyticsExt.context

actual class FirebaseConfigure actual constructor(key: String) {
    init {
        FirebaseApp.initializeApp(context)
        Firebase.initialize(context)
    }
}