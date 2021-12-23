package kz.bcc.huawei

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}