package aula.android.exercicio3;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText nome;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn = (Button)findViewById(R.id.enviar);
		nome = (EditText) findViewById(R.id.nome);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mostraJanela();
			}
		});
	}
	
	public void mostraJanela(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Quanto falta para tirar a carteira");
		builder.setMessage(nome.toString());
	}
}
