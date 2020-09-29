package com.example.chorsiphai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chorsiphai.pojo.User;
import com.example.chorsiphai.pojo.UserResource;
import com.example.chorsiphai.rest.APIClient;
import com.example.chorsiphai.rest.APIError;
import com.example.chorsiphai.rest.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APIInterface apiInterface;
    APIError apiError;
    String MY_PREFS_NAME = "SharedFile";
    public void saveName(View view)
    {
        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        /**
         Create new user
         **/
        User user = new User(editTextName.getText().toString());
        Call<User> call1 = apiInterface.createUser(user);

        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                User userResource = response.body();

                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString("name", userResource.name);
                editor.putLong("uid", userResource.uid);
                editor.apply();

                Toast.makeText(getApplicationContext(),userResource.uid + " " +userResource.name, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
            }
        });
    }

    /*
    public void getData(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        long uid = Long.parseLong(editText.getText().toString());;

        Call<UserResource> call = apiInterface.doGetUserResources(uid);

        call.enqueue(new Callback<UserResource>() {
            @Override
            public void onResponse(Call<UserResource> call, Response<UserResource> response) {


                if (response.isSuccessful()) {
                    Log.d("TAG", response.code() + "");

                    String displayResponse = "";

                    UserResource resource = response.body();

                    long uid = resource.uid;
                    String name = resource.name;

                    Toast.makeText(getApplicationContext(), uid + " " + name, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    apiError = ErrorUtils.parseError(response);
                    Toast.makeText(getApplicationContext(), apiError.getError(),
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserResource> call, Throwable t) {
                apiError = new APIError.Builder().defaultError().build();
                Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();
                //call.cancel();
            }
        });
    }

    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        long uid = prefs.getLong("uid", -1);
        if(uid == -1)
        {
            //Now we need to get username from user
        }
        else
        {
            //User is already here
            String name = prefs.getString("name","Empty Here");
            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);

        }


    }
}