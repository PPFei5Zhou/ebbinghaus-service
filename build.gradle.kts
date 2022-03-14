import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    java
    checkstyle
    id("org.springframework.boot") version "2.6.4"
}

repositories {
    maven { setUrl("https://maven.aliyun.com/repository/public/")}
    maven { setUrl("https://maven.aliyun.com/repository/spring/")}
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(platform(SpringBootPlugin.BOM_COORDINATES))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("mysql:mysql-connector-java")
    implementation("org.flywaydb:flyway-core")

    testImplementation(platform("org.junit:junit-bom:5.8.2")) // 在此修改junit版本
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:testcontainers:1.16.3")
    testImplementation("org.testcontainers:mysql:1.16.3")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

checkstyle {
    maxWarnings = 0
    toolVersion = "10.0"
}

tasks {

    test {
        useJUnitPlatform()
    }
}