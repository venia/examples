#################################################################################################################################################

Spring-Boot vs Spring-Framework

3.1.2 -> 6.0.11 Spring-Boot-3.1-Release-Notes
2.7.14 -> 5.3.29 Spring-Boot-3.0-Release-Notes
2.6.15 -> 5.3.27 Spring-Boot-2.7-Release-Notes
2.5.15 -> 5.3.27 Spring-Boot-2.6-Release-Notes
2.4.13 -> 5.3.13 Spring-Boot-2.4-Release-Notes
2.3.12.RELEASE -> 5.2.15.RELEASE
2.3.6.RELEASE -> 5.2.11.RELEASE
#################################################################################################################################################

Here is a simplified Spring Boot and Spring Framework compatibility table:

Spring Boot 3.x uses Spring Framework 6.x and requires Java 17 or higher.
Spring Boot 2.7.x uses Spring Framework 5.3.x and supports Java 8, 11, and 17.
Spring Boot 2.6.x also supports Spring Framework 5.3.x but with slightly older updates.
Spring Boot 2.5.x works with Spring Framework 5.3.x and is compatible with Java 8 and 11.
Newer versions of Spring Boot (3.x) bring Jakarta EE 9 compatibility, while older versions are built on the traditional Java EE platform.
#################################################################################################################################################

mvn archetype:generate -DgroupId=com.aquila.example.java.springintegration -DartifactId=spring-integration-aggregator -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false