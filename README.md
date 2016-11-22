# WebChat

#####Training project 
 - Maven
 - Spring Framework
    - MVC
    - Data JPA 
    - WebSocket 
    - HATEOAS
 - PostgreSQL
 - Redis
 - JavaScript
    - SockJS
    - AngularJS
    - jQuery

##### Deploy to Tomcat without IDE 
add to **apache-tomcat\conf\tomcat-users.xml**
 ```xml
  <tomcat-users> 
    <role rolename="manager-gui"/>  
    <role rolename="manager-script"/>   
    <user username="admin" password="password" roles="manager-gui,manager-script" />  
  </tomcat-users>
  ```
and **apache-maven\conf\settings.xml**
```xml
<servers>  
    <server>
       <id>TomcatServer</id>
       <username>admin</username>
       <password>password</password>
    </server>
</servers> 
 ```
use **mvn tomcat7:deploy** OR **mvn tomcat7:redeploy**
 
 Tomcat manager should be running or properly setup, before you can use it with maven.
 
 **Good Luck!**