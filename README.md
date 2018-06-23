# microtrace
Distributed Tracing for Micro Services using Jaeger

# Jaeger
Install jaeger without docker on Windows / Llinux
https://github.com/jaegertracing/jaeger/releases

~~
Release 1.5.0 -> jaeger-1.5.0-windows-amd64.tar.gz
~~

- Extract the package jaeger-1.5.0-windows-amd64
- Navigate to the folder where package is extracted in Command Prompt (cmd)
- Execute jaeger-standalone.exe (windows) 
- Access jaeger-ui  http://localhost:16686

# MicroServices

- 3 micro-services are developed using spring boot 
 
  Service | HTTP Port
  ----|---
  micro-a | 8180 
  micro-b | 8280
  micro-c | 8380


The following features are demonstrated.

Api | Summary
--- |---
/hello |  test
/chaining| 3 micro services are invoked successfully
/chainException|  3 micro services are invoked causing exception in micro-c
/chainLatency| 3 micro services are invoked causing delay in response micro-b


# Build & Run 

Navigate to each micro-service root directory
- mvn clean install (Build)
- mvn spring-boot:run (Run micro-service)

# Demo Application - Test URLs

- http://localhost:8180/hello
- http://localhost:8180/chaining
- http://localhost:8180/chainException
- http://localhost:8180/chainLatency
  