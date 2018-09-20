package dialog.iso.com.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btnBasico).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoBasico();
            }
        });

        findViewById(R.id.btnPersonalizado).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mostrarDialogoPersonalizado();
            }
        });

    }

    private void mostrarDialogoBasico(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.DialogBasicCustomStyle);
        builder.setTitle("Titulo");
        builder.setMessage("¿Quieres eliminar todos los datos?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Eliminamos datos...",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Cancel...",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setCancelable(false)
                .show();
    }


    //TODO set btn Cancel onClickListener
    private void mostrarDialogoPersonalizado(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_personalizado,null);

        builder.setView(view);

        //TODO BOTONES POR DEFECTO
        /**
        builder.setView(inflater.inflate(R.layout.dialog_personalizado,null))
                .setPositiveButton("Reintentar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Conectando...",Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT).show();
            }
        });

        */

        final AlertDialog dialog = builder.create();
        dialog.show();

        TextView txt = view.findViewById(R.id.text_dialog);
        txt.setText("Fallo de conexión...");

        Button btnReintentar = view.findViewById(R.id.btnReintentar);
        btnReintentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Conectando...",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


    }
























}
