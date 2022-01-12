package kz.bcc.firebase

import cocoapods.FirebaseCore.FIRApp

actual class FirebaseConfigure actual constructor() {
    init {
        FIRApp.configure()
    }
}