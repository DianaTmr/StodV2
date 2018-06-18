package diana_tyemir.com.stod;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Profile extends Fragment {
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle("Perfil");
		return inflater.inflate(R.layout.fragment_profile, null);
	}
}