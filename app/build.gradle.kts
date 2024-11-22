plugins {
    alias(libs.plugins.android.application)
    // Eliminamos el plugin de Firebase
}

android {
    namespace = "com.misoft.proyecto_final_programacion_movil"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.misoft.proyecto_final_programacion_movil"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Dependencias base
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Parse SDK
    implementation("com.parse:parse-android:4.3.0")
    implementation("com.parse:parse-livequery-android:1.2.3") // Para tiempo real si lo necesitas

    // Glide para manejo de imágenes
    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    // ShapeOfView para diseños personalizados
    implementation("io.github.florent37:shapeofview:1.4.7")
    implementation ("com.google.android.material:material:1.9.0")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}