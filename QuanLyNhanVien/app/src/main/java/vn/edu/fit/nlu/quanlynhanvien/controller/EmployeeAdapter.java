package vn.edu.fit.nlu.quanlynhanvien.controller;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.List;

import vn.edu.fit.nlu.quanlynhanvien.R;
import vn.edu.fit.nlu.quanlynhanvien.model.Employee;

public class EmployeeAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Employee> listEmployee;

    public EmployeeAdapter(Context context, int layout, List<Employee> listEmployee) {
        this.context = context;
        this.layout = layout;
        this.listEmployee = listEmployee;
    }

    @Override
    public int getCount() {
        return listEmployee.size(); //goi tat ca cac employee co trong list
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//tra ve moi dong tren mot item trong view
        ViewHolder holder;
        if(convertView == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //construc view holder
            holder = new ViewHolder();
            //convertView chua noi hien thi
            convertView = inflater.inflate(layout, null);

            //anh xa viw
            holder.txtEmployeeInfor= convertView.findViewById(R.id.textView_EmployeeInfor);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag(); //lay lai holder
        }
        //gan gia tri
        Employee e = listEmployee.get(position);
        holder.txtEmployeeInfor.setText(e.toString());

        return convertView;
    }
    class ViewHolder{
        TextView txtEmployeeInfor;
    }
}
