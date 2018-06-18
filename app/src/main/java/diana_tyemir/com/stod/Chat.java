package diana_tyemir.com.stod;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chat extends Fragment {
	public Chat(){};

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle("Salas de Chat");
		View v =  inflater.inflate(R.layout.fragment_chat, container, false);

		// Referencia los objetos del XML
		final ListView lvChat = (ListView) v.findViewById(R.id.lvChat);

		// Inicializa un nuevo Array de String
		String[] disease = new String[] {
				"Cáncer infantil",
				"HBP",
				"Anorexia",
				"Diabetes",
				"Hepatitis"
		};
		// Crea la lista desde el array de strings
		final List<String> disease_list = new ArrayList<String>(Arrays.asList(disease));

		// Crea un ArrayAdapter de la lista
		final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
				(getActivity(), android.R.layout.simple_list_item_1, disease_list){
			@Override
			public View getView(int position, View convertView, ViewGroup parent){
				// Obtiene el item de la lista
				View view = super.getView(position,convertView,parent);
				if(position %2 == 1)
				{
					// Setea el fondo con el color regular
					view.setBackgroundColor(Color.parseColor("#BBDBA7"));

				}
				else
				{
					//  Setea el fondo con el color alternativo
					view.setBackgroundColor(Color.parseColor("#F5F0D1"));
				}
				return view;
			}
		};
		lvChat.setAdapter(arrayAdapter);
		return v;
	}
}