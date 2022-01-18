# Approach to solve the problem

"User microservice" was identified as `many to many` problem in microservices nature. The decision was taken to
host `users` in one service and its db and `addresses` in another service and db. `gateway` service is responsible to
expose http endpoints and orchestration of users/address data flows by calling them via avro/gRPC

# How to run

### Prerequisites
- Java 17 is required <br/>
- 2 PostgreSQL db need to be created: <br/>
db1 name: `cbua-user` <br/>
db1 user: `cbua-user` <br/>
db1 password: `cbua-user` <br/>
db2 name: `cbua-address` <br/>
db2 user: `cbua-address` <br/>
db2 password: `cbua-address` <br/>

### UserService
`user-service` will try to access by default db `cbua-user` with user `cbua-user` with password `cbua-user` but these
values can be overridden by corresponding env vars supported by spring <br/>

To start `user-service` run `UserApplication` with nex env variables: <br/>
`SERVER_PORT=8081;GRPC_SERVER_PORT=8085`<br/>

### AddressService
Similarly to UserService configure db connection properties if needed <br/>

Run `AddressService` with nex env variables:<br/>
`SERVER_PORT=8082;GRPC_SERVER_PORT=8086`<br/>

### Gateway
Run `GatewayApplication` with nex env variables:<br/>
`SERVER_PORT=8080;USER_SERVICE_HOST=localhost;USER_SERVICE_PORT=8085;ADDRESS_SERVICE_HOST=localhost;ADDRESS_SERVICE_PORT=8086;` <br/>


### Hot to test  
There is http snippets which can be used as an example:<br/> 
misc/http/rest.http








