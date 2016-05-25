package io.stevejamison;


import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DriversLicense {

    private String name, address, licenseNumber, endorsements, issuingState, eyeColor;

    private int height;
    private double weight;
    private char licenseClassification, sex;
    private boolean organDonor, federallyCompliant;
    private Date dateOfBirth, issueDate, expirationDate;

    //private Restriction[] restrictions;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public char getLicenseClassification() {
        return licenseClassification;
    }

    public void setLicenseClassification(char licenseClassification) {
        this.licenseClassification = licenseClassification;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public boolean isOrganDonor() {
        return organDonor;
    }

    public void setOrganDonor(boolean organDonor) {
        this.organDonor = organDonor;
    }

    public boolean isFederallyCompliant() {
        return federallyCompliant;
    }

    public void setFederallyCompliant(boolean federallyCompliant) {
        this.federallyCompliant = federallyCompliant;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

//    public Restriction[] getRestrictions() {
//        return restrictions;
//    }
//
//    public void setRestrictions(Restriction[] restrictions) {
//        this.restrictions = restrictions;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getEndorsements() {
        return endorsements;
    }

    public void setEndorsements(String endorsements) {
        this.endorsements = endorsements;
    }

    public String getIssuingState() {
        return issuingState;
    }

    public void setIssuingState(String issuingState) {
        this.issuingState = issuingState;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * (include description of field order here)
     * @return
     */
    public static String serializeToCSV(DriversLicense license){

        StringBuilder csvBuilder = new StringBuilder();

        csvBuilder.append(license.getName()).append(',')
                .append(license.getAddress()).append(',')
                .append(license.getLicenseNumber()).append(',')
                .append(license.getEndorsements()).append(',')
                .append(license.getIssuingState()).append(',')
                .append(license.getEyeColor()).append(',')
                .append(license.getHeight()).append(',')
                .append(license.getWeight()).append(',')
                .append(license.getLicenseClassification()).append(',')
                .append(license.getSex()).append(',')
                .append(license.isOrganDonor()).append(',')
                .append(license.isFederallyCompliant()).append(',')
                .append(license.getDateOfBirth()).append(',')
                .append(license.getIssueDate()).append(',')
                .append(license.getExpirationDate());

        return csvBuilder.toString();
    }

    public static Date dateConvert(String stringDate){
        DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        Date date = null;
        try {
            date = format.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static ArrayList deserializeFromCSV(String csvText){

        ArrayList<DriversLicense> licenses = new ArrayList<DriversLicense>();
        ArrayList<String> list = new ArrayList<String>();
        int count = 0;

        for(int i = 0; i < 15; i++) {
            list.add(csvText.split(",")[i]);
        }
        licenses.add(new DriversLicense());
        licenses.get(count).setName(list.get(0).toString());
        licenses.get(count).setAddress(list.get(1).toString());
        licenses.get(count).setLicenseNumber(list.get(2).toString());
        licenses.get(count).setEndorsements(list.get(3).toString());
        licenses.get(count).setIssuingState(list.get(4).toString());
        licenses.get(count).setEyeColor(list.get(5).toString());
        licenses.get(count).setHeight(Integer.parseInt(list.get(6)));
        licenses.get(count).setWeight(Double.parseDouble(list.get(7)));
        licenses.get(count).setLicenseClassification(list.get(8).charAt(0));
        licenses.get(count).setSex(list.get(9).charAt(0));
        licenses.get(count).setOrganDonor(Boolean.valueOf(list.get(10)));
        licenses.get(count).setFederallyCompliant(Boolean.valueOf(list.get(11)));
        licenses.get(count).setDateOfBirth(dateConvert(list.get(12).toString()));
        licenses.get(count).setIssueDate(dateConvert(list.get(13).toString()));
        licenses.get(count).setExpirationDate(dateConvert(list.get(14).toString()));
        count++;

        return licenses;
    }

    public boolean isLike(DriversLicense b){

        if(this.getName().equals(b.getName()) && this.getAddress().equals(b.getAddress()) && this
                .getLicenseNumber().equals(b.getLicenseNumber()) && this.getEndorsements().equals(b.getEndorsements()) && this.getIssuingState().equals(b.getIssuingState())
                && this.getEyeColor().equals(b.getEyeColor()) && this.getHeight() == b.getHeight() && this.getWeight() == b.getWeight() &&
                this.getLicenseClassification() == b.getLicenseClassification() && this.getSex() == b.getSex() && this.isOrganDonor() == b.isOrganDonor() &&
                this.isFederallyCompliant() == b.isFederallyCompliant())
            return true;
        else
            return false;
    }

    public static String getCSVHeader(){
        return "NAME,ADDRESS,LICENSE NUMBER,ENDORSEMENTS,ISSUING STATE,EYE COLOR,HEIGHT" +
                "WEIGHT,LICENSE CLASSIFICATION,SEX,ORGAN DONOR,FEDERALLY COMPLIANT,DATE OF BIRTH" +
                "ISSUE DATE, EXPIRATION DATE";
    }


}
