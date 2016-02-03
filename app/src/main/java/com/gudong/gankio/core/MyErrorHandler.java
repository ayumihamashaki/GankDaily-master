package com.gudong.gankio.core;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by rmtic on 2016/1/21.
 */
class MyErrorHandler implements ErrorHandler{

    @Override
    public Throwable handleError(RetrofitError cause) {
        return cause;
    }


}
