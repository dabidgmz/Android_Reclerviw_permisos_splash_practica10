package com.example.practica10.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.practica10.R;
import com.example.practica10.model.Permiso;
import java.util.List;
public class permisoAdapter extends RecyclerView.Adapter<permisoAdapter.ViewHolder> {
    List<Permiso> Lista_permisos;

    public permisoAdapter(List<Permiso> lista_permisos) {
        Lista_permisos = lista_permisos;
    }

    public interface PermissionRequester {
        void requestPermission(String permission);
    }

    @NonNull
    @Override
    public permisoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ly= LayoutInflater.from(parent.getContext());
        View v= ly.inflate(R.layout.itempermiso, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull permisoAdapter.ViewHolder holder, int position) {
        Permiso p= Lista_permisos.get(position);
        holder.setData(p);

        holder.swPermiso.setOnCheckedChangeListener((buttonView, isChecked) -> {
            p.setEstado(isChecked);
            if (isChecked) {
                if (holder.itemView.getContext() instanceof PermissionRequester) {
                    ((PermissionRequester) holder.itemView.getContext()).requestPermission(p.getPermisos());
                }
            } else {
                p.setEstado(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Lista_permisos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtPermiso;
        TextView txtDesc;
        Switch swPermiso;
        Permiso pe;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPermiso= itemView.findViewById(R.id.txtPermiso);
            txtDesc= itemView.findViewById(R.id.txtDesc);
            swPermiso= itemView.findViewById(R.id.switch1);
        }

        public void setData(Permiso p) {
            pe=p;
            txtPermiso.setText(p.getPermiso());
            txtDesc.setText(p.getDescripcion());
            swPermiso.setChecked(p.isEstado());
        }
    }
}
