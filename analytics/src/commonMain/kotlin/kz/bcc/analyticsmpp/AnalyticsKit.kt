package kz.bcc.analyticsmpp

import kz.bcc.core.*
import kotlin.native.concurrent.ThreadLocal


@ThreadLocal
object AnalyticsKit {

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

    private fun providers(globalKey: String) =
        eventMap.find { it.globalKey == globalKey }?.providers ?: emptyList()

    private fun provider(provider: ProviderEnum) =
        providers.find { it.provider == provider }


    /**
     * Отправка с помощью event map
     */
    fun eventByGlobalKey(key: String, params: Map<String, Any>) {
        val vendors = providers(key)
        vendors.forEach {
            val vendor = provider(it.provider)
            vendor?.event(it.eventKey, params + getParam())
        }
    }

    /**
     * Отправка всем подключенным провайдером(общий ключ для всех)
     */
    fun eventAllActiveProviders(key: String, params: Map<String, Any>) {
        providers.forEach {
            it.event(key, params)
        }
    }

    /**
     * Отправка выбранным провайдерам(если они подключены)(общий ключ для всех)
     */
    fun eventByProviders(key: String, params: Map<String, Any>, providers: List<ProviderEnum>) {
        val pr = this.providers.filter { pr -> providers.any { it == pr.provider } }
        pr.forEach {
            it.event(key, params)
        }
    }

    /**
     * Отправка выбранным провайдерам(если они подключены) у каждого свои ключи
     */
    fun eventByProviderKey(params: Map<String, Any>, providers: List<Provider>) {
        providers
            .filter { pr -> this.providers.any { it.provider == pr.provider } }
            .forEach {
                val vendor = provider(it.provider)
                vendor?.event(it.eventKey, params + getParam())
            }
    }


}