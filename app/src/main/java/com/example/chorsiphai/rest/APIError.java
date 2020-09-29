package com.example.chorsiphai.rest;

public class APIError {

    private String timestamp;
    private int status;
    private String error;
    private String path;

    public String getError() {
        return error;
    }

    public static class Builder {
        private String error;

        public Builder() {}

        public Builder error(final String error) {
            this.error = error;
            return this;
        }

        public Builder defaultError() {
            this.error = "Something wrong happened";
            return this;
        }

        public APIError build() { return new APIError(this); }
    }

    private APIError(final Builder builder) {
        error = builder.error;
    }
}
