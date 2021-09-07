package org.ywb.grpcservice.impl;

import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;
import org.ywb.userservice.api.*;

/**
 * @author yuwenbo
 * @date 2021/6/9 下午3:27
 * @since 1.0.0
 */
@Service
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void get(UserGetRequest request, StreamObserver<UserGetResponse> responseObserver) {
        UserGetResponse userGetResponse = UserGetResponse.newBuilder()
                .setId(request.getId())
                .setName("name:" + request.getId())
                .setGender(request.getId() % 2)
                .build();
        responseObserver.onNext(userGetResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void create(UserCreateRequest request, StreamObserver<UserCreateResponse> responseObserver) {
        // 创建响应对象
        UserCreateResponse.Builder builder = UserCreateResponse.newBuilder();
        builder.setId((int) (System.currentTimeMillis() / 1000));
        // 返回响应
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
