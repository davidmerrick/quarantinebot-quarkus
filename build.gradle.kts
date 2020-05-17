repositories {
    mavenLocal()
    mavenCentral()
}

plugins {
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.allopen") version "1.3.72"
    id("io.quarkus") version "1.4.2.Final"
}

dependencies {
    val quarkusVersion = "1.4.2.Final"

    implementation(enforcedPlatform("io.quarkus:quarkus-universe-bom:$quarkusVersion"))
    implementation("io.quarkus:quarkus-resteasy-jackson")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-config-yaml")
    implementation("io.quarkus:quarkus-amazon-lambda-http")
    implementation("io.quarkus:quarkus-resteasy")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:kotlin-extensions")
}

group = "io.github.davidmerrick"
version = "1.0.0-SNAPSHOT"

quarkus {
    setOutputDirectory("$projectDir/build/classes/kotlin/main")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
            javaParameters = true
        }
    }

    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
            javaParameters = true
        }
    }

    quarkusDev {
        setSourceDir("$projectDir/src/main/kotlin")
    }

    test {
        systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
    }
}