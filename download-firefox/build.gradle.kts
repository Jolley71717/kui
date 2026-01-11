plugins {
    `kotlin-dsl`
}

group = "com.github.juggernaut0.kui"

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("de.undercouch:gradle-download-task:5.3.1")
}

gradlePlugin {
    plugins {
        create("downloadFirefoxPlugin") {
            id = "com.github.juggernaut0.kui.download-firefox"
            implementationClass = "DownloadFirefoxPlugin"
        }
    }
}
