using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Aerogear.Ups.RNAerogearUps
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNAerogearUpsModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNAerogearUpsModule"/>.
        /// </summary>
        internal RNAerogearUpsModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNAerogearUps";
            }
        }
    }
}
