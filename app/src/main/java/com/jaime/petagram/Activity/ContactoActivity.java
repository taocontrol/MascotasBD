package com.jaime.petagram.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jaime.petagram.R;

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
    private String remitente;
    private EditText destinatario;

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

        if (destinatario != null) {
            if (destinatario.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+") && destinatario.length() > 0) {
                enviar2(destinatario.getText().toString(), mensaje.getText().toString(), nombre.getText().toString());
                Toast.makeText(this, "El mensaje ha sido enviado...", Toast.LENGTH_SHORT).show();
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

    private void inicializarCampos() {
        nombre.setText(null);
        destinatario.setText(null);
        mensaje.setText(null);
        nombre.requestFocus();
    }

    private void enviar2(String destinatario, String mensaje, String nombre) {
        try {
            Properties properties2 = new Properties();
            properties2.put("mail.smtps.host", "mail.fundacionparaguaya.org.py");
            properties2.put("mail.smtps.port", 465);
            properties2.put("mail.smtps.mail.sender", "appfupa@fundacionparaguaya.org.py");
            properties2.put("mail.smtps.user", "appfupa@fundacionparaguaya.org.py");
            properties2.put("mail.smtps.password", "appfupa123");
            Session session2 = Session.getDefaultInstance(properties2);
            session2.setDebug(true);

            String sendto2 = destinatario.toString();

            MimeMessage message2 = new MimeMessage(session2);
            message2.setFrom(new InternetAddress((String) properties2.get("mail.smtps.mail.sender")));
            message2.addRecipient(Message.RecipientType.TO, new InternetAddress(sendto2));
            message2.setSubject("Correo");
            message2.setText(nombre.toString() + ", " + mensaje.toString());

            Transport t2 = session2.getTransport("smtps");
            t2.connect((String) properties2.get("mail.smtps.user"), (String) properties2.get("mail.smtps.password"));
            t2.sendMessage(message2, message2.getAllRecipients());
            t2.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
