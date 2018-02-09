package io.github.anotherjack.mvvmarchdemo.databinding;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by zhengj on 2018-2-8.
 */

public class CommonBindingAdapters {

//    @BindingAdapter("android:text")
//    public static void setText(TextView view, int value) {
//        view.setText(Integer.toString(value));
//    }
//    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
//    public static int getTextInt(TextView view) {
//        String str = view.getText().toString();
//        return Integer.parseInt(str);
//    }

    @BindingAdapter("txt")
    public static void setTxt(TextView textView, String value){
        String oldValue = textView.getText().toString();
        if(value.equals(oldValue)) return;
        Log.d("BindingAdapter","setTxt");
        textView.setText(value);
    }

    @BindingAdapter("ttxtAttrChanged")
    public static void setTxtWatcher(TextView textView, final InverseBindingListener txtAttrChanged){
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtAttrChanged.onChange();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @InverseBindingAdapter(attribute = "txt",event = "ttxtAttrChanged")
    public static String getTxtString(TextView textView){
        Log.d("InverseBindingAdapter","getTxtString");
        return textView.getText().toString();
    }
}
