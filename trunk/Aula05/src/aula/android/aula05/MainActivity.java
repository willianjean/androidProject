package aula.android.aula05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity {
		
	public final static String EDTNOMEMAIN = "aula.android.aula05.MAINACTIVITY";
	
	TextView nome;
	
	private String[] bairros={
			"Centro", "Pra�a 14", "Aparecida", "Cachoeirinha",
			"Educandos", "Parque 10", "Vila Municipal",
			"Reden��o", "Alvorada", "Compensa"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//EditText edtNome = (EditText)findViewById(R.id.edtNome);
	
		//texto = edtNome.getText().toString();
	
		Button btn=(Button)findViewById(R.id.btnCadastro);
		EditText edtNome = (EditText)findViewById(R.id.edtNome);
//		EditText edtRegiao = (EditText) findViewById(R.id.edtRegiao);
		
		registerForContextMenu(edtNome);
//		registerForContextMenu(edtRegiao);
		
		nome = edtNome;

		btn.setOnClickListener(new View.OnClickListener(){

			public void onClick(View v){
				//getText();
				mostrarMensagem();
			}
		}
	);
		
		//Spinner       outro layout para o spinner --> simple_spinner_item
		Spinner spReg=(Spinner)findViewById(R.id.spRegiao);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, bairros);
		spReg.setAdapter(adapter);
		
		//ImageView
		final ImageView imgBairro = (ImageView)findViewById(R.id.imgBairro);
		
		//Spinner
		spReg.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
//				usarToast("O indice selecionado foi "+position+
//						" o conteudo � "+bairros[position]+" ID: "+id);
				if(position==0)
					imgBairro.setImageResource(R.drawable.centro);
				else if(position==1)
					imgBairro.setImageResource(R.drawable.praca14);
				else if(position==2)
					imgBairro.setImageResource(R.drawable.aparecida);
				else
					imgBairro.setImageResource(R.drawable.cachoeirinha);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		//imageView
		
		
		
		
/*		edtRegiao.setOnKeyListener(new View.OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub

				if(event.getAction()==KeyEvent.ACTION_DOWN){
					if(keyCode==KeyEvent.KEYCODE_A){
						usarToast("Voce pressionou a tecla A");
					}
				}
				
//				if(keyCode == KeyEvent.KEYCODE_A){
//					usarToast("Voce pressionou a tecla A");
//				}
				
//				usarToast("KeyCode= "+keyCode);
				return false;
			}
		}); */
		
//		edtNome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//			
//			@Override
//			public void onFocusChange(View v, boolean hasFocus) {
//				// TODO Auto-generated method stub
//				if(hasFocus){
//					usarToast("Nome ganhou foco");
//				}else{
//					usarToast("Nome perdeu foco");
//				}
//			}
//		});
		
//		edtRegiao.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//			
//			@Override
//			public void onFocusChange(View v, boolean hasFocus) {
//				// TODO Auto-generated method stub
//				if(hasFocus){
//					usarToast("Regiao ganhou foco");
//				}else{
//					usarToast("Regiao perdeu foco");
//				}
//			}
//		});
		
		
//		edtRegiao.setOnClickListener(new View.OnClickListener(){
//			
//			public void onClick(View v){
//				usarToast("Clique");
//			}
//		});
		
//		edtRegiao.setOnLongClickListener(new View.OnLongClickListener(){
//			
//			public boolean onLongClick(View v){
//				usarToast("Long Clique");
//				return false;
//			}
//		});
		
		
//		LinearLayout llPrincipal = (LinearLayout) findViewById(R.id.llPrincipal);
//		llPrincipal.setOnTouchListener(new View.OnTouchListener() {
//			
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				usarToast("Cliquei em um dos componentes!!!!!");
//				return true;
//			}
//		});


	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.itemCadastro:
			usarToast("Selecionou Cadastro");
			return true;
		case R.id.item2:
			usarToast("Selecionou Graficos");
			return true;
		case R.id.itemnegrito:
			item.setChecked(!item.isChecked());
			return true;
		case R.id.itemarial://verificar esse case se nao esta faltando alguma coisa -------------------------------------------------
			return true;
		case R.id.itemcourier:
			//verificaRadio(item);
			return true;
		default:
		return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
									ContextMenuInfo menuInfo){
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.context_menu, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()){
		case R.id.ajuda:
			Toast.makeText(this, "Ajuda", 1000).show();
			return true;
		case R.id.historico:
			Toast.makeText(this, "Hist�rico", 1000).show();
			return true;
		default:
			return super.onContextItemSelected(item);
		}
		
		
	}

	public void mostrarMensagem(){
				
		Intent intent = new Intent(this,MensagemActivity.class);
		intent.putExtra(EDTNOMEMAIN, nome.getText().toString());

		startActivity(intent);
		

	}
	
	public void usarToast (String text){
		Toast.makeText(this, text, 1000).show();
	}
	
	//public void getText(){
	//	texto = edtNome.getText().toString();
	//}
}
