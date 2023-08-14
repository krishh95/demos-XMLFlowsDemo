pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "XMLFlowsDemo"
include(":app")
include(":SignIn:SignIn_Data")
include(":SignIn:SignIn_UseCase")
include(":SignIn:SignIn_Presentation")
