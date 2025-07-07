package com.RestfulApi.TeacherInformationSystem.util;

import com.RestfulApi.TeacherInformationSystem.response.CustomResponse;

// Utility class for building consistent API responses
public class ApiResponseUtil {
    private ApiResponseUtil() {}

    // Example static method for success response
    public static <T> CustomResponse<T> success(T data) {
        CustomResponse<T> response = new CustomResponse<>();
        response.setData(data);
        response.setStatusCode(200);
        response.setStatusMessage("SUCCESS");
        response.setTimestamp(java.time.Instant.now().toString());
        return response;
    }

    // Example static method for error response
    public static <T> CustomResponse<T> error(String message, int statusCode) {
        CustomResponse<T> response = new CustomResponse<>();
        response.setData(null);
        response.setStatusCode(statusCode);
        response.setStatusMessage(message);
        response.setTimestamp(java.time.Instant.now().toString());
        return response;
    }
}
