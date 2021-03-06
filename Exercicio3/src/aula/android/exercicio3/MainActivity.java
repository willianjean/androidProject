package aula.android.exercicio3;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	private static final int DATE_DIALOG_ID = 0;
	private int ano, mes, dia;
	private EditText nome;
	private Button btnDataNas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Calendar
		Calendar calendar = Calendar.getInstance();
		ano = calendar.get(Calendar.YEAR);
		mes = calendar.get(Calendar.MONTH);
		dia = calendar.get(Calendar.DAY_OF_MONTH);
		
		btnDataNas = (Button)findViewById(R.id.data);
		btnDataNas.setText(dia + "/" + (mes+1) + "/" + ano);
		
		nome = (EditText)findViewById(R.id.nome);
		
		//bot�o para setar a data de nascimento
		btnDataNas.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG_ID);
			}
		});
		
		//botao da habilita��o
		Button btnHabilitacao = (Button)findViewById(R.id.enviarHabilitacao);
		
		btnHabilitacao.setOnClickListener(this);
		//A chamada abaixo foi substituido pela linha acima e tem o mesmo efeito
		
		//botao de Tirar Habilita��o
//		btnHabilitacao.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				if(nome.length()==0){
//					Toast.makeText(MainActivity.this, "Por favor informe seu nome", Toast.LENGTH_SHORT).show();
//					return;}
//				else mostraJanelaHabilitacao();
//			}
//		});
		
		//botao de habilita��o
		Button btnAposentadoria = (Button)findViewById(R.id.enviarAposentadoria);
		
		btnAposentadoria.setOnClickListener(this);
		//A chamada abaixo foi substituido pela linha acima e tem o mesmo efeito
		
		//botao de Aposentar
//		btnAposentadoria.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				if(nome.length()==0){
//					Toast.makeText(MainActivity.this, "Por favor informe seu nome", Toast.LENGTH_SHORT).show();
//					return;}
//				else mostraJanelaAposentadoria();
//			}
//			
//		});
		
	}
	
	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		switch (id){
		case DATE_DIALOG_ID:
			DatePickerDialog dp = new DatePickerDialog(this, listener, ano, mes, dia);
			return dp;
		}		
		return null;
	}
	
	//classe anonima para passar como parametro em Dialog onCreateDialog
	private OnDateSetListener listener = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			ano = year;
			mes = monthOfYear;
			dia = dayOfMonth;
			
			btnDataNas.setText(dia + "/" + mes + "/" + ano);
		}
	};
	
	public void mostraJanelaHabilitacao(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Quanto falta para tirar a carteira de habilita��o?");
		Calendar calendar = Calendar.getInstance();
		if((calendar.get(Calendar.YEAR)-ano)>=18)
			builder.setMessage("Voc� ja pode tirar sua habilita��o");
		else builder.setMessage(nome.getText()+", falta(m) "+String.valueOf((18-(calendar.get(Calendar.YEAR)-ano)))+" ano(s)");
		AlertDialog alerta = builder.create();		
		alerta.show();
	}
	
	public void mostraJanelaAposentadoria(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Quanto falta para se aposentar?");
		Calendar calendar = Calendar.getInstance();
		if((calendar.get(Calendar.YEAR)-ano)>=65)
			builder.setMessage("Voc� ja pode se aposentar");
		else builder.setMessage(nome.getText()+", falta(m) "+String.valueOf((65-(calendar.get(Calendar.YEAR)-ano)))+" ano(s)");
		AlertDialog alerta = builder.create();		
		alerta.show();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.enviarHabilitacao:
			if(nome.length()==0){
				Toast.makeText(this, "Por favor informe seu nome", Toast.LENGTH_SHORT).show();
				break;}
			else {mostraJanelaHabilitacao();
			break;}
		case R.id.enviarAposentadoria:
			if(nome.length()==0){
				Toast.makeText(this, "Por favor informe seu nome", Toast.LENGTH_SHORT).show();
				break;}
			else {mostraJanelaAposentadoria();
			break;}
		}
			
	}
}
