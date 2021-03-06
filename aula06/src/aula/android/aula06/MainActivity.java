package aula.android.aula06;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	String nomes[]={"Anisio", "Angelo", "Andrea",
			"Andre", "Antonio", "Anglo", "Anderson", "Willian", "Designer"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//autoComplete
		ArrayAdapter<String> adapter=
				new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line,nomes);
		AutoCompleteTextView autoTextView =
				(AutoCompleteTextView)findViewById(R.id.autoComplete);
		autoTextView.setThreshold(3);
		autoTextView.setAdapter(adapter);
		
		//CaixaDialogoSimples
		AlertDialog.Builder bld = new AlertDialog.Builder(this);
		bld.setMessage("Mensagem de Text");
		bld.setTitle("Titulo de Teste");
		bld.setIcon(android.R.drawable.ic_dialog_alert);
		final AlertDialog alerta = bld.create();
		
		Button btnSimples=(Button)findViewById(R.id.btnSimples);
		btnSimples.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				alerta.show();
			}
		});
		
		Button btnOpcoes=(Button)findViewById(R.id.btnOpcoes);
		btnOpcoes.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mostraDialogoOpcoes();
			}
		});
	}
	
	public void mostraDialogoOpcoes(){
		AlertDialog.Builder buildOpc = new AlertDialog.Builder(this);
		buildOpc.setMessage("Escolha uma op��o");
		buildOpc.setTitle("Teste Dialogo com");//-----------------------------------------------------------------------
	}
	
	public void confirmaHora(View v){
		TimePicker tmPick = (TimePicker)findViewById(R.id.timePicker);
		int hora, minuto;
		hora=tmPick.getCurrentHour();
		minuto=tmPick.getCurrentMinute();
		Toast.makeText(this, "Hora informada " + hora+ ":"+ minuto, Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	
}
