package diana_tyemir.com.stod;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import diana_tyemir.com.stod.models.Enfermedad;
import diana_tyemir.com.stod.models.Sintoma;

public class Analysis extends Fragment {

	public Analysis() {

	}

	Button bnAgregar, bnEvaluar;
	ListView mItemSelected;
	TextView titulo, descripcion, gravedad, tvEmptyText;
	RelativeLayout resultLayout;
	LinearLayout findLayout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle("Analízate");
		View v =  inflater.inflate(R.layout.fragment_analysis, container, false);
		bnAgregar = (Button) v.findViewById(R.id.btnOrder);
		bnEvaluar = (Button) v.findViewById(R.id.btnEvaluar);

		titulo = (TextView) v.findViewById(R.id.tv_enfermedad);
		descripcion = (TextView) v.findViewById(R.id.tv_description);
		gravedad = (TextView) v.findViewById(R.id.tv_gravedad);

		tvEmptyText = (TextView) v.findViewById(R.id.tvEmptyText);

		findLayout = (LinearLayout) v.findViewById(R.id.sintoma_find);
		resultLayout = (RelativeLayout) v.findViewById(R.id.sintoma_result);

		mItemSelected = (ListView) v.findViewById(R.id.tvItemSelected);

		Api api = new Api();

		api.getSintomas(getContext(), new VolleyCallback_S(){

			boolean[] checkedItems;
			ArrayList<Integer> mUserItems = new ArrayList<>();
			ArrayList<Integer> sintomaIndex = new ArrayList<>();
			List<String> sintomasNombre = new ArrayList<>();

			ListView lista;
			ArrayAdapter<String> adaptador;

			@Override
			public void onSuccess(final ArrayList<Sintoma> result) {

				checkedItems = new boolean[result.size()];

				final String[] names = new String[result.size()];
				for(int i = 0 ; i < result.size(); i++){
					names[i] = result.get(i).getNombre();
				}

				bnAgregar.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
						mBuilder.setTitle("Selecciona tus sintomas");
						mBuilder.setCancelable(false);
						onViewUpdate();
						mBuilder.setMultiChoiceItems(names, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
								if (isChecked) {
									mUserItems.add(position);
									sintomaIndex.add(result.get(position).getId());
									sintomasNombre.add(result.get(position).getNombre());
								} else {
									mUserItems.remove((Integer.valueOf(position)));
									sintomaIndex.remove((Integer.valueOf(result.get(position).getId())));
									sintomasNombre.remove((String.valueOf(result.get(position).getNombre())));
								}
							}
						});

						mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							@SuppressLint("SetTextI18n")
							@Override
							public void onClick(DialogInterface dialogInterface, int which) {

								onViewUpdate();
								bnEvaluar.setVisibility(View.VISIBLE);
								mItemSelected.setVisibility(View.VISIBLE);
								bnAgregar.setText("Modificar Sintomas");
							}
						});

						mBuilder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								dialogInterface.dismiss();
							}
						});

						mBuilder.setNeutralButton("BORRAR", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int which) {

								bnAgregar.setText("Agregar Sintomas");
								removerTodo();
								onViewUpdate();
							}
						});

						AlertDialog mDialog = mBuilder.create();
						mDialog.show();
					}

					public void removerTodo() {
						for (int i = 0; i < checkedItems.length; i++) {
							checkedItems[i] = false;
							mUserItems.clear();
							sintomaIndex.clear();
							sintomasNombre.clear();
						}
					}

					public void onViewUpdate() {
						ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, sintomasNombre);

						// Assign adapter to ListView
						mItemSelected.setAdapter(adapter);

						if(sintomaIndex.size() > 0) {
							tvEmptyText.setVisibility(View.INVISIBLE);
							bnEvaluar.setVisibility(View.VISIBLE);
						}
						else {
							tvEmptyText.setVisibility(View.VISIBLE);
							bnEvaluar.setVisibility(View.INVISIBLE);
						}
					}
				});
				bnEvaluar.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						if (sintomaIndex.size() > 0) {

							String idx = "";
							for (int i = 0; i < sintomaIndex.size(); i++) {
								idx = idx + sintomaIndex.get(i).toString();
								if (i != sintomaIndex.size() - 1) {
									idx = idx + ",";
								}
							}

							new diana_tyemir.com.stod.Api().evaluarEnfermedad(idx, getContext(), new VolleyCallback_E() {
								@Override
								public void onSuccess(ArrayList<Enfermedad> enfermedadList) {
									findLayout.setVisibility(View.INVISIBLE);

									// 1. Mostrar resultado Principal
									if (enfermedadList.size() > 0) {

										System.out.println(enfermedadList.get(0).getNombre());

										String nivelEnfermedad = "Enfermedad de muy baja gravedad";
										String colorEnfermedad = "#46EA2F";
										if (enfermedadList.get(0).getGravedad() == 2) {
											nivelEnfermedad = "Enfermedad de gravedad leve";
											colorEnfermedad = "#AEEC2D";
										}
										else if (enfermedadList.get(0).getGravedad() == 3) {
											nivelEnfermedad = "Enfermedad de gravedad media";
											colorEnfermedad = "#ECE22D";
										}
										else if (enfermedadList.get(0).getGravedad() == 4) {
											nivelEnfermedad = "Enfermedad de gravedad alta";
											colorEnfermedad = "#ED8C2C";
										}
										else if (enfermedadList.get(0).getGravedad() == 5) {
											nivelEnfermedad = "Enfermedad de gravedad muy alta";
											colorEnfermedad = "#EE2B2B";
										}

										titulo.setText(enfermedadList.get(0).getNombre().toString());
										descripcion.setText(enfermedadList.get(0).getDescripcion().toString());
										gravedad.setText(nivelEnfermedad.toString());
										gravedad.setTextColor(Color.parseColor(colorEnfermedad.toString()));
									}
									resultLayout.setVisibility(View.VISIBLE);
								}
							});
						}
					}
				});
			}
		});
		return v;
	}
}
