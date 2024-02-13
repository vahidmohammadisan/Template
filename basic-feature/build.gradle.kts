plugins {
    id("template.android.lib")
    id("template.android.compose.library")
    id("template.android.hilt")
    id("kotlin-parcelize")

}

android {
    namespace = "ir.vahidmohammadisan.newtemplate.basicfeature"
}

dependencies {
    implementation(project(":core"))

    implementation(platform(libs.compose.bom))
    implementation(libs.coil)
    implementation(libs.compose.material3)
    implementation(libs.hilt)
    implementation(libs.kotlin.coroutines)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.navigation)
    implementation(libs.navigation.hilt)
    implementation(libs.kotlin.serialization)
    implementation(libs.retrofit)
    implementation(libs.room)
    implementation(libs.timber)
    testImplementation(libs.bundles.common.test)
    androidTestImplementation(libs.bundles.common.android.test)
    debugImplementation(libs.debug.compose.manifest)

    ksp(libs.hilt.compiler)
    //kspAndroidTest(libs.test.android.hilt.compiler)

    coreLibraryDesugaring(libs.desugar)

    //detektPlugins(libs.detekt.compose.rules)
}
