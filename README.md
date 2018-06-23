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
  
#Snapshots

-Traces
![micro-trace-snapshot-1](https://user-images.githubusercontent.com/33663711/41805673-7d02b52a-76cc-11e8-8124-6a6fc8d936a4.PNG)

-Services
![micro-trace-snapshot-2](https://user-images.githubusercontent.com/33663711/41805674-7d2d80ca-76cc-11e8-8f2e-7a699617d02c.PNG)

-Span
![micro-trace-snapshot-3](https://user-images.githubusercontent.com/33663711/41805675-7d575de6-76cc-11e8-9d75-7e01ceceb066.PNG)