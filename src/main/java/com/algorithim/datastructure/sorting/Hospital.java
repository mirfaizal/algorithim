package com.algorithim.datastructure.sorting;

// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock'

/*
The flu is spreading and the hospital needs your help!
Being an awesome programmer, you have been assigned the task to design a patient management system. Each patient enters the hospital with an infection level.
The patient is put in a waitlist until the treatment is provided. While the patient waits, the infection level of the patient level may increase.

Implement a system which supports the following functions:

- AddPatient: Given a patient name and an infection level, place the patient in the waitlist.
- GetPatient: Get the patient with the highest infection level. If 2 people have the same infection level, priority is given to the person who arrived first.
- IncreaseInfection: Given the patient name and new infection level, update the patient's infection level in the waitlist.
- TreatPatient: Given the patient name, remove the patient from the waitlist.

*/

import java.util.*;

public class Hospital {

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        hospital.AddPatient("A",3);
        hospital.AddPatient("B",1);
        hospital.AddPatient("C",2);
        hospital.AddPatient("D",2);
        Patient patient = hospital.GetPatient();
        System.out.print(patient.name +" "+ patient.infectionLevel+" ");
        hospital.AddPatient("E",5);
        patient = hospital.GetPatient();
        System.out.print(patient.name +" "+ patient.infectionLevel+" ");
        hospital.IncreaseInfection("B",6);
        patient = hospital.GetPatient();
        System.out.print(patient.name +" "+ patient.infectionLevel+" ");
        hospital.TreatPatient("E");
        patient = hospital.GetPatient();
        System.out.print(patient.name +" "+ patient.infectionLevel+" ");
        hospital.TreatPatient("B");
        patient = hospital.GetPatient();
        System.out.print(patient.name +" "+ patient.infectionLevel+" ");
    }

    PriorityQueue<Patient> patientQueue = new PriorityQueue<>(this::getRank);

    static class Patient {
        String name;
        int infectionLevel;
        Patient(String name, int infectionLevel){
            this.infectionLevel = infectionLevel;
            this.name = name;
        }
        private void setInfectionLevel(int infectionLevel){
            this.infectionLevel = infectionLevel;
        }
    }

    private int getRank(Patient a, Patient b){
        if(a.infectionLevel < b.infectionLevel) return 1;
        else if (a.infectionLevel > b.infectionLevel) return -1;
        else return 0;
    }

    public Patient GetPatient(){
        return patientQueue.peek();
    }

    // [("E",5,5), ("B","3",2),("A","2",1),("C","2",3),("D","1",4)]
    public void IncreaseInfection(String name, int infectionLevel){
        Queue<Patient> tempQueue = new LinkedList<>();
        while(!patientQueue.isEmpty()){
            Patient patient = patientQueue.poll();
            tempQueue.add(patient);
            if(patient.name.equals(name)){
                patient.setInfectionLevel(infectionLevel);
                break;
            }
        }
        while(!tempQueue.isEmpty()){
            patientQueue.offer(tempQueue.poll());
        }
    }

    public void TreatPatient(String name){
        Queue<Patient> tempQueue = new LinkedList<>();
        while(!patientQueue.isEmpty()){
            Patient patient = patientQueue.poll();
            if(patient.name.equals(name)){
                break;
            }
            tempQueue.add(patient);
        }
        while(!tempQueue.isEmpty()){
            patientQueue.offer(tempQueue.poll());
        }
    }


    public void AddPatient(String name, int infectionLevel){
        Patient patient = new Patient(name, infectionLevel);
        patientQueue.offer(patient);
    }




}


// patient - with infection level - infection level may change
// Waitlist
//


// AddPatient  Time O(log(n))
// GetPatient  O(1)
// IncreaseInfection O(n) + log(n)
// TreatPatient O(1) + O(n) + log(n)

// [1,2,3,4,5]

// Time - O(n) + heafify log(n)
// O(nlogn)
// O(n)


// Example
// [("A","2"),("B","3"),("C","2"),("D","1")]
// Sort based on infection then Arrival [("A","2",1),("B","3",2),("C","2",3),("D","1",4)]
// [("B","3",2),("A","2",1),("C","2",3),("D","1",4)]
// [("B","3",2),("A","2",1),("C","2",3),("D","1",4)]
// [("E",5,5), ("B","3",2),("A","2",1),("C","2",3),("D","1",4)]

// "A" -->



