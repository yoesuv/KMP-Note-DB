import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.androidx.room)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
            freeCompilerArgs.add("-Xexpect-actual-classes")
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            linkerOpts.add("-lsqlite3")
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation(libs.kotlinx.serialization.json)
            implementation(libs.navigation.compose)
            implementation(libs.androidx.room.runtime)
            implementation(libs.androidx.sqlite.bundled)
            implementation(libs.material.icons.extended)
            implementation(libs.kotlinx.coroutines.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.yoesuv.kmptask"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.yoesuv.kmptask"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0.1"
        setProperty("archivesBaseName", "$applicationId-v$versionName")
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = true
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
}

room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {
    debugImplementation(compose.uiTooling)
    add("kspAndroid", libs.androidx.room.compiler)
    add("kspIosSimulatorArm64", libs.androidx.room.compiler)
    add("kspIosArm64", libs.androidx.room.compiler)
}

// https://github.com/google/ksp/issues/2442
project.afterEvaluate {
    tasks.named("kspDebugKotlinAndroid") {
        // Ensure Compose resource generation tasks have completed before running KSP for Android
        dependsOn(tasks.named("generateResourceAccessorsForAndroidMain"))
        dependsOn(tasks.named("generateResourceAccessorsForAndroidDebug"))
        dependsOn(tasks.named("generateActualResourceCollectorsForAndroidMain"))
        dependsOn(tasks.named("generateComposeResClass"))
        dependsOn(tasks.named("generateResourceAccessorsForCommonMain"))
        dependsOn(tasks.named("generateExpectResourceCollectorsForCommonMain"))
    }
    tasks.named("kspReleaseKotlinAndroid") {
        // Same ordering for release variant
        dependsOn(tasks.named("generateResourceAccessorsForAndroidMain"))
        dependsOn(tasks.named("generateResourceAccessorsForAndroidRelease"))
        dependsOn(tasks.named("generateActualResourceCollectorsForAndroidMain"))
        dependsOn(tasks.named("generateComposeResClass"))
        dependsOn(tasks.named("generateResourceAccessorsForCommonMain"))
        dependsOn(tasks.named("generateExpectResourceCollectorsForCommonMain"))
    }
    tasks.named("kspKotlinIosSimulatorArm64") {
        // Ensure Compose resource generation tasks have completed before running KSP for iOS
        dependsOn(tasks.named("generateActualResourceCollectorsForIosSimulatorArm64Main"))
        dependsOn(tasks.named("generateResourceAccessorsForIosSimulatorArm64Main"))
        dependsOn(tasks.named("generateResourceAccessorsForIosMain"))
        dependsOn(tasks.named("generateResourceAccessorsForAppleMain"))
        dependsOn(tasks.named("generateResourceAccessorsForNativeMain"))
        dependsOn(tasks.named("generateComposeResClass"))
        dependsOn(tasks.named("generateResourceAccessorsForCommonMain"))
        dependsOn(tasks.named("generateExpectResourceCollectorsForCommonMain"))
    }
}

