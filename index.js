
import { NativeModules } from 'react-native';

const { RNAerogearUps } = NativeModules;

export default class {
  
  /**
   * Creates the connection between the ups server and the client.
   * @param {String} unifiedPushServerURL 
   * @param {String} senderId 
   * @param {String} variantId 
   * @param {String} variantSecret 
   * 
   * @return {Promise} success or failure
   */
  static init(unifiedPushServerURL, senderId, variantId, variantSecret){
    return RNAerogearUps.init(unifiedPushServerURL, senderId, variantId,variantSecret);
  }

  /**
   * Use it to receive the new push notification event while the app is being used, not in background.
   */
  static registerMainMessageHandler() {
      RNAerogearUps.registerMainMessageHandler();
  }

  /**
   * Stop receiving the new push notification event while the app is being used, not in background.
   */
  static unregisterMainMessageHandler() {
    RNAerogearUps.unregisterMainMessageHandler();
  }

  /**
   * Use it if you want to show the notifications in the notification bar. It can be used together with the registerMainMessageHandler method
   */
  static registerBarMessageHandler() {
    RNAerogearUps.registerBarMessageHandler();
  }

  /**
   * Use it if you don't want to show the notifications in the notification bar.
   */
  static unregisterBarMessageHandler() {
    RNAerogearUps.unregisterBarMessageHandler();
  }

};
