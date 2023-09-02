plugins {
    id("java-platform")
}

group="com.croman"

val androidxVersion = "1.4.3"
val ktorVersion = "2.3.3"
val coroutinesVersion = "1.6.4"
val glideVersion = "4.16.0"
val koinVersion = "3.3.3"
dependencies {
    constraints {
        // apply here all the constraints to the projects
        api("androidx.compose.ui:ui:$androidxVersion")
        api("androidx.compose.ui:ui-tooling:$androidxVersion")
        api("androidx.compose.ui:ui-tooling-preview:$androidxVersion")
        api("androidx.compose.foundation:foundation:$androidxVersion")
        api("androidx.compose.material:material:$androidxVersion")
        api("androidx.activity:activity-compose:1.7.1")

        api("io.ktor:ktor-client-core:$ktorVersion")
        api("io.ktor:ktor-client-okhttp:$ktorVersion")
        api("io.ktor:ktor-client-content-negotiation:$ktorVersion")
        api("io.ktor:ktor-client-serialization:$ktorVersion")
        api("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
        api("io.ktor:ktor-client-darwin:$ktorVersion")
        api("io.ktor:ktor-client-android:$ktorVersion")

        api("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
        api("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

        api("com.github.bumptech.glide:glide:$glideVersion") //4.15.1
        api("com.github.bumptech.glide:compose:1.0.0-alpha.1")

        api("io.insert-koin:koin-core:$koinVersion")
        api("io.insert-koin:koin-android:$koinVersion")
        api("io.insert-koin:koin-androidx-compose:3.4.2")
        api("dev.icerock.moko:mvvm-core:0.13.1")
    }
}