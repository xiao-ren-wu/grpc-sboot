package org.ywb.grpcservice.bootstrap;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.ywb.grpcservice.impl.UserServiceImpl;

import java.io.IOException;

/**
 * @author yuwenbo
 * @date 2021/6/9 下午3:51
 * @since 1.0.0
 */
@Slf4j
@Configuration
public class GrpcServerBootStrap {

    @Bean
    public Server grpcServer(final UserServiceImpl userServiceGrpc) throws IOException {
        Server server =
                ServerBuilder.forPort(8888)
                .addService(userServiceGrpc)
                .build();
        server.start();
        log.info("Grpc start at 8888");
        return server;
    }
}
