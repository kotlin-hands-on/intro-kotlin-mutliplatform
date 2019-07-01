plugins {
  kotlin("jvm") version "1.3.40"
}

repositories {
  jcenter()
  mavenCentral()
}

val ktorVersion = "1.2.2"
val logbackVersion = "1.2.3"

dependencies {
  implementation(kotlin("stdlib-jdk8"))
  implementation("io.ktor:ktor-server-netty:$ktorVersion")
  implementation("io.ktor:ktor-html-builder:$ktorVersion")
  implementation("ch.qos.logback:logback-classic:$logbackVersion")
}

val run by tasks.creating(JavaExec::class) {
  group = "application"
  dependsOn(tasks.classes)
  main = "com.jetbrains.handson.introMpp.MainKt"
  classpath(
          { sourceSets["main"].output },
          { configurations.runtimeClasspath }
  )
  ///disable app icon on macOS
  systemProperty("java.awt.headless", "true")
}
