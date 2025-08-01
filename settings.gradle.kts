pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "CodeLabsTutorials"
include(":app")
include(":app:u2_path1")
include(":app:u2_path2")
include(":app:u2_path2_practice")
include(":app:u2_path3")
include(":app:u2_path4")
include(":app:u3_path1")
include(":app:u3_path1_practice")
include(":app:u1_path3")
include(":app:u3_path2")
include(":app:u3_path2_practice")
include(":app:u3_path3")
include(":app:u3_path3_practice1")
