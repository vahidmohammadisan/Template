import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}
group = "com.blank.wallpaper.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApp"){
            id = "template.android.app"
            implementationClass = "plugins.AndroidApplicationConventionPlugin"
        }
        register("androidCompose"){
            id = "template.android.compose"
            implementationClass = "plugins.AndroidComposeConventionPlugin"
        }
        register("androidLibrary"){
            id = "template.android.lib"
            implementationClass = "plugins.AndroidLibConventionPlugin"
        }
        register("androidComposeLibrary"){
            id = "template.android.compose.library"
            implementationClass = "plugins.AndroidLibComposeConventionPlugin"
        }
        register("androidHilt"){
            id = "template.android.hilt"
            implementationClass = "plugins.AndroidHiltConventionPlugin"
        }


    }
}