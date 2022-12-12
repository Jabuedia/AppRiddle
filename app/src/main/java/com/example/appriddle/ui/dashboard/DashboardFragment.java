package com.example.appriddle.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appriddle.DataInfo;
import com.example.appriddle.MainActivity;
import com.example.appriddle.R;
import com.example.appriddle.adapters.AdarterUsuario;
import com.example.appriddle.databinding.FragmentDashboardBinding;
import com.example.appriddle.entity.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private FirebaseFirestore db;
    private CollectionReference usuariosRef;
    private ListView lista;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        db = FirebaseFirestore.getInstance();
         usuariosRef= db.collection(DataInfo.USUARIO_REF);
        lista = root.findViewById(R.id.lista);


        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        cargarDatos();
    }

    private void cargarDatos(){
        usuariosRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>(){
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task){
                        if (task.isSuccessful()){
                            ArrayList<Usuario> usuarios = new ArrayList<>();
                            for(QueryDocumentSnapshot doc:task.getResult()){
                                Usuario usuarioo = doc.toObject(Usuario.class);

                                usuarios.add(usuarioo);
                            }
                            mostrarDatos(usuarios);
                        }else{
                            Log.d(DataInfo.TAG, "Error al traer la data");
                        }
                    }
                });

    }
    private void mostrarDatos(ArrayList<Usuario> usuario){
        AdarterUsuario adarterUsuario = new AdarterUsuario(getActivity().getApplicationContext(), usuario);
        lista.setAdapter(adarterUsuario);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}