package com.example.chorsiphai.rest;

import org.json.JSONObject;

import retrofit2.Response;

public class ErrorUtils {

    public static APIError parseError(final Response<?> response) {
        JSONObject bodyObj = null;

        String error;

        try {
            String errorBody = response.errorBody().string();

            if (errorBody != null) {
                bodyObj = new JSONObject(errorBody);

                error = bodyObj.getString("error");

            } else {

                error = "Unable to parse error";
            }
        } catch (Exception e) {
            e.printStackTrace();

            error = "Unable to parse error";
        }

        return new APIError.Builder()
                .error(error)
                .build();
    }

}
