# Solution for Customer balance.
Spring boot application is used in this demo application which provides APIs for Monthly and Cumulative balace for a customer.
# APIs
The application provides two end points.

`1. /balance/monthly` :- Provides monthly balance for the current logged in user in a map.

`2./balance/cumulative` :- Provides cumulative balance for the current user.

 (* User session in not handled in this application).

 # Test the application

Application uses Spring Boot's testing support (*JUnit and Mockito*) to create unit tests for service and controller. And *WireMock* to mock the HTTP requests to the external API.

# Deployment

The application can be deploy to remote server using CI/CD pipeline using Jenkins, Gitlab CI/CD etc. 

The pipeline would typically consist of the following steps:

1. Build: The pipeline would first build application into a deployable package.
2. Test: The pipeline would then run unit tests and integration tests to ensure that application is working as expected.
3. Deploy: If all of the tests pass, the pipeline would deploy application to the remote server.
   
Another way to deploy a Spring Boot application to a remote server is to use a manual deployment process. To manually deploy application, first need to build application into a deployable package. Then transfer the deployable package to the remote server, finally start application on the remote server.

