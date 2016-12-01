package com.jaime.petagram.Activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jaime.petagram.R;
import com.jaime.petagram.utilities.SendMail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactoActivity extends AppCompatActivity {

    private EditText mensaje;
    private EditText nombre;
    private EditText destinatario;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        //ocular el boton de favoritos del actionbar
        ImageView fav = (ImageView) findViewById(R.id.imgFav);
        fav.setVisibility(View.INVISIBLE);

        Toolbar miactionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miactionBar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void enviarComentario(View v) {
        destinatario = (EditText) findViewById(R.id.campo_correo);
        mensaje = (EditText) findViewById(R.id.campo_descripcion);
        nombre = (EditText) findViewById(R.id.campo_nombre);
        view = v;


        if (destinatario != null) {
            if (destinatario.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+.*+") && destinatario.length() > 0) {
                sendEmail(destinatario.getText().toString(), mensaje.getText().toString(), nombre.getText().toString());

                inicializarCampos();
            } else {
                Toast.makeText(this, "El correo no es válido...", Toast.LENGTH_SHORT).show();
                destinatario.requestFocus();
            }
        } else {
            Toast.makeText(this, "Debe ingresar el correo...", Toast.LENGTH_SHORT).show();
            destinatario.requestFocus();
        }
    }


    private void sendEmail(String destinatario, String mensaje, String nombre) {
        //Creating SendMail object
        SendMail sm = new SendMail(this, destinatario, "Comentario App Petagram", mensaje+"\n \n"+nombre, view);
        //Executing sendmail to send email
        sm.execute();
    }

    private void inicializarCampos() {
        nombre.setText(null);
        destinatario.setText(null);
        mensaje.setText(null);
        nombre.requestFocus();
    }



}
