package com.example.a45mph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import android.content.Context;
import android.content.res.Resources;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;

import java.util.Objects;

public class ProfileAdapterInstrumentationTests {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.a45mph", appContext.getPackageName());
    }

    @Test
    public void testProfileSearchSuccessful() {
        try {
            VehicleProfile vp = VehicleProfilesActivity.createVehicleProfile("Test","Test","Test");
            VehicleSelectionActivity.profileAdapter.addProfile(vp);
            VehicleProfile result = VehicleProfileAdapter.searchProfiles(vp.getName());

            vp.setEntry();
            result.setEntry();

            assertEquals(vp.entry,result.entry);
        } catch (Exception e) {
            InstrumentationTestHelper.exceptionHandler(e);
        }

    }

    @Test
    public void testProfileSearchMultiple() {
        try {
            VehicleProfile vp = VehicleProfilesActivity.createVehicleProfile("Test","Test","Test");
            VehicleProfile vp1 = VehicleProfilesActivity.createVehicleProfile("Not It", "Not It", "Not It");
            VehicleSelectionActivity.profileAdapter.addProfile(vp);
            VehicleSelectionActivity.profileAdapter.addProfile(vp1);
            VehicleProfile result = VehicleProfileAdapter.searchProfiles(vp.getName());

            vp.setEntry();
            vp1.setEntry();
            result.setEntry();

            assertEquals(vp.entry,result.entry);
            assert !Objects.equals(vp1.entry,result.entry);
        } catch (Exception e) {
            InstrumentationTestHelper.exceptionHandler(e);
        }
    }

    @Test
    public void testProfileSearchUnsuccessful() {
        try {
            VehicleProfile vp = VehicleProfilesActivity.createVehicleProfile("Test","Test","Test");
            VehicleSelectionActivity.profileAdapter.addProfile(vp);
            VehicleProfile result = VehicleProfileAdapter.searchProfiles("Not There");

            assertNull(result);
        } catch (Exception e) {
            InstrumentationTestHelper.exceptionHandler(e);
        }
    }

}
