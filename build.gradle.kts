// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

plugins {
  id("java")
  id("org.jetbrains.intellij") version "1.17.4"
}

group = "org.intellij.sdk"
version = "2.0.0"

repositories {
  maven("https://maven.aliyun.com/repository/public")
}

java {
  sourceCompatibility = JavaVersion.VERSION_21
  targetCompatibility = JavaVersion.VERSION_21
}

// See https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
//  localPath.set("C:\\Program Files\\JetBrains\\IntelliJ IDEA 2024.1")
  version.set("2024.2")

  plugins.set(listOf("java","properties","yaml","Kotlin"))
}

tasks {
  buildSearchableOptions {
    enabled = false
  }

  patchPluginXml {
    version.set("${project.version}")
    sinceBuild.set("242")
  }
}

dependencies {
  implementation("cn.hutool:hutool-all:5.8.31")
  implementation("dom4j:dom4j:1.6.1")
}
