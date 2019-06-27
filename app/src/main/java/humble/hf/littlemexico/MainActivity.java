package humble.hf.littlemexico;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int i;

    // Sound Constants
    private final int NR_OF_SIMULTANEOUS_SOUNDS = 1;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int NO_LOOP = 0;
    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    // Member Variables
    private SoundPool mSoundPool;
    private int mDiceSoundID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creates soundpool on start
        mSoundPool = new SoundPool(NR_OF_SIMULTANEOUS_SOUNDS, AudioManager.STREAM_MUSIC, 0);

        //Load ID and res for sounds
        mDiceSoundID = mSoundPool.load(getApplicationContext(), R.raw.dicesound, 1);

        //setting up buttons
        Button rollButton = findViewById(R.id.rollButton);
        Button lifeButton = findViewById(R.id.lifeButton);

        // linking image java to xml
        final ImageView leftDice = findViewById(R.id.image_leftDice);
        final ImageView rightDice = findViewById(R.id.image_rightDice);
        final ImageView lifeDice = findViewById(R.id.image_lifeDice);

        //array with dice images used in app
        final int[] diceArray = {R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };
        final int[] lifeArray = {R.drawable.dice6,
                R.drawable.dice5,
                R.drawable.dice4,
                R.drawable.dice3,
                R.drawable.dice2,
                R.drawable.dice1
        };
        rollButton.setSoundEffectsEnabled(false);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Sound", "sound play");
                mSoundPool.play(mDiceSoundID, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                Log.d("Little Mexico", "Ze button is good");
                Random randomNumberGenrator = new Random();
                int number = randomNumberGenrator.nextInt(6);
                Log.d("Little Mexico", "Number is: " + number);
                leftDice.setImageResource(diceArray[number]);
                number = randomNumberGenrator.nextInt(6);
                rightDice.setImageResource(diceArray[number]);
                Log.d("Little Mexico", "App has ran " + number);
            }

        });

        lifeButton.setSoundEffectsEnabled(false);
        lifeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomNumberGenrator = new Random();
                int number = randomNumberGenrator.nextInt(6);
                Log.d("Little Mexico", "Number is: " + number);
                lifeDice.setImageResource(lifeArray[i]);
                Log.d("Little Mexico", "Test for my counter");
                i++;

                if (i == 6) {
                    i = 0;
                }


            }

        });
    }

}
