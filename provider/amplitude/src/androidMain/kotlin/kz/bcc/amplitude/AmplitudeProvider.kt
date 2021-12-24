package kz.bcc.amplitude

import com.amplitude.api.Amplitude
import kz.bcc.core.IProvider
import kz.bcc.core.ProviderEnum
import org.json.JSONObject

actual class AmplitudeProvider : IProvider {

    override val provider: ProviderEnum
        get() = ProviderEnum.AMPLITUDE

    override fun event(key: String, params: Map<String, Any>) {
        val json = JSONObject()
        params.forEach { key,value ->
            json.put(key,value)
        }
        Amplitude.getInstance().logEvent(key, json)
    }

}