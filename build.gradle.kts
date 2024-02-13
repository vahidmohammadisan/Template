plugins {
/*
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.junit) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
*/

    alias(libs.plugins.android.top.app.gradle.plugin) apply false
    alias(libs.plugins.android.top.library.plugin) apply false
    alias(libs.plugins.android.top.kotlin.plugin) apply false
    alias(libs.plugins.hilt.app) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.ksp) apply false
}


/*allprojects {
    apply(
        plugin = "io.gitlab.arturbosch.detekt"
    )

*//*    detekt {
        buildUponDefaultConfig = true
        config.setFrom(files("$rootDir/gradle/detekt.yml"))
    }*//*
}*/
