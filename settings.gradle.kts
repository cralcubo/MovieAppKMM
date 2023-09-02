pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
//    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    includeBuild("gradle/platform")
}


rootProject.name = "MovieAppKMM"
include(":androidApp")
include(":shared")