//
//  Counter.m
//  testapp
//
//  Created by Pablo Roncero on 26/11/2018.
//  Copyright © 2018 Facebook. All rights reserved.
//

#import "React/RCTBridgeModule.h"
@interface RCT_EXTERN_MODULE(Counter, NSObject)

  RCT_EXTERN_METHOD(increment)


+ (BOOL)requiresMainQueueSetup
{
  return YES;
}

@end
