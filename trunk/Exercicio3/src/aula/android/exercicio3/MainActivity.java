package aula.android.exercicio3;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private static final int DATE_DIALOG_ID = 0;
	private int ano, mes, dia;
	private EditText nome;
	private Button dataNas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Calendar
		Calendar calendar = Calendar.getInstance();
		ano = calendar.get(Calendar.YEAR);
		mes = calendar.get(Calendar.MONTH);
		dia = calendar.get(Calendar.DAY_OF_MONTH);
		
		dataNas = (Button)findViewById(R.id.data);
		
		dataNas.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG_ID);
			}
		});
		
		
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
	
	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		switch (id){
		case DATE_DIALOG_ID:
			DatePickerDialog dp = new DatePickerDialog(this, listener, ano, mes, dia);
		
		}		
		return null;
	}
	
	private OnDateSetListener listener = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			ano = year;
			mes = monthOfYear;
			dia = dayOfMonth;
			
			dataNas.setText(dia + "/" + mes + "/" + ano);
		}
	};
	
	public void mostraJanela(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Quanto falta para tirar a carteira");
		builder.setMessage(nome.getText().toString());
		AlertDialog alerta = builder.create();
		
		//time
		
		alerta.show();
	}
}
