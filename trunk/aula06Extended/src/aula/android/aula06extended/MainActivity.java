package aula.android.aula06extended;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	String paises[]={"Brasil", "Angola", "Argentina", "Espanha", "França"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,paises));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Você selecionou o pais:"+paises[position], Toast.LENGTH_SHORT).show();
		//super.onListItemClick(l, v, position, id);
	}
}
