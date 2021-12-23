pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "BCCAnalyticsMPP"
includeBuild("convention-plugins")
include(":analytics")
include(":provider:firebase")
include(":provider:amplitude")
include(":provider:appmetrica")
include(":provider:appsflayer")
include(":core")
include(":provider:huawei")
