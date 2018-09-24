package com.reactnativeaerogearups;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import org.jboss.aerogear.android.core.Callback;
import org.jboss.aerogear.android.unifiedpush.PushRegistrar;
import org.jboss.aerogear.android.unifiedpush.RegistrarManager;
import org.jboss.aerogear.android.unifiedpush.fcm.AeroGearFCMPushConfiguration;

import java.net.URI;

public class RNAerogearUpsModule extends ReactContextBaseJavaModule {

    private final String TAG = "ups";

    public RNAerogearUpsModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNAerogearUps";
    }

    @ReactMethod
    public void init(String unifiedPushServerURL, String senderId, String variantId, String variantSecret) {
        RegistrarManager.config("register", AeroGearFCMPushConfiguration.class)
                .setPushServerURI(URI.create(unifiedPushServerURL)).setSenderId(senderId).setVariantID(variantId)
                .setSecret(variantSecret).asRegistrar();

        PushRegistrar registrar = RegistrarManager.getRegistrar("register");
        registrar.register(getReactApplicationContext().getApplicationContext(), new Callback<Void>() {
            @Override
            public void onSuccess(Void data) {
                Log.i(TAG, "Registration Succeeded!");
            }

            @Override
            public void onFailure(Exception e) {
                Log.e(TAG, e.getMessage(), e);
            }
        });
    }

}
