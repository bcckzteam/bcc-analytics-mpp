pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "bcc-analytics-mpp"
includeBuild("convention-plugins")
include(":analytics")
include(":provider:firebase")
include(":provider:amplitude")
include(":provider:appmetrica")
include(":provider:appsflayer")
include(":core")
include(":provider:huawei")
