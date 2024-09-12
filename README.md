
# Load Balancer Application with Docker and AWS

This project involves building an application with a load balancer architecture, three services handling incoming requests, and a NoSQL database, all orchestrated using Docker and deployed on AWS.

![Architecture Diagram](https://i.imgur.com/legoFeL.png)

---

## MongoDB

This project uses **MongoDB** as its NoSQL database solution. MongoDB is a flexible and scalable database designed for handling large volumes of unstructured data. It stores data in JSON-like documents, making it easy to store and retrieve complex data structures.

In this application:
- **MongoDB** serves as the backend database where logs and other data are stored.
- The `LogService` retrieves and stores log entries in MongoDB, and the data is distributed among multiple services using the Round Robin load-balancing algorithm.

---
## Prerequisites

To work on this project, you'll need the following technologies:

- **[Maven](https://openwebinars.net/blog/que-es-apache-maven/)**: A build automation tool used for managing project dependencies and configurations throughout the project lifecycle.
- **[Git](https://learn.microsoft.com/en-us/devops/develop/git/what-is-git)**: A distributed version control system (VCS) for tracking changes in source code.
- **[Docker](https://www.ibm.com/co-es/topics/docker)**: An open-source containerization platform that allows developers to package applications into standardized containers, combining the application's source code with the operating system libraries and dependencies required to run the code in any environment.

---

## Installation

First, clone the repository:

```bash
git clone https://github.com/juaneortiz1/lab04Arep.git
```

Navigate to the cloned repository directory:

```bash
cd lab04Arep
```

Pull the images defined in the `docker-compose.yml` file:

```bash
docker-compose pull
```

---

## Running the Application

To start the containers, use the following command:

**Windows/Linux/MacOS**

```bash
docker-compose up -d
```

To verify that the containers are running, use:

```bash
docker ps
```

For this setup, we're deploying on an AWS EC2 instance:



You can access the main service locally at:

```text
http://localhost:8087
```

For deployment on an EC2 instance, access the application using the public DNS or IP address provided by AWS:

ec2-54-145-198-255.compute-1.amazonaws.com




The web application allows users to input any text string, which is then distributed evenly among the log services using a Round Robin load-balancing algorithm. The application returns the last 10 stored inputs from the database, along with their creation timestamps, in JSON format.



---

## Built With

* [Maven](https://maven.apache.org/): A build automation tool that standardizes project configurations throughout its lifecycle.
* [Git](https://rometools.github.io/rome/): A distributed version control system (VCS) for source code management.
* [IntelliJ IDEA](https://www.jetbrains.com/idea/): An integrated development environment (IDE) for software development.
* [Java 19](https://www.java.com/en/): A general-purpose programming language used for web, server, mobile applications, and more, featuring object-oriented programming and strong variable typing.
* [HTML](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/HTML_basics): The standard markup language for structuring and presenting content on the web.
* [JavaScript](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/First_steps/What_is_JavaScript): A programming language for implementing complex features on web pages.
* [Docker](https://www.ibm.com/co-es/topics/docker): An open-source containerization platform for packaging applications with their dependencies in standardized containers.

**Author**: Juan Esteban Ortiz Pastrana



