import { NativeModules } from 'react-native';

const aerogearUps = NativeModules.RNAerogearUps;


// aerogearUps.init(
//   "https://test-aerogear.web.cern.ch/", 
//   "453929919359", 
//   "b07dab9b-e294-47ea-89e7-6ff6fe7e1055", 
//   "da648aa5-dfcb-472b-a44b-cc4d01129efc")

export default class RNAerogearUps {

  /**
   * Method that connects the react mobile application and the unified push server 
   * @param {string} unifiedPushServerURL 
   * @param {string} senderId 
   * @param {string} variantId 
   * @param {string} variantSecret 
   */
  init(unifiedPushServerURL, senderId, variantId, variantSecret ){
    aerogearUps.init(unifiedPushServerURL, senderId, variantId, variantSecret)
  }

}
