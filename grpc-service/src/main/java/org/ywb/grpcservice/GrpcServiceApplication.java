package org.ywb.grpcservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

/**
 * @author mi
 */
@SpringBootApplication
public class GrpcServiceApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(GrpcServiceApplication.class, args);
        new CountDownLatch(1).await();
    }

}
