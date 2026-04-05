plugins {
    kotlin("jvm") version "1.9.23"
    application
}

application {
    mainClass.set("com.test.MainKt")
}

/* ====== helper function di sini ====== */
fun registerRunTask(taskName: String, mainClassName: String) {
    tasks.register<JavaExec>(taskName) {
        group = "application"
        description = "Run $mainClassName"
        mainClass.set(mainClassName)
        classpath = project.extensions
            .getByType<org.gradle.api.tasks.SourceSetContainer>()
            .getByName("main")
            .runtimeClasspath
    }
}
/* ==================================== */


/* ====== pemanggilan ====== */
registerRunTask("runMain", "com.test.MainKt")
registerRunTask("runSay", "com.test.SayKt")
registerRunTask("runNumber", "com.test.NumberKt")
/* ======================== */


group = "com.test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}
