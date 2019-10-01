# RSSfeed-reader-scala
The purpose of this project is to parse a text file containing RSS feed URLs by building a Scala application. Because an RSS feed is just XML, this library uses ROME parsing library and its standard functions to required extract data.

Add the following external Jar files that includes the rometools dependencies:
jdom2-2.0.6.jar
rome-1.12.2.jar
rome-modules-1.12.2.jar
rome-utils-1.12.2.jar

If it is a MAVEN project, add the following dependencies-
<dependency>
    <groupId>rome</groupId>
    <artifactId>rome</artifactId>
    <version>1.0</version>
</dependency>
<dependency>
    <groupId>org.jdom</groupId>
    <artifactId>jdom</artifactId>
    <version>1.1</version>
</dependency>
