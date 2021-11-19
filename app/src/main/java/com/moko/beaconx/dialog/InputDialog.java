package com.moko.beaconx.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.moko.beaconx.R;
import com.moko.beaconx.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class InputDialog extends BaseDialog<String> {
    @BindView(R.id.et_ip_addr)
    EditText etIpAddr;
    @BindView(R.id.et_staff_id)
    EditText etStaffId;

    private String inputIpAddr;
    private String inputStaffId;

    public InputDialog(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.dialog_input;
    }

    @Override
    protected void renderConvertView(View convertView, String password) {
        if (!TextUtils.isEmpty(inputIpAddr) || !TextUtils.isEmpty((inputStaffId))) {
            etIpAddr.setText(inputIpAddr);
            etIpAddr.setSelection(inputIpAddr.length());
            etStaffId.setText(inputStaffId);
            etStaffId.setSelection(inputStaffId.length());
        }
    }

    @OnClick({R.id.tv_input_cancel, R.id.tv_input_ensure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_input_cancel:
                dismiss();
                inputClickListener.onDismiss();
                break;
            case R.id.tv_input_ensure:
                dismiss();
                //check if null
                if (TextUtils.isEmpty(etIpAddr.getText().toString())) {
                    ToastUtils.showToast(getContext(), getContext().getString(R.string.ipaddr_null));
                    return;
                }
                if (TextUtils.isEmpty(etStaffId.getText().toString())) {
                    ToastUtils.showToast(getContext(), getContext().getString(R.string.staffid_null));
                    return;
                }

                inputClickListener.onEnsureClicked(etIpAddr.getText().toString(), etStaffId.getText().toString());
                break;
        }
    }

    private InputDialog.InputClickListener inputClickListener;

    public void setOnInputClicked(InputDialog.InputClickListener inputClickListener) {
        this.inputClickListener = inputClickListener;
    }

    public interface InputClickListener {

        void onEnsureClicked(String input1, String input2);

        void onDismiss();
    }

    public void showKeyboard() {
        if (etIpAddr != null && etStaffId !=null) {
            //设置可获得焦点
            etIpAddr.setFocusable(true);
            etIpAddr.setFocusableInTouchMode(true);
            //设置可获得焦点
            etStaffId.setFocusable(true);
            etStaffId.setFocusableInTouchMode(true);
            //请求获得焦点
            etIpAddr.requestFocus();
            //请求获得焦点
            etStaffId.requestFocus();
            //调用系统输入法
            InputMethodManager inputManager = (InputMethodManager) etIpAddr.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.showSoftInput(etIpAddr, 0);
            InputMethodManager inputManager1 = (InputMethodManager) etStaffId.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager1.showSoftInput(etStaffId, 0);
        }
    }
}
