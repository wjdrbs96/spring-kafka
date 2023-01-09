tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}

dependencies {
    implementation("org.springframework.kafka:spring-kafka")
    implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5")
}