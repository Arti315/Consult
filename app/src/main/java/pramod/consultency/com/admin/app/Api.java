package pramod.consultency.com.admin.app;
import pramod.consultency.com.admin.model.LoginResponse;

import pramod.consultency.com.admin.model.Result;
import pramod.consultency.com.admin.model.User;
import pramod.consultency.com.admin.model.UsersResponse;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {


    @FormUrlEncoded
    @POST("login")
    Call<Result> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );





      @FormUrlEncoded
    @POST("forgetpassword")
    Call<Result> resetpassword(
            @Field("restpassword") String reset

    );









    @FormUrlEncoded
    @POST("forgetpassword")
    Call<Result> document(
            @Field("company_name") String company_name,
            @Field("email") String email,
            @Field("comment") String comment




    );












    @GET("users")
    Call<User> getUsers();

  @FormUrlEncoded
    @POST("update/{id}")
    Call<Result> updateUser(
            @Path("id") int id,
            @Field("email") String email,

            @Field("mobile") String mobile
    );






   @FormUrlEncoded
    @POST("interview/{id}")
    Call<Result>   interviewSchedule  (
            @Path("id") int id,
            @Field("condidate") String condidate,
            @Field("email") String email,
            @Field("com_web") String com_web,
            @Field("job") String job,
            @Field("interviewDate") String interviewDate,
            @Field("address") String address,
            @Field("contract_name") String contract_name,
            @Field("contract_mobile") String contract_mobile,
            @Field("comment") String comment



    );














   @FormUrlEncoded
    @POST("updatepassword/{id}")
    Call<Result> updatePassword(
           @Path("id") int id,
            @Field("currentpassword") String currentpassword,
            @Field("newpassword") String newpassword

    );




  /*  @DELETE("deleteuser/{id}")
    Call<DefaultResponse> deleteUser(@Path("id") int id);*/



    @FormUrlEncoded
    @POST("report")
    Call<Result> report(
            @Field("company_name") String company_name,
            @Field("email") String email,
            @Field("comment") String comment




    );


}