package vn.edu.tdmu.luuphuchung_073_cau2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TacGiaAdapter extends ArrayAdapter<TacGia> {
    // man hinh su dung layout nay
    Activity context;
    // layout cho tung dong
    int resource;
    //dsach nguon dl muon hien thi len giao dien
    List<TacGia> objects;
    public TacGiaAdapter(@NonNull Activity context, int resource, @NonNull List<TacGia> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // LayoutInflater la 1 lop bluild file binh thuong thanh code java
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);

        TextView txtHoTen = row.findViewById(R.id.txtHoTen);
        TextView txtDienThoai = row.findViewById(R.id.txtDienThoai);
        TextView txtDiaChi = row.findViewById(R.id.txtDiaChi);



        // tra ve danh ba hien tai muon vẽ
        TacGia tacGia = this.objects.get(position);
        txtHoTen.setText(tacGia.getFullName());
        txtDienThoai.setText(tacGia.getTel());
        txtDiaChi.setText(tacGia.getAddress());





        return row;

    }




}


