plugins {
    id("java")
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.springframework.boot") version "2.5.3"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11)) // Или 17, в зависимости от поддержки
    }
}

group = "may.code"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-amqp")
    implementation("org.springframework.boot:spring-boot-starter-reactor-netty")
    implementation("org.springframework.amqp:spring-rabbit:2.3.10")
    implementation("org.springframework:spring-websocket:5.3.9")
    implementation("org.springframework:spring-messaging:5.3.9")
    implementation("org.postgresql:postgresql:42.3.1")

    compileOnly("org.projectlombok:lombok:1.18.20")
    testCompileOnly("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.20")
    implementation("redis.clients:jedis:3.6.3")
    implementation("com.h2database:h2:1.4.200")
//    compileOnly("org.projectlombok:lombok:1.18.28']")
//    annotationProcessor("org.projectlombok:lombok:1.18.28")

    testImplementation("org.junit.platform:junit-platform-runner:1.8.0-M1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}


tasks.test {
    useJUnitPlatform()
}
