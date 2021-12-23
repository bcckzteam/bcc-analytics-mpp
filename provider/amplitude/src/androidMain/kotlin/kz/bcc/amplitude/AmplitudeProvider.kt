package kz.bcc.amplitude

import com.amplitude.api.Amplitude
import kz.bcc.core.IProvider
import kz.bcc.core.ProviderEnum
import org.json.JSONObject

actual class AmplitudeProvider : IProvider {

    override val provider: ProviderEnum
        get() = ProviderEnum.AMPLITUDE

    override fun event(key: String, params: Map<String, Any>) {
        val eventProperties = JSONObject()
        try {
            params.forEach { item ->
                eventProperties.put(item.key, item.value)
            }
        } catch (e: Exception) {
            //TODO logs
            e.printStackTrace()
        }

        Amplitude.getInstance().logEvent(key, eventProperties)
    }

}