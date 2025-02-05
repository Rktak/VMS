# Visitor Management System
 
 
### Technologies Used
Backend: Spring Boot, MySQL
CSV Processing: Apache Commons CSV
Logging: SLF4J
 
### Modules
#### Admin Module
Manages users with role-based access.
Supports bulk user creation via CSV uploads.
Implements logging for system monitoring.
#### GateKeeper Module
Handles visitor registration and visit tracking.
Marks visitor entry and exit.
Supports image uploads for visitor identification.
#### Resident Module
Manages visit approvals and status updates.
Tracks pending visits.
Provides paginated visit history.
## Setup & Installation
 
Clone the repository:

```bash
  git clone <repo-url>
  cd VMS
```
 
Configure MySQL database in application.properties
 
Build and run the Spring Boot application
 
```bash
  mvn clean install  
  mvn spring-boot:run  
```
 
