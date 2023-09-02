plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
}

android {
    namespace = "com.croman.movieapp.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.croman.movieapp.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(platform("com.croman:platform"))
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material:material")
    implementation("androidx.activity:activity-compose")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android")

    implementation("com.github.bumptech.glide:compose")
    implementation("com.github.bumptech.glide:glide")
    kapt("com.github.bumptech.glide:ksp:4.14.2")

    implementation("io.insert-koin:koin-android")

    implementation("io.ktor:ktor-client-okhttp")
//    implementation("io.ktor:ktor-client-core") // The main functionality is here
//    implementation("io.ktor:ktor-client-content-negotiation") // ContentNegotiation: Negotiates media types between client and server, Serialize and deserialize content in a specific format (JSON, ProtoBuff and others)
//    implementation("io.ktor:ktor-serialization-kotlinx-json") // Artifact for JSON serializer
}