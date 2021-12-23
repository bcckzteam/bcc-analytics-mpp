package kz.bcc.appsflayer

import kz.bcc.core.IProvider
import kz.bcc.core.ProviderEnum


actual class AppsFlayerProvider : IProvider {

    override val provider: ProviderEnum
        get() = ProviderEnum.APPSFLAYER

    override fun event(key: String, params: Map<String, Any>) {
        TODO("Not yet implemented")
    }


}