package edisontkp.com.justpark.network;

/**
 * Created by edisontkp on 15/10/2016.
 */

import java.io.IOException;


public class ApiClient {

//    public static final String BASE_URL = "http://api.themoviedb.org/3/";
//    private static Retrofit retrofit = null;
//
//
//    public static Retrofit getClient() {
//        if (retrofit==null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }


//
//    private static GitApiInterface gitApiInterface ;
//    private static String baseUrl = "https://api.github.com" ;
//
//    public static GitApiInterface getClient() {
//        if (gitApiInterface == null) {
//
//            OkHttpClient okClient = new OkHttpClient();
//            okClient.interceptors().add(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Response response = chain.proceed(chain.request());
//                    return response;
//                }
//            });
//
//            Retrofit client = new Retrofit.Builder()
//                    .baseUrl(baseUrl)
//                    .addConverter(String.class, new ToStringConverter())
//                    .client(okClient)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//            gitApiInterface = client.create(GitApiInterface.class);
//        }
//        return gitApiInterface ;
//    }
//
//    public interface GitApiInterface {
//
//        @Headers("User-Agent: Retrofit2.0Tutorial-App")
//        @GET("/search/users")
//        Call<GitResult> getUsersNamedTom(@Query("q") String name);
//
//        @POST("/user/create")
//        Call<Item> createUser(@Body String name, @Body String email);
//
//        @PUT("/user/{id}/update")
//        Call<Item> updateUser(@Path("id") String id , @Body Item user);
//    }


}
