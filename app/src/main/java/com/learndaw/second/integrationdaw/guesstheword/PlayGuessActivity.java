package com.learndaw.second.integrationdaw.guesstheword;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.learndaw.second.integrationdaw.R;

import static java.lang.Integer.valueOf;

public class PlayGuessActivity extends AppCompatActivity {
    TextView Points, Lifes, Score, Correct, Incorrect;
    ImageView image;
    EditText Question;
    Button Confirm;


    String[] nomPattern = {"abstract factory", "adapter", "builder", "command", "composite", "decorator", "factory", "fecade", "prototype", "proxy", "sigleton", "strategy"};
    String[] nomPattern2 = {"Abstract Factory", "Adapter", "Builder", "Command", "Composite", "Decorator", "Factory", "Fecade", "Prototype", "Proxy", "Sigleton", "Strategy"};
    String[] imgPattern = {"abstractfactory", "adapter", "builder", "command", "composite", "decorator", "factory", "fecade", "prototype", "proxy", "sigleton", "strategy"};
    String[] desPattern = {"Es una jerarquía que encapsula muchas familias posibles y la creación de un conjunto de productos. Tiene la responsabilidad de proporcionar servicios de creación para toda una familia de productos.," +
            "Convertir la interfaz de una clase en otra interfaz (target) que el cliente espera. Permitir a dos interfaces incompatibles trabajar en conjunto. Este patrón nos permite ver a nuevos y distintos elementos como si fueran igual a la interfaz conocida por nuestra aplicación.",
            "Nos permite crear un objeto que está compuesto por muchoso otros objetos.conoce a detalle las clases concretas de los objetos que serán creados.",
            "Este patrón desacopla al objeto que invoca la operación del objeto que sabe cómo llevar a cabo la misma. Un objeto llamado Invoker transfiere el comando a otro objeto llamado Receiver el cual ejecuta el código correcto para el comando recibido.",
            "Provee a los clientes un mismo trato para todos los objetos que forman la jerarquía, este contiene directorios con archivos y a su vez estos archivos pueden ser otros directorios que contenga más archivos, y así sucesivamente.",
            "Adjuta responsabilidades adicionales a un objeto de forma dinámica, proporcionan una alternativa flexible para ampliar la funcionalidad.",
            "Define una interface para crear un objeto, dejando a las subclases decidir de que tipo de clase se realizará la instancia. Reducir el uso del operador new.",
            "Este patrón no evita que los clientes usen las clases internas del subsistema, si es que es necesario.",
            "Especificar varios tipos de objetos que pueden ser creados en un prototipo para crear nuevos objetos copiando ese prototipo. Reduce la necesidad de crear subclases.",
            "Representa un objeto local que pertenece a un espacio de direcciones diferente, representa un objeto local que pertenece a un espacio de direcciones diferente.",
            "La aplicación necesita una, y sólo una, instancia de una clase, además está instancia requiere ser accesible desde cualquier punto de la aplicación.",
            "Define una familia de algoritmos, encapsular cada uno, y que sean intercambiables. Strategy permite al algoritmo variar independientemente de los clientes que lo utilizan."};

    int conPoints = 0;
    int conLifes = 5;
    int generateNum = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_guess);

        Points = (TextView) findViewById(R.id.tv_points);
        Lifes = (TextView) findViewById(R.id.tv_lifes);
        Correct = (TextView) findViewById(R.id.tv_correct);
        Incorrect = (TextView) findViewById(R.id.tv_incorrect);
        Score = (TextView) findViewById(R.id.tv_score_count);
        image = (ImageView) findViewById(R.id.iv_question);
        Question = (EditText) findViewById(R.id.tv_question);
        Confirm = (Button) findViewById(R.id.bt_confirm);

        selectImage(generateNum);


        //Confirmar la palabra
        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String answerConfirm = Question.getText().toString().toLowerCase();
                if (answerConfirm.equals(nomPattern[generateNum]) | answerConfirm.equals(nomPattern2[generateNum])) {

                    Correct.setVisibility(View.VISIBLE);
                    conPoints = conPoints + 1;
                    Points.setText(getString(R.string.score_game) + conPoints);

                    stayC();
                } else {
                    Incorrect.setVisibility(View.VISIBLE);
                    conLifes = conLifes - 1;
                    Lifes.setText(getString(R.string.lifes_game) + conLifes);
                    stayI();
                }
                if (conLifes == 0) {
                    finish();
                }
                if (conPoints == 10) {

                 AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PlayGuessActivity.this);
                    alertDialogBuilder
                            .setMessage(getString(R.string.finish_game) + conPoints)
                            .setCancelable(false)
                            .setPositiveButton(R.string.new_game, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(getApplicationContext(), PlayGuessActivity.class);
                                    startActivity(i);
                                    finish();

                                }
                            }).setNegativeButton(R.string.exit_game, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            finish();
                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }
        });

    }

    void stayI() {
        //Contador de cuenta regresiva
        new CountDownTimer(1000, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                Confirm.setVisibility(View.GONE);


            }

            @Override
            public void onFinish() {
                Confirm.setVisibility(View.VISIBLE);
                Incorrect.setVisibility(View.INVISIBLE);
                Question.setText("");
                Question.setHint(R.string.question_game);


            }
        }.start();
    }

    void stayC() {
        //Contador de cuenta regresiva
        new CountDownTimer(1000, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                Score.setText("" + millisUntilFinished / 1000 + 1);
                Confirm.setVisibility(View.GONE);

            }

            @Override
            public void onFinish() {
                Confirm.setVisibility(View.VISIBLE);
                generateNum = generateNum + 1;
                //Para mostrar una nueva imagen
                selectImage(generateNum);
                Score.setText("");
                Correct.setVisibility(View.INVISIBLE);
                Question.setText("");
                Question.setHint(R.string.question_game);



            }
        }.start();
    }


    void selectImage(int num) {
        int id = getResources().getIdentifier(imgPattern[num], "mipmap", getPackageName());
        //Cambiar imagen
        image.setImageResource(id);
    }
}