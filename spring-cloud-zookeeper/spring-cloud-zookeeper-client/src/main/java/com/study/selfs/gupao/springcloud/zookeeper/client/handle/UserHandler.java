package com.study.selfs.gupao.springcloud.zookeeper.client.handle;

import com.study.selfs.gupao.springcloud.user.domain.User;
import com.study.selfs.gupao.springcloud.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    @Autowired
    private UserService userServiceImpl;

    public Mono<ServerResponse> saveUser(ServerRequest serverRequest){
        Mono<User> objectMono = serverRequest.bodyToMono(User.class);
        Mono<User> map = objectMono.map(userServiceImpl::save);
        return ServerResponse.ok().body(map,User.class);
    }

}
