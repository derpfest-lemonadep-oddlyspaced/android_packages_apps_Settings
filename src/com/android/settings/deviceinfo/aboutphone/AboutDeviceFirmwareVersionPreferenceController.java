/*
 * SPDX-FileCopyrightText: DerpFest AOSP
 * SPDX-License-Identifier: Apache-2.0
 */

package com.android.settings.deviceinfo.aboutphone;

import android.content.Context;
import android.os.Build;

import androidx.preference.Preference;

import com.android.settings.core.BasePreferenceController;

public class AboutDeviceFirmwareVersionPreferenceController extends BasePreferenceController {

    public AboutDeviceFirmwareVersionPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        return Build.VERSION.RELEASE_OR_PREVIEW_DISPLAY;
    }

    @Override
    public boolean handlePreferenceTreeClick(Preference preference) {
        return false;
    }
}
