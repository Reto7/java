package Fach_2_Objektorientierung.A11_1_Student_Enum;

/**
 * Created by rk on 01.11.16.
 */
public enum Fach {
    MATHEMATIKSTUDIUM,INFORMATIKSTUDIUM,ARCHITEKTURSTUDIUM,
    WIRTSCHAFTLICHESSTUDIUM,BIOLOGIESTUDIUM,GESCHICHTSSTUDIUM,
    GERMANISTIKSTUDIUM ,POLITOLOGIESTUDIUM ,PHYSIKSTUDIUM;

    // returns Anzahl Semester
    public int regelstudienzeit(){
        switch (this) {
            case MATHEMATIKSTUDIUM:
            case INFORMATIKSTUDIUM:
            case ARCHITEKTURSTUDIUM:
                return 4;
            case WIRTSCHAFTLICHESSTUDIUM:
            case BIOLOGIESTUDIUM:
            case GESCHICHTSSTUDIUM:
            case GERMANISTIKSTUDIUM:
                return 6;
            case POLITOLOGIESTUDIUM:
            case PHYSIKSTUDIUM:
                return 8;
            default:
                return 0;
        }
    }
}
