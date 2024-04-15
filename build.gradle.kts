plugins {
    id("java")
}

group = "com.iesam.digitallibrary"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
sourceSets {
    test {
        java {
            srcDirs("/test")
        }
    }
}