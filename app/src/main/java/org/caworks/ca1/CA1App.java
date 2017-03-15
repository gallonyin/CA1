package org.caworks.ca1;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by gallon on 2017/3/14
 */

public class CA1App extends TinkerApplication {

    public CA1App() {
        super(
                //tinkerFlags, which types is supported
                //dex only, library only, all support
                ShareConstants.TINKER_ENABLE_ALL,
                // This is passed as a string so the shell application does not
                // have a binary dependency on your ApplicationLifeCycle class.
//                "tinker.sample.android.app.SampleApplicationLike");
                "org.caworks.ca1.MyTinkerInApplicationLike");
    }

    protected CA1App(int tinkerFlags) {
        super(tinkerFlags);
    }
}
