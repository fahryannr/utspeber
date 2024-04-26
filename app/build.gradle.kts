plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.githubuserapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.githubuserapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    implementation("com.squareup.picasso:picasso:2.8")
    implementation("de.hdodenhof:circleimageview:3.1.0")

    implementation(libs.constraintlayout)
    implementation(libs.cardview)
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
}
