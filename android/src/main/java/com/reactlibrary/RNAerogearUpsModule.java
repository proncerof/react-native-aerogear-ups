
package com.reactlibrary;

import android.content.Context;
import android.os.Bundle;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import org.jboss.aerogear.android.core.Callback;
import org.jboss.aerogear.android.unifiedpush.MessageHandler;
import org.jboss.aerogear.android.unifiedpush.PushRegistrar;
import org.jboss.aerogear.android.unifiedpush.RegistrarManager;
import org.jboss.aerogear.android.unifiedpush.fcm.AeroGearFCMPushConfiguration;
import org.jboss.aerogear.android.unifiedpush.fcm.UnifiedPushMessage;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class RNAerogearUpsModule extends ReactContextBaseJavaModule implements MessageHandler {

    private final String TAG = "ups";
    private List<MessageHandler> messageHandlers = new ArrayList();

    private final ReactApplicationContext reactContext;

    public RNAerogearUpsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNAerogearUps";
    }

    @ReactMethod
    public void init(String unifiedPushServerURL, String senderId, String variantId, String variantSecret, String alias,
            final Promise promise) {
        RegistrarManager.config("register", AeroGearFCMPushConfiguration.class)
                .setPushServerURI(URI.create(unifiedPushServerURL)).setSenderId(senderId).setVariantID(variantId)
                .setSecret(variantSecret).setAlias(alias).asRegistrar();

        PushRegistrar registrar = RegistrarManager.getRegistrar("register");
        registrar.register(getReactApplicationContext().getApplicationContext(), new Callback<Void>() {
            @Override
            public void onSuccess(Void data) {
                promise.resolve(data);
            }

            @Override
            public void onFailure(Exception e) {
                promise.reject(e);
            }
        });
    }

    @ReactMethod
    public void registerMainMessageHandler() {
        RegistrarManager.registerMainThreadHandler(this);
    }

    @ReactMethod
    public void unregisterMainMessageHandler() {
        RegistrarManager.unregisterMainThreadHandler(this);
    }

    @ReactMethod
    public void registerBarMessageHandler() {
        RegistrarManager.registerBackgroundThreadHandler(NotificationBarMessageHandler.getInstance());
    }

    @ReactMethod
    public void unregisterBarMessageHandler() {
        RegistrarManager.unregisterBackgroundThreadHandler(NotificationBarMessageHandler.getInstance());
    }

    @Override
    public void onMessage(Context context, Bundle bundle) {
        String message = bundle.getString(UnifiedPushMessage.ALERT_KEY);
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("onMessage", message);
    }
}