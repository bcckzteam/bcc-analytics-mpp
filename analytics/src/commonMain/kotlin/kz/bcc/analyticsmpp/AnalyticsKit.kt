package kz.bcc.analyticsmpp

import kz.bcc.core.EventMap
import kz.bcc.core.IEvent
import kz.bcc.core.IProvider
import kz.bcc.core.ProviderEnum
import kotlin.native.concurrent.ThreadLocal


@ThreadLocal
object AnalyticsKit : IEvent {

    private val providers = mutableListOf<IProvider>()

    private val eventMap = mutableListOf<EventMap>()

    internal fun registerProvider(event: IProvider) {
        providers.add(event)
    }

    private val defaultParams = mutableMapOf<String, String>()

    private fun getParam() = defaultParams.map { it.key to it.value }

    /**
     * Получаем файл конфига с бэка
     */
    fun setMap(map: List<EventMap>) {
        this.eventMap.clear()
        this.eventMap.addAll(map)
    }

    /**
     * Параметры по умолчанию (время,аккаунт и т д)
     */
    fun setParam(key: String, value: String) {
        defaultParams[key] = value
    }

    private fun vendors(globalKey: String) =
        eventMap.find { it.globalKey == globalKey }?.providers ?: emptyList()

    private fun vendor(provider: ProviderEnum) =
        providers.find { it.provider == provider }


    override fun event(key: String, params: Map<String, Any>) {
        val vendors = vendors(key)
        vendors.forEach {
            val vendor = vendor(it.provider)
            vendor?.event(it.eventKey, params + getParam())
        }
    }

}