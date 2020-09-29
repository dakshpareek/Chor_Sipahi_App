package com.example.chorsiphai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chorsiphai.pojo.Game;
import com.example.chorsiphai.pojo.User;
import com.example.chorsiphai.rest.APIClient;
import com.example.chorsiphai.rest.APIError;
import com.example.chorsiphai.rest.APIInterface;
import com.example.chorsiphai.rest.ErrorUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    String MY_PREFS_NAME = "SharedFile";
    APIInterface apiInterface;
    APIError apiError;
    long uid;
    String name;

    public void createGame(View view)
    {
        EditText turnsEditText = findViewById(R.id.turnsEditText);
        Integer turns = Integer.valueOf(turnsEditText.getText().toString());

        Game game = new Game();
        User user = new User();
        user.uid = uid;

        game.setPlayer1(user);
        game.setTurnsRemaining(turns);

        System.out.println(game.toString());

        Call<Game> call = apiInterface.createGame(game);

        call.enqueue(new Callback<Game>() {
            @Override
            public void onResponse(Call<Game> call, Response<Game> response) {

                if (response.isSuccessful()) {

                    Game gameResource = response.body();

                    Toast.makeText(getApplicationContext(), gameResource.toString(), Toast.LENGTH_SHORT).show();
                    Log.d("Process",gameResource.toString());

                    Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                    intent.putExtra("gameObject", gameResource);
                    startActivity(intent);

                }
                else
                {
                    apiError = ErrorUtils.parseError(response);
                    Toast.makeText(getApplicationContext(), apiError.getError(),
                            Toast.LENGTH_LONG).show();

                    //Move user to main screen to get username
                    if(apiError.getError().matches("User Not Found"))
                    {
                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putLong("uid", -1);
                        editor.apply();

                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<Game> call, Throwable t) {

                apiError = new APIError.Builder().defaultError().build();
                System.out.println(t.toString());
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                call.cancel();

            }
        });
    }


    public void viewAllGames(View view)
    {
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        name = prefs.getString("name","Empty Here");
        uid = prefs.getLong("uid",-1);

        TextView textView = findViewById(R.id.textViewWelcome);
        textView.setText("Welcome "+name);

        apiInterface = APIClient.getClient().create(APIInterface.class);

    }
}