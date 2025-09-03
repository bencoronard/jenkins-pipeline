plugins {
  groovy
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("com.lesfurets:jenkins-pipeline-unit:1.26")
}

sourceSets {
  main {
    groovy {
      srcDirs("vars", "src/main/groovy")
    }
  }
}