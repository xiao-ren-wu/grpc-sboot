package org.ywb.grpcclient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.ywb.userservice.api.UserGetRequest;
import org.ywb.userservice.api.UserGetResponse;
import org.ywb.userservice.api.UserServiceGrpc;

@Slf4j
@SpringBootApplication
public class GrpcClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
        UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub = UserServiceGrpc.newBlockingStub(userGrpcManagedChannel());


        UserGetRequest userGetRequest = UserGetRequest.newBuilder()
                .setId(123)
                .build();
        UserGetResponse userGetResponse = userServiceBlockingStub.get(userGetRequest);
        String s = userGetResponse.toString();
        log.info(s);
    }

    public static ManagedChannel userGrpcManagedChannel(){
        return ManagedChannelBuilder.forAddress("127.0.0.1",8888)
                .usePlaintext()
                .build();
    }

}
