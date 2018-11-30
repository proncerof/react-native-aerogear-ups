//
//  Counter.swift
//  testapp
//
//  Created by Pablo Roncero on 26/11/2018.
//  Copyright © 2018 Facebook. All rights reserved.
//

import Foundation
@objc(Counter)
class Counter: NSObject {
  
  @objc func constantsToExport() -> [AnyHashable : Any]! {
    return [
      "number": 123.9,
      "string": "foo",
      "boolean": true,
      "array": [1, 22.2, "33"],
      "object": ["a": 1, "b": 2]
    ]
  }
  
  private var count = 0
  @objc
  func increment() {
    count += 1
    print("count is \(count)")
  }
}
