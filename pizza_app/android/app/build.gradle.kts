plugins {
    id("com.android.application")
    id("kotlin-android")
    // Flutter Gradle Plugin mora biti nakon Android i Kotlin pluginova
    id("dev.flutter.flutter-gradle-plugin")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.pizza_app"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        applicationId = "com.example.pizza_app"
        minSdkVersion(23)
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            // TODO: Dodaj svoj potpis za release build
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    // Import Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.11.0"))

    // Firebase dependencies
    //implementation("com.google.firebase:firebase-analytics")
    //implementation("com.google.firebase:firebase-auth")
    //implementation("com.google.firebase:firebase-firestore")
    //implementation("com.google.firebase:firebase-messaging")
}

// Primjeni Google Services plugin
apply(plugin = "com.google.gms.google-services")
