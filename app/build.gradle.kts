plugins {
    id("template.android.app")
    //id("template.android.compose")
    id("template.android.hilt")
    //  id("template.android.lib")
}

android {

    namespace = "ir.vahidmohammadisan.newtemplate"

    defaultConfig {
        applicationId = "ir.vahidmohammadisan.newtemplate"

    }

    /*    buildFeatures {
            buildConfig = true
            compose = true
        }

        buildTypes {
            release {
                isMinifyEnabled = true
                isShrinkResources = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro"
                )
                // TODO: for development purposes, remember to create a release signing config when releasing proper app
                signingConfig = signingConfigs.getByName("debug")
            }
        }

        compileOptions {
            isCoreLibraryDesugaringEnabled = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
        }

        kotlin {
            jvmToolchain(17)
        }

        packaging {
            resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }*/
}

dependencies {
    implementation(project(":core"))
    implementation(project(":basic-feature"))

    implementation(libs.hilt)
    implementation(libs.navigation) // needed for Room
    implementation(libs.room.ktx)
    implementation(libs.timber)

    ksp(libs.hilt.compiler)
    ksp(libs.room.compiler)

    coreLibraryDesugaring(libs.desugar)

    //detektPlugins(libs.detekt.compose.rules)
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}
