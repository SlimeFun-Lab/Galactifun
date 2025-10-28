plugins {
    `java-library`
    id("io.freefair.lombok") version "8.6"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.3"
    id("xyz.jpenilla.run-paper") version "2.2.0"

    id("com.gradleup.shadow") version "8.3.2"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven(url = "https://repo.papermc.io/repository/maven-public/")
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("com.github.SlimeFun-Lab:InfinityLib:0a765fa9e6")
    compileOnly("io.papermc.paper:paper-api:1.21.10-R0.1-SNAPSHOT")
    compileOnly("com.github.SlimeFun-Lab:Slimefun4:6d5694e")
    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
    implementation("commons-lang:commons-lang:2.6")

//    testImplementation("com.github.seeseemelk:MockBukkit-v1.18:2.85.2")
}

group = "io.github.addoncommunity.galactifun"
version = "2.0.0-UNOFFICIAL"
description = "Galactifun"
java.sourceCompatibility = JavaVersion.VERSION_17

tasks.shadowJar {
    relocate("io.github.mooy1.infinitylib", "io.github.addoncommunity.galactifun.infinitylib")

    archiveFileName = "galactifun.jar"
}

bukkit {
    name = rootProject.name
    description = "Space addon for Slimefun"
    main = "io.github.addoncommunity.galactifun.Galactifun"
    version = project.version.toString()
    authors = listOf("Seggan", "Mooy1", "GallowsDove", "ProfElements")
    apiVersion = "1.21"
    softDepend = listOf("ClayTech", "BentoBox")
    loadBefore = listOf("Multiverse-Core")
    depend = listOf("Slimefun")

    commands {
        register("galactifun") {
            description = "Galactifun main command"
            usage = "/galactifun <subcommand>"
            aliases = listOf("gf", "galactic")
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.runServer {
    downloadPlugins {
        url("https://blob.build/dl/Slimefun4/Dev/1116")
    }
    maxHeapSize = "4G"
    minecraftVersion("1.21.1")
}