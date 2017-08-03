package com.example.android.reportcard;

public class ReportCard{

    private String mStudentName;
    private int mStudentRollNo;
    private int mHindiMarks;
    private int mMathsMarks;
    private int mChemistryMarks;
    private int mPhysicsMarks;
    private int mCompSc;
    private int mEnglishMarks;
    private int mTotal;


    public ReportCard(String studentName, int studentRollNo,int hindiMarks,int mathsMarks,int chemistryMarks,
                      int physicsMarks,int compScMarks,int englishMarks)
    {
        mStudentName = studentName;
        mStudentRollNo = studentRollNo;
        mHindiMarks = hindiMarks;
        mMathsMarks = mathsMarks;
        mChemistryMarks = chemistryMarks;
        mPhysicsMarks = physicsMarks;
        mCompSc = compScMarks;
        mEnglishMarks = englishMarks;
    }

    public int getmStudentRollNo() {return mStudentRollNo;}
    public void setmStudentRollNo(int studentRollNo) {mStudentRollNo = studentRollNo;}

    public String getmStudentName() {return mStudentName;}
    public void setmStudentName(String studentName) {mStudentName = studentName;}

    public int getmHindiMarks() {return mHindiMarks;}
    public void setmHindiMarks(int hindiMarks) {mHindiMarks = hindiMarks;}

     public int getmMathsMarks() {return mMathsMarks;}
     public void setmMathsMarks( int mathsMarks) {mMathsMarks = mathsMarks;}

     public int getmChemistryMarks() {return mChemistryMarks;}
     public void setmChemistryMarks( int chemistryMarks) {mChemistryMarks = chemistryMarks;}

    public int getmPhysicsMarks() {return mPhysicsMarks;}
    public void setmPhysicsMarks( int physicsMarks) {mPhysicsMarks = physicsMarks;}

    public int getmCompScsMarks() {return mCompSc;}
    public void setmCompScsMarks( int compScMarks) {mCompSc = compScMarks;}

    public int getmEnglishMarks() {return mEnglishMarks;}
    public void setmEnglishMarks( int englishMarks) {mEnglishMarks = englishMarks;}

   public int  getmTotal(int mHindiMarks,int mMathsMarks,int mPhysicsMarks,int mChemistryMarks,int mCompSc,int mEnglishMarks){

       mTotal = mChemistryMarks+mCompSc+mEnglishMarks+mHindiMarks+mMathsMarks+mPhysicsMarks;
        return mTotal;
   }



    @Override
       public String toString() {
        return "ReportCard {" +
                "Student Name='" + mStudentName + '\'' +
                ", Hindi Marks=" + mHindiMarks +
                ", Maths Marks=" + mMathsMarks +
                ", Chemistry Marks=" + mChemistryMarks +
                ", Physics Marks=" + mPhysicsMarks +
                ", Computer Science Marks=" + mCompSc +
                ", English Marks=" + mEnglishMarks +
                ", grade='" + getmTotal(mHindiMarks,mMathsMarks,mPhysicsMarks,mChemistryMarks,mCompSc,mEnglishMarks) +
                '\'' +
                '}';

    }


}