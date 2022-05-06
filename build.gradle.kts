plugins { java }
repositories {
    mavenCentral()
    google()
}
dependencies {
    implementation("com.google.code.gson:gson:2.8.5")
}

val fatJar = tasks.create<Jar>("fatJar") {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes["Main-Class"] = "Main.Main"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
}

tasks["build"].dependsOn(fatJar)

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}