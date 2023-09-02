plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") // Automatically generates instances of serialization interfaces for classes marked @Serializable
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation(platform("com.croman:platform"))

                implementation("io.ktor:ktor-client-core") // The main functionality is here
                implementation("io.ktor:ktor-client-content-negotiation") // ContentNegotiation: Negotiates media types between client and server, Serialize and deserialize content in a specific format (JSON, ProtoBuff and others)
                implementation("io.ktor:ktor-serialization-kotlinx-json") // Artifact for JSON serializer

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")

                implementation("io.insert-koin:koin-core")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                // Put here all the platform drivers for Android
                implementation(platform("com.croman:platform"))
                implementation("io.ktor:ktor-client-okhttp")
            }

        }
        val iosMain by getting {
            dependencies {
                // Put here all the platform drivers for iOS
                implementation(platform("com.croman:platform"))
                implementation("io.ktor:ktor-client-darwin")
            }
        }
    }
}

android {
    namespace = "com.croman.movieappkmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}