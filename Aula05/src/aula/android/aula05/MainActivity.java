package aula.android.aula05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends Activity {
		
	public final static String EDTNOMEMAIN = "aula.android.aula05.MAINACTIVITY";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//EditText edtNome = (EditText)findViewById(R.id.edtNome);
	
		//texto = edtNome.getText().toString();
	
		Button btn=(Button)findViewById(R.id.btnCadastro);

		btn.setOnClickListener(new View.OnClickListener(){

			public void onClick(View v){
				//getText();
				mostrarMensagem();
			}
		}


				);


	}

	public void mostrarMensagem(){
		
		EditText edtNome = (EditText)findViewById(R.id.edtNome);
		
		Intent intent = new Intent(this,MensagemActivity.class);
		intent.putExtra(EDTNOMEMAIN, edtNome.getText().toString());

		startActivity(intent);
		

	}
	
	//public void getText(){
	//	texto = edtNome.getText().toString();
	//}
}
