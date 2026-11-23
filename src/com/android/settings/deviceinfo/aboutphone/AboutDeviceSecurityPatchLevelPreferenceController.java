/*
 * SPDX-FileCopyrightText: DerpFest AOSP
 * SPDX-License-Identifier: Apache-2.0
 */

package com.android.settings.deviceinfo.aboutphone;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.Preference;

import com.android.settings.core.BasePreferenceController;
import com.android.settings.deviceinfo.firmwareversion.SecurityDialogFragment;
import com.android.settingslib.DeviceInfoUtils;

public class AboutDeviceSecurityPatchLevelPreferenceController extends BasePreferenceController {

    private Fragment mHost;

    public AboutDeviceSecurityPatchLevelPreferenceController(Context context, String key) {
        super(context, key);
    }

    public void setHost(Fragment host) {
        mHost = host;
    }

    @Override
    public int getAvailabilityStatus() {
        return !DeviceInfoUtils.getSecurityPatch().isEmpty()
                ? AVAILABLE : CONDITIONALLY_UNAVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        return DeviceInfoUtils.getSecurityPatch();
    }

    @Override
    public boolean handlePreferenceTreeClick(Preference preference) {
        if (!getPreferenceKey().equals(preference.getKey())) {
            return false;
        }

        // Show security dialog
        if (mHost != null) {
            FragmentManager fragmentManager = mHost.getChildFragmentManager();
            SecurityDialogFragment.show(fragmentManager);
            return true;
        }
        return false;
    }
}
