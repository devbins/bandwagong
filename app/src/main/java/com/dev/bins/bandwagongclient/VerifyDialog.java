package com.dev.bins.bandwagongclient;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dev.bins.bandwagongclient.util.SharePreferenceConstant;

/**
 * Created by bin on 14/02/2017.
 */

public class VerifyDialog implements View.OnClickListener {

    private Context mContext;
    private EditText mVeidEditText;
    private EditText mKeyEditText;
    private AlertDialog mAlertDialog;

    public VerifyDialog(Context context) {
        mContext = context;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("config")
                .setView(initView());
        mAlertDialog = builder.create();
    }

    private View initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.host_dialog, null);
        mVeidEditText = (EditText) view.findViewById(R.id.et_veid);
        mKeyEditText = (EditText) view.findViewById(R.id.et_key);

        Button saveButton = (Button) view.findViewById(R.id.btn_save);
        Button cancleButton = (Button) view.findViewById(R.id.btn_cancel);

        saveButton.setOnClickListener(this);
        cancleButton.setOnClickListener(this);

        return view;
    }

    public void show() {
        mAlertDialog.show();
    }

    public void hide() {
        if (mAlertDialog.isShowing()) {
            mAlertDialog.dismiss();
        }
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_save) {
            String veid = mVeidEditText.getText().toString().trim();
            String key = mKeyEditText.getText().toString().trim();
            if (TextUtils.isEmpty(veid)) {
                mVeidEditText.setError("veid must not empty");
                return;
            }
            if (TextUtils.isEmpty(key)) {
                mKeyEditText.setError("veid must not empty");
                return;
            }

            SharedPreferences sp =
                    PreferenceManager.getDefaultSharedPreferences(mContext);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(SharePreferenceConstant.VEID, veid);
            editor.putString(SharePreferenceConstant.key, key);
            editor.commit();
            mAlertDialog.dismiss();
        } else {
            mAlertDialog.dismiss();
        }
    }
}
