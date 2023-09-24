import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
}

val secretProperties = Properties()
secretProperties.load(FileInputStream(file("../secrets.properties")))

android {
    namespace = "com.bjelor.dine4fit"
    compileSdk = 34
    buildFeatures {
        buildConfig = true
        dataBinding = true
    }

    defaultConfig {
        applicationId = "com.bjelor.dine4fit"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "PID_KEY", secretProperties.getProperty("PID_KEY"))

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    // Coil
    implementation("io.coil-kt:coil:2.4.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    // Navigation component
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.2")

    // OkHttp
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-simplexml:2.9.0") {
        exclude(module = "stax")
        exclude(module = "stax-api")
        exclude(module = "xpp3")
    }

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

kapt {
    correctErrorTypes = true
}