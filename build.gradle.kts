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
      srcDirs("vars", "pipeline", "src/main/groovy")
    }
  }
}