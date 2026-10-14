plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "edu.geadaadrian.appdummy"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "edu.geadaadrian.appdummy"
        minSdk = 30
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)

    // Iconos de Material Design. Para usar los iconos, se debe importar el paquete correspondiente en el archivo Kotlin donde se vayan a utilizar, por ejemplo: import androidx.compose.material.icons.Icons
    implementation(libs.iconos.material)

    // Coil para la carga de imágenes.
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    // Activity Compose para la gestión de permisos y otras funcionalidades de Activity en Compose
    implementation(libs.androidx.activity.compose)

    // ViewModel y Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.11.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.11.0")

    // Corrutinas
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.11.0")

    // Testing
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.11.0")

}