plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.residencehub"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.residencehub"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        // UPDATED: Use 1.5.14 for Kotlin 2.0.x compatibility (matches Compose 1.7.x)
        kotlinCompilerExtensionVersion = "1.5.14"
    }
}

dependencies {
    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

    // Supabase Kotlin SDK – using latest v3.2.5
    implementation(platform("io.github.jan-tennert.supabase:bom:3.2.5"))
    implementation("io.github.jan-tennert.supabase:postgrest-kt")
    implementation("io.github.jan-tennert.supabase:auth-kt")
    implementation("io.github.jan-tennert.supabase:storage-kt")
    implementation("io.github.jan-tennert.supabase:realtime-kt")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")

    // Existing dependencies
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")

    // ==============================================
    // --- UPDATED: Compose UI, Material, and Navigation Dependencies ---
    // ==============================================

    // UPDATED: Use BOM 2024.09.00 (includes Compose 1.7.x, compatible with Kotlin 2.0.x)
    implementation(platform("androidx.compose:compose-bom:2024.09.00"))

    // Core Compose libraries (BOM manages versions)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")

    // Material 3 components (Should now resolve "material3" reference errors)
    implementation("androidx.compose.material3:material3")

    // Compose Navigation (unchanged, but BOM ensures compatibility)
    implementation("androidx.navigation:navigation-compose:2.8.0")  // UPDATED: Minor version bump for stability

    // UPDATED: Add ui-tooling-preview for previews
    implementation("androidx.compose.ui:ui-tooling-preview")

    // Tooling for debugging
    debugImplementation("androidx.compose.ui:ui-tooling")

    // ==============================================

    // Add core KTX for compatibility
    implementation("androidx.core:core-ktx:1.13.1")
}