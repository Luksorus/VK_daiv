package com.example.vk_it_case.Activity;




import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.graphics.RenderEffect;
import android.graphics.Shader;

import android.os.Build;
import android.os.Bundle;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vk_it_case.R;
import com.example.vk_it_case.constant.constants;

public class MainActivity extends AppCompatActivity {
    private ImageButton button;
    private ImageView imageView;
    private ImageButton imageButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView ss_user1 = (ImageView) findViewById(R.id.user1_image);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView ss_user2 = (ImageView) findViewById(R.id.user2_image);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton button_end = (ImageButton) findViewById(R.id.imageButton_end);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton button_hand = (ImageButton) findViewById(R.id.imageButton_hand);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton button_mic = (ImageButton) findViewById(R.id.imageButton_microphone);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton button_videocam = (ImageButton) findViewById(R.id.imageButton_videocam);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton button_chat = (ImageButton) findViewById(R.id.imageButton_chat);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton button_users = (ImageButton) findViewById(R.id.imageButton_users);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton button_revers = (ImageButton) findViewById(R.id.imageButton_revers);
        ImageView image_user1 = (ImageView) findViewById(R.id.imageView_us1);
        ImageView image_user2 = (ImageView) findViewById(R.id.imageView_us2);
        TextView user1_name = (TextView) findViewById(R.id.user1_name);
        TextView user2_name = (TextView) findViewById(R.id.user2_name);

        blur();
        button_mic.setOnClickListener(v->{
            if (constants.mic ==0) {
                constants.mic++;
                button_mic.setBackgroundResource(R.drawable.crug_grey);
                button_mic.setImageResource(R.drawable.microphone_alt_28);
            } else {
                constants.mic--;
                button_mic.setBackgroundResource(R.drawable.crug_white);
                button_mic.setImageResource(R.drawable.microphone_slash_28);
            }
        });

        button_hand.setOnClickListener(v->{
            Dialog();
        });


        button_chat.setOnClickListener(v->{
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });

        button_end.setOnClickListener(v-> {
            finish();
        });


        button_revers.setOnClickListener(v -> {
            if (constants.revers == 0) {
                constants.revers++;
                ss_user1.setImageResource(R.drawable.alex_curry);
                image_user1.setImageResource(R.drawable.alex_curry);
                ss_user2.setImageResource(R.drawable.kate_swanson);
                image_user2.setImageResource(R.drawable.kate_swanson);
                user1_name.setText(R.string.name_user2);
                user2_name.setText(R.string.name_user1);
            } else {
                constants.revers--;
                ss_user1.setImageResource(R.drawable.kate_swanson);
                image_user1.setImageResource(R.drawable.kate_swanson);
                ss_user2.setImageResource(R.drawable.alex_curry);
                image_user2.setImageResource(R.drawable.alex_curry);
                user1_name.setText(R.string.name_user1);
                user2_name.setText(R.string.name_user2);
            }

        });


        button_users.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, recycler.class);
            startActivity(intent);

        });


        button_videocam.setOnClickListener(v -> {


            if (constants.c==0) {
                constants.c++;
                button_videocam.setBackgroundResource(R.drawable.crug_grey);
                button_videocam.setImageResource(R.drawable.videocam_24);

            } else {
                constants.c--;
                button_videocam.setBackgroundResource(R.drawable.crug_white);
                button_videocam.setImageResource(R.drawable.videocam_slash_24);
            }
        });

    }

    private void blur() {
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView ss_user1 = (ImageView) findViewById(R.id.user1_image);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView ss_user2 = (ImageView) findViewById(R.id.user2_image);
        ss_user1.setImageResource(R.drawable.kate_swanson);
        ss_user2.setImageResource(R.drawable.alex_curry);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ss_user1.setRenderEffect(RenderEffect.createBlurEffect(200, 200, Shader.TileMode.MIRROR));
            ss_user2.setRenderEffect(RenderEffect.createBlurEffect(200, 200, Shader.TileMode.MIRROR));
        }
    }
    private void Dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.text_title);
        builder.setMessage(R.string.text_message);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}


