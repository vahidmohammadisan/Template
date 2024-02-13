pluginManagement {
    repositories {
        google()
        maven(
            uri("https://maven.google.com")
        )
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        maven(
            uri("https://maven.google.com")
        )
        google()
        maven(
            uri("https://maven.google.com")
        )
        google()
        mavenCentral()
    }
}

rootProject.name = "newTemplate"
include(":app")
include(":core")
include(":basic-feature")
