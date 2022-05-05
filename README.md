# Springboot-selenium
A spring boot based cucumber + testNg selenium framework
<br><br>
**Features:**
- [x] [Dependency Inversion](https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring)
- [x] Parallel test execution
- [x] Cucumber + TestNg
- [x] Selenium Grid
- [x] [Spring profiles](https://www.baeldung.com/spring-profiles)
- [x] [Aspect-Oriented Programming (AOP)](https://www.baeldung.com/spring-aop)

**Annotations used in project:**
- [x] [@Bean](https://www.baeldung.com/spring-bean)
- [x] [@Autowired](https://www.baeldung.com/spring-autowire)
- [x] [@PostConstruct](https://www.baeldung.com/spring-postconstruct-predestroy)
- [x] [@Component](baeldung.com/spring-component-annotation)
- [x] [@Lazy](https://www.baeldung.com/spring-boot-lazy-initialization)
- [x] [@Configuration](https://www.baeldung.com/configuration-properties-in-spring-boot)
- [x] [@Value](https://www.baeldung.com/spring-value-annotation)
- [x] [@Service](baeldung.com/spring-component-repository-service)
- [x] [@Profile](https://www.baeldung.com/spring-profiles)

**Custom Annotations used in project:**
- [x] @LazyAutowired
- [x] @LazyConfiguration
- [x] @LazyService
- [x] @PageFragment
- [x] @ThreadScopeBean
- [x] @TakeScreenShot
- [x] @IterativeBackwardWindowSwitch
- [x] @IterativeForwardWindowSwitch
- [x] @TitleBasedWindowSwitch

#### To learn more about the spring boot, please see the below links which might be helpful in understanding the same:
- [Spring boot official](https://spring.io/projects/spring-boot)
- [Spring boot video course by Telusko](https://www.youtube.com/watch?v=35EQXmHKZYs)
- [Spring boot video course by Amigoscode](https://www.youtube.com/watch?v=9SGDpanrc8U)
- [Spring boot integration in to test automation by Execute Automation](https://www.youtube.com/watch?v=cG6ZLiRxn1M&list=PL6tu16kXT9PrDr6kMGQ-CgnvCsFxrq1eS)
- [Spring boot integration in to test automation by VinsGuru](https://www.udemy.com/course/cucumber-with-spring-boot/)


### How to start?
Clone the repository and below are few dependencies which are required for the project to run: 
- [x] Maven 3.8.5 or greater (preferably Maven 3.8.5)
  - [Maven official site](https://maven.apache.org/download.cgi)
  - [Tutorial to install maven in windows/linux/mac](https://maven.apache.org/install.html)
- [x] Java 8 or 11 or higher (preferably Java 11)
  - [AdoptOpenJdk official site](https://adoptopenjdk.net/)
  - [Installation procedure for windows/linux/mac](https://adoptopenjdk.net/installation.html)
- [x] Docker latest
  - [Installation instructions for windows/linux/mac](https://docs.docker.com/engine/install/)
- [x] Docker compose
  - [Installation instructions for windows/linux/mac](https://docs.docker.com/compose/install/)

## Step by step actions
Required dependencies:
```
     <dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-log4j2</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>${lombok.version}</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>com.github.javafaker</groupId>
			<artifactId>javafaker</artifactId>
			<version>${faker.version}</version>
		</dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>${selenium.version}</version>
		</dependency>
		<dependency>
			<groupId>io.github.bonigarcia</groupId>
			<artifactId>webdrivermanager</artifactId>
			<version>${webdrivermanager.version}</version>
		</dependency>
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>${cucumber-java.version}</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-java8</artifactId>
			<version>${cucumber-java.version}</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-spring</artifactId>
			<version>${cucumber-srping.version}</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-testng</artifactId>
			<version>${cucumber-testng.version}</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>${testng.version}</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		<exclusions>
			<exclusion>
				<groupId>org.junit.vintage</groupId>
				<artifactId>junit-vintage-engine</artifactId>
			</exclusion>
		</exclusions>
		</dependency>
	</dependencies>
```
Jar dependencies version:
```
  <java.version>11</java.version>
  <selenium.version>4.1.3</selenium.version>
  <webdrivermanager.version>5.1.1</webdrivermanager.version>
  <testng.version>7.5</testng.version>
  <junit.engine.version>5.8.2</junit.engine.version>
  <cucumber-java.version>7.3.2</cucumber-java.version>
  <cucumber-srping.version>7.3.2</cucumber-srping.version>
  <cucumber-testng.version>7.3.2</cucumber-testng.version>
  <lombok.version>1.18.24</lombok.version>
  <faker.version>1.0.2</faker.version>
  <maven.surefire.version>3.0.0-M6</maven.surefire.version>
  <maven.compiler.version>3.10.1</maven.compiler.version>
```
Maven dependencies can be downloaded through below any one command
```
mvn dependency:resolve
-OR-
mvn install
-OR-
mvn package
```
### Running the project
To see the output and the magic, just run below command and make sure that all prerequisites with regards to dependencies are completed
```
docker compose up -- build
-OR-
docker compose up
-OR- (not recommended)
docker compose up -d 
```
## Additional information
### Creating a docker image
The above command builds image for the dockerfile specified in the root project directory
```
docker build -t ownerName/repositoryName:version-tag -f Dockerfile .
```
Example:
```
docker build -t suneel/spring-boot-selenium:0.0.1 -f Dockerfile .
```
### Running a docker compose
To run a docker compose use the below command
```
docker-compose up -d
-OR-
docker-compose up
```
### Volume mapping in docker
To map a directory from the local system to docker container
```
docker run -v any_directory_from_local_system:docker_container_directory_even_auto_created_if_not_present container_name
```
To see existing docker containers
```
docker ps -a
```
If any further action has to be performed in the container and don't want to exit immediately after the above operation
```
docker run -v -it any_directory_from_local_system:docker_container_directory_even_auto_created_if_not_present container_name
```