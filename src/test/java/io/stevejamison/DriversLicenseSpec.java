package io.stevejamison;

import jdk.nashorn.internal.runtime.OptimisticReturnFilters;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by stevejaminson on 5/23/16.
 */
public class DriversLicenseSpec {

    private String name, address, licenseNumber, endorsements, issuingState, eyeColor;

    private int height;
    private double weight;
    private char licenseClassification, sex;
    private boolean organDonor, federallyCompliant;
    private Date dateOfBirth, issueDate, expirationDate;

    @Test
    public void dateConvertTest(){
        DriversLicense driver = new DriversLicense();
        Long expected = new Date().getTime();
        Long actual = driver.dateConvert(new Date().toString()).getTime();
        assertEquals(expected, actual, 400);
    }

    @Test
    public void serializeToCSVTester(){
        DriversLicense driver = new DriversLicense();
        driver.setName("Tester");
        driver.setAddress("123 Testing Way");
        driver.setLicenseNumber("123456");
        driver.setEndorsements("P");
        driver.setIssuingState("DE");
        driver.setEyeColor("Brown");
        driver.setHeight(60);
        driver.setWeight(150);
        driver.setLicenseClassification('A');
        driver.setSex('M');
        driver.setOrganDonor(true);
        driver.setFederallyCompliant(true);
        driver.setDateOfBirth(new Date());
        driver.setIssueDate(new Date());
        driver.setExpirationDate(new Date());
        String expected = "Tester,123 Testing Way,123456,P,DE,Brown,60,150.0,A,M,true,true," + new Date() + "," + new Date() + "," + new Date();
        String actual = driver.serializeToCSV(driver);
        assertEquals(expected,actual);
    }

    @Test
    public void deserializeToCSVTester(){
        DriversLicense driver = new DriversLicense();
        driver.setName("Tester");
        driver.setAddress("123 Testing Way");
        driver.setLicenseNumber("123456");
        driver.setEndorsements("P");
        driver.setIssuingState("DE");
        driver.setEyeColor("Brown");
        driver.setHeight(60);
        driver.setWeight(150);
        driver.setLicenseClassification('A');
        driver.setSex('M');
        driver.setOrganDonor(true);
        driver.setFederallyCompliant(true);
        driver.setDateOfBirth(new Date());
        driver.setIssueDate(new Date());
        driver.setExpirationDate(new Date());
        String text = driver.serializeToCSV(driver);
        ArrayList<DriversLicense> licenseArrayList = driver.deserializeFromCSV(text);

        long expected = driver.getDateOfBirth().getTime();
        long actual = licenseArrayList.get(0).getDateOfBirth().getTime();
        assertEquals(expected,actual,500);

        DriversLicense expected1 = driver;
        DriversLicense actual1 = licenseArrayList.get(0);
        assertTrue(expected1.isLike(actual1));

    }
}
