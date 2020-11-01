package vn.edu.fit.nlu.learnsqlite;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {
    Button btnCreateDB, btnDeleteDB, btnCreateTB, btnDeleteTB, btnInsertRowTB, btnDeleteRowTB, btnUpdateRowTB, btnQueryData, btnInsertSt, btnQuerySt;
    EditText edtTypeTB, edtTypeMaLop;
    Dialog dialog;
    SQLiteDatabase db;
    EditText edtDBName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateDB = findViewById(R.id.btn_CreateDB);
        btnDeleteDB = findViewById(R.id.btn_DeleteDB);
        btnCreateTB = findViewById(R.id.btn_CreateTB);
        btnDeleteTB = findViewById(R.id.btn_DeleteTB);
        btnInsertRowTB = findViewById(R.id.btn_InsertRowTB);
        btnDeleteRowTB = findViewById(R.id.btn_DeleteRowTB);
        btnUpdateRowTB = findViewById(R.id.btn_UpdateRowTB);
        btnQueryData = findViewById(R.id.btn_QueryTB);
        btnInsertSt = findViewById(R.id.btn_InsertSt);
        btnQuerySt = findViewById(R.id.btn_QueryStByMaLop);


        edtTypeMaLop = findViewById(R.id.edt_TypeMaLop);


        btnCreateDB.setOnClickListener(new ButtonOnClickListener());
        btnDeleteDB.setOnClickListener(new ButtonOnClickListener());
        btnCreateTB.setOnClickListener(new ButtonOnClickListener());
        btnDeleteTB.setOnClickListener(new ButtonOnClickListener());
        btnInsertRowTB.setOnClickListener(new ButtonOnClickListener());
        btnDeleteRowTB.setOnClickListener(new ButtonOnClickListener());
        btnUpdateRowTB.setOnClickListener(new ButtonOnClickListener());
        btnQueryData.setOnClickListener(new ButtonOnClickListener());
        btnInsertSt.setOnClickListener(new ButtonOnClickListener());
        btnQuerySt.setOnClickListener(new ButtonOnClickListener());

    }

    void initData() {
        db = openOrCreateDatabase(edtDBName.getText().toString(), MODE_PRIVATE, null);
    }

    class ButtonOnClickListener implements View.OnClickListener {
        TextView txt;

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_CreateDB:
                    dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.create_database_dialog);
                    txt = dialog.findViewById(R.id.tv_TitleButtonLayout);
                    txt.setText("CREATE DATABASE");
                    dialog.show();
                    edtDBName = dialog.findViewById(R.id.edt_DBName);

                    Button btnSave = dialog.findViewById(R.id.btn_Save);
                    btnSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!edtDBName.getText().toString().equals("")) {
                                initData();
                                Toast.makeText(MainActivity.this, "" + getDatabasePath(edtDBName.getText().toString() + ".db"), Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            } else {
                                Toast.makeText(MainActivity.this, "Please input database name!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    Button btnCancel = dialog.findViewById(R.id.btn_Cancel);
                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    break;

                case R.id.btn_DeleteDB:
                    dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.create_database_dialog);
                    txt = dialog.findViewById(R.id.tv_TitleButtonLayout);
                    txt.setText("DELETE DATABASE");
                    dialog.show();

                    edtDBName = dialog.findViewById(R.id.edt_DBName);
                    Button btnDelete = dialog.findViewById(R.id.btn_Save);
                    btnDelete.setText("Delete");
                    btnDelete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!edtDBName.getText().toString().equals("")) {
                                String mss = "";
                                if (deleteDatabase(edtDBName.getText().toString()) == true) {
                                    mss = "Deleted " + getDatabasePath(edtDBName.getText().toString() + ".db") + " !";
                                } else {
                                    mss = "Database is not exists!";
                                }
                                Toast.makeText(MainActivity.this, mss, Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            } else {
                                Toast.makeText(MainActivity.this, "Please input database name!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    Button btnCancelDelete = dialog.findViewById(R.id.btn_Cancel);
                    btnCancelDelete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    break;
                case R.id.btn_CreateTB:
                    initData();
                    createTable();
                    break;
                case R.id.btn_DeleteTB:
                    initData();
                    edtTypeTB = MainActivity.this.findViewById(R.id.edt_TypeTableDelete);
                    String tbname = edtTypeTB.getText().toString();
                    deleteTable(tbname);
                    break;
                case R.id.btn_InsertRowTB:
                    initData();
                    insertRowTotbllop("DH17DT", "A", 50);
                    break;

                case R.id.btn_DeleteRowTB: //is fail
                    dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.create_database_dialog);
                    txt = dialog.findViewById(R.id.tv_TitleButtonLayout);
                    txt.setText("DELETE ROW");
                    dialog.show();

                    edtDBName = dialog.findViewById(R.id.edt_DBName);
                    edtDBName.setHint("Input malop to deleted!");

                    dialog.show();
                    Button btnCancelDeleteRow = dialog.findViewById(R.id.btn_Cancel);
                    btnCancelDeleteRow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    Button btnDeleteRowTotbllop = dialog.findViewById(R.id.btn_Save);
                    btnDeleteRowTotbllop.setText("Delete");
                    btnDeleteRowTotbllop.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!edtDBName.getText().toString().equals("")) {
                                deleteRowFromtbllop(edtDBName.getText().toString());
                            } else {
                                Toast.makeText(MainActivity.this, "Please input malop to delete!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });


                    break;

                case R.id.btn_UpdateRowTB:
                    dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.update_row_to_tb);
                    dialog.show();

                    Button btnUpdate = dialog.findViewById(R.id.btn_Update);
                    btnUpdate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            EditText edtConditionMalop = dialog.findViewById(R.id.edt_ConditionMalop);
                            if (edtConditionMalop.getText().toString().equals("")) {
                                Toast.makeText(MainActivity.this, "Please input condition!", Toast.LENGTH_LONG).show();
                            } else {
                                updateRowTotbllop(edtConditionMalop.getText().toString());
                                Toast.makeText(MainActivity.this, "Update is succeed!", Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            }
                        }
                    });
                    Button btnCancelUpdate = dialog.findViewById(R.id.btn_Cancel);
                    btnCancelUpdate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    break;
                case R.id.btn_QueryTB:
                    break;
                case R.id.btn_InsertSt:
                    break;
                case R.id.btn_QueryStByMaLop:
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + v.getId());
            }
        }

        void createTable() {
            String sql = "CREATE TABLE IF NOT EXISTS tbllop (";
            sql += "malop TEXT PRIMARY KEY,";
            sql += "tenlop TEXT,";
            sql += "siso INTEGER)";

            db.execSQL(sql);
            Toast.makeText(MainActivity.this, "CREATE TABLE IS SUCCEED!", Toast.LENGTH_LONG).show();

        }

        void deleteTable(String tbname) {
            String sql = "DROP TABLE ";
            sql += tbname + ";";
            db.execSQL(sql);
            Toast.makeText(MainActivity.this, "Deleted table " + tbname + "!", Toast.LENGTH_LONG).show();
        }

        void insertRowTotbllop(String malop, String tenlop, int siso) {
            String sql = "INSERT INTO tbllop (malop, tenlop, siso) VALUES (";
            sql += "\'" + malop + "\', \'" + tenlop + "\', " + siso + ");";
            db.execSQL(sql);
            Toast.makeText(MainActivity.this, "Insert into table tbllop is succeed!", Toast.LENGTH_LONG).show();
        }

        void deleteRowFromtbllop(String malop) {
            String sql = "DELETE FROM tbllop WHERE tbllop.malop =\'" + malop + "\'";
            db.execSQL(sql);

            Toast.makeText(MainActivity.this, "Deleted row has malop is " + malop + " !", Toast.LENGTH_LONG).show();
        }

        void updateRowTotbllop(String condition) {
            EditText edtMalop = dialog.findViewById(R.id.edt_Malop);
            EditText edtTenlop = dialog.findViewById(R.id.edt_Tenlop);
            EditText edtSiso = dialog.findViewById(R.id.edt_Siso);

            String ml = edtMalop.getText().toString();
            String tl = edtTenlop.getText().toString();
            String ss = edtSiso.getText().toString();
            String mss = "";
//            String sql = "UPDATE tbllop AS t SET t.malop = \'" + (ml.equals("") ? condition : ml) + "\', t.tenlop = \'" + (tl.equals("") ? selectTenlop(condition) : tl) + "\', t.siso = " + (ss.equals("") ? mss = "Can not update!" : Integer.parseInt(ss));
//            sql += " WHERE t.malop = \'" + condition + "\'";
//            db.execSQL(sql);
            if(tl.equals("") && ml.equals("") && ss.equals("")){
                mss = "Can not update!";
            }else{
                db.execSQL("UPDATE tbllop SET tenlop = \'"+(tl.equals("") ? selectTenlop(condition) : tl)+"\', siso = "+(ss.equals("") ? selectSiso(condition) : Integer.parseInt(ss) )+" WHERE malop = \'"+condition+"\'");
            }
            Toast.makeText(MainActivity.this, "ok" + mss, Toast.LENGTH_LONG).show();
        }

        Cursor selectTenlop(String condition) {
            String sql = "SELECT tenlop FROM tbllop WHERE malop = \'" + condition + "\'";
            Cursor data = db.rawQuery(sql, null);
            return data;
        }
        Cursor selectSiso(String condition){
            String sql = "SELECT siso FROM tbllop WHERE malop = \'" + condition + "\'";
            Cursor data = db.rawQuery(sql, null);
            return data;
        }
        Cursor selectMalop(){
            String sql = "SELECT malop FROM tbllop ";
            Cursor data = db.rawQuery(sql, null);
            return data;
        }
    }

}