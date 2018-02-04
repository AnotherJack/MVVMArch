package io.github.anotherjack.mvvmarchdemo.mvvm.model.api;

import java.util.List;

import io.github.anotherjack.mvvmarchdemo.mvvm.model.entity.User;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by jack on 2018/2/2.
 */

public interface ApiService {

    String HEADER_API_VERSION = "Accept: application/vnd.github.v3+json";

    @Headers({HEADER_API_VERSION})
    @GET("/users")
    Observable<List<User>> getUsers(@Query("since") int lastIdQueried, @Query("per_page") int perPage);
}
