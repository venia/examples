# examples
Create submodule:
mvn archetype:generate -DgroupId=com.aquila.spring -DartifactId=event-domain -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

These files are from Maven wrapper. It works similarly to the Gradle wrapper.

This allows you to run the Maven project without having Maven installed and present on the path. It downloads the correct Maven version if it's not found (as far as I know by default in your user home directory).

The mvnw file is for Linux (bash) and the mvnw.cmd is for the Windows environment.

To create or update all necessary Maven Wrapper files execute the following command:

mvn -N io.takari:maven:wrapper
To use a different version of maven you can specify the version as follows:

mvn -N io.takari:maven:wrapper -Dmaven=3.3.3
Both commands require maven on PATH (add the path to maven bin to Path on System Variables) if you already have mvnw in your project you can use ./mvnw instead of mvn in the commands.
