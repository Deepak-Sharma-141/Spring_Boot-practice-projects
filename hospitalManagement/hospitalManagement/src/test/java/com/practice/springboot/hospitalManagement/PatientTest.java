package com.practice.springboot.hospitalManagement;

import com.practice.springboot.hospitalManagement.entity.Patient;
import com.practice.springboot.hospitalManagement.repository.PatientRepository;
import com.practice.springboot.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private  PatientRepository patientRepository;

   @Autowired
   private PatientService patientService;

    @Test
    public void testPatientRepository(){

        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);

    }

    @Test
    public void testTransactionMethods(){
        Patient patient =patientService.getPatientById(0L);

        System.out.println(patient);
    }
}
