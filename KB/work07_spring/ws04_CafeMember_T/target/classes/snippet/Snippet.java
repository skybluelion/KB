package snippet;

public class Snippet {
	<?xml version="1.0" encoding="UTF-8"?>
	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/maven-v4_0_0.xsd">
		<modelVersion>4.0.0</modelVersion>
		<groupId>com.service</groupId>
		<artifactId>spring</artifactId>
		<name>ws_04_CafeMember_T</name>
		<packaging>war</packaging>
		<version>1.0.0-BUILD-SNAPSHOT</version>
		<properties>
			<java-version>1.8</java-version>
			<org.springframework-version>4.1.1.RELEASE</org.springframework-version>
			<org.aspectj-version>1.6.10</org.aspectj-version>
			<org.slf4j-version>1.6.6</org.slf4j-version>
		</properties>
		<dependencies>
			<!-- Spring -->
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-context</artifactId>
				<version>${org.springframework-version}</version>
				<exclusions>
					<!-- Exclude Commons Logging in favor of SLF4j -->
					<exclusion>
						<groupId>commons-logging</groupId>
						<artifactId>commons-logging</artifactId>
					 </exclusion>
				</exclusions>
			</dependency>
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-webmvc</artifactId>
				<version>${org.springframework-version}</version>
			</dependency>
					
			<!-- AspectJ -->
			<dependency>
				<groupId>org.aspectj</groupId>
				<artifactId>aspectjrt</artifactId>
				<version>${org.aspectj-version}</version>
			</dependency>	
			
			<!-- Logging -->
			<dependency>
				<groupId>org.slf4j</groupId>
				<artifactId>slf4j-api</artifactId>
				<version>${org.slf4j-version}</version>
			</dependency>
			<dependency>
				<groupId>org.slf4j</groupId>
				<artifactId>jcl-over-slf4j</artifactId>
				<version>${org.slf4j-version}</version>
				<scope>runtime</scope>
			</dependency>
			<dependency>
				<groupId>org.slf4j</groupId>
				<artifactId>slf4j-log4j12</artifactId>
				<version>${org.slf4j-version}</version>
				<scope>runtime</scope>
			</dependency>
			<dependency>
				<groupId>log4j</groupId>
				<artifactId>log4j</artifactId>
				<version>1.2.15</version>
				<exclusions>
					<exclusion>
						<groupId>javax.mail</groupId>
						<artifactId>mail</artifactId>
					</exclusion>
					<exclusion>
						<groupId>javax.jms</groupId>
						<artifactId>jms</artifactId>
					</exclusion>
					<exclusion>
						<groupId>com.sun.jdmk</groupId>
						<artifactId>jmxtools</artifactId>
					</exclusion>
					<exclusion>
						<groupId>com.sun.jmx</groupId>
						<artifactId>jmxri</artifactId>
					</exclusion>
				</exclusions>
				<scope>runtime</scope>
			</dependency>
	
			<!-- @Inject -->
			<dependency>
				<groupId>javax.inject</groupId>
				<artifactId>javax.inject</artifactId>
				<version>1</version>
			</dependency>
					
			<!-- Servlet -->
			<dependency>
				<groupId>javax.servlet</groupId>
				<artifactId>servlet-api</artifactId>
				<version>2.5</version>
				<scope>provided</scope>
			</dependency>
			<dependency>
				<groupId>javax.servlet.jsp</groupId>
				<artifactId>jsp-api</artifactId>
				<version>2.1</version>
				<scope>provided</scope>
			</dependency>
			<dependency>
				<groupId>javax.servlet</groupId>
				<artifactId>jstl</artifactId>
				<version>1.2</version>
			</dependency>
		
			<!-- 1. mybatis -->
		    <dependency>
		        <groupId>org.mybatis</groupId>
		        <artifactId>mybatis</artifactId>
		        <version>3.4.6</version>
		    </dependency>
	    
		    <!-- 2. mybatis-spring -->
		    <dependency>
		        <groupId>org.mybatis</groupId>
		        <artifactId>mybatis-spring</artifactId>
		        <version>1.3.2</version>
		    </dependency>
	        
		    <!-- 3. spring-jdbc -->
		    <dependency>
		        <groupId>org.springframework</groupId>
		        <artifactId>spring-jdbc</artifactId>
		        <version>5.1.3.RELEASE</version>
		    </dependency>
	    
		    <!-- 4. spring-tx -->
		    <dependency>
		        <groupId>org.springframework</groupId>
		        <artifactId>spring-tx</artifactId>
		        <version>5.1.3.RELEASE</version>
		    </dependency>
	    
		    <!-- 5. commons-dbcp -->
		    <dependency>
		        <groupId>commons-dbcp</groupId>
		        <artifactId>commons-dbcp</artifactId>
		        <version>1.4</version>
		    </dependency>
	    
		    <!-- 6. commons-pool2 -->
		    <dependency>
		        <groupId>org.apache.commons</groupId>
		        <artifactId>commons-pool2</artifactId>
		        <version>2.6.0</version>
		    </dependency>
	    
		    <!-- 7. 오라클 드라이버  -->
			<dependency>
			    <groupId>com.oracle.database.jdbc</groupId>
			    <artifactId>ojdbc8</artifactId>
			    <version>12.2.0.1</version>
		    </dependency> 
	    
		    <!-- 8. commons-fileupload -->
			<dependency>
			    <groupId>commons-fileupload</groupId>
			    <artifactId>commons-fileupload</artifactId>
			    <version>1.3.3</version>
			</dependency>    
	
	
			<!-- 9. Ajax Json -->
			<dependency>
				<groupId>com.fasterxml.jackson.core</groupId>
				<artifactId>jackson-databind</artifactId>
				<version>2.5.1</version>
			</dependency>
		
			<!-- Test -->
			<dependency>
				<groupId>junit</groupId>
				<artifactId>junit</artifactId>
				<version>4.7</version>
				<scope>test</scope>
			</dependency>        
		</dependencies>
	    <build>
	        <plugins>
	            <plugin>
	                <artifactId>maven-eclipse-plugin</artifactId>
	                <version>2.9</version>
	                <configuration>
	                    <additionalProjectnatures>
	                        <projectnature>org.springframework.ide.eclipse.core.springnature</projectnature>
	                    </additionalProjectnatures>
	                    <additionalBuildcommands>
	                        <buildcommand>org.springframework.ide.eclipse.core.springbuilder</buildcommand>
	                    </additionalBuildcommands>
	                    <downloadSources>true</downloadSources>
	                    <downloadJavadocs>true</downloadJavadocs>
	                </configuration>
	            </plugin>
	            <plugin>
	                <groupId>org.apache.maven.plugins</groupId>
	                <artifactId>maven-compiler-plugin</artifactId>
	                <version>2.5.1</version>
	                <configuration>
	                    <source>1.6</source>
	                    <target>1.6</target>
	                    <compilerArgument>-Xlint:all</compilerArgument>
	                    <showWarnings>true</showWarnings>
	                    <showDeprecation>true</showDeprecation>
	                </configuration>
	            </plugin>
	            <plugin>
	                <groupId>org.codehaus.mojo</groupId>
	                <artifactId>exec-maven-plugin</artifactId>
	                <version>1.2.1</version>
	                <configuration>
	                    <mainClass>org.test.int1.Main</mainClass>
	                </configuration>
	            </plugin>
	        </plugins>
	    </build>
	</project>
	
}

